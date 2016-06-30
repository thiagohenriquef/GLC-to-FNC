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
public class MenuPrincipal {
    Arquivo arq = new Arquivo();
    
    MenuPrincipal(String arg) throws Exception {
        try {
            arq.leituraArquivo(arg);
        } catch (FileNotFoundException ex) {
            //System.out.println("Ocorreu um erro na leitura do arquivo");
            //ex.printStackTrace();
            throw new Exception(ex);
        }
    }
   
    
}
