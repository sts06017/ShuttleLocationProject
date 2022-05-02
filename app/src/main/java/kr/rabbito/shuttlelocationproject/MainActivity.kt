package kr.rabbito.shuttlelocationproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_btn_toGetLocation.setOnClickListener {
            val intent = Intent(this, GetLocationActivity::class.java)
            startActivity(intent)
        }
    }
}
