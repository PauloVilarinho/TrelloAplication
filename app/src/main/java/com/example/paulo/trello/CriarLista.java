package com.example.paulo.trello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paulo.trello.modelos.Lista;
import com.example.paulo.trello.modelos.Quadro;

import javax.xml.transform.Result;

import io.objectbox.Box;

public class CriarLista extends AppCompatActivity {

    EditText editText;
    Box<Quadro> quadroBox;
    Box<Lista> listaBox;
    Quadro quadro;
    public static final long DEFAULT_LONG = (long) 12341234.213123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_lista);

        quadroBox = ((App)getApplication()).getBoxStore().boxFor(Quadro.class);
        listaBox = ((App)getApplication()).getBoxStore().boxFor(Lista.class);

        Toast.makeText(this, (int) listaBox.count(),Toast.LENGTH_SHORT).show();

        editText = findViewById(R.id.editTextLista);

        final Intent intent = getIntent();
        long quadro_id = intent.getLongExtra(OnQuadroSelect.PACOTE,DEFAULT_LONG);
        quadro =  quadroBox.get(quadro_id);
    }

    public void criar(View view) {
        if (editText.getText().toString().matches("")){
            Toast.makeText(this,"Digite um nome para a Lista", Toast.LENGTH_LONG).show();
            return;
        }

        Lista lista = new Lista(editText.getText().toString());



        Intent intent = new Intent();

        setResult(RESULT_OK,intent);

        finish();

    }
}
