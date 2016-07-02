/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto2teoria;

import Auxiliar.MontadorLinguagem;
import Modelo.Producao;
import Modelo.Terminal;
import Modelo.Variavel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author thiago
 */
public class MenuPrincipal {
    File file = new File("");
    Arquivo arq = new Arquivo();
    MontadorLinguagem montador = new MontadorLinguagem();
    private static ArrayList<Producao> pro = new ArrayList<>();
    private static ArrayList<Terminal> ter = new ArrayList<>();
    private static ArrayList<Variavel> var = new ArrayList<>();
    String so = System.getProperty("os.name");
    
    public MenuPrincipal() {
    }
    
    MenuPrincipal(String[] arg) throws Exception {
        try {
            Scanner entrada = new Scanner(new FileReader(arg[0]));
            //BufferedReader buff = new BufferedReader(entrada);
            var = arq.variaveis(entrada);
            ter = arq.terminais(entrada);
            pro = arq.producoes(entrada);
            
            montador.chomsky(pro, var, ter);
            
            FileWriter arq = new FileWriter(arg[1], false);
            arq.flush();
            Arquivo.gravaArquivo(pro, ter, var, arq);
            
            arq.close();
            entrada.close();
            if(so.equals("Linux")){
                System.out.println("Arquivo de saída salvo em "+file.getAbsolutePath()+"/"+arg[1]);
            }else{
                System.out.println("Arquivo de saída salvo em "+file.getAbsolutePath()+"\\"+arg[1]);
            }
        } catch (FileNotFoundException ex) {
            throw new Exception(ex);
        }
        
    }

    public ArrayList<Producao> getPro() {
        return pro;
    }

    public void setPro(ArrayList<Producao> pro) {
        this.pro = pro;
    }

    public static ArrayList<Terminal> getTer() {
        return ter;
    }

    public static void setTer(ArrayList<Terminal> ter) {
        MenuPrincipal.ter = ter;
    }

    public static ArrayList<Variavel> getVar() {
        return var;
    }

    public static void setVar(ArrayList<Variavel> var) {
        MenuPrincipal.var = var;
    }
   
    public static void imprimeProducao(ArrayList<Producao> pro){
        for(Producao p: pro){
            System.out.println(p);
        }
    }
}
