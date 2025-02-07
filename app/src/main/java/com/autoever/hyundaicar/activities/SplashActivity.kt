package com.autoever.hyundaicar.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.autoever.hyundaicar.R
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 2초 뒤에 페이지 이동
        Handler(Looper.getMainLooper()).postDelayed({
            val auth = FirebaseAuth.getInstance()
            val currentUser = auth.currentUser
            var intent: Intent? = null
            if (currentUser != null) {
                // 사용자가 로그인된 상태
                Log.d("SplashActivity", currentUser.toString())
                intent = Intent(this, MainActivity::class.java)
            } else {
                // 사용자가 로그인 안 된 상태
                intent = Intent(this, LoginActivity::class.java)
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        },2000)
    }
}