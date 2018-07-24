package kakaopay.kwanghwan.app.repo

import android.content.Context
import kakaopay.kwanghwan.app.interfaces.MediaService
import kakaopay.kwanghwan.app.model.KakaoMedia
import kakaopay.kwanghwan.app.util.CommonUtil
import java.util.*

/**
 * KakaoMedia(동영상, 이미지) 데이터를 관리합니다.
 */
class MediaDataRepository(private val context: Context) : MediaService {
    /**
     * 아이템 관리
     */
    override var mediaList: ArrayList<KakaoMedia> = ArrayList<KakaoMedia>()
        set(mediaList) {
            field = sort(mediaList)
        }

    /**
     * 데이터 정렬
     */
    private fun sort(origin: ArrayList<KakaoMedia>): ArrayList<KakaoMedia> {
        val comparator = { k1: KakaoMedia, k2: KakaoMedia ->
            val k1Millisecond = CommonUtil.timeConvertToMillisecond(context, k1.date)
            val k2Millisecond = CommonUtil.timeConvertToMillisecond(context, k2.date)
            java.lang.Long.compare(k1Millisecond!!, k2Millisecond!!)
        }

        Collections.sort(origin, comparator)
        origin.reverse()
        return origin
    }
}
