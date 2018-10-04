package com.example.arthurmachado.roomprojectlivros.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.arthurmachado.roomprojectlivros.model.Livro;

import java.util.List;

@Dao
public interface LivroDAO {

    @Insert
    void insert(Livro livro);

    @Query("DELETE FROM livro_table where livro_table.ID == :id")
    void delete(long id);

    @Query("SELECT * from livro_table ORDER BY avaliacao DESC")
    List<Livro> loadLivros();
}
