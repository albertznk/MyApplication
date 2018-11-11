package znk.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_measurement_unit.*
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat
import java.time.format.DecimalStyle

class Measurement_unit : AppCompatActivity() {
    val measure_num = arrayOf("ံMeter/Metre", "Centimeter", "Millimeter", "Decimeter", "Kilometer", "Inch")
    var input_Unit: Int? = null
    var tometer_int: Int? = 0
    var sp_input: Int? = 0
    var sp_output: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_measurement_unit)
        var edittext = findViewById(R.id.input_unit) as EditText
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, measure_num)
        unit_for_iu.adapter = adapter
        val ou_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, measure_num)
        unit_for_ou.adapter = ou_adapter
        unit_for_iu.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                sp_input = unit_for_iu.selectedItemId.toInt()
                Measure_Unit.set(sp_input!!)
            }
        }

        unit_for_ou.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                sp_output = unit_for_ou.selectedItemId.toInt()
                Measure_Unit.set_ou(sp_output!!)

            }


        }
        convert_unit.setOnClickListener {
            var iu = edittext.text.toString()
            if (iu != "") {
                input_Unit = edittext.text.toString().toInt()
                var in_id: Int? = Measure_Unit.get()
                var ou_id: Int? = Measure_Unit.get_ou()
                when (in_id) {
                    1 -> { Meter_Function(ou_id!!)}
                    2->  {Centi_Function(ou_id!!)}
                    3->  {Mili_funtion(ou_id!!)}
                    4->  {Deci_Function(ou_id!!)}
                    5-> {Kilo_function(ou_id!!)}
                    6-> {Inch_function(ou_id!!)}
                }

            } else {
                Toast.makeText(this, "Please Input Something ", Toast.LENGTH_SHORT).show()

            }
        }

    }
    fun Meter_Function(ou_id:Int){

        if (ou_id == 1) {
            result_measurement.setText("Cannot convert same unit!! ")
        }
       else if (ou_id == 2) {
            result_measurement.setText(meter_to_centi(input_Unit!!).toString() + " cm")
        }
        else if (ou_id==3){
            result_measurement.setText(meter_to_mili(input_Unit!!).toString()+" mm")
        }
        else if (ou_id==4)
        {
            result_measurement.setText(metet_to_Deci(input_Unit!!).toString()+" dm")
        }
        else if (ou_id==5)
        {
            result_measurement.setText(meter_to_kilo(input_Unit!!)+" km")
        }
        else if (ou_id==6)
        {
            result_measurement.setText(meter_to_inch(input_Unit!!)+" in")
        }

    }
    fun Centi_Function(ou_id: Int)
    {
        if (ou_id == 1) {
            result_measurement.setText(centi_to_meter(input_Unit!!)+" m")
        }

        else if (ou_id == 2) {
            result_measurement.setText("Cannot convert same unit!! ")
        }
        else if (ou_id==3){
            result_measurement.setText(centi_to_mili(input_Unit!!)+" mm")
        }
        else if (ou_id==4)
        {
            result_measurement.setText(centi_to_deci(input_Unit!!)+" dm")
        }
        else if (ou_id==5)
        {
            result_measurement.setText(centi_to_kilo(input_Unit!!)+" km")
        }
        else if (ou_id==6)
        {            result_measurement.setText(centi_to_inch(input_Unit!!)+" in")
        }
    }

    fun Deci_Function(ou_id: Int)
    {
        if (ou_id == 1) {
            result_measurement.setText(deci_to_meter(input_Unit!!)+" m")
        }
        else if (ou_id==2){
            result_measurement.setText(deci_to_centi(input_Unit!!)+" cm")
        }

        else if (ou_id == 4) {
            result_measurement.setText("Cannot convert same unit!! ")
        }
        else if (ou_id==3)
        {
            result_measurement.setText(deci_to_mili(input_Unit!!)+" mm")
        }
        else if (ou_id==5)
        {
            result_measurement.setText(deci_to_kilo(input_Unit!!)+" km")
        }
        else if (ou_id==6)
        {            result_measurement.setText(deci_to_inch(input_Unit!!)+" in")
        }
    }
    fun Mili_funtion(ou_id: Int)
    {
        if (ou_id == 1) {
            result_measurement.setText(mili_to_meter(input_Unit!!)+" m")
        }
        else if (ou_id==2){
            result_measurement.setText(mili_to_centi(input_Unit!!)+" cm")
        }

       else if (ou_id == 3) {
            result_measurement.setText("Cannot convert same unit!! ")
        }
        else if (ou_id==4)
        {
            result_measurement.setText(mili_to_deci(input_Unit!!)+" dm")
        }
        else if (ou_id==5)
        {
            result_measurement.setText(mili_to_kilo(input_Unit!!)+" km")
        }
        else if (ou_id==6)
        {   result_measurement.setText(mili_to_inch(input_Unit!!)+" in")
        }
    }
    fun Kilo_function(ou_id: Int)
    {        if (ou_id == 1) {
        result_measurement.setText(kilo_to_meter(input_Unit!!)+" m")
    }
    else if (ou_id==2){
        result_measurement.setText(kilo_to_centi(input_Unit!!)+" cm")
    }
    else if (ou_id==3)
    {
        result_measurement.setText(kilo_to_mili(input_Unit!!)+" mm")
    }
    else if (ou_id==4)
    {
        result_measurement.setText(kilo_to_deci(input_Unit!!)+" dm")
    }

       else if (ou_id == 5) {
            result_measurement.setText("Cannot convert same unit!! ")
        }
    else if (ou_id==6)
    {   result_measurement.setText(kilo_to_inch(input_Unit!!)+" in")
    }

    }
    fun Inch_function(ou_id: Int)
    {        if (ou_id == 1) {
        result_measurement.setText(inch_to_meter(input_Unit!!)+" m")
    }
    else if (ou_id==2){
        result_measurement.setText(inch_to_centi(input_Unit!!)+" cm")
    }
    else if (ou_id==3)
    {
        result_measurement.setText(inch_to_mili(input_Unit!!)+" mm")
    }
    else if (ou_id==4)
    {
        result_measurement.setText(inch_to_deci(input_Unit!!)+" dm")
    }
    else if (ou_id==5)
    {   result_measurement.setText(inch_to_kilo(input_Unit!!)+" km")
    }

       else if (ou_id == 6) {
            result_measurement.setText("Cannot convert same unit!! ")
        }
    }





    fun meter_to_centi(input_unit: Int): Int {
        return input_unit * 100
    }
    fun meter_to_mili(input_unit: Int):Int{
        return  input_unit*1000
    }
    fun metet_to_Deci(input_unit: Int):Int{
        return  input_unit*10
    }
    fun meter_to_kilo(input_unit: Int): String {
           var m=input_unit.toDouble()
        return  String.format("%.7f",m/1000)
    }
    fun meter_to_inch(input_unit: Int):String{
        var mi=input_unit.toDouble()
        return  String.format("%.7f",mi*39.37007874)
    }
    ///////////////////////////End meter///////////////////////

    fun centi_to_meter(input_unit: Int):String{
        var cm=input_unit.toDouble()
        return  String.format("%.7f",cm/100)
    }
    fun  centi_to_mili(input_unit: Int):String
    {
        var ctm=input_unit.toDouble()
        return  String.format("%.1f",ctm*10)
    }
    fun centi_to_deci(input_unit: Int):String{
        var ctc=input_unit.toDouble()
        return  String.format("%.7f",ctc/10)
    }
    fun centi_to_kilo(input_unit: Int):String{
        var ctk=input_unit.toDouble()
        return String.format("%.7f",ctk/100000)
    }
    fun centi_to_inch(input_unit: Int):String{
        var cti=input_unit.toDouble()
        return String.format("%.7f",cti*0.3937007874)
    }

    ///////////////////////////////End Centi/////////////////////
    fun mili_to_meter(input_unit: Int):String{
        var mtm=input_unit.toDouble()
        return  String.format("%.5f",mtm/100)
    }
    fun mili_to_centi(input_unit: Int):String{
        var mtc=input_unit.toDouble()
        return String.format("%.6f",mtc/10)
    }
    fun mili_to_deci(input_unit: Int):String{
        var mtd=input_unit.toDouble()
        return String.format("%.6f",mtd/100)
    }
    fun mili_to_kilo(input_unit: Int):String{
        var mtk=input_unit.toDouble()
        return String.format("%.7f",mtk/100000)
    }
    fun mili_to_inch(input_unit: Int):String{
        var mti=input_unit.toDouble()
        return  String.format("%.7f",mti*0.03937008)
    }




//////////////////////////////////End Mili////////////////////////
    fun deci_to_meter(input_unit: Int):String{
        var dtm=input_unit.toDouble()
        return String.format("%.7f",dtm/10)
    }
    fun deci_to_centi(input_unit: Int):String{
        var input_unit=input_unit.toDouble();
        return String.format("%.1f",input_unit*10)
    }
    fun deci_to_mili(input_unit: Int):String{
        var input_unit=input_unit.toDouble()
        return String.format("%.1f",input_unit*100)
    }
    fun deci_to_kilo(input_unit: Int):String{
        return  String.format("%.5f",input_unit/1000)
    }
    fun deci_to_inch(input_unit: Int):String{
        return String.format("%.7f",input_unit/3.9370079)
    }
    ////////////////////////////////End Deci//////////////////////////
    fun kilo_to_meter(input_unit: Int):String{
        return (input_unit*1000).toString()
    }
    fun kilo_to_centi(input_unit: Int):String{
        return (input_unit*100000).toString()
    }
    fun kilo_to_mili(input_unit: Int):String{
        return (input_unit*1000000).toString()
    }
    fun kilo_to_deci(input_unit: Int):String{
        return  (input_unit*10).toString()
    }
    fun kilo_to_inch(input_unit: Int):String{
        var kti=input_unit.toDouble()
        return String.format("%.5f",kti*39370.0787)
    }
    /////////////////////////////////End Kilo////////////////////////
    fun inch_to_meter(input_unit: Int):String{
        var itm=input_unit.toDouble()
        return  String.format("%.7f",itm/39.3700787)
    }
    fun inch_to_centi(input_unit: Int):String{
        var itc=input_unit.toDouble()
        return  String.format("%.3f",itc*2.54)
    }
    fun inch_to_mili(input_unit: Int):String{
        var itm=input_unit.toDouble()
        return String.format("%.3f",itm*25.4)
    }
    fun inch_to_deci(input_unit: Int):String{
        var itd=input_unit.toDouble()
        return String.format("%.4f",itd*0.254)
    }
    fun  inch_to_kilo(input_unit: Int):String{
        var itd=input_unit.toDouble()
        return String.format("%.8f",itd*0.0000254)
    }
     ///////////////////////////End InchToMeter/////////////////////



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
    }
}
