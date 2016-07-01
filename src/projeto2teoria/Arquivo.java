package projeto2teoria;

import Modelo.Terminal;
import Modelo.Variavel;
import Modelo.Producao;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
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

    
    /**
     * Salva as variaveis do programa
     * @param entrada
     * @return 
     */
    public ArrayList<Variavel> variaveis(Scanner entrada) {
        entrada.nextLine(); // tipo de formalismo
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

    /**
     * Salva os terminais
     * @param entrada
     * @return 
     */
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
    
    /**
     * Salva as produções
     * @param entrada
     * @return 
     */
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
    
    /**
     * grava as informações em arquivo
     * @param pro
     * @param ter
     * @param var
     * @param arquivo 
     */
    static void gravaArquivo(ArrayList<Producao> pro, ArrayList<Terminal> ter, ArrayList<Variavel> var, FileWriter arquivo) {
        PrintWriter gravarArq = new PrintWriter(arquivo);
        
        gravarArq.printf("FNC Identifica o tipo de formalismo\n");
        
        gravarArq.printf("# Listagem das variáveis\n");
        gravarArq.printf(var.size()+"\tNúmero de váriaveis\n");
        
        for(int i=0; i<var.size(); i++){
            gravarArq.printf(var.get(i)+"\tVáriavel "+i+"\n");
        }
        
        gravarArq.printf("# Listagem dos Terminais \n");
        gravarArq.printf(ter.size()+"#\tNúmero de terminais\n");
        for(int i=0; i<ter.size(); i++){
            gravarArq.printf(ter.get(i)+"\tSímbolo Terminal "+i+"\n");
        }
        
        gravarArq.printf("# Listagem das regras de produção\n");
        for(int i=0; i<pro.size(); i++){
            gravarArq.printf(pro.get(i).getLadoEsq()+"\tLado esquerdo da produção "+pro.get(i)+"\n");
            gravarArq.printf(pro.get(i).getLadoDir()+"\tLado direito da produção "+pro.get(i)+"\n");
        }
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

}
