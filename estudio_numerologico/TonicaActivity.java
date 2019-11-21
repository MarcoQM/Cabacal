package com.example.estudio_numerologico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TonicaActivity extends AppCompatActivity {

    TextView nombreCom;
    TextView nacimientoCom;
    TextView resultado;
    ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tonica);

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

        int dia = Integer.parseInt(d2.substring(0,2));
        int mes = Integer.parseInt(d2.substring(3,5));
        int año = Integer.parseInt(d2.substring(6,10));
        int suma = dia + mes + año;
        int suma2 = d1.length()-2;
        // Metodo Para Hayar la Suma hasta llegar a la unidad, el valor se guarda en numTam
        String numTam = (suma+suma2)+"";
        int guardar = 0;
        while(numTam.length()!=1) {
            guardar = 0;
            for(int x = 0; x<numTam.length(); x++) {
                guardar = guardar + Integer.parseInt(numTam.substring(x,x+1));
            }
            numTam = guardar+"";
        }
        // Ahora descubriremos la dicha
        String dicha = "";
        if(Integer.parseInt(numTam)==1){
            picture.setImageResource(R.drawable.arcano_1);
            dicha = getString(R.string.tonica1);
        } else if (Integer.parseInt(numTam)==2){
            picture.setImageResource(R.drawable.arcano_2);
            dicha = getString(R.string.tonica2);;
        } else if (Integer.parseInt(numTam)==3){
            picture.setImageResource(R.drawable.arcano_3);
            dicha = getString(R.string.tonica3);;
        } else if (Integer.parseInt(numTam)==4){
            picture.setImageResource(R.drawable.arcano_4);
            dicha = getString(R.string.tonica4);;
        } else if (Integer.parseInt(numTam)==5){
            picture.setImageResource(R.drawable.arcano_5);
            dicha = getString(R.string.tonica5);;
        } else if (Integer.parseInt(numTam)==6){
            picture.setImageResource(R.drawable.arcano_6);
            dicha = getString(R.string.tonica6);;
        } else if (Integer.parseInt(numTam)==7){
            picture.setImageResource(R.drawable.arcano_7);
            dicha = getString(R.string.tonica7);;
        } else if (Integer.parseInt(numTam)==8){
            picture.setImageResource(R.drawable.arcano_8);
            dicha = getString(R.string.tonica8);;
        } else if (Integer.parseInt(numTam)==9){
            picture.setImageResource(R.drawable.arcano_9);
            dicha = getString(R.string.tonica9);;
        }
        resultado.setText(numTam+": "+dicha);
    }
}
