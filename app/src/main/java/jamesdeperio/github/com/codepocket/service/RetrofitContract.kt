package jamesdeperio.github.com.codepocket.service

import retrofit2.Converter

/**
* Created by jamesdeperio on 7/5/2017
*  jamesdeperio.github.com.codepocket.service
 */

internal interface RetrofitContract {
    fun initCacheSize(): Int
    fun initBaseURL(): String
    fun initWriteTimeOut(): Long = 10
    fun initConnectTimeOut(): Long = 10
    fun initReadTimeOut(): Long = 30
    fun create( service: Class<*>,username:String,password:String): Any
    fun create( service: Class<*>): Any
    fun initConverterFactory(): Converter.Factory

}