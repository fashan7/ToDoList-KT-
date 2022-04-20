package fr.epita.finalexam_old

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import fr.epita.finalexam_old.storeList.Companion.store
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var userid:Int = 0
    private var username:String = toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllTodo()
        click_btn()
        logo_click()
    }

    fun click_btn(){

        var btnFashan = findViewById<Button>(R.id.user_fashan)
        btnFashan.setOnClickListener {
            userid= 1
            username = "Fashan"
            call_intent()
        }

        var btnThoshith = findViewById<Button>(R.id.user_thoshith)
        btnThoshith.setOnClickListener {
            userid = 3
            username = "Thoshith"
            call_intent()
        }

        var btnPavan = findViewById<Button>(R.id.user_pavan)
        btnPavan.setOnClickListener {
            userid = 5
            username = "Pavan"
            call_intent()
        }

        var btnPierre = findViewById<Button>(R.id.user_pierre)
        btnPierre.setOnClickListener {
            userid = 7
            username = "Pierre"
            call_intent()
        }

        var btnElias = findViewById<Button>(R.id.user_elias)
        btnElias.setOnClickListener {
            userid = 9
            username = "Elias"
            call_intent()
        }
    }

    fun call_intent(){
        Intent(this@MainActivity, listscreen::class.java).also {
            it.putExtra("id", userid.toString())
            it.putExtra("username", username)
            startActivity(it)
        }
    }

    fun logo_click(){
        var logoClick = findViewById<ImageView>(R.id.epita)
        logoClick.setOnClickListener {
            val intent  = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.epita.fr")
            startActivity(intent)
        }
    }

    fun getAllTodo(){
        API.service.getAllTodo().enqueue(object : Callback<List<ToDoObject>> {
            override fun onResponse(
                call: Call<List<ToDoObject>>,
                response: Response<List<ToDoObject>>
            ) {
                var todoArray = response.body()!!
                for (row in todoArray){
                    store.add(ToDoObject(row.userId, row.id, row.title, row.completed))
                }
            }

            override fun onFailure(call: Call<List<ToDoObject>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}

