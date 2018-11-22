package com.example.doacao_.projeto_integrador.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.doacao_.projeto_integrador.R;
import com.example.doacao_.projeto_integrador.modelo.Instituicao;
import com.example.doacao_.projeto_integrador.modelo.Usuario;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ImageButton btnMaps;
    private ListView listaInst;
    // private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private List<Instituicao> listaInstituicoes = new ArrayList<>();
    private ArrayAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listaInst = findViewById(R.id.listInstituicao);
        btnMaps = findViewById(R.id.btnMapa);

        listaInst.setAdapter(adapter);

        iniciarFirebase();
        eventoDatabase();

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maps = new Intent(ListActivity.this, ActMapa.class);
                startActivity(maps);
            }
        });

        //DatabaseReference instituicoes = databaseReference.child("instituicoes");

        /*instituicoes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Instituicao dadosInstituicao = dataSnapshot.getValue(Instituicao.class);
                //Log.i("FIREBASE", dadosInstituicao.getI_nome());
                //Log.i("FIREBASE", dataSnapshot.getValue().toString());
                listaInstituicoes.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    Instituicao inst = objSnapshot.getValue(Instituicao.class);
                    listaInstituicoes.add(inst);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

    }

    private void eventoDatabase() {
        databaseReference.child("instituicoes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaInstituicoes.clear();
                for (DataSnapshot objSnapshot: dataSnapshot.getChildren()){
                    Instituicao inst = objSnapshot.getValue(Instituicao.class);
                    listaInstituicoes.add(inst);
                }
                adapter = new ArrayAdapter<Instituicao>(ListActivity.this
                        , android.R.layout.simple_list_item_1, android.R.id.text1
                        , listaInstituicoes);
                listaInst.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void iniciarFirebase(){
        FirebaseApp.initializeApp(ListActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_maps, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return true;
    }
}

