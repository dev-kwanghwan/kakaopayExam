package kakaopay.kwanghwan.app.model

import com.google.gson.annotations.SerializedName

import kakaopay.kwanghwan.app.statics.Constants

/**
 * 이미지 DTO 입니다.
 */
class KakaoImage : KakaoMedia, BaseModel {
    @SerializedName("collection")
    private val collection: String? = null
    @SerializedName("thumbnail_url")
    override val mediaSource: String = ""
    @SerializedName("image_url")
    val imageUrl: String? = null
    @SerializedName("width")
    private val width: Int = 0
    @SerializedName("height")
    private val height: Int = 0
    @SerializedName("displaySiteName")
    private val displaySiteName: String = ""
    @SerializedName("doc_url")
    private val docUrl: String = ""
    @SerializedName("datetime")
    override val date: String = ""

    private var like = false

    override val mediaType: Int
        get() = Constants.KAKAO_MEDIA_TYPE_IMAGE

    override val title: String
        get() = when {
            collection!!.isEmpty() -> displaySiteName
            displaySiteName.isEmpty() -> collection
            else -> "$displaySiteName · $collection"
        }

    override val author: String
        get() = ""
}