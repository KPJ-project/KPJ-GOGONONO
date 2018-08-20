package kpj_group.gogonono.gogonono.model

import com.google.gson.annotations.SerializedName

class Group{
    @SerializedName("groupId")
    val groupId:Int=0

    @SerializedName("groupName")
    val groupName:String=""

    @SerializedName("groupUserCount")
    val groupUserCount=0

    @SerializedName("completeVotes")
    val completeVotes:Int=0

    @SerializedName("notCompleteVotes")
    val notCompleteVotes:Int=0
}