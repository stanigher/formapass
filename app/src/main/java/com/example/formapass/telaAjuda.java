package com.example.formapass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class telaAjuda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tela_ajuda);
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

        Intent intent = new Intent(this, qrcodeevento.class);
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
}