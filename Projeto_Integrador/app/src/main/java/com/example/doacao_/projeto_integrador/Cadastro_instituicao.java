package com.example.doacao_.projeto_integrador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.doacao_.projeto_integrador.modelo.Instituicao;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Cadastro_instituicao extends AppCompatActivity {
    private EditText edt_nomeInst, edt_cnpj, edt_tel, edt_email, edt_desc
            ,edt_nomeUsuario, edt_senha, edt_senha2;
    private Button btnSalvar;
    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private String nomeInst, cnpj, telefone, email, descricao, nomeUsuario,
    senha, senha2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_instituicao);

        edt_nomeInst = findViewById(R.id.edt_nome_institu_cadast_instituic);
        edt_cnpj = findViewById(R.id.edt_CNPJ_cadast_instituic);
        edt_tel = findViewById(R.id.edt_telefone);
        edt_email = findViewById(R.id.edt_email_cadast_instituic);
        edt_desc = findViewById(R.id.edt_descricao);
        btnSalvar = findViewById(R.id.btn_cadastrar_cadast_instituic);
        edt_nomeUsuario = findViewById(R.id.edt_usuario_intituicao);
        edt_senha = findViewById(R.id.edt_senha_instituicao);
        edt_senha2 = findViewById(R.id.edt_senha2_instituicao);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nomeInst = edt_nomeInst.getText().toString();
                cnpj = edt_cnpj.getText().toString();
                telefone = edt_tel.getText().toString();
                email = edt_email.getText().toString();
                descricao = edt_desc.getText().toString();
                nomeUsuario = edt_nomeUsuario.getText().toString();
                senha = edt_senha.getText().toString();
                senha2 = edt_senha2.getText().toString();

                if (senha.equals(senha2)) {
                    if (cnpj != "" && descricao != "" && email != ""
                            && nomeInst != "" && telefone != "" && senha != ""
                            && nomeUsuario != "") {

                        // Referenciando
                        DatabaseReference instituicoes = reference.child("intituicoes");
                        // Instaciando uma nova instituição
                        Instituicao instituicao = new Instituicao();
                        instituicao.setI_nome(nomeInst);
                        instituicao.setI_cnpj(cnpj);
                        instituicao.setI_telefone(telefone);
                        instituicao.setI_email(email);
                        instituicao.setI_desc(descricao);
                        instituicao.setI_nomeUsuario(nomeUsuario);
                        instituicao.setI_senha(senha);
                        // instituicao.setI_senha2(edt_senha2.getText().toString());


                        instituicoes.push().setValue(instituicao);

                        Toast.makeText(Cadastro_instituicao.this,
                                "Cadastro efetuado com sucesso!", Toast.LENGTH_LONG).show();

                        finish();

                    } else {
                        Toast.makeText(Cadastro_instituicao.this,
                                "Preencha os campos em branco!!", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(Cadastro_instituicao.this,
                            "As senhas digitadar são diferentes!", Toast.LENGTH_SHORT).show();
                }




            }
        });



    }
}
