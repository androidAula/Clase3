package com.leonardogonzalez.lista;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leonardo.gonzalez on 3/11/2017.
 */

public class FragmentLista extends Fragment {
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] items={"amarillo", "azul","rojo","verde"};
         super.onCreateView(inflater, container, savedInstanceState);
         View view=inflater.inflate(R.layout.fragmento_lista,container,false);
        ListView lista=(ListView) view.findViewById(R.id.lista);

        final List<Contacto> contactos=new ArrayList<>();
        contactos.add(new Contacto("leonardo","3102522891","https://aulamatriz.edu.co/"));
        contactos.add(new Contacto("juan","3102522890","https://eltiempo.com/"));
        contactos.add(new Contacto("pedro","3102522899","https://elespectador/"));

        List<String> nombres= new ArrayList();
        for(int i=0;i<contactos.size();i++){
            nombres.add(contactos.get(i).getNombre());
        }

        ArrayAdapter<String> adapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,nombres);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),DetalleActivity.class);
                intent.putExtra("contacto",contactos.get(position));
                getActivity().startActivity(intent);
                Log.e("lista",(((TextView)view).getText().toString()));
            }
        });
        return  view;
    }
}
