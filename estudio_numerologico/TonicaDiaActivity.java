package com.example.estudio_numerologico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.TimeZone;

public class TonicaDiaActivity extends AppCompatActivity {

    TextView nombreCom;
    TextView nacimientoCom;
    TextView resultado;
    TextView fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tonica_dia);
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
        fecha.setText("Fecha Actual: "+actualDay+"/"+actualMonth+"/"+actualYear);

        int dia = Integer.parseInt(d2.substring(0,2));
        int mes = Integer.parseInt(d2.substring(3,5));
        int año = Integer.parseInt(d2.substring(6,10));
        int suma = dia + mes + año;
        int suma2 = d1.length()-2;
        // Metodo Para Hayar la Suma hasta llegar a la unidad, el valor se guarda en numTam
        String numTam = (suma+suma2+actualDay+actualMonth+actualYear)+"";
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
            dicha = getString(R.string.tonica_dia1);
        } else if (Integer.parseInt(numTam)==2){
            dicha = getString(R.string.tonica_dia2);
        } else if (Integer.parseInt(numTam)==3){
            dicha = getString(R.string.tonica_dia3);
        } else if (Integer.parseInt(numTam)==4){
            dicha = getString(R.string.tonica_dia4);
        } else if (Integer.parseInt(numTam)==5){
            dicha = getString(R.string.tonica_dia5);
        } else if (Integer.parseInt(numTam)==6){
            dicha = getString(R.string.tonica_dia6);
        } else if (Integer.parseInt(numTam)==7){
            dicha = getString(R.string.tonica_dia7);
        } else if (Integer.parseInt(numTam)==8){
            dicha = getString(R.string.tonica_dia8);
        } else if (Integer.parseInt(numTam)==9){
            dicha = getString(R.string.tonica_dia9);
        }
        resultado.setText(numTam+": "+dicha);
    }
}
