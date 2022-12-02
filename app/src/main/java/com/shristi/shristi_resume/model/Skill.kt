package com.shristi.shristi_resume.model

import com.google.gson.annotations.SerializedName

class Skill {
    @SerializedName("name")
    lateinit var name:String

    override fun toString():String {
        return ("Skill{" +
                "name= " + name + "} ")
    }
}