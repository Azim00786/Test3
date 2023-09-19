package com.example.test3

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity(), StudentInterface {

    private lateinit var myData: ArrayList<MyData>
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData = arrayListOf(
            MyData("Azim", "antimacassar", R.drawable.baseline_person_24)
        )

        val listview = findViewById<ListView>(R.id.ListView)
//        val nameEdit = findViewById<EditText>(R.id.Editname)
//        val descriptionEdit = findViewById<EditText>(R.id.editDescription)
        val add = findViewById<Button>(R.id.add)
            add.setOnClickListener{
                customdialogbox()
            }
        adapter = StudentAdapter(this, myData, this)

        listview.adapter = adapter

//       
    }
   private fun customdialogbox(): View? {
        val view=layoutInflater.inflate(R.layout.custom_dialog,null)
        val nameEdit = view.findViewById<EditText>(R.id.Editname)
        val descriptionEdit = view.findViewById<EditText>(R.id.editDescription)
        val submit=view.findViewById<Button>(R.id.submit)
       val dialog=AlertDialog.Builder(this)
       dialog.setView(view)
       val createdialog=dialog.create()
       createdialog.show()
       submit.setOnClickListener() {
            if (nameEdit.text.isEmpty()) {
                return@setOnClickListener
                Toast.makeText(this, "Enter Your name", Toast.LENGTH_SHORT).show()
            }
            myData.add(MyData(nameEdit.text.toString(), descriptionEdit.text.toString(), R.drawable.baseline_person_24))
            adapter.notifyDataSetChanged()
           createdialog.dismiss()
         }

           return view

    }

    override fun onProfile(position: Int) {
        Toast.makeText(this, "please name", Toast.LENGTH_SHORT).show()
        myData.removeAt(position)
        adapter.notifyDataSetChanged()
    }

    override fun next(position: Int) {

        val intent = Intent(this,NestActivity2::class.java)
        intent.putExtra("name",myData[position].name)
        intent.putExtra("derc",myData[position].description)
        intent.putExtra("image",myData[position].image)

       startActivity(intent)

    }


}