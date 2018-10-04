package com.example.arthurmachado.roomprojectlivros.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.arthurmachado.roomprojectlivros.R;
import com.example.arthurmachado.roomprojectlivros.adapter.LivroAdapter;
import com.example.arthurmachado.roomprojectlivros.model.Livro;
import com.example.arthurmachado.roomprojectlivros.repository.LivrosRepository;

public class MainActivity extends Activity {

    // APP
    private ListView listaLivros;
    private LivrosRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaLivros = findViewById(R.id.listaLivros);
        repository = new LivrosRepository(getApplicationContext());
        ArrayAdapter<Livro> adapter = new LivroAdapter(this,R.layout.livro_item,repository.getAllLivros());
        listaLivros.setAdapter(adapter);
    }

    public void novoLivro(View view){
        Intent novoLivro = new Intent(MainActivity.this,NovoLivroActivity.class);
        startActivity(novoLivro);
    }
}
