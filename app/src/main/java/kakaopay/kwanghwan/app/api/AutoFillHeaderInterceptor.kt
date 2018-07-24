package kakaopay.kwanghwan.app.api

import kakaopay.kwanghwan.app.statics.Constants
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AutoFillHeaderInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Authorization", Constants.KAKAO_NATIVE_API_KEY)
        val request = builder.build()
        return chain.proceed(request)
    }
}
