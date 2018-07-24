package kakaopay.kwanghwan.app.model

import com.google.gson.annotations.SerializedName
import kakaopay.kwanghwan.app.statics.Constants

/**
 * 동영상 DTO 입니다.
 */
class KakaoVideo : KakaoMedia, BaseModel {
    @SerializedName("title")
    override val title: String = ""

    @SerializedName("url")
    val url: String? = null

    @SerializedName("datetime")
    override val date: String = ""

    @SerializedName("playTime")
    private val playTime: Int = 0

    @SerializedName("thumbnail")
    override val mediaSource: String = ""

    @SerializedName("author")
    override val author: String = ""

    private var like = false

    override val mediaType: Int
        get() = Constants.KAKAO_MEDIA_TYPE_VIDEO
}