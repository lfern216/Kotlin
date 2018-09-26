package tt.reddit.application.com.kotlintutorial

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ListView1 = listview
        ListView1.adapter = CustomAdapter(this)
    }

    private class CustomAdapter(context: Context): BaseAdapter(){

        private val names = arrayListOf<String>(
                "Lazaro F", "Jose J", "Jessica R"
        )

        val c: Context

        init {
            this.c = context
        }

        override fun getView(position: Int, view: View?, viewgroup: ViewGroup?): View {

            val LayoutInflater = LayoutInflater.from(c)
            val viewOfLayoutInflator = LayoutInflater.inflate(R.layout.layout_inflator,viewgroup,false)

            val text_Name = viewOfLayoutInflator.findViewById<TextView>(R.id.layout_inflator_textView1)
            text_Name.setText("Name: " + names.get(position))

            val task = viewOfLayoutInflator.findViewById<TextView>(R.id.layout_inflator_textView2)
            task.setText("Task " + position)

            return viewOfLayoutInflator
        }

        override fun getItem(position: Int): Any {

            return "Hello string"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return 3
        }
    }
}
