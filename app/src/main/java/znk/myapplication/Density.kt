package znk.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_density.*

class Density : AppCompatActivity() {
    val other_num = arrayOf("Degree", "Grad", "Radian")
    var input_Unit: Int? = null
    var tometer_int: Int? = 0
    var sp_input: Int? = 0
    var sp_output: Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_density)

        var edittext = findViewById(R.id.input_unit_density) as EditText
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, other_num)
        unit_for_iu_density.adapter = adapter
        val ou_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, other_num)
        unit_for_ou_density.adapter = ou_adapter
        unit_for_iu_density.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                sp_input = unit_for_iu_density.selectedItemId.toInt()
                Measure_Unit_Other.set(sp_input!!)
                Log.i("sp_input",sp_input.toString())
            }
        }

        unit_for_ou_density.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                sp_output = unit_for_ou_density.selectedItemId.toInt()
                Measure_Unit_Other.set_ou(sp_output!!)

            }


        }
        convert_unit_desnity.setOnClickListener {
            var iu = edittext.text.toString()
            if (iu != "") {
                input_Unit = edittext.text.toString().toInt()
                var in_id: Int? = Measure_Unit_Other.get()
                var ou_id: Int? = Measure_Unit_Other.get_ou()
                when (in_id) {
                    1 -> {
                        Wat_function(ou_id!!)
                    }
                    2->  {Joule(ou_id!!)}
                    3->  {Pond(ou_id!!)}
                   }

            } else {
                Toast.makeText(this, "Please Input Something ", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun Wat_function(ou_id:Int){
        val  result_measurement_other: TextView = findViewById(R.id.result_measurement_density) as TextView
        if (ou_id == 1) {
            result_measurement_other.setText("Cannot convert same Unit!!")
        }

      else  if (ou_id == 2) {
            result_measurement_other.setText(watt_to_joule(input_Unit!!))
        }
        else if (ou_id==3){
            result_measurement_other.setText(watt_to_pound(input_Unit!!))
        }

    }
    fun Joule(ou_id: Int){
        if (ou_id == 1) {
            result_measurement_density.setText(jole_to_wat(input_Unit!!))
        }
        else if (ou_id==3){
            result_measurement_density.setText(jole_to_pond(input_Unit!!))
        }

    }
    /////////////////////////////////////////////////////////////////
    fun Pond(ou_id: Int){
        if (ou_id == 1) {
            result_measurement_density.setText(pond_to_wat(input_Unit!!))
        }

        else if (ou_id==2){
            result_measurement_density.setText(pond_to_joule(input_Unit!!))
        }
       else if (ou_id == 1) {
            result_measurement_density.setText("Cannot convert same Unit!!")
        }

        else if (ou_id==4)
        {
            result_measurement_density.setText(pon_to_ton(input_Unit!!))
        }

    }
    /////////////////////////////////////////////////////////
    fun Ton(ou_id: Int){
        if (ou_id == 1) {
            result_measurement_density.setText(ton_to_wat(input_Unit!!))
        }
        else if (ou_id==2){
            result_measurement_density.setText(ton_to_joule(input_Unit!!))
        }
        else if (ou_id==3)
        {
            result_measurement_density.setText(ton_to_pon(input_Unit!!))
        }
        else if (ou_id == 4) {
            result_measurement_density.setText("Cannot convert same Unit!!")
        }
    }
    ///////////////////////////////////////////////////////////////////////
    fun Dyne(ou_id: Int){
        if (ou_id == 1) {
            result_measurement_density.setText(weight_to_wat(input_Unit!!))
        }
        else if (ou_id==2){
            result_measurement_density.setText(weight_to_joule(input_Unit!!))
        }
        else if (ou_id==3)
        {
            result_measurement_density.setText(weight_to_pon(input_Unit!!))
        }
        else if (ou_id == 4) {
            result_measurement_density.setText("Cannot convert same Unit!!")
        }

    }

    ///////////////////////////////////////Watt//////////////
    fun watt_to_joule(input_unit: Int): String {
        return ((input_unit * 1).toString())
    }
    fun watt_to_pound(input_unit: Int): String
    {
        var watt_to=input_unit.toDouble()
        return String.format("%.7f",watt_to*0.01745329)
    }

    ///////////////////////////////////////////////////////////
    fun jole_to_wat(input_unit: Int):String{

        return String.format("%5f",input_unit * 0.9).toString()
    }
    fun jole_to_pond(input_unit: Int):String{
        var pond=input_unit.toDouble()
        return  String.format("%10f", pond* 0.01570796326)
    }

    //////////////////////////////////////////////////////////
    fun pond_to_wat(input_unit: Int):String
    {
        var pwat=input_unit.toDouble()
        return  String.format("%11f",pwat *4.214011)
    }
    fun  pond_to_joule(input_unit: Int):String{
        var pte=input_unit.toDouble()
        return  String.format("%10f",pte*151.704396)
    }
    fun pon_to_ton(input_unit: Int):String
    {
        var pton=input_unit.toDouble()
        return  String.format("%10f",pton*0.00001198)
    }
    fun pon_to_dyne(input_unit: Int):String
    {
        var ptd=input_unit.toDouble()
        return  String.format("%10f",ptd*25284066)
    }
    //////////////////////////////////////////////////////////////
    fun ton_to_wat(input_unit: Int):String
    {
        var pwat=input_unit.toDouble()
        return  String.format("%10f",pwat *351685.284)
    }
    fun  ton_to_joule(input_unit: Int):String{
        var pte=input_unit.toDouble()
        return  String.format("%7f",pte*12660670.224)
    }
    fun ton_to_pon(input_unit: Int):String
    {
        var pton=input_unit.toDouble()
        return  String.format("%7f",pton*83456.18)
    }
    fun ton_to_dyne(input_unit: Int):String
    {
        var ptd=input_unit.toDouble()
        return  String.format("%1f",ptd*126940000.0)
    }
    //////////////////////////////////////////////////////////////
    fun weight_to_wat(input_unit: Int):String
    {
        var pwat=input_unit.toDouble()
        return  String.format("%7f",pwat *2.7777777)
    }
    fun  weight_to_joule(input_unit: Int):String{
        var pte=input_unit.toDouble()
        return  String.format("%7f",pte/10000000)
    }
    fun weight_to_pon(input_unit: Int):String
    {
        var pton=input_unit.toDouble()
        return  String.format("%11f",pton*6.59176679)
    }
    fun weight_to_ton(input_unit: Int):String
    {
        var ptd=input_unit.toDouble()
        return  String.format("%10f",ptd*12667540000.0)
    }

    ////////////////////////////////////////////////////////
    class Measure_Unit_Other {
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


