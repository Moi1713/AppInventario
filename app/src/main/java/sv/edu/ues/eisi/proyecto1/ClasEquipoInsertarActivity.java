package sv.edu.ues.eisi.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ClasEquipoInsertarActivity extends AppCompatActivity {

    ControlBDProyecto1 helper;
    EditText editIdClasEquipo;
    EditText editDescClasEquipo;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clas_equipo_insertar);
        helper = new ControlBDProyecto1(this);
        editIdClasEquipo = (EditText) findViewById(R.id.editIdClasEquipo);
        editDescClasEquipo = (EditText) findViewById(R.id.editDescClasEquipo);
    }

    public void insertarClasEquipo(View v) {
        String IdClasEquipo=editIdClasEquipo.getText().toString();
        String DescClasEquipo=editDescClasEquipo.getText().toString();
        String regInsertados;
        ClasEquipo clasEquipo=new ClasEquipo();
        clasEquipo.setIdClasEquipo(IdClasEquipo);
        clasEquipo.setDescClasEquipo(DescClasEquipo);
        helper.abrir();
        regInsertados=helper.insertar(clasEquipo);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIdClasEquipo.setText("");
        editDescClasEquipo.setText("");
    }
}