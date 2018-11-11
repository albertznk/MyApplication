package znk.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val numeral_num = arrayOf("ံHex", "Binary", "Octal")
    var exportnumb:String?=null
    var User_Input:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var input_number=findViewById(R.id.user_input)as EditText
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, numeral_num)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_unit.adapter = adapter
        spinner_unit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                var Id:Int?=spinner_unit.selectedItemId.toInt()
                Userk.set(Id!!)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
        val n_convert_b= findViewById(R.id.n_convert_b) as Button

        n_convert_b.setOnClickListener {
            var buttoncheck:String?=input_number.text.toString()
            if(buttoncheck!="")
            {
                User_Input=input_number.text.toString().toInt()
                if (User_Input !=null)
                {
                    var c_id:Int?=Userk.get()
                    when(c_id)
                    {
                        1->    exportnumb=  Integer.toHexString(User_Input!!)
                        2->    exportnumb=  Integer.toBinaryString(User_Input!!)
                        3->    exportnumb=  Integer.toOctalString(User_Input!!)
                        else->{
                            Toast.makeText(this,"Something Wrong",Toast.LENGTH_LONG).show()}
                    }
                    //    Toast.makeText(this,exportnumb.toString(),Toast.LENGTH_LONG).show()
                    n_result.setText(exportnumb).toString()
                }
                else
                {
                    Toast.makeText(this,"Please Input Something ",Toast.LENGTH_SHORT).show()
                }

            }
            else
            {
                Toast.makeText(this,"Please Input Something ",Toast.LENGTH_SHORT).show()
            }

        }
    }

}


fun onNothingSelected(p0: AdapterView<*>?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}


class Userk{
    companion object {
        //@JvmStatic
        var company:Int=1

        fun set(Company:Int){
            this.company=Company+1
        }
        fun get():Int
        {
            return  Userk.company
        }
    }
}

