package za.co.dubedivine.app

import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.SimpleAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import za.co.dubedivine.app.adapter.MainActivityGridItemsAdapter
import android.content.Intent
import android.net.Uri
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        const val NUM_ROW_ITEMS  = 4
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        recyclerView.layoutManager = GridLayoutManager(this, NUM_ROW_ITEMS)
        recyclerView.adapter = MainActivityGridItemsAdapter()

        // add the the motto string

//        val header: TextView = findViewById(R.id.tvAbout) // todo should be tv header
//        header.text = getString(R.string.motto)



        //initialize ads section
//        MobileAds.initialize(this, "ca-app-pub-4443208221904295~1025407295"); // prod
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713")
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            super.onBackPressed()
        } else {
            drawer_layout.openDrawer(GravityCompat.START)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> {
                return true
            }
            R.id.action_contact_us -> {
                var dialog = AlertDialog.Builder(this)
                        .setTitle(getString(R.string.contact_us))
                        .setItems(arrayOf("Message us", "Call us"), { dialog: DialogInterface?, which: Int ->
                            Log.d("MainActivity", "Clicked $which")

                            when (which) {
                                0 -> {

                                }
                                1 -> {
                                    val intent = Intent(Intent.ACTION_DIAL)
                                    intent.data = Uri.parse("tel:079 123 4560")
                                    startActivity(intent)
                                }
                            }
                            dialog?.dismiss()
                        }).create()

                dialog.show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
