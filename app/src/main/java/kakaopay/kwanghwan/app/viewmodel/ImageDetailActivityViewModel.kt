package kakaopay.kwanghwan.app.viewmodel

import android.content.Intent
import android.databinding.BaseObservable
import android.view.View
import kakaopay.kwanghwan.app.model.KakaoImage
import kakaopay.kwanghwan.app.ui.activity.ImageDetailActivity
import kakaopay.kwanghwan.app.util.CommonUtil





class ImageDetailActivityViewModel(var activity: ImageDetailActivity, var kakaoImage: KakaoImage) : BaseObservable() {
    fun back(view: View) {
        activity.onBackPressed()
    }

    fun share(view: View) {
        val intent = Intent(android.content.Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "이미지 공유합니다.\n${kakaoImage.imageUrl}")
        val chooser = Intent.createChooser(intent, "친구에게 공유하기")
        activity.startActivity(chooser)
    }

    val datetime: String
        get() = CommonUtil.getMediaDateTime(activity, kakaoImage.date)

    var imageSize: Int = 0
        get() {
            return CommonUtil.getDetailImageSize(activity)
        }
}