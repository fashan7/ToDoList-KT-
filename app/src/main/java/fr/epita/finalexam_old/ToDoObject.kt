package fr.epita.finalexam_old

import java.io.Serializable

data class ToDoObject (var userId:Int?, var id:Int?, var title:String?, var completed:Boolean?): Serializable
