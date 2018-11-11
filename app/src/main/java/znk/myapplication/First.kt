package znk.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class First : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        binaryImage.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        measureImage.setOnClickListener {
            val intent=Intent(this,Measurement_unit::class.java)
            startActivity(intent)
        }
        voltage_img.setOnClickListener{
            val intent=Intent(this,Density::class.java)
            startActivity(intent)
        }
        measure_tape.setOnClickListener{
            val intent=Intent(this,Civil_Meter::class.java)
            startActivity(intent)
        }

    }
}
