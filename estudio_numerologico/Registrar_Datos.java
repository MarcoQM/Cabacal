package com.example.estudio_numerologico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Registrar_Datos extends AppCompatActivity {

    MediaPlayer mp;
    Button button;
    private EditText nombre;
    private EditText apellido;
    private EditText nacimiento;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar__datos);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        button=findViewById(R.id.buttonPri);
        nombre=findViewById(R.id.nombreR);
        apellido=findViewById(R.id.apellidoR);
        nacimiento=findViewById(R.id.nacimientoR);
        info=findViewById(R.id.infoPersonal);

        // INICIO Reproducir Audio
        mp = MediaPlayer.create(this,R.raw.button_sound);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // INICIO Vibracion
                Vibrator vibrator=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(80);
                // FIN Vibracion
                // INICIO Reproducir Audio
                mp.start();
                // FIN Reproducir Audio
                InputMethodManager abrirTeclado = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if(nombre.getText().toString().isEmpty()){
                    abrirTeclado.showSoftInput(nombre, InputMethodManager.SHOW_IMPLICIT); // Abrir Teclado
                   nombre.setText("COMPLETAR ESTE CAMPO");
                   nombre.isSelected();
                   nombre.isActivated();
                   nombre.selectAll();
                } else if(apellido.getText().toString().isEmpty()){
                    abrirTeclado.showSoftInput(apellido, InputMethodManager.SHOW_IMPLICIT); // Abrir Teclado
                    apellido.setText("COMPLETAR ESTE CAMPO");
                    apellido.isSelected();
                    apellido.isActivated();
                    apellido.selectAll();
                } else if(nacimiento.getText().toString().isEmpty()){
                    abrirTeclado.showSoftInput(nacimiento, InputMethodManager.SHOW_IMPLICIT); // Abrir Teclado
                    nacimiento.setText("00000000");
                    nacimiento.isSelected();
                    nacimiento.isActivated();
                    nacimiento.selectAll();
                } else {
                    Intent inte = new Intent(Registrar_Datos.this, Activity_Opciones.class);
                    inte.putExtra("nombreCompleto", nombre.getText().toString() + " " + apellido.getText().toString());
                    inte.putExtra("nacimientoCom", nacimiento.getText().toString().substring(0, 2) + "/" + nacimiento.getText().toString().substring(2, 4) + "/" + nacimiento.getText().toString().substring(4, 8));
                    startActivity(inte);
                }
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // INICIO Reproducir Audio
                mp.start();
                // FIN Reproducir Audio
                // INICIO Vibracion
                Vibrator vibrator=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(80);
                // FIN Vibracion
                Intent inte = new Intent(Registrar_Datos.this, Main3Activity.class);
                startActivity(inte);
            }
        });
    }
}
