/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerenciamentoFaltas.model;

/**
 *
 * @author felip
 */
public class Materias {
    private int id_materias;
    private String nome_materia;
    private int qtd_Max_faltas;
    private int qtd_atual_faltas;

    public int getId_materias() {
        return id_materias;
    }

    public void setId_materias(int id_materias) {
        this.id_materias = id_materias;
    }

    public String getNome_materia() {
        return nome_materia;
    }

    public void setNome_materia(String nome_materia) {
        this.nome_materia = nome_materia;
    }

    public int getQtd_Max_faltas() {
        return qtd_Max_faltas;
    }

    public void setQtd_Max_faltas(int qtd_Max_faltas) {
        this.qtd_Max_faltas = qtd_Max_faltas;
    }

    public int getQtd_atual_faltas() {
        return qtd_atual_faltas;
    }

    public void setQtd_atual_faltas(int qtd_atual_faltas) {
        this.qtd_atual_faltas = qtd_atual_faltas;
    }

    @Override
    public String toString() {
        return this.nome_materia;
    }

    

}
