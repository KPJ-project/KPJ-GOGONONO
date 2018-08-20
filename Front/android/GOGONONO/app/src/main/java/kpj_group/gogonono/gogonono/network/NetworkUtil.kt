package kpj_group.gogonono.gogonono.network


import kpj_group.gogonono.gogonono.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class NetworkUtil {

    companion object {
        val BASE_URL = "http://14.39.161.25:3000/"

        fun getRetrofit(): Retrofit {

            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(createOkHttpClient())
                    .build()
        }

        fun <T> create(service:Class<T>):T{
            return getRetrofit().create(service)
        }

        fun createOkHttpClient(): OkHttpClient {
            val interceptor = HttpLoggingInterceptor()
            if(BuildConfig.DEBUG){
                interceptor.level = HttpLoggingInterceptor.Level.BODY
            } else{
                interceptor.level = HttpLoggingInterceptor.Level.NONE
            }
            return OkHttpClient()
                    .newBuilder()
                    .addNetworkInterceptor(interceptor)
                    .build()
        }

    }




}