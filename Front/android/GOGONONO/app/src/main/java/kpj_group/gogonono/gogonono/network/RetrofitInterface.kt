package kpj_group.gogonono.gogonono.network

import io.reactivex.Observable
import kpj_group.gogonono.gogonono.model.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitInterface {
    @GET("users/login/{email}")
    fun getGroupList(@Path("email") email: String): Observable<Response>

    companion object {
        fun getGroupList(email:String):Observable<Response>{
            return NetworkUtil.create(RetrofitInterface::class.java).getGroupList(email)
        }
    }


}