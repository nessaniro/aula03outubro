package com.example.arthurmachado.roomprojectlivros.repository;

import android.content.Context;
import android.os.AsyncTask;

import com.example.arthurmachado.roomprojectlivros.DAO.LivroDAO;
import com.example.arthurmachado.roomprojectlivros.database.LivroRoomDatabase;
import com.example.arthurmachado.roomprojectlivros.model.Livro;

import java.util.List;

public class LivrosRepository {
    private LivroDAO mLivroDAO;
    private List<Livro> mLivros;

    public LivrosRepository(Context context){
        LivroRoomDatabase db = LivroRoomDatabase.getDatabase(context);
        mLivroDAO = db.livroDAO();
        mLivros = mLivroDAO.loadLivros();
    }

    public List<Livro> getAllLivros(){
        return mLivros;
    }

    public void insert(Livro livro){
        new insertAsyncTask(mLivroDAO).execute(livro);
    }

    private static class insertAsyncTask extends AsyncTask<Livro,Void,Void>{

        private LivroDAO mAsyncTaskDAO;

        insertAsyncTask(LivroDAO dao){
            mAsyncTaskDAO = dao;
        }

        @Override
        protected Void doInBackground(final Livro... params){
            mAsyncTaskDAO.insert(params[0]);
            return null;
        }
    }
}
