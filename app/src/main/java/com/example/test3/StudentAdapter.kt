package com.example.test3

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class StudentAdapter(
    val context: Context,
    val item: ArrayList<MyData>,
    val studentAdapter: StudentInterface
) : BaseAdapter() {
    override fun getCount(): Int {
        return item.size
    }

    override fun getItem(p0: Int): Any {
        return item[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation", "ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        val layout = LayoutInflater.from(context).inflate(R.layout.sdutent_list_view, p2, false)

        val img = layout.findViewById<ImageView>(R.id.image)
        val title = layout.findViewById<TextView>(R.id.title)
        val desc = layout.findViewById<TextView>(R.id.desc)

        title.text = item[p0].name
        desc.text = item[p0].description

        img.setImageResource(item[p0].image)

        val btn = layout.findViewById<Button>(R.id.btn)

        btn.setOnClickListener() {

            val alertBuilder = AlertDialog.Builder(context)
            alertBuilder.setPositiveButton(
                "Yes",
                DialogInterface.OnClickListener() { DialogInterface, i ->
                    studentAdapter.onProfile(p0)
                })
            alertBuilder.setNegativeButton(
                "No",
                DialogInterface.OnClickListener() { DialogInterface, i ->
                })
            val builder = alertBuilder.create()
            builder.setTitle("Delete")
            builder.setMessage("Are you sure")
            builder.show()

        }

        layout.setOnClickListener {
            studentAdapter.next(p0)
        }

        return layout

    }
}