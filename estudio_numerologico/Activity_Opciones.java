package com.example.estudio_numerologico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity_Opciones extends AppCompatActivity {

    TextView nombreCom;
    TextView nacimientoCom;
    MediaPlayer mp;
    //---------------------
    private CardView urgencia,tonica,suceso,numerico,cabala,tonica_dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__opciones);

        nombreCom=findViewById(R.id.name);
        nacimientoCom=findViewById(R.id.age);

        recibirDatos();

        // Definiendo las opciones
        urgencia=(CardView)findViewById(R.id.UrgenciaOpcion);
        tonica=(CardView)findViewById(R.id.TonicaOpcion);
        suceso=(CardView)findViewById(R.id.SucesoOpcion);
        numerico=(CardView)findViewById(R.id.NumericoOpcion);
        cabala=(CardView)findViewById(R.id.CabalaOpcion);
        tonica_dia=(CardView)findViewById(R.id.TonicaDiaOpcion);

        // INICIO Reproducir Audio
        mp = MediaPlayer.create(this,R.raw.button_sound);

        // Cambiar a otras pestañas
        urgencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // INICIO Reproducir Audio
                mp.start();
                // FIN Reproducir Audio
                // INICIO Vibracion
                Vibrator vibrator=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(80);
                // FIN Vibracion
                Intent inte = new Intent(Activity_Opciones.this, UgenciaActivity.class);
                inte.putExtra("nombreCompleto",nombreCom.getText().toString());
                inte.putExtra("nacimientoCom",nacimientoCom.getText().toString().substring(0,2)+"/"+nacimientoCom.getText().toString().substring(3,5)+"/"+nacimientoCom.getText().toString().substring(6,10));
                startActivity(inte);
            }
        });
        tonica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // INICIO Reproducir Audio
                mp.start();
                // FIN Reproducir Audio
                // INICIO Vibracion
                Vibrator vibrator=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(80);
                // FIN Vibracion
                Intent inte = new Intent(Activity_Opciones.this, TonicaActivity.class);
                inte.putExtra("nombreCompleto",nombreCom.getText().toString());
                inte.putExtra("nacimientoCom",nacimientoCom.getText().toString().substring(0,2)+"/"+nacimientoCom.getText().toString().substring(3,5)+"/"+nacimientoCom.getText().toString().substring(6,10));
                startActivity(inte);
            }
        });
        suceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // INICIO Reproducir Audio
                mp.start();
                // FIN Reproducir Audio
                // INICIO Vibracion
                Vibrator vibrator=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(80);
                // FIN Vibracion
                Intent inte = new Intent(Activity_Opciones.this, SucesoActivity.class);
                inte.putExtra("nombreCompleto",nombreCom.getText().toString());
                inte.putExtra("nacimientoCom",nacimientoCom.getText().toString().substring(0,2)+"/"+nacimientoCom.getText().toString().substring(3,5)+"/"+nacimientoCom.getText().toString().substring(6,10));
                startActivity(inte);
            }
        });
        numerico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // INICIO Reproducir Audio
                mp.start();
                // FIN Reproducir Audio
                // INICIO Vibracion
                Vibrator vibrator=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(80);
                // FIN Vibracion
                Intent inte = new Intent(Activity_Opciones.this, NumericoActivity.class);
                inte.putExtra("nombreCompleto",nombreCom.getText().toString());
                inte.putExtra("nacimientoCom",nacimientoCom.getText().toString().substring(0,2)+"/"+nacimientoCom.getText().toString().substring(3,5)+"/"+nacimientoCom.getText().toString().substring(6,10));
                startActivity(inte);
            }
        });
        cabala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // INICIO Reproducir Audio
                mp.start();
                // FIN Reproducir Audio
                // INICIO Vibracion
                Vibrator vibrator=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(80);
                // FIN Vibracion
                Intent inte = new Intent(Activity_Opciones.this, CabalaActivity.class);
                inte.putExtra("nombreCompleto",nombreCom.getText().toString());
                inte.putExtra("nacimientoCom",nacimientoCom.getText().toString().substring(0,2)+"/"+nacimientoCom.getText().toString().substring(3,5)+"/"+nacimientoCom.getText().toString().substring(6,10));
                startActivity(inte);
            }
        });
        tonica_dia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // INICIO Reproducir Audio
                mp.start();
                // FIN Reproducir Audio
                // INICIO Vibracion
                Vibrator vibrator=(Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(80);
                // FIN Vibracion
                Intent inte = new Intent(Activity_Opciones.this, TonicaDiaActivity.class);
                inte.putExtra("nombreCompleto",nombreCom.getText().toString());
                inte.putExtra("nacimientoCom",nacimientoCom.getText().toString().substring(0,2)+"/"+nacimientoCom.getText().toString().substring(3,5)+"/"+nacimientoCom.getText().toString().substring(6,10));
                startActivity(inte);
            }
        });
    }

    private void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        String d1 = extras.getString("nombreCompleto");
        String d2 = extras.getString("nacimientoCom");

        nacimientoCom=(TextView)findViewById(R.id.age);
        nacimientoCom.setText(d2);
        nombreCom=(TextView)findViewById(R.id.name);
        nombreCom.setText(d1);
    }
}
