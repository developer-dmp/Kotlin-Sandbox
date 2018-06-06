package sample.dmp.com.kotlinsandbox

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_row.view.*
import kotlin.dmp.com.kotlinsandbox.R

class MainActivityAdapter(private val list:ArrayList<Person>, private val context:Context): RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_main_row, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        fun bind(person: Person) {

            val name = itemView.findViewById(R.id.name_textView) as TextView
            val age = itemView.findViewById(R.id.age_textView) as TextView

            name.text = person.name
            age.text = person.age.toString()

            val color = if (person.male!!) {
                Color.BLUE
            } else {
                Color.RED
            }

            itemView.icon_imageView.setColorFilter(color, PorterDuff.Mode.OVERLAY)
            itemView.setOnClickListener { Toast.makeText(context, person.name, Toast.LENGTH_SHORT).show() }
        }
    }
}