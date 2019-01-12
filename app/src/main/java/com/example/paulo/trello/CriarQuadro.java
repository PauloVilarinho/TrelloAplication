package com.example.paulo.trello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paulo.trello.modelos.Quadro;

import io.objectbox.Box;

public class CriarQuadro extends AppCompatActivity {

    Box<Quadro> box_quadros;
    private EditText editNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_quadro);
        editNome = findViewById(R.id.editText);

        box_quadros = ((App)getApplication()).getBoxStore().boxFor(Quadro.class);
    }

    public void criar(View view) {
        if (editNome.getText().toString().matches("")){
            Toast.makeText(this,"Digite um nome para o Quadro", Toast.LENGTH_LONG).show();
            return;
        }

        Quadro quadro = new Quadro(editNome.getText().toString());
        box_quadros.put(quadro);
        Intent intent = new Intent();

        setResult(RESULT_OK,intent);
        finish();




    }
}
