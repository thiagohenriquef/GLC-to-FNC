package projeto2teoria;

import Modelo.Terminal;
import Modelo.Variavel;
import Modelo.Producao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thiago
 */
public class Arquivo {
    private ArrayList<Variavel> var = new ArrayList<Variavel>();
    private ArrayList<Terminal> ter = new ArrayList<Terminal>();
    private ArrayList<Producao> pro = new ArrayList<Producao>();
    
    public Arquivo() {
    }
    
    public ArrayList leituraArquivo(String filename) throws FileNotFoundException{
        /*Scanner entrada = new Scanner(new FileReader(filename));
        
        System.out.println(entrada.nextLine()); // tipo de formalismo
        entrada.nextLine(); // listagem das variáveis
        
        String quant = entrada.nextLine(); //quantidade de variaveis
        char c = quant.charAt(0);
        int n = Character.getNumericValue(c);
        
        //Salvar variaveis
        for(int i=0; i<n; i++){
            String nome = String.valueOf(entrada.nextLine().charAt(0));
            var.add(new Variavel(nome));
        }*/
        
        /*entrada.nextLine(); //listagem dos terminais
        
        //Salvar terminais
        int num = Character.getNumericValue(entrada.nextLine().charAt(0));
        for(int i=0; i<num; i++){
            String nome = String.valueOf(entrada.nextLine().charAt(0));
            ter.add(new Terminal(nome));
        }*/
        
        /*entrada.nextLine(); //Listagem das regras de produção
       
        //Salvar regras de produção
        while(entrada.hasNext()){
            String esq = String.valueOf(entrada.nextLine().charAt(0));  
            String ent = entrada.nextLine();
            String[] partes = ent.split(" ");
            String dir = partes[0];
            pro.add(new Producao(esq, dir));
        }*/
        
        /*for(Variavel v: var){
            System.out.println(v);
        }
        
        for(Terminal t : ter){
            System.out.println(t);
        }
        
        for(Producao p : pro){
            System.out.println(p);
        }*/
        
        return pro;
    
    }

    public ArrayList<Variavel> getVar() {
        return var;
    }

    public void setVar(ArrayList<Variavel> var) {
        this.var = var;
    }

    public ArrayList<Terminal> getTer() {
        return ter;
    }

    public void setTer(ArrayList<Terminal> ter) {
        this.ter = ter;
    }

    public ArrayList<Producao> getPro() {
        return pro;
    }

    public void setPro(ArrayList<Producao> pro) {
        this.pro = pro;
    }

    public ArrayList<Variavel> variaveis(Scanner entrada) {
        System.out.println(entrada.nextLine()); // tipo de formalismo
        entrada.nextLine(); // listagem das variáveis
        
        String quant = entrada.nextLine(); //quantidade de variaveis
        char c = quant.charAt(0);
        int n = Character.getNumericValue(c);
        
        //Salvar variaveis
        for(int i=0; i<n; i++){
            String nome = String.valueOf(entrada.nextLine().charAt(0));
            var.add(new Variavel(nome));
        }
        return var;
    }

    public ArrayList<Terminal> terminais(Scanner entrada) {
        entrada.nextLine(); //listagem dos terminais
        
        //Salvar terminais
        int num = Character.getNumericValue(entrada.nextLine().charAt(0));
        for(int i=0; i<num; i++){
            String nome = String.valueOf(entrada.nextLine().charAt(0));
            ter.add(new Terminal(nome));
        }
        return ter;
    }

    public ArrayList<Producao> producoes(Scanner entrada) {
        entrada.nextLine(); //Listagem das regras de produção
       
        //Salvar regras de produção
        while(entrada.hasNext()){
            String esq = String.valueOf(entrada.nextLine().charAt(0));  
            String ent = entrada.nextLine();
            String[] partes = ent.split(" ");
            String dir = partes[0];
            pro.add(new Producao(esq, dir));
        }
        return pro;
    }

}
