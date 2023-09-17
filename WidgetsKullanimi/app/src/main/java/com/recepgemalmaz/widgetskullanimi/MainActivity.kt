package com.recepgemalmaz.widgetskullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import com.recepgemalmaz.widgetskullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var kontrol = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonMutlu.setOnClickListener {
           binding.imageView.setImageResource(R.drawable.mutlu_resim)
        }

        binding.buttonUzgun.setOnClickListener {
            binding.imageView.setImageResource(resources.getIdentifier("uzgun_resim", "drawable",packageName))
        }

        binding.buttonToggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->

            kontrol = isChecked
            if (kontrol){
                val secilenButton =findViewById<Button>(checkedId)
                val buttonYazi = secilenButton.text.toString()
                Log.e("Sonuc", buttonYazi)
            }
        }

        val ulkeler = ArrayList<String>()
        ulkeler.add("Türkiye")
        ulkeler.add("Almanya")
        ulkeler.add("İngiltere")
        ulkeler.add("Fransa")
        ulkeler.add("İtalya")
        ulkeler.add("İspanya")

        val arrayAdapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, ulkeler)

        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.buttonGoster.setOnClickListener {
            if (kontrol){
                val secilenButton =findViewById<Button>(binding.buttonToggleGroup.checkedButtonId)
                val buttonYazi = secilenButton.text.toString()
                Log.e("Sonuc son durum", buttonYazi)
            }

            Log.e("Sonuc Ulke", binding.autoCompleteTextView.text.toString())
        }

    }
}