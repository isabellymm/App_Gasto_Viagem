package com.example.app_gasto_viagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.app_gasto_viagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)



    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }
    }

    private fun isValid():Boolean{
        return (binding.editAcomodation.text.toString() != ""
                && binding.editTickets.text.toString() != ""
                && binding.editTransport.text.toString() != ""
                && binding.editAlimentation.text.toString() != ""
                && binding.editExtraExpenses.text.toString() != ""
                && binding.editAtractions.text.toString() != "")
    }

    private fun calculate(){
        if(isValid()){
            val acomodation = binding.editAcomodation.text.toString().toFloat()
            val tickets = binding.editTickets.text.toString().toFloat()
            val transport = binding.editTransport.text.toString().toFloat()
            val alimentation = binding.editAlimentation.text.toString().toFloat()
            val expenses = binding.editExtraExpenses.text.toString().toFloat()
            val atractions = binding.editAtractions.text.toString().toFloat()

            val totalValue = (acomodation + tickets + transport + alimentation + expenses + atractions)
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}"

        }else{
            Toast.makeText(this,R.string.validation_fill_all_fields,Toast.LENGTH_SHORT).show()
        }
    }
}