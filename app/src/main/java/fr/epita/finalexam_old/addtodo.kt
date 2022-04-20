package fr.epita.finalexam_old

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import fr.epita.finalexam_old.storeList.Companion.store
import java.util.*

class addtodo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtodo)

        val orginIntent = intent
        val getid = orginIntent.getStringExtra("id")?.toInt()
        val getUsername = orginIntent.getStringExtra("username").toString()

        val description : EditText = findViewById(R.id.textarea)
        var totalCount = store.size
        val headertext = findViewById<TextView>(R.id.headeradd)

        headertext.text = "Hello ${getUsername}, to add a new item to your list, just type its content in the box below and press then Add button"


        val btnClck = findViewById<Button>(R.id.addtodo)
        btnClck.setOnClickListener {
            if (headertext.text.toString().trim().isNotEmpty() ||
                headertext.text.toString().trim().isNotBlank()) {
                store.add(ToDoObject(getid, totalCount++, description.text.toString(), false))
                Toast.makeText(this@addtodo, "Successfully saved", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@addtodo, "Text Field is empty", Toast.LENGTH_LONG).show()
            }

        }
    }
}