package za.co.dubedivine.app

import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_fullscreen.*
import za.co.dubedivine.app.adapter.NumberGridAdapter
import android.app.KeyguardManager
import android.graphics.Color
import android.hardware.fingerprint.FingerprintManager
import android.support.annotation.RequiresApi
import android.widget.TextView
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import android.view.WindowManager
import za.co.dubedivine.app.MainActivity.Companion.NUM_ROW_ITEMS


class FullscreenActivity : AppCompatActivity() {

    private var cipher: Cipher? = null
    private var keyStore: KeyStore? = null
    private var keyGenerator: KeyGenerator? = null
    private var cryptoObject: FingerprintManager.CryptoObject? = null
    private var fingerprintManager: FingerprintManager? = null
    private var keyguardManager: KeyguardManager? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)

        password_btns.layoutManager = GridLayoutManager(this, NUM_ROW_ITEMS)
        password_btns.adapter = NumberGridAdapter({ value: Int ->
            when (value) {
                -1 -> {
                    tv_password_view.text = tv_password_view.text.dropLast(1)
                }
                -2 -> {
                   startActivity(Intent(this, MainActivity::class.java))
                }
                else -> {
                    tv_password_view.append(value.toString())
                }
            }
        })

        val make = Snackbar.make(findViewById<View>(android.R.id.content), "You can use your fingerprint or password", Snackbar.LENGTH_INDEFINITE)
        make.setAction("Dismiss", View.OnClickListener {
            make.dismiss()
        })
        make.show()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = getColor(R.color.bg)
        }

       // setUpFingerPrintScanner()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun setUpFingerPrintScanner() {
    keyguardManager =
             getSystemService(KEYGUARD_SERVICE) as KeyguardManager
    fingerprintManager =
             getSystemService(FINGERPRINT_SERVICE) as FingerprintManager
    }

}
