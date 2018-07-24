package kakaopay.kwanghwan.app.util

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import kakaopay.kwanghwan.app.R
import kakaopay.kwanghwan.app.ui.activity.ImageDetailActivity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Util 메서드가 모여있습니다.
 */
object CommonUtil {
    /**
     * 시간 정렬을 위해 millisecond를 구합니다.
     */
    fun timeConvertToMillisecond(context: Context, tzDate: String): Long? {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+09:00", getCurrentLocale(context))
        var convertDate: Long? = 0L
        try {
            val date = simpleDateFormat.parse(tzDate)
            convertDate = date.time
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return convertDate
    }

    /**
     * UI에 보여지는 시간 포멧으로 변환합니다.
     */
    fun getMediaDateTime(context: Context, stringDate: String): String {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+09:00", getCurrentLocale(context))
        try {
            return SimpleDateFormat(context.getString(R.string.kakao_media_datetime_format), getCurrentLocale(context)).format(simpleDateFormat.parse(stringDate))
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return stringDate
    }

    /**
     * 현재 Locale을 구합니다.
     */
    private fun getCurrentLocale(context: Context): Locale {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.resources.configuration.locales.get(0)
        } else {
            context.resources.configuration.locale
        }
    }

    /**
     * 상세 이미지 사이즈를 반환
     */
    fun getDetailImageSize(imageDetailActivity: ImageDetailActivity): Int {
        val metrics = DisplayMetrics()
        imageDetailActivity.windowManager.defaultDisplay.getMetrics(metrics)
        return metrics.widthPixels
    }
}
