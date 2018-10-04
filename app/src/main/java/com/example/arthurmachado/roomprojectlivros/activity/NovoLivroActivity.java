package com.example.arthurmachado.roomprojectlivros.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import com.example.arthurmachado.roomprojectlivros.R;
import com.example.arthurmachado.roomprojectlivros.model.Livro;
import com.example.arthurmachado.roomprojectlivros.repository.LivrosRepository;

public class NovoLivroActivity extends Activity {

    private EditText editTitulo, editAutor, editAno;
    private Spinner spinnerGenero;
    private RatingBar ratingLivro;
    private LivrosRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_livro);

        editTitulo = findViewById(R.id.editTitulo);
        editAutor = findViewById(R.id.editAutor);

        editAno = findViewById(R.id.editAno);
        spinnerGenero = findViewById(R.id.spinnerGenero);
        ratingLivro = findViewById(R.id.ratingNotaLivro);
        repository = new LivrosRepository(getApplicationContext());
    }

    public void salvarLivro(View view){
        Livro livro = new Livro();
        livro.setAutor(editTitulo.getText().toString());
        livro.setAutor(editAutor.getText().toString());
        livro.setGenero(spinnerGenero.getSelectedItem().toString());
        livro.setAno_producao(Integer.parseInt(editAno.getText().toString()));
        livro.setAvaliacao((int) ratingLivro.getRating());

        repository.insert(livro);
        callMainActivity();
    }

    private void callMainActivity() {
        Intent mainActivity = new Intent(NovoLivroActivity.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}

