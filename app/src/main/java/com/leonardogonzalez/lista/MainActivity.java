package com.leonardogonzalez.lista;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        FrameLayout frameLayout=(FrameLayout) findViewById(R.id.container);
        MyFragment myFragment=new MyFragment();
        FragmentManager fragmentManager=getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container,myFragment).commit();

        //lista=(ListView) findViewById(R.id.lista);

//        ArrayAdapter<String> adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
//        lista.setAdapter(adapter);
//
//        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.e("lista",(((TextView)view).getText().toString()));
//            }
//        });


    }
}
