package com.example.arthurmachado.roomprojectlivros.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.arthurmachado.roomprojectlivros.R;
import com.example.arthurmachado.roomprojectlivros.model.Livro;

import java.util.List;


public class LivroAdapter extends ArrayAdapter<Livro> {
    private int rId;

    public LivroAdapter(@NonNull Context context, int resource, @NonNull List<Livro> objects) {
        super(context, resource, objects);
        rId = resource;
    }

    @Override
    public View getView(int position, View currentView, ViewGroup parent){
        View mView = currentView;

        if(mView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = inflater.inflate(rId,null);
        }

        Livro livro = getItem(position);

        TextView textTitulo = mView.findViewById(R.id.textNomeLivro);
        TextView textAutor = mView.findViewById(R.id.textAutorLivro);
        TextView textGenero = mView.findViewById(R.id.textGeneroLivro);
        TextView textAno = mView.findViewById(R.id.textAnoLivro);
        RatingBar rating = mView.findViewById(R.id.ratingNotaLivro);

        textTitulo.setText(livro.getTitulo().toUpperCase());
        textAutor.setText(livro.getAutor().toUpperCase());
        textGenero.setText(livro.getGenero());
        textAno.setText("Ano: " + String.valueOf(livro.getAno_producao()));
        rating.setRating((float)livro.getAvaliacao());

        return mView;
    }
}

