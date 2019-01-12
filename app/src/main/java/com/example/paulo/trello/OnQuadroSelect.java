package com.example.paulo.trello;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paulo.trello.adapters.ListasAdapter;
import com.example.paulo.trello.adapters.QuadrosAdapter;
import com.example.paulo.trello.modelos.Lista;
import com.example.paulo.trello.modelos.Quadro;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.Box;

public class OnQuadroSelect extends AppCompatActivity {
    Box<Quadro> box_quadros;
    Quadro quadro ;
    RecyclerView rvListas ;
    List<Lista> listas;
    TextView titulo;

    public static final int REQUEST_CODE = 1002;
    public static final String PACOTE = "pacote_quadro_lista";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_quadro_select);
        final Intent intent = getIntent();
        box_quadros = ((App)getApplication()).getBoxStore().boxFor(Quadro.class);

        long quadroId = intent.getLongExtra(QuadrosAdapter.PACOTE,(long)999999.9);
        quadro = box_quadros.get(quadroId);

        titulo = findViewById(R.id.quadroTitulo);
        titulo.setText(quadro.getTitulo());

        listas = quadro.getListas();

//        TODO
//        rvListas = findViewById(R.id.rvLista);
//        ListasAdapter adapter = new ListasAdapter(listas,this);




    }

    public void criarLista(View view) {

        Intent intent = new Intent(this,CriarLista.class);

        intent.putExtra(PACOTE,quadro.id);

        startActivityForResult(intent,REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String x = "";
                List<Lista> listas = quadro.getListas();
                Lista lista = listas.get(0);
                //Toast.makeText(this,lista.getTitulo(),Toast.LENGTH_SHORT).show();
            }
        }
    }
}
