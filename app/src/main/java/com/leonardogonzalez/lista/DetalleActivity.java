package com.leonardogonzalez.lista;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Leonardo on 7/11/2017.
 */

public class DetalleActivity extends Activity {

    private Contacto contactObject;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        TextView textNombre = (TextView) findViewById(R.id.nombre);
        TextView textNumero = (TextView) findViewById(R.id.telefono);
        TextView textWeb = (TextView) findViewById(R.id.web);


        Bundle extras = getIntent().getExtras();
        if (extras == null)
            return;
        contactObject = (Contacto)
                getIntent().getSerializableExtra("contacto");
        textNombre.setText(contactObject.getNombre().toString());
        textNumero.setText(contactObject.getTelefono().toString());
        textWeb.setText(contactObject.getWeb().toString());

        textNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ActivityCompat.checkSelfPermission(DetalleActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(DetalleActivity.this, Manifest.permission.CALL_PHONE)) {
                        //If the user has denied the permission previously your code will come to this block
                        //Here you can explain why you need this permission
                        //Explain here why you need this permission
                        ActivityCompat.requestPermissions(DetalleActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 2);
                    }

                    //And finally ask for the permission
                    ActivityCompat.requestPermissions(DetalleActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 2);

                }else {
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contactObject.getTelefono())));
                }

            }
        });

        textWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://" + contactObject.getWeb())));
            }
        });
    }
}
