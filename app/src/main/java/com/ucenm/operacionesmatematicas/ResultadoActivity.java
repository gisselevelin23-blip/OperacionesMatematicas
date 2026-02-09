package com.ucenm.operacionesmatematicas;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // 1. Enlazar el TextView (Punto 2 del diseño)
        TextView tvResultado = findViewById(R.id.tvResultado);

        // 2. Recibir datos del Intent
        double n1 = getIntent().getDoubleExtra("N1", 0);
        double n2 = getIntent().getDoubleExtra("N2", 0);
        String op = getIntent().getStringExtra("OP");

        // 3. COMPETENCIA POO: Transferir datos mediante el constructor
        OperacionesMatematicas misOperaciones = new OperacionesMatematicas(n1, n2);

        // 4. Mostrar el resultado según la operación (Manejo de Eventos)
        if (op != null) {
            if (op.equals("suma")) {
                tvResultado.setText("Resultado Suma: " + misOperaciones.sumar());
            } else if (op.equals("resta")) {
                tvResultado.setText("Resultado Resta: " + misOperaciones.restar());
            } else if (op.equals("multiplicacion")) {
                tvResultado.setText("Resultado Multiplicación: " + misOperaciones.multiplicar());
            } else if (op.equals("division")) {
                // Aquí se muestra el String de error o el número
                tvResultado.setText("Resultado División: " + misOperaciones.dividir());
            }
        }
    }
}