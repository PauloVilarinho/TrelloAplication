package com.example.paulo.trello;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import com.example.paulo.trello.adapters.QuadrosAdapter;
import com.example.paulo.trello.modelos.Quadro;

import io.objectbox.Box;

public class Home extends AppCompatActivity {
    public static  final  int REQUEST_CODE = 1001;
    Box<Quadro> box_quadros;
    RecyclerView rvQuadros ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        box_quadros = ((App)getApplication()).getBoxStore().boxFor(Quadro.class);
        rvQuadros = findViewById(R.id.rv_quadros);

        rvQuadros = findViewById(R.id.rv_quadros);

        QuadrosAdapter adapter = new QuadrosAdapter(box_quadros.getAll(),this);

        rvQuadros.setAdapter(adapter);
        rvQuadros.setLayoutManager(new LinearLayoutManager(this));



    }

    public void criarQuadro(View view) {
        final Intent intent = new Intent(this,CriarQuadro.class);

        startActivityForResult(intent,REQUEST_CODE);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                Toast.makeText(this,"Quadro criado.",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
