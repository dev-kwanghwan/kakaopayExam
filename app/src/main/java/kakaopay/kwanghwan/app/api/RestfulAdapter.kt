package kakaopay.kwanghwan.app.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import kakaopay.kwanghwan.app.statics.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestfulAdapter {
    lateinit var apiService: ApiService

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .addInterceptor(AutoFillHeaderInterceptor())
                .addInterceptor(interceptor).build()

        //Retrofit 설정
        apiService = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService::class.java) //인터페이스 연결
    }
}
