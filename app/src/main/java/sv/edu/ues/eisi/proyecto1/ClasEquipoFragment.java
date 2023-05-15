package sv.edu.ues.eisi.proyecto1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ClasEquipoFragment extends Fragment implements AdapterView.OnItemClickListener{

    String[] menu={"Insertar Registro","Eliminar Registro","Consultar Registro", "Actualizar Registro"};
    String[] activities={"ClasEquipoInsertarActivity","ClasEquipoEliminarActivity","ClasEquipoConsultarActivity", "ClasEquipoActualizarActivity"};

    //para poder llamar al activity
    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // context para llamar al activity desde el navigation drawer
        context = getActivity();

        View view = inflater.inflate(R.layout.fragment_clas_equipo, container, false);

        return view;
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = (ListView) view.findViewById(R.id.lst_clas_equipo);
        listView.setBackgroundColor(Color.rgb(242,228,249));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, menu);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id){

        String nombreValue=activities[position];

        try{
            Class<?> clase = Class.forName("sv.edu.ues.eisi.proyecto1."+nombreValue);
            Intent inte = new Intent(context, clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}