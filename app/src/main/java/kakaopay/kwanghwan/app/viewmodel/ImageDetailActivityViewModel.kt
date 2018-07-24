package kakaopay.kwanghwan.app.viewmodel

import android.databinding.BaseObservable
import android.view.View
import kakaopay.kwanghwan.app.model.KakaoImage
import kakaopay.kwanghwan.app.ui.activity.ImageDetailActivity
import kakaopay.kwanghwan.app.util.CommonUtil

class ImageDetailActivityViewModel(var activity: ImageDetailActivity, var kakaoImage: KakaoImage) : BaseObservable() {
    fun back(view: View) {
        activity.onBackPressed()
    }

    val datetime: String
        get() = CommonUtil.getMediaDateTime(activity, kakaoImage.date)

    var imageSize: Int = 0
        get() {
            return CommonUtil.getDetailImageSize(activity)
        }
}