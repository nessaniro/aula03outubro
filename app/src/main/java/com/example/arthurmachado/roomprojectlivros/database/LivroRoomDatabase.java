package com.example.arthurmachado.roomprojectlivros.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.arthurmachado.roomprojectlivros.DAO.LivroDAO;
import com.example.arthurmachado.roomprojectlivros.model.Livro;

@Database(entities = {Livro.class},version = 1)
public abstract class LivroRoomDatabase extends RoomDatabase {
    private static volatile LivroRoomDatabase INSTANCE;
    public abstract LivroDAO livroDAO();

    public static LivroRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (LivroRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LivroRoomDatabase.class,"livro_database").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
