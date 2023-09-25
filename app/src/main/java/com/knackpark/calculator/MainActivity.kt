package com.knackpark.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.knackpark.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.c.setOnClickListener{
            val removeLast = binding.input.text.toString().dropLast(1)
            binding.input.text = removeLast
        }
        binding.cross.setOnClickListener{
                binding.input.text = ""
                binding.output.text = ""
        }
        binding.bracketOpen.setOnClickListener{
            binding.input.text = addToInputText("(")
        }
        binding.bracketClose.setOnClickListener{
            binding.input.text = addToInputText(")")
        }
        binding.div.setOnClickListener{
            binding.input.text = addToInputText("/")
        }
        binding.mul.setOnClickListener{
            binding.input.text = addToInputText("*")
        }
        binding.plus.setOnClickListener{
            binding.input.text = addToInputText("+")
        }
        binding.minuss.setOnClickListener{
            binding.input.text = addToInputText("-")
        }

        binding.one.setOnClickListener{
            binding.input.text = addToInputText("1")
        }
        binding.two.setOnClickListener{
            binding.input.text = addToInputText("2")
        }
        binding.three.setOnClickListener{
            binding.input.text = addToInputText("3")
        }
        binding.four.setOnClickListener{
            binding.input.text = addToInputText("4")
        }
        binding.five.setOnClickListener{
            binding.input.text = addToInputText("5")
        }
        binding.six.setOnClickListener{
            binding.input.text = addToInputText("6")
        }
        binding.seven.setOnClickListener{
            binding.input.text = addToInputText("7")
        }
        binding.eight.setOnClickListener{
            binding.input.text = addToInputText("8")
        }
        binding.nine.setOnClickListener{
            binding.input.text = addToInputText("9")
        }
        binding.zero.setOnClickListener{
            binding.input.text = addToInputText("0")
        }
        binding.dosomik.setOnClickListener{
            binding.input.text = addToInputText(".")
        }
        binding.result.setOnClickListener{
            showResult()
        }
    }


    private fun addToInputText(buttonValue:String):String{
        return binding.input.text.toString()+ "" + buttonValue
    }
    private fun showResult(){


        try {
            val myExpression = binding.input.text.toString()
            val result = Expression(myExpression).calculate()
            if(result.isNaN()){
                binding.output.text = ""

            }else{
                binding.output.text = DecimalFormat("0.####").format(result)
            }
        }catch (e:Exception){
            binding.output.text = "Math Error"
        }

    }


}