package fr.epita.finalexam_old

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epita.finalexam_old.storeList.Companion.store

class listscreen : AppCompatActivity() {
    private lateinit var todolist : RecyclerView
    private lateinit var manager : RecyclerView.LayoutManager
    private var get_username: String = toString()
    private var get_id:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listscreen)
        manager = LinearLayoutManager(this@listscreen, LinearLayoutManager.VERTICAL, false)
        val orginIntent = intent
        get_id = orginIntent.getStringExtra("id")?.toInt()!!
        get_username = orginIntent.getStringExtra("username").toString()
        val headertext = findViewById<TextView>(R.id.header)

        headertext.text = "Hello, ${get_username}, you have the following things to do ASAP:"
        if (get_id != null) {
            extractToDo(get_id)
            add_listener()
        }

    }

    fun extractToDo(id:Int){
        var store_ = store.filterIndexed { index, toDoObject -> toDoObject.userId == id }
        todolist = findViewById<RecyclerView>(R.id.main_cycler).apply {
            layoutManager = manager
            adapter = AdapterTodo(store_, this@listscreen)
            addItemDecoration(DividerItemDecoration(this@listscreen, DividerItemDecoration.VERTICAL))
        }
    }

    fun add_listener(){
        val btnClck = findViewById<Button>(R.id.addnew)
        btnClck.setOnClickListener {
            call_intent()
        }
    }

    fun call_intent(){
        Intent(this@listscreen, addtodo::class.java).also {
            it.putExtra("id", get_id.toString())
            it.putExtra("username", get_username)
            startActivity(it)
        }
    }
}