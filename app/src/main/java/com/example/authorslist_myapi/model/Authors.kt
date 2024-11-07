package com.example.authorslist_myapi.model
import com.google.gson.annotations.SerializedName

data class Authors(

    @SerializedName("id")
    val id: Int,

    @SerializedName("email")
    val email: String,

    @SerializedName("name")
    val fullName: String,

    @SerializedName("avatar")
    val avatar: String,
)
