package com.example.arthurmachado.roomprojectlivros.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "livro_table")
public class Livro {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private long id;
    private String titulo;
    private String autor;
    private String genero;
    private int ano_producao;
    private int avaliacao;

    public Livro() {
    }

    public Livro(long id, String titulo, String autor, String genero, int ano_producao, int avaliacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ano_producao = ano_producao;
        this.avaliacao = avaliacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno_producao() {
        return ano_producao;
    }

    public void setAno_producao(int ano_producao) {
        this.ano_producao = ano_producao;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }
}

