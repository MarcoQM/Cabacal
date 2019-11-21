package com.example.estudio_numerologico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

public class SucesoActivity extends AppCompatActivity {

    TextView nombreCom;
    TextView nacimientoCom;
    TextView resultado;
    TextView fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suceso);

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
        resultado=(TextView)findViewById(R.id.resultado);
        fecha=(TextView)findViewById(R.id.fecha);

        // Calcular la Fecha Actual
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int actualYear = calendar.get(Calendar.YEAR);
        int actualMonth = calendar.get(Calendar.MONTH) + 1;
        int actualDay = calendar.get(Calendar.DAY_OF_MONTH);
        int actualHor = calendar.get(Calendar.HOUR);
        fecha.setText("Hora: "+ actualHor+" Fecha Actual: "+actualDay+"/"+actualMonth+"/"+actualYear);

        int dia = Integer.parseInt(d2.substring(0,2));
        int mes = Integer.parseInt(d2.substring(3,5));
        int año = Integer.parseInt(d2.substring(6,10));
        int suma = dia + mes+ año;
        int suma2 = d1.length()-2;
        // Metodo Para Hayar la Suma hasta llegar a la unidad, el valor se guarda en numTam
        String numTam = (suma+suma2+actualHor+actualDay+actualMonth+actualYear)+"";
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
            dicha = getString(R.string.suceso1);
        } else if (Integer.parseInt(numTam)==2){
            dicha = getString(R.string.suceso2);
        } else if (Integer.parseInt(numTam)==3){
            dicha = getString(R.string.suceso3);
        } else if (Integer.parseInt(numTam)==4){
            dicha = getString(R.string.suceso4);
        } else if (Integer.parseInt(numTam)==5){
            dicha = getString(R.string.suceso5);
        } else if (Integer.parseInt(numTam)==6){
            dicha = getString(R.string.suceso6);
        } else if (Integer.parseInt(numTam)==7){
            dicha = getString(R.string.suceso7);
        } else if (Integer.parseInt(numTam)==8){
            dicha = getString(R.string.suceso8);
        } else if (Integer.parseInt(numTam)==9){
            dicha = getString(R.string.suceso9);
        }
        resultado.setText(numTam+": "+dicha);
    }
}
