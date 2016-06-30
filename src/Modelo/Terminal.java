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
public class Terminal {
    private String ladoDir;

    public Terminal(String ladoDir) {
        this.ladoDir = ladoDir;
    }

    public Terminal() {
    }

    public String getLadoDir() {
        return ladoDir;
    }

    public void setLadoDir(String ladoDir) {
        this.ladoDir = ladoDir;
    }

    @Override
    public String toString() {
        return ladoDir;
    }
    
    
    
}
