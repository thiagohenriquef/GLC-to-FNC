/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliar;

import Modelo.Producao;
import Modelo.Terminal;
import Modelo.Variavel;
import java.util.ArrayList;
import projeto2teoria.Arquivo;
import projeto2teoria.MenuPrincipal;

/**
 *
 * @author thiago
 */
public class MontadorLinguagem {
    Arquivo arq;

    public MontadorLinguagem() {
    }
    
    public void chomsky(ArrayList<Producao> pro, ArrayList<Variavel> var, ArrayList<Terminal> ter) {
        pro = removeProducoesVazias(pro); //remove producoes vazias nao aceitas na FNC pura
        pro = trocaTerminalPorVariavel(pro, var); //troca as producoes terminais por variaveis da forma variavel(terminal)
        pro = defineVariaveis(pro, var); //define com que cada produção possua apenas 2 variaveis
        //MenuPrincipal.imprimeProducao(pro);
    }
    
    /**
     * Remove todas as produções vazias da GLC, pois não são aceitas na FNC pura
     * @param pro todas as produções
     * @return todas as produções
     */
    public ArrayList<Producao> removeProducoesVazias(ArrayList<Producao> pro) {
        for(int i=0; i<pro.size(); i++){
            if(pro.get(i).getLadoDir().equals("&")){
                pro.remove(i);
            }
        }
        
        
        return pro;
    }
    
    /**
     * troca terminal por variavel, e não modifica as que geram terminal
     * @param pro as regras de produção
     * @param var o array com as variaveis
     * @return as regras de produção
     */
    private ArrayList<Producao> trocaTerminalPorVariavel(ArrayList<Producao> pro, ArrayList<Variavel> var) {
        
        for(int i =0; i<pro.size(); i++){ //percorre todas as regras de produção
            String prod = pro.get(i).getLadoDir(); //lado direito
            String value = String.valueOf(prod.charAt(0)); //primeiro valor do lado direito da producao
            String prodFinal = "";
            
            if (prod.length()==1 && isLowerCase(value)) { //se a produção tiver tamanho 1 e for minuscula, vai pro próximo loop
                continue;
            }
            else { //caso não seja, irá percorrer a string
                
                for(int count=0; count<prod.length(); count++){    
                    char caracter = prod.charAt(count);
                    
                    if(Character.isUpperCase(caracter)){ //caso seja maiusculo, apenas incrementa para o valor final
                        prodFinal += caracter;
                        continue;
                    }else{
                        String nome = String.valueOf((char) (var.get(var.size()-1).getLadoEsq().charAt(0)+1)); //adiciona uma variavel a partir da ultima salva 
                                                                                                               //por ex: se a ultima é G, a próxima é H 
                        
                        pro.add(new Producao(nome, String.valueOf(caracter))); //gera nova produção (variavel nova e caractere)
                        prodFinal += nome; //incrementa pra produção restante
                        var.add(new Variavel(nome)); //salva nova variavel
                        
                    }
                }
                pro.get(i).setLadoDir(prodFinal); //seta a variavel antiga toda maiuscula, ou seja, apenas com variaveis
            }    
        }
        
        MenuPrincipal.setVar(var);
        return pro;
    }
    
    /**
     * reduz o lado direito até que ele possua apenas 2 variáveis
     * @param pro as regras de produção
     * @param var as variaveis do programa
     * @return as regras de produção
     */
    public ArrayList<Producao> defineVariaveis(ArrayList<Producao> pro, ArrayList<Variavel> var){

        for(int count=0; count<pro.size(); count++){    //reduzir até ocorrer apenas 2 variaveis
            
            char ultLetra = var.get(var.size()-1).getLadoEsq().charAt(0); //ultima letra salva no array de variaveis
            
            while(pro.get(count).getLadoDir().length()>2){ // percorre o lado direito até ficar com tamanho 2
                
                String esquerda = pro.get(count).getLadoEsq(); //produção do lado esquerdo
                String direita = pro.get(count).getLadoDir(); //produção do lado direito
                
                ultLetra++; //incrementa a ultima letra
                String nomeProd = ""+ultLetra;  //coloca a ultima letra em uma variavel do tipo String
                String ladoDir = ""+pro.get(count).getLadoDir().charAt(0)+pro.get(count).getLadoDir().charAt(1); //salva um lado direito com as 2 primeiras produções
                Producao p = new Producao(nomeProd, ladoDir);   //salva a nova produção
                pro.add(p); //adiciona a nova produção no array
                
                direita = direita.replace(ladoDir, String.valueOf(ultLetra));   //atualiza a variavel do lado direito removendo a producao antiga, por ex: o que era AB é removido e vira C
                p = new Producao(esquerda, direita); //cria a nova produção
                pro.set(count, p);  //atualiza a produção que foi removida as variaveis
                var.add(new Variavel(String.valueOf(ultLetra)));    //salva uma nova variavel
                
                
            }
            
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
