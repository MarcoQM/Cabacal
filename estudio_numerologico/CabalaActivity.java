package com.example.estudio_numerologico;

import androidx.annotation.XmlRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;

public class CabalaActivity extends AppCompatActivity {

    TextView nombreCom;
    TextView nacimientoCom;
    TextView resultado;
    ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabala);

        recibirDatos();
    }

    private void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        String d1 = extras.getString("nombreCompleto");
        String d2 = extras.getString("nacimientoCom");

        nacimientoCom=(TextView)findViewById(R.id.age);
        nacimientoCom.setText(d2);
        nombreCom=(TextView)findViewById(R.id.name);
        nombreCom.setText(d1);
        picture=(ImageView)findViewById(R.id.picture);
        resultado=(TextView)findViewById(R.id.resultado);

        String año_na = nacimientoCom.getText().toString().substring(6,10);
        String numTam = "";
        int sum = 0;
        String sum2 = "";
        String dicha = "";
        for(int x=0; x <3;x++){
            sum=0;
            for(int y = 0; y < año_na.length();y++){
                sum = sum + Integer.parseInt(año_na.substring(y,y+1));
            }
            sum2=sum+"";
            int sumT = 0;
            while(sum2.length()>1){
                sumT=0;
                for(int p = 0; p < sum2.length();p++){
                    sumT=sumT+Integer.parseInt(sum2.substring(p,p+1));
                }
                sum2=sumT+"";
            }
            numTam = sum2+"";
            año_na = (Integer.parseInt(año_na)+sum)+"";
            if(Integer.parseInt(numTam)==1){
                picture.setImageResource(R.drawable.arcano_1);
                dicha = año_na+ getString(R.string.cabala1) +dicha+"\n";
            } else if (Integer.parseInt(numTam)==2){
                picture.setImageResource(R.drawable.arcano_2);
                dicha = año_na+ getString(R.string.cabala2) +dicha+"\n";
            } else if (Integer.parseInt(numTam)==3){
                picture.setImageResource(R.drawable.arcano_3);
                dicha = año_na+ getString(R.string.cabala3) +dicha+"\n";
            } else if (Integer.parseInt(numTam)==4){
                picture.setImageResource(R.drawable.arcano_4);
                dicha = año_na+ getString(R.string.cabala4) +dicha+"\n";
            } else if (Integer.parseInt(numTam)==5){
                picture.setImageResource(R.drawable.arcano_5);
                dicha = año_na+ getString(R.string.cabala5) +dicha+"\n";
            } else if (Integer.parseInt(numTam)==6){
                picture.setImageResource(R.drawable.arcano_6);
                dicha = año_na+ getString(R.string.cabala6) +dicha+"\n";
            } else if (Integer.parseInt(numTam)==7){
                picture.setImageResource(R.drawable.arcano_7);
                dicha = año_na+ getString(R.string.cabala7) +dicha+"\n";
            } else if (Integer.parseInt(numTam)==8){
                picture.setImageResource(R.drawable.arcano_8);
                dicha = año_na+ getString(R.string.cabala8) +dicha+"\n";
            } else if (Integer.parseInt(numTam)==9){
                picture.setImageResource(R.drawable.arcano_9);
                dicha = año_na+ getString(R.string.cabala9) +dicha+"\n";
            }
            resultado.setText(dicha);
        }
        // Ahora descubriremos la dicha
    }
}
