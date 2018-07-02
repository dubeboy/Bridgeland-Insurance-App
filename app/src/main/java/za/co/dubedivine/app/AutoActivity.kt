package za.co.dubedivine.app

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class AutoActivity : AppCompatActivity() {

    companion object {
        fun getStartActivity(context: Context): Intent {
            return Intent(context, AutoActivity::class.java)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto)
    }
}
