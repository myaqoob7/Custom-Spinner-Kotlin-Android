package com.zekab.customspinner

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerCountry:Spinner
    private lateinit var itemName:TextView
    private var mPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initSpinner()

    }

    private fun initViews(){
        spinnerCountry = findViewById(R.id.spinnerCountry)
        itemName = findViewById(R.id.itemName)
    }

    @SuppressLint("SetTextI18n")
    private fun initSpinner() {
        val countryList = dataProvider()
        val spinnerAdapter = CustomDropDownAdapter(this, countryList)
        spinnerCountry.adapter = spinnerAdapter

        spinnerCountry.onItemSelectedListener =
            (object : AdapterView.OnItemSelectedListener {

                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    mPosition = position
                    itemName.text = "Item Selected: ${countryList[position].itemLabel}"
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            })
    }

    private fun dataProvider():ArrayList<DropDownItem>{
        val mList:ArrayList<DropDownItem> = ArrayList()
        mList.add(DropDownItem("Australia",R.drawable.australia_flag))
        mList.add(DropDownItem("Brazil",R.drawable.brazil_flag))
        mList.add(DropDownItem("Canada",R.drawable.canada_flag))
        mList.add(DropDownItem("China",R.drawable.china_flag))
        mList.add(DropDownItem("Germany",R.drawable.germany_flag))
        mList.add(DropDownItem("India",R.drawable.india_flag))
        mList.add(DropDownItem("Italy",R.drawable.italy_flag))
        mList.add(DropDownItem("Mexico",R.drawable.mexico_flag))
        mList.add(DropDownItem("Netherlands",R.drawable.netherlands_flag))
        mList.add(DropDownItem("Norway",R.drawable.norway_flag))
        mList.add(DropDownItem("Pakistan",R.drawable.pakistan_flag))
        mList.add(DropDownItem("Spain",R.drawable.spain_flag))
        mList.add(DropDownItem("Switzerland",R.drawable.switzerland_flag))
        mList.add(DropDownItem("Turkey",R.drawable.turkey_flag))
        mList.add(DropDownItem("United Kingdom",R.drawable.united_kingdom_flag))
        mList.add(DropDownItem("United States",R.drawable.united_states_flag))


        return mList

    }
}