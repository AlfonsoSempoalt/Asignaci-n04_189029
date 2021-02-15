package mx.edu.itson.asignacion04_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var etEstatura: EditText;
    private lateinit var etPeso: EditText;
    private lateinit var tvIMC: TextView;
    private lateinit var tvsaludEstado: TextView;
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            etPeso=findViewById(R.id.etPeso)
            etEstatura=findViewById(R.id.etEstatura)
            tvIMC=findViewById(R.id.tvIMC)
            tvsaludEstado=findViewById(R.id.tvestadoSalud)
            val btnCalcular: Button= findViewById(R.id.btnCalcular)
            var peso=0.0.toFloat();
            var estatura=0.0.toFloat();
            var IMC=0.0.toFloat();
            btnCalcular.setOnClickListener {
                peso= etPeso.text.toString().toFloat()
                estatura=etEstatura.text.toString().toFloat()
                IMC= calculateIMC(peso, estatura)
                estadoSalud(IMC)
                tvIMC.text = tvIMC.text.toString()+" :"+ IMC
            }


        }

        private fun estadoSalud(IMC:Float){
            if (IMC<18.5){
                tvsaludEstado.text= "Bajo de peso"
            } else if (IMC>=18.5&&IMC<24.9){
                tvsaludEstado.text="Normal"
            }else if (IMC>=25&&IMC<29.9){
                tvsaludEstado.text="Sobrepeso"
            }else if (IMC>=30&&IMC<34.9){
                tvsaludEstado.text="Obesidad grado 1"
            }else if (IMC>=35&&IMC<39.9){
                tvsaludEstado.text="Obesidad grado 2"
            }else if (IMC>=40){
                tvsaludEstado.text="Obesidad grado 3"
            }
        }
       private fun calculateIMC(peso:Float,est:Float):Float{
            tvIMC.text="IMC"

            return peso/(est*est)
        }
}