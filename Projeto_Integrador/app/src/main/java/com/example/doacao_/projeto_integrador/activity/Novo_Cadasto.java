package com.example.doacao_.projeto_integrador.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.doacao_.projeto_integrador.Cadastro_Usuario;
import com.example.doacao_.projeto_integrador.Cadastro_instituicao;
import com.example.doacao_.projeto_integrador.R;

public class Novo_Cadasto extends AppCompatActivity {
ImageButton botao_cadastrar_usuario,botao_cadastrar_instituuicao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_cadastro);


        botao_cadastrar_usuario = findViewById(R.id.img_botao_cadastrar_usuario);
        botao_cadastrar_instituuicao = findViewById(R.id.img_botao_cadastrar_instituicao);

        botao_cadastrar_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Cadastro_Usuario.class);
                startActivity(i);
            }
        });botao_cadastrar_instituuicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Cadastro_instituicao.class);
                startActivity(i);
            }
        });


    }
}
