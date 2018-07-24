package kakaopay.kwanghwan.app.model

import com.google.gson.annotations.SerializedName

/**
 * 이미지, 동영상 META 데이터 입니다.
 */
class Meta {
    @SerializedName("total_count")
    val totalCount: Int = 0
    @SerializedName("pageable_count")
    val pageableCunt: Int = 0
    @SerializedName("is_end")
    val isEnd: Boolean = false
}
