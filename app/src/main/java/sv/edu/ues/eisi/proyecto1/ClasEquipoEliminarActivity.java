package sv.edu.ues.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ClasEquipoEliminarActivity extends AppCompatActivity {

    ControlBDProyecto1 controlhelper;
    EditText editIdClasEquipo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clas_equipo_eliminar);
        controlhelper=new ControlBDProyecto1 (this);
        editIdClasEquipo=(EditText)findViewById(R.id.editIdClasEquipo);
    }

    public void eliminarClasEquipo(View v){
        String regEliminadas;
        ClasEquipo clasEquipo=new ClasEquipo();
        clasEquipo.setIdClasEquipo(editIdClasEquipo.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(clasEquipo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}