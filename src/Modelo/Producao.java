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
public class Producao {
    private String ladoEsq;
    private String ladoDir;

    public Producao(String ladoEsq, String ladoDir) {
        this.ladoEsq = ladoEsq;
        this.ladoDir = ladoDir;
    }

    public Producao() {
    }

    public String getLadoEsq() {
        return ladoEsq;
    }

    public void setLadoEsq(String ladoEsq) {
        this.ladoEsq = ladoEsq;
    }

    public String getLadoDir() {
        return ladoDir;
    }

    public void setLadoDir(String ladoDir) {
        this.ladoDir = ladoDir;
    }

    @Override
    public String toString() {
        return ladoEsq + "->" + ladoDir ;
    }
    
}
