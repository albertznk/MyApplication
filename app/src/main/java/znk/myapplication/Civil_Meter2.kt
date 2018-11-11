package znk.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_civil__meter.*

class Civil_Meter2 : AppCompatActivity() {
    val other_num = arrayOf("CentiWatt", "Joule", "Pond", "Ton of Refrigeration", "Dyne")
    var input_Unit: Int? = null
    var tometer_int: Int? = 0
    var sp_input: Int? = 0
    var sp_output: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_civil__meter2)
        var edittext = findViewById(R.id.input_unit_other) as EditText
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, other_num)
        unit_for_iu_other.adapter = adapter
        val ou_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, other_num)
        unit_for_ou_other.adapter = ou_adapter
        unit_for_iu_other.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                sp_input = unit_for_iu_other.selectedItemId.toInt()
                Measure_Unit.set(sp_input!!)
                Log.i("sp_input",sp_input.toString())
            }
        }

        unit_for_ou_other.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                sp_output = unit_for_ou_other.selectedItemId.toInt()
                Measure_Unit.set_ou(sp_output!!)

            }


        }
        convert_unit_other.setOnClickListener {
            var iu = edittext.text.toString()
            if (iu != "") {
                input_Unit = edittext.text.toString().toInt()
                var in_id: Int? = Measurement_unit.Measure_Unit.get()
                var ou_id: Int? = Measurement_unit.Measure_Unit.get_ou()
                when (in_id) {
                    1 -> {
                        blabla(ou_id!!)

                    }
//                    2->  {Centi_Function(ou_id!!)}
//                    3->  {Mili_funtion(ou_id!!)}
//                    4->  {Deci_Function(ou_id!!)}
//                    5-> {Kilo_function(ou_id!!)}
                }

            } else {
                Toast.makeText(this, "Please Input Something ", Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun  blabla(ou_id: Int){
        if (ou_id==2)
        {
            result_measurement_other.setText("bla")
        }
    }

    fun Wat_function(ou_id:Int){
        if (ou_id == 2) {
            Log.i("joule","success")
            result_measurement_other.setText(watt_to_joule(input_Unit!!).toString()+"joule/hour")
        }
        else if (ou_id==3){
            result_measurement_other.setText(watt_to_pound(input_Unit!!)+"pound square foot")
        }
        else if (ou_id==4)
        {
        }
        else if (ou_id==5)
        {
        }

    }

    ///////////////////////////////////////Watt//////////////
    fun watt_to_joule(input_unit: Int): Int {
        return input_unit * 36
    }
    fun watt_to_pound(input_unit: Int): String
    {
        var watt_to=input_unit.toDouble()
        return String.format("%.7f",watt_to/0.2373036047)
    }
    class Measure_Unit {
        companion object {
            var unit_id: Int? = 1
            var unit_id_ou: Int? = 1
            fun get(): Int {
                return unit_id!!
            }

            fun set(Unit_id: Int) {
                unit_id = Unit_id + 1
            }

            fun get_ou(): Int {
                return unit_id_ou!!
            }

            fun set_ou(Unit_Id_Ou: Int) {
                unit_id_ou = Unit_Id_Ou + 1
            }
        }
    ///////////////////////////////////////////////////////////
}


}

