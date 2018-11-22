package com.example.doacao_.projeto_integrador.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.doacao_.projeto_integrador.R;
import com.example.doacao_.projeto_integrador.activity.Logar_Instituicao;
import com.example.doacao_.projeto_integrador.activity.Logar_Usuario;
import com.example.doacao_.projeto_integrador.activity.Novo_Cadasto;

public class Tela_Principal extends AppCompatActivity {
    ImageButton botao_usuario,botao_instituicao;
    Button botao_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        botao_instituicao = findViewById(R.id.img_btn_instituicao);
        botao_usuario = findViewById(R.id.img_btn_usuario);
        botao_cadastro = findViewById(R.id.btnnovocadastro);

        botao_instituicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Logar_Instituicao.class);
                startActivity(i);
            }
        });

        botao_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Logar_Usuario.class);
                startActivity(i);
            }
        });

        botao_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Novo_Cadasto.class);
                startActivity(i);
            }
        });


    }
}
