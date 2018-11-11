package znk.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_measurement_unit.*
import kotlinx.android.synthetic.main.activity_voltage_meter.*

class Voltage_meter : AppCompatActivity() {
    var  voltage_unit = arrayOf(" 1 volt = 1 watt/ampere", "1 volt = 100000000 abvolt","1 volt = 100000000 EMU of electric potential",
            "1 volt = 0.0033356405 ESU of electric potential"," 1 abvolt = 1.E-8 watt/ampere"," 1 abvolt = 1 EMU of electric potential",
            "1 abvolt = 3.335640484E-11 ESU of electric potential"," 1 abvolt = 3.335640484E-11 statvolt"," 1 EMU of electric potential = 1.E-8 watt/ampere","1 oersted = 7.957747151 abampere/meter","1 gigafarad = 1000000000 farad")
    var input_Unit: Int? = null
    var tometer_int: Int? = 0
    var sp_input: Int? = 0
    var sp_output: Int? = 0
    internal val PROJECTION = arrayOf(
            ContactsContract.Data._ID,
            ContactsContract.Data.DISPLAY_NAME)

    // This is the select criteria
    internal  val SELECTION = "((" +
            ContactsContract.Data.DISPLAY_NAME + " NOTNULL) AND (" +
            ContactsContract.Data.DISPLAY_NAME + " != '' ))"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voltage_meter)
        val toViews = intArrayOf(android.R.id.text1) // The TextView in simple_list_item_1
        val adapter = ArrayAdapter(this,
                R.layout.listview_layout,voltage_unit )

        val list_view:ListView=findViewById(R.id.recipe_list_view)
        list_view.setAdapter(adapter)
    }
}
