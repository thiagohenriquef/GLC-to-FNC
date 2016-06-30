package projeto2teoria;

import Modelo.Terminal;
import Modelo.Variavel;
import Modelo.Producao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
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
    ArrayList<Variavel> var = new ArrayList<Variavel>();
    ArrayList<Terminal> ter = new ArrayList<Terminal>();
    ArrayList<Producao> pro = new ArrayList<Producao>();
    public Arquivo() {
    }
    
    public void leituraArquivo(String filename) throws FileNotFoundException{
        Scanner entrada = new Scanner(new FileReader(filename));
        
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
        
        entrada.nextLine(); //listagem dos terminais
        
        //Salvar terminais
        int num = Character.getNumericValue(entrada.nextLine().charAt(0));
        for(int i=0; i<num; i++){
            String nome = String.valueOf(entrada.nextLine().charAt(0));
            ter.add(new Terminal(nome));
        }
        
        entrada.nextLine(); //Listagem das regras de produção
       
        //Salvar regras de produção
        while(entrada.hasNext()){
            String esq = String.valueOf(entrada.nextLine().charAt(0));  
            String ent = entrada.nextLine();
            String[] partes = ent.split(" ");
            String dir = partes[0];
            pro.add(new Producao(esq, dir));
        }
        
        for(Variavel v: var){
            System.out.println(v);
        }
        
        for(Terminal t : ter){
            System.out.println(t);
        }
        
        for(Producao p : pro){
            System.out.println(p);
        }
    
    }

}
