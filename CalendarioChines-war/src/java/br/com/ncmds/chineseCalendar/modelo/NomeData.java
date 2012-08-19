/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ncmds.chineseCalendar.modelo;

import java.util.Calendar;

/**
 *
 * @author juliano
 */
public class NomeData {
    private String nome;
    private int anoNascimento;
    private int idade;
    private String signoChines;
    
    public NomeData() {

    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int dataNascimento) {
        this.anoNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSignoChines() {
        return signoChines;
    }

    public void setSignoChines(String signoChines) {
        this.signoChines = signoChines;
    }


    @Override
    public String toString() {
        return "NomeData{" + "nome=" + nome + ", dataNascimento=" + anoNascimento + ", idade=" + idade + ", signoChines=" + signoChines + '}';
    }
    
    
  
    
}
