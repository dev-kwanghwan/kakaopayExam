package kakaopay.kwanghwan.app.viewmodel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.support.v4.util.Pair
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import kakaopay.kwanghwan.app.BR
import kakaopay.kwanghwan.app.ui.activity.HomeActivity
import kakaopay.kwanghwan.app.api.RestfulAdapter
import kakaopay.kwanghwan.app.interfaces.MediaService
import kakaopay.kwanghwan.app.model.KakaoImage
import kakaopay.kwanghwan.app.model.KakaoMedia
import kakaopay.kwanghwan.app.model.KakaoVideo
import kakaopay.kwanghwan.app.model.response.MediaMetaResponse
import kakaopay.kwanghwan.app.recyclerview.adapter.KakaoMediaRecyclerViewAdapter
import kakaopay.kwanghwan.app.statics.Constants

class HomeActivityViewModel(var homeActivity: HomeActivity, private val mediaService: MediaService) : BaseObservable() {
    val adapter = KakaoMediaRecyclerViewAdapter()
    var keyword = ""
    @Bindable get
    set(value) {
        field = value
        notifyPropertyChanged(BR.keyword)
    }

    val layoutManager: LinearLayoutManager
        get() = LinearLayoutManager(homeActivity.applicationContext, LinearLayoutManager.VERTICAL, false)

    fun keywordTextWatcher(s: CharSequence, start: Int, before: Int, count: Int) {
        Log.d(Constants.LOG_TAG, "검색어 : $s")
        keyword = s.toString()
        requestSearchResponse()
        notifyPropertyChanged(BR.keyword)
    }

    fun clearKeyword(view: View) {
        setKeyword()
    }

    private fun setKeyword() {
        this.keyword = ""
        notifyPropertyChanged(BR.keyword)
    }

    /**
     * 검색 데이터 가져오기
     */
    private fun requestSearchResponse() {
        if (keyword.isEmpty()) {
            setData(ArrayList())
            return
        }
        val service = RestfulAdapter.apiService
        //kakaoImage 가져오기
        val imageObservable = service.getKakaoImages(keyword)

        //kakaoVideo 가져오기
        val videoObservable = service.getKakaoVideos(keyword)

        //zip
        Single.zip(imageObservable, videoObservable, BiFunction<MediaMetaResponse<KakaoImage>, MediaMetaResponse<KakaoVideo>, Pair<MediaMetaResponse<KakaoImage>, MediaMetaResponse<KakaoVideo>>> { first, second -> Pair(first, second) })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ model ->
                    Log.d(Constants.LOG_TAG, "${model.first!!.kakaoMedia.size}, ${model.second!!.kakaoMedia.size}")
                    val data = ArrayList<KakaoMedia>()
                    data.addAll(model.first!!.kakaoMedia)
                    data.addAll(model.second!!.kakaoMedia)
                    setData(data)
                }, { error -> Log.e(Constants.LOG_TAG, "error ${error.printStackTrace()}") })
    }

    private fun setData(data: ArrayList<KakaoMedia>?) {
        mediaService.mediaList = data!!
        adapter.setData(mediaService.mediaList)
    }
}
