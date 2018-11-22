package com.example.doacao_.projeto_integrador.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doacao_.projeto_integrador.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Logar_Usuario extends AppCompatActivity {
    private Button btnLogar;
    private FirebaseAuth usuario = FirebaseAuth.getInstance();
    private EditText edt_login, edt_senha;
    private String senha, login;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logar_usuario_);

        btnLogar = findViewById(R.id.btn_logar_usuario);
        edt_login = findViewById(R.id.edt_logar_usuario);
        edt_senha = findViewById(R.id.edt_senha_usuario);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = edt_login.getText().toString();
                senha = edt_senha.getText().toString();


                    // Logar usuario
                    usuario.signInWithEmailAndPassword(login, senha)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Log.i("signIn", "Usuario logado com sucesso!!");

                                        Toast.makeText(Logar_Usuario.this,
                                                "Logado com sucesso!", Toast.LENGTH_SHORT).show();

                                        Intent it = new Intent(Logar_Usuario.this, ListActivity.class);
                                        startActivity(it);
                                    } else {
                                        Log.i("signIn", "Erro ao logar usuario!!");
                                        Toast.makeText(Logar_Usuario.this,
                                                "Erro de login!", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });




            }
        });

    }
}
