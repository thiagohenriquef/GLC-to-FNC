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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author thiago
 */
public class MenuPrincipal {
    Arquivo arq = new Arquivo();
    MontadorLinguagem montador = new MontadorLinguagem();
    private ArrayList<Producao> pro = new ArrayList<>();
    private ArrayList<Terminal> ter = new ArrayList<>();
    private ArrayList<Variavel> var = new ArrayList<>();
    //private ArrayList<ArrayList> array = new ArrayList<>();

    public MenuPrincipal() {
    }
    
    
    
    MenuPrincipal(String arg) throws Exception {
        try {
            Scanner entrada = new Scanner(new FileReader(arg));
            var = arq.variaveis(entrada);
            ter = arq.terminais(entrada);
            pro = arq.producoes(entrada);
            //pro = arq.leituraArquivo(arg);
            montador.chomsky(pro, var, ter);
        } catch (FileNotFoundException ex) {
            //System.out.println("Ocorreu um erro na leitura do arquivo");
            //ex.printStackTrace();
            throw new Exception(ex);
        }
    }

    public ArrayList<Producao> getPro() {
        return pro;
    }

    public void setPro(ArrayList<Producao> pro) {
        this.pro = pro;
    }

    public ArrayList<Terminal> getTer() {
        return ter;
    }

    public void setTer(ArrayList<Terminal> ter) {
        this.ter = ter;
    }

    public ArrayList<Variavel> getVar() {
        return var;
    }

    public void setVar(ArrayList<Variavel> var) {
        this.var = var;
    }
   
    
}
