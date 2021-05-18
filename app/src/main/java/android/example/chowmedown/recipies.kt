package android.example.chowmedown

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recipe_row.*
import kotlinx.android.synthetic.main.recipe_row.view.*


class recipies : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
//    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(android.example.chowmedown.R.layout.recipies)


        recyclerView= findViewById(R.id.recyclerView_recp)
//        listView = findViewById(R.id.listingri)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Recipeadaptor()

//        listView.adapter = MyCusAdaptor(this)
    }

//    private class MyCusAdaptor(context: Context): BaseAdapter() {
//
//        private val mContext: Context
//
//        init{
//          this.mContext = context
//        }
////responsible for how many rows in list
//        override fun getCount(): Int {
//            TODO("Not yet implemented")
//        }
//
//        override fun getItemId(position: Int): Long {
//            return position.toLong()
//        }
//
//        override fun getItem(position: Int): Any {
//            return "test"
//        }
//        //renders each row
//        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//            val textView = TextView(mContext)
//            textView.text = "here is my row"
//            return textView
//
//        }
//
//    }
}