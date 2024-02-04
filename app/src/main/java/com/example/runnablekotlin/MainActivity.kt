package com.example.runnablekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.runnablekotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var number=0
    var runnable:Runnable=Runnable{}
    var handler : Handler=Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    fun start(view : View){
        binding.button3.isEnabled=true
        runnable=object : Runnable{
            override fun run() {
                number = number+1
                binding.textView.text="${number}"
                handler.postDelayed(runnable,1000)//runbale yerine this olabilir

            }

        }
        handler.post(runnable)//runnable başlat
        binding.button.isEnabled=false//bi daha tıklanmaz
        //threading
        //Runnable-handler



    }
    fun sifirla(view : View){
        binding.button.isEnabled=true
        number=0
        binding.textView.text="0"
        handler.removeCallbacks(runnable)//runnable durduruldu

    }

    fun stop(view : View){
        var deger= binding.textView.text.toString().toIntOrNull()
        if(deger!=null){
            handler.removeCallbacks(runnable)
            binding.textView.text = "${deger}"
            binding.button.isEnabled=true

        }




    }
}