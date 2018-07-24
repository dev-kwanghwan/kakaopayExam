package kakaopay.kwanghwan.app.model

/**
 * 리스트를 구성할 Media 인터페이스 입니다.
 */
interface KakaoMedia {
    val mediaSource: String

    val mediaType: Int

    val title: String

    val author: String

    val date: String
}