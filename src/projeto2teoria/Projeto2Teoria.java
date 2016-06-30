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
            MenuPrincipal menu = new MenuPrincipal(args[0]);
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado\nSaindo do programa");
            System.exit(0);
        }
    }
    
}
