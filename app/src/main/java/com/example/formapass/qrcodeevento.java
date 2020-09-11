package com.example.formapass;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import com.google.android.material.navigation.NavigationView;
import android.widget.Toast;

public class qrcodeevento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_qrcodeevento);




    }
    public void telaEvento(View view){

        Intent intent = new Intent(this, mainevento.class);
        startActivity(intent);
    }
    public void telaAjuda(View view){

        Intent intent = new Intent(this, telaAjuda.class);
        startActivity(intent);
    }
    public void telaQR(View view){

        Intent intent = new Intent(this, digiteevento.class);
        startActivity(intent);
    }
    public void apareceNav(View view){
        NavigationView nav= (NavigationView) findViewById(R.id.menunavbar);
        ImageView sair_nav= (ImageView) findViewById(R.id.fundo);
        nav.setVisibility(View.VISIBLE);
        sair_nav.setVisibility(View.VISIBLE);
    }
    public void desapareceNav(View view){
        NavigationView nav= (NavigationView) findViewById(R.id.menunavbar);
        ImageView sair_nav= (ImageView) findViewById(R.id.fundo);
        nav.setVisibility(View.GONE);
        sair_nav.setVisibility(View.GONE);
    }

            public void onclick(View v){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
        integrator.setPrompt("Scan");
        integrator.setCameraId(0);
        integrator.initiateScan();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if(intentResult != null){
            if (intentResult.getContents() !=  null){
                alert(intentResult.getContents().toString());
            }else{
                alert(" alert");
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
    private void alert(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }


}