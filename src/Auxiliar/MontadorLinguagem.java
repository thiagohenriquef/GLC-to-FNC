/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliar;

import Modelo.Producao;
import java.util.ArrayList;
import projeto2teoria.Arquivo;

/**
 *
 * @author thiago
 */
public class MontadorLinguagem {
    Arquivo arq;
    
    public void imprimeProducao(ArrayList<Producao> pro){
        for(Producao p: pro){
            System.out.println(p);
        }
    }
    
    public void chomsky(ArrayList<Producao> pro) {
        pro = removeProducoesVazias(pro); //remove producoes vazias nao aceitas na FNC pura
        pro = trocaTerminalPorVariavel(pro); //troca as producoes terminais por variaveis da forma variavel(terminal)
        pro = defineVariaveis(pro); //define com que cada produção possua apenas 2 variaveis
        this.imprimeProducao(pro);
    }

    public ArrayList<Producao> removeProducoesVazias(ArrayList<Producao> pro) {
        for(int i=0; i<pro.size(); i++){
            if(pro.get(i).getLadoDir().equals("&")){
                pro.remove(i);
            }
        }
        
        
        return pro;
    }

    private ArrayList<Producao> trocaTerminalPorVariavel(ArrayList<Producao> pro) {
        for(int i =0; i<pro.size(); i++){
            String prod = pro.get(i).getLadoDir();
            String value = String.valueOf(prod.charAt(0));
            String prodFinal = "";
            if (prod.length()==1 && isLowerCase(value)) {
                continue;
            } else {
                for(int count=0; count<prod.length(); count++){
                    char caracter = prod.charAt(count);
                    
                    if(Character.isUpperCase(caracter)){
                        prodFinal += caracter;
                        continue;
                    }else{
                        String nome = Character.toUpperCase(caracter)+"("+caracter+")";
                        pro.add(new Producao(nome, String.valueOf(caracter)));
                        prodFinal += nome;
                    }
                }
                
                pro.get(i).setLadoDir(prodFinal);
            }
            
        }
        return pro; 
    }
    
    private ArrayList<Producao> defineVariaveis(ArrayList<Producao> pro) {
        
        for(int i =0; i<pro.size(); i++){
            String prod = pro.get(i).getLadoDir();
            String value = String.valueOf(prod.charAt(0));
            String prodFinal = "";
            
            
            if (prod.length()==1 && isLowerCase(value)) {
                continue;
            } else {
                for(int count = 0; count<prod.length(); count++){
                    String nome = prod.substring(count, count+3);
                    if(nome.equals(""));
                }
            }
                
                pro.get(i).setLadoDir(prodFinal);
            
        }
        return pro;
    }    
    
    
    public static boolean isUpperCase(String string) {  
        return string.toUpperCase().equals(string);  
    }
    
    public static boolean isLowerCase(String string) {  
        return string.toLowerCase().equals(string);  
    }

    
    
    
}
