package fr.epita.finalexam_old

import android.app.Application

class storeList: Application() {
    companion object {
        val store : MutableList<ToDoObject> = arrayListOf()
    }
}