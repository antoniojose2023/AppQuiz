package br.com.antoniojoseuchoa.appquiz

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import br.com.antoniojoseuchoa.appquiz.databinding.ActivityMainBinding
import br.com.antoniojoseuchoa.appquiz.fragment.HomeFragment


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

           val mDecorView = window.decorView
           mDecorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }

           supportFragmentManager.beginTransaction().add(R.id.fragment_container, HomeFragment()).commit()
    }

}