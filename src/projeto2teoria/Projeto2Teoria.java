/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2teoria;

import java.io.FileNotFoundException;

/**
 *
 * @author thiago
 */
public class Projeto2Teoria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            MenuPrincipal menu = new MenuPrincipal(args);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro, por favor verifique o nome do arquivo de entrada");
            e.printStackTrace();
            System.exit(0);
        }
    }
    
}
