package kakaopay.kwanghwan.app.model.response

import com.google.gson.annotations.SerializedName
import kakaopay.kwanghwan.app.model.Meta
import java.util.*

/**
 * 이미지, 동영상 DTO 입니다.
 */
class MediaMetaResponse<T> {
    @SerializedName("meta")
    val meta: Meta? = null
    @SerializedName("documents")
    private val documents: List<T>? = null

    val kakaoMedia: List<T>
        get() = documents ?: ArrayList()
}
