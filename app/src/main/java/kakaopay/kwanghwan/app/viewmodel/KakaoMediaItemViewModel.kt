package kakaopay.kwanghwan.app.viewmodel

import android.content.Context
import android.content.Intent
import android.databinding.BaseObservable
import android.net.Uri
import android.view.View
import kakaopay.kwanghwan.app.R
import kakaopay.kwanghwan.app.model.KakaoImage
import kakaopay.kwanghwan.app.model.KakaoMedia
import kakaopay.kwanghwan.app.model.KakaoVideo
import kakaopay.kwanghwan.app.statics.Constants
import kakaopay.kwanghwan.app.ui.activity.ImageDetailActivity
import kakaopay.kwanghwan.app.util.CommonUtil

/**
 * KakaoMediaItem의 ViewModel 입니다.
 */
class KakaoMediaItemViewModel(private val context: Context, val kakaoMedia: KakaoMedia) : BaseObservable() {

    val mediaType: String
        get() = if (kakaoMedia.mediaType == Constants.KAKAO_MEDIA_TYPE_IMAGE) {
            context.getString(R.string.kakao_media_type_image)
        } else context.getString(R.string.kakao_media_type_video)

    val datetime: String
        get() = CommonUtil.getMediaDateTime(context, kakaoMedia.date)

    fun detail(view: View) {
        when (kakaoMedia.mediaType) {
            Constants.KAKAO_MEDIA_TYPE_IMAGE -> context.startActivity(ImageDetailActivity.buildIntent(context, kakaoMedia as KakaoImage))
            Constants.KAKAO_MEDIA_TYPE_VIDEO -> {
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse((kakaoMedia as KakaoVideo).url)))}
        }
    }
}
