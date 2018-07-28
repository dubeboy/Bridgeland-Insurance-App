package za.co.dubedivine.app

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.TextView
import kotlinx.android.synthetic.main.content_main.*
import za.co.dubedivine.app.MainActivity.Companion.NUM_ROW_ITEMS
import za.co.dubedivine.app.adapter.AutoAdapter

class AutoActivity : AppCompatActivity() {

    companion object {
        fun getStartActivity(context: Context): Intent {
            return Intent(context, AutoActivity::class.java)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)

        recyclerView.layoutManager = GridLayoutManager(this, NUM_ROW_ITEMS)
        recyclerView.adapter = AutoAdapter()

        // add the the motto string

//        val header: TextView = findViewById(R.id.tvAbout) // todo should be tv header
//        header.text = getString(R.string.auto)
    }
}
