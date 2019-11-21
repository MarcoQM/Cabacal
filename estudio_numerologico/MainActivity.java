package com.example.estudio_numerologico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=2500; // 4000 tiempo en milisegundos para cambio de pantalla
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reproducir Audio
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sound_app);
        mediaPlayer.start();

        // Crear y empezar la acción de Splash
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this,Registrar_Datos.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
