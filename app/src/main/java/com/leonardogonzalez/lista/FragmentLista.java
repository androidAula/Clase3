package com.leonardogonzalez.lista;

import android.app.Fragment;
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

        ArrayAdapter<String> adapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,items);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("lista",(((TextView)view).getText().toString()));
            }
        });
        return  view;
    }
}
