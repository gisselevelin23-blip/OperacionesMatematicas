package com.ucenm.operacionesmatematicas;

import android.content.Intent; // Asegúrate de agregar estos imports
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // --- PASO 1: DECLARACIONES AQUÍ ---
    private EditText txtNum1, txtNum2;
    private Button btnSuma, btnResta, btnDivision, btnMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bloque por defecto de Android Studio para el diseño a pantalla completa
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // --- PASO 2: ENLAZAR IDS Y BOTONES AQUÍ ---
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnDivision = findViewById(R.id.btnDivision);
        btnMulti = findViewById(R.id.btnMulti);

        // Listeners de los botones
        btnSuma.setOnClickListener(v -> enviarDatos("suma"));
        btnResta.setOnClickListener(v -> enviarDatos("resta"));
        btnDivision.setOnClickListener(v -> enviarDatos("division"));
        btnMulti.setOnClickListener(v -> enviarDatos("multiplicacion"));
    }

    // --- PASO 3: MÉTODO DE ENVÍO FUERA DEL ONCREATE ---
    private void enviarDatos(String operacion) {
        String s1 = txtNum1.getText().toString();
        String s2 = txtNum2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);

        Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
        intent.putExtra("N1", n1);
        intent.putExtra("N2", n2);
        intent.putExtra("OP", operacion);
        startActivity(intent);
    }
}