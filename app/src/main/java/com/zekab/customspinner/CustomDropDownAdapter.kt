package com.zekab.customspinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomDropDownAdapter(context: Context, var listItems: ArrayList<DropDownItem>) : BaseAdapter() {


    private val mInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ItemRowHolder
        if (convertView == null) {
            view = mInflater.inflate(R.layout.item_drop_down, parent, false)
            vh = ItemRowHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemRowHolder
        }

        // setting adapter item height programatically.

//        val params = view.layoutParams
//        params.height = 60
//        view.layoutParams = params

        vh.itemLabel.text = listItems[position].itemLabel
        vh.itemImage.setBackgroundResource( listItems[position].itemImage)
        return view
    }

    override fun getItem(position: Int): Any? {

        return null

    }

    override fun getItemId(position: Int): Long {

        return 0

    }

    override fun getCount(): Int {
        return listItems.size
    }

    private class ItemRowHolder(row: View?) {

        val itemLabel: TextView = row?.findViewById(R.id.item_label) as TextView
        val itemImage: ImageView = row?.findViewById(R.id.item_image) as ImageView

    }
}