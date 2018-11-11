package znk.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_civil__meter.*
import kotlinx.android.synthetic.main.activity_measurement_unit.*
import org.w3c.dom.Text
import znk.myapplication.R.id.result_measurement_other

class Civil_Meter : AppCompatActivity() {
    val other_num = arrayOf("CentiWatt", "Joule", "Pond", "Ton of Refrigeration", "Dyne")
    var input_Unit: Int? = null
    var tometer_int: Int? = 0
    var sp_input: Int? = 0
    var sp_output: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_civil__meter)
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
                Measure_Unit_Other.set(sp_input!!)
                Log.i("sp_input",sp_input.toString())
            }
        }

        unit_for_ou_other.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                sp_output = unit_for_ou_other.selectedItemId.toInt()
                Measure_Unit_Other.set_ou(sp_output!!)

            }


        }
        convert_unit_other.setOnClickListener {
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
                    4->  { Ton(ou_id!!)}
                   5->  {Dyne(ou_id!!) }
                }

            } else {
                Toast.makeText(this, "Please Input Something ", Toast.LENGTH_SHORT).show()
            }
        }
    }


   fun Wat_function(ou_id:Int){
       val  result_measurement_other:TextView= findViewById(R.id.result_measurement_other) as TextView

       if (ou_id == 2) {
            result_measurement_other.setText(watt_to_joule(input_Unit!!))
            }
        else if (ou_id ==1){
           result_measurement_other.setText("Cannot convert same Unit!!")
       }

        else if (ou_id==3){
            result_measurement_other.setText(watt_to_pound(input_Unit!!))
        }
        else if (ou_id==4)
        {
            result_measurement_other.setText(watt_to_ton(input_Unit!!))
        }
        else if (ou_id==5)
        {
            result_measurement_other.setText(watt_to_dyne(input_Unit!!))
        }

    }
    fun Joule(ou_id: Int){
        if (ou_id == 1) {
            result_measurement_other.setText(jole_to_wat(input_Unit!!))
        }
        else if (ou_id ==2){
            result_measurement_other.setText("Cannot convert same Unit!!")
        }
        else if (ou_id==3){
            result_measurement_other.setText(jole_to_pond(input_Unit!!))
        }
        else if (ou_id==4)
        {
            result_measurement_other.setText(jole_to_ton(input_Unit!!))
        }
        else if (ou_id==5)
        {
            result_measurement_other.setText(jole_to_dyne(input_Unit!!))
        }

    }
/////////////////////////////////////////////////////////////////
 fun Pond(ou_id: Int){
    if (ou_id == 1) {
        result_measurement_other.setText(pond_to_wat(input_Unit!!))
    }
    else if (ou_id==2){
        result_measurement_other.setText(pond_to_joule(input_Unit!!))
    }
    else if (ou_id ==3){
        result_measurement_other.setText("Cannot convert same Unit!!")
    }
    else if (ou_id==4)
    {
        result_measurement_other.setText(pon_to_ton(input_Unit!!))
    }
    else if (ou_id==5)
    {
        result_measurement_other.setText(pon_to_dyne(input_Unit!!))
    }

}
    /////////////////////////////////////////////////////////
    fun Ton(ou_id: Int){
        if (ou_id == 1) {
            result_measurement_other.setText(ton_to_wat(input_Unit!!))
        }
        else if (ou_id==2){
            result_measurement_other.setText(ton_to_joule(input_Unit!!))
        }
        else if (ou_id==3)
        {
            result_measurement_other.setText(ton_to_pon(input_Unit!!))
        }
        else if (ou_id ==4){
            result_measurement_other.setText("Cannot convert same Unit!!")
        }
        else if (ou_id==5)
        {
            result_measurement_other.setText(ton_to_dyne(input_Unit!!))
        }

        }
///////////////////////////////////////////////////////////////////////
fun Dyne(ou_id: Int){
    if (ou_id == 1) {
        result_measurement_other.setText(weight_to_wat(input_Unit!!))
    }
    else if (ou_id==2){
        result_measurement_other.setText(weight_to_joule(input_Unit!!))
    }
    else if (ou_id==3)
    {
        result_measurement_other.setText(weight_to_pon(input_Unit!!))
    }
    else if (ou_id ==5){
        result_measurement_other.setText("Cannot convert same Unit!!")
    }
    else if (ou_id==4)
    {
        result_measurement_other.setText(weight_to_ton(input_Unit!!))
    }
}
    ///////////////////////////////////////Watt//////////////
        fun watt_to_joule(input_unit: Int): Int {
            return (input_unit * 36)
        }
        fun watt_to_pound(input_unit: Int): String
        {
            var watt_to=input_unit.toDouble()
            return String.format("%.7f",watt_to/0.2373036047)
        }
        fun watt_to_ton(input_unit: Int):String{
            var ton=input_unit.toDouble()
            return String.format("%.13f",ton*0.000002843451)
        }
        fun watt_to_dyne(input_unit: Int):String{
            var dyne=input_unit.toDouble()
            return String.format("%13f",dyne*360000000)
        }

    ///////////////////////////////////////////////////////////
    fun jole_to_wat(input_unit: Int):String{

        return String.format("%5f",input_unit/36).toString()
    }
    fun jole_to_pond(input_unit: Int):String{
        var pond=input_unit.toDouble()
        return  String.format("%10f", pond*0.006591766)
    }
    fun  jole_to_ton(input_unit: Int):String{
        var ton=input_unit.toDouble()
        return String.format("%10f",ton*7.8984760)
    }
    fun  jole_to_dyne(input_unit: Int):String
    {
        var dyne=input_unit.toDouble()
        return String.format("%10f",dyne*10000000)
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





