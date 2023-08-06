package br.com.antoniojoseuchoa.appquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import br.com.antoniojoseuchoa.appquiz.databinding.ActivityMainBinding
import br.com.antoniojoseuchoa.appquiz.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mDecorView = window.decorView
        mDecorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
        }, 3000)

    }
}