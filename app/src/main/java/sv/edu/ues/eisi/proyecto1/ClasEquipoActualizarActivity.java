package sv.edu.ues.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ClasEquipoActualizarActivity extends AppCompatActivity {

    ControlBDProyecto1 helper;
    EditText editIdClasEquipo;
    EditText editDescClasEquipo;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clas_equipo_actualizar);
        helper = new ControlBDProyecto1(this);
        editIdClasEquipo = (EditText) findViewById(R.id.editIdClasEquipo);
        editDescClasEquipo = (EditText) findViewById(R.id.editDescClasEquipo);
    }
    public void actualizarClasEquipo(View v) {
        ClasEquipo clasEquipo = new ClasEquipo();
        clasEquipo.setIdClasEquipo(editIdClasEquipo.getText().toString());
        clasEquipo.setDescClasEquipo(editDescClasEquipo.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(clasEquipo);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIdClasEquipo.setText("");
        editDescClasEquipo.setText("");
    }
}