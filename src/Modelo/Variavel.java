/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author thiago
 */
public class Variavel {
    private String ladoEsq;

    public Variavel() {
    }

    public Variavel(String ladoEsq) {
        this.ladoEsq = ladoEsq;
    }

    public String getLadoEsq() {
        return ladoEsq;
    }

    public void setLadoEsq(String ladoEsq) {
        this.ladoEsq = ladoEsq;
    }

    @Override
    public String toString() {
        return ladoEsq;
    }
    
    
    
}
