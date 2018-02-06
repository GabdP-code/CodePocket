package jamesdeperio.github.com.codepocket.service

import android.content.Context
import okhttp3.Cache
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * Created by jamesdeperio on 7/5/2017
 *  jamesdeperio.github.com.codepocket.service
 */
abstract class RetrofitService(private val context:Context) : RetrofitContract {
    private var retrofit: Retrofit? = null

    override fun create(service: Class<*>): Any {
        if(retrofit==null){
            if (initCacheSize()!=0) {
                val cacheSize = initCacheSize() * 1024 * 1024
                val cache = Cache(context.cacheDir, cacheSize.toLong())
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                val okHttpClient = OkHttpClient.Builder()
                        .cache(cache)
                        .writeTimeout(initWriteTimeOut(), TimeUnit.SECONDS)
                        .connectTimeout(initConnectTimeOut(), TimeUnit.SECONDS)
                        .readTimeout(initReadTimeOut(), TimeUnit.SECONDS)
                        .addInterceptor(logging)
                        .build()
                retrofit = Retrofit.Builder()
                        .baseUrl(initBaseURL())
                        .client(okHttpClient)
                        .addConverterFactory(initConverterFactory())
                        .addCallAdapterFactory(initRxAdapterFactory())
                        .build()
            }else {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                val okHttpClient = OkHttpClient.Builder()
                        .writeTimeout(initWriteTimeOut(), TimeUnit.SECONDS)
                        .connectTimeout(initConnectTimeOut(), TimeUnit.SECONDS)
                        .readTimeout(initReadTimeOut(), TimeUnit.SECONDS)
                        .addInterceptor(logging)
                        .build()
                retrofit = Retrofit.Builder()
                        .baseUrl(initBaseURL())
                        .client(okHttpClient)
                        .addConverterFactory(initConverterFactory())
                        .addCallAdapterFactory(initRxAdapterFactory())
                        .build()
            }
        }
        return retrofit!!.create(service)
    }

    override fun create(service: Class<*>, username: String, password: String): Any {
        val authToken =  Credentials.basic(username, password)
        val interceptor = AuthenticationInterceptor(authToken)
             if (initCacheSize()!=0) {
                val cacheSize = initCacheSize() * 1024 * 1024
                val cache = Cache(context.cacheDir, cacheSize.toLong())
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                val okHttpClient = OkHttpClient.Builder()
                        .cache(cache)
                        .writeTimeout(initWriteTimeOut(), TimeUnit.SECONDS)
                        .connectTimeout(initConnectTimeOut(), TimeUnit.SECONDS)
                        .readTimeout(initReadTimeOut(), TimeUnit.SECONDS)
                        .addInterceptor(logging)
                        .addInterceptor(interceptor)
                        .build()
                retrofit = Retrofit.Builder()
                        .baseUrl(initBaseURL())
                        .client(okHttpClient)
                        .addConverterFactory(initConverterFactory())
                        .addCallAdapterFactory(initRxAdapterFactory())
                        .build()
            }else {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                val okHttpClient = OkHttpClient.Builder()
                        .writeTimeout(initWriteTimeOut(), TimeUnit.SECONDS)
                        .connectTimeout(initConnectTimeOut(), TimeUnit.SECONDS)
                        .readTimeout(initReadTimeOut(), TimeUnit.SECONDS)
                        .addInterceptor(logging)
                        .addInterceptor(interceptor)
                        .build()
                retrofit = Retrofit.Builder()
                        .baseUrl(initBaseURL())
                        .client(okHttpClient)
                        .addConverterFactory(initConverterFactory())
                        .addCallAdapterFactory(initRxAdapterFactory())
                        .build()
            }
        return retrofit!!.create(service)
    }
}
