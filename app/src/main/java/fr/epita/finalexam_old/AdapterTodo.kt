package fr.epita.finalexam_old

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class AdapterTodo(val todoArray :List<ToDoObject>,
                  var context: Activity
                  ):RecyclerView.Adapter<AdapterTodo.ViewHolder>() {

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var checkbtn : CheckBox
        init {
            checkbtn = itemView.findViewById(R.id.checker)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(context)
            .inflate(R.layout.check_list, parent, false)
        val viewHolder = ViewHolder(itemView)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todo : ToDoObject = todoArray[position]
        holder.itemView.apply {
            holder.checkbtn.text = todo.title
            if (todo.completed == true){
                holder.checkbtn.isChecked = true
            }
            holder.checkbtn.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    todo.completed = true
                    Toast.makeText(context, "${todo.completed}", Toast.LENGTH_SHORT).show()
                } else {
                    todo.completed = false
                    Toast.makeText(context, "${todo.completed}", Toast.LENGTH_SHORT).show()
                }
            }
        }
        holder.checkbtn.tag = position
    }

    override fun getItemCount(): Int {
        return todoArray.size
    }
}
