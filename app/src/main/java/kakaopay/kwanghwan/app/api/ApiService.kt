package kakaopay.kwanghwan.app.api

import io.reactivex.Single
import kakaopay.kwanghwan.app.model.KakaoImage
import kakaopay.kwanghwan.app.model.KakaoVideo
import kakaopay.kwanghwan.app.model.response.MediaMetaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/search/image")
    fun getKakaoImages(@Query(value = "query", encoded = true) query: String): Single<MediaMetaResponse<KakaoImage>>

    @GET("v2/search/vclip")
    fun getKakaoVideos(@Query(value = "query", encoded = true) query: String): Single<MediaMetaResponse<KakaoVideo>>
}