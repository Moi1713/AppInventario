package sv.edu.ues.eisi.proyecto1;

import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.SortedListAdapterCallback;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class EquipoFragment extends Fragment implements AdapterView.OnItemClickListener{

    String[] menu={"Insertar Registro","Eliminar Registro","Consultar Registro", "Actualizar Registro"};
    String[] activities={"EquipoInsertarActivity","EquipoEliminarActivity","EquipoConsultarActivity", "EquipoActualizarActivity"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_equipo, container, false);

        return view;
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = (ListView) view.findViewById(R.id.lst_equipo);
        listView.setBackgroundColor(Color.rgb(244,235,190));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, menu);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id){

        String nombreValue=activities[position];

        try{
            Class<?> clase = Class.forName("sv.edu.ues.eisi.proyecto1."+nombreValue);
            //Intent inte = new Intent(Intent.ACTION_SENDTO, Uri.parse("sv.edu.ues.eisi.proyecto1."+nombreValue));
            //this.startActivity(inte);

            Intent i = new Intent(getActivity(), clase);
            startActivity(i);


        }catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }


    }
}