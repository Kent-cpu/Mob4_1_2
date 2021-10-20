package ru.kemsu.recyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CellClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(this, list,this)
    }
    private val list = arrayListOf(ColorData(Color.CYAN.toString(), "Cyan"),
        ColorData(Color.BLACK.toString(), "Black"),
        ColorData(Color.BLUE.toString(), "Blue"),
        ColorData(Color.RED.toString(), "Red"),
        ColorData(Color.YELLOW.toString(), "Yellow")
    )
    override fun onCellClickListener(data: ColorData) {
        Toast.makeText(this, "It is " + data.colorName, Toast.LENGTH_SHORT).show()
    }
}

data class ColorData(
    val colorHex: String,
    val colorName: String
)

interface CellClickListener {
    fun onCellClickListener(data: ColorData)
}