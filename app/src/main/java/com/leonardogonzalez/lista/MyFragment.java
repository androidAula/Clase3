package com.leonardogonzalez.lista;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by leonardo.gonzalez on 3/11/2017.
 */

public class MyFragment extends Fragment {
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] items={"amarillo", "azul","rojo","verde"};
         super.onCreateView(inflater, container, savedInstanceState);
       View view=inflater.inflate(R.layout.fragmento_recicler,container,false);
        recyclerView=(RecyclerView) view.findViewById(R.id.reciclerView);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        MyAdapter mAdapter = new MyAdapter(items);
        recyclerView.setAdapter(mAdapter);
        return  view;
    }
}
