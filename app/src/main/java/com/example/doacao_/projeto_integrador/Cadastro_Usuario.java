package com.example.doacao_.projeto_integrador;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doacao_.projeto_integrador.modelo.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cadastro_Usuario extends AppCompatActivity {
    private Button btnCadastrar;
    private EditText edt_cpf, edt_email, edt_senha, edt_senha2, edt_nome;
    private FirebaseAuth usuarioAuth = FirebaseAuth.getInstance();
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro__usuario);

        edt_cpf = findViewById(R.id.edt_cpf_cadast_usuario);
        edt_email = findViewById(R.id.edt_email_cadast_usuario);
        edt_nome = findViewById(R.id.edt_nome_cadast_usuario);
        edt_senha = findViewById(R.id.edt_senha_cadast_usuario);
        edt_senha2 = findViewById(R.id.edt_confirm_senh_cadast_usuario);
        btnCadastrar = findViewById(R.id.btn_cadastrar_cadast_usuario);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Cadastro de usuario
                // Email e senha(string) como parametros, recuperados da view
                usuarioAuth.createUserWithEmailAndPassword(edt_email.getText().toString(),
                        edt_senha.getText().toString())
                        .addOnCompleteListener(Cadastro_Usuario.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Log.i("CreateUser", "Usuario cadastrado com sucesso!!");
                                }else {
                                    Log.i("CreateUser", "Erro no cadastro!!");
                                }
                            }
                        });

                DatabaseReference usuarios = reference.child("usuarios");

                Usuario usuario = new Usuario();
                usuario.setU_cpf(edt_cpf.getText().toString());
                usuario.setU_email(edt_email.getText().toString());
                usuario.setU_senha(edt_senha.getText().toString());
                usuario.setU_nome(edt_nome.getText().toString());

                usuarios.push().setValue(usuario);

                Toast.makeText(Cadastro_Usuario.this,
                        "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();

                finish();

            }
        });

    }
}
