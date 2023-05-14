package sv.edu.ues.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ClasEquipoConsultarActivity extends AppCompatActivity {

    ControlBDProyecto1 helper;
    EditText editIdClasEquipo;
    EditText editDescClasEquipo;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clas_equipo_consultar);
        helper = new ControlBDProyecto1(this);
        editIdClasEquipo = (EditText) findViewById(R.id.editIdClasEquipo);
        editDescClasEquipo = (EditText) findViewById(R.id.editDescClasEquipo);
    }
    public void consultarClasEquipo(View v) {
        helper.abrir();
        ClasEquipo clasEquipo = helper.consultarClasEquipo(editIdClasEquipo.getText().toString());
        helper.cerrar();
        if(clasEquipo == null)
            Toast.makeText(this, "Clasificacion de equipo con código " +
                    editIdClasEquipo.getText().toString() +
                    " no encontrada", Toast.LENGTH_LONG).show();
        else{
            editDescClasEquipo.setText(clasEquipo.getDescClasEquipo());
        }
    }
    public void limpiarTexto(View v){
        editIdClasEquipo.setText("");
        editDescClasEquipo.setText("");
    }
}