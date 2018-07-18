package za.co.dubedivine.app

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.TextView
import kotlinx.android.synthetic.main.content_main.*
import za.co.dubedivine.app.adapter.AutoAdapter
import za.co.dubedivine.app.adapter.HomeAdapater

class HomeActivity : AppCompatActivity() {


    companion object {
        fun getStartActivity(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)

        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = HomeAdapater()

        // add the the motto string

        val header: TextView = findViewById(R.id.tvAbout) // todo should be tv header
        header.text = getString(R.string.home)
    }
}
