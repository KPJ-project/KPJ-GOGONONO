package kpj_group.gogonono.gogonono.model

import com.google.gson.annotations.SerializedName

class Response{
    @SerializedName("isFirst")
    val isFirst:Boolean=false

    @SerializedName("userId")
    val userId:Int=0


    @SerializedName("groupList")
    val groupList:List<Group> = listOf()
}