package projeto2teoria;

import Auxiliar.MontadorLinguagem;
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

    public void leArquivo(Scanner entrada) {
        while (entrada.hasNext()) {
            String x = entrada.nextLine();

            if (x.charAt(0) == '#') {
                entrada.nextLine();
            }
        }
    }

    /**
     * Salva as variaveis do programa
     *
     * @param entrada
     * @return
     */
    public ArrayList<Variavel> variaveis(Scanner entrada) {
        String x = "";
        x = entrada.nextLine();
        while (true) {
            if (Character.isDigit(x.charAt(0))) {
                break;
            } else {
                x = entrada.nextLine();
            }
        }

        int n = Integer.parseInt("" + x.charAt(0));

        //Salvar variaveis
        for (int i = 0; i < n; i++) {
            while (true) {
                x = entrada.nextLine();
                if (x.charAt(0) != '#') {
                    break;
                } else {
                    continue;
                }
            }
            var.add(new Variavel("" + x.charAt(0)));
        }
        return var;
    }

    /**
     * Salva os terminais
     *
     * @param entrada
     * @return
     */
    public ArrayList<Terminal> terminais(Scanner entrada) {
        String x = ""; // listagem dos terminais
        x = entrada.nextLine();
        while (true) {
            if (Character.isDigit(x.charAt(0))) {
                break;
            } else {
                x = entrada.nextLine();
            }
        }

        //Salvar terminais
        int num = Integer.parseInt("" + x.charAt(0));
        for (int i = 0; i < num; i++) {
            while (true) {
                x = entrada.nextLine();
                if (x.charAt(0) == '#') {
                    continue;
                } else {
                    break;
                }
            }
            String nome = "" + x.charAt(0);
            //if (nome.equals('&')) continue;
            if (MontadorLinguagem.isUpperCase(nome)) {
                System.out.println("eliminando simbolo terminal " + nome + " por não ser minusculo");
                continue;
            }

            Terminal t = new Terminal(nome);
            ter.add(t);
        }
        return ter;
    }

    /**
     * Salva as produções
     *
     * @param entrada
     * @return
     */
    public ArrayList<Producao> producoes(Scanner entrada) {
        String x = ""; // listagem das produções

        //Salvar regras de produção
        while (entrada.hasNextLine()) {
            try {
                while (true) {
                    x = entrada.nextLine();
                    if (x.charAt(0) == '#') {
                        continue;
                    } else {
                        break;
                    }
                }
                String esq = "" + x.charAt(0);

                while (true) {
                    x = entrada.nextLine();
                    if (x.charAt(0) == '#') {
                        continue;
                    } else {
                        break;
                    }
                }
                String ent = x;
                String[] partes = ent.split(" ");
                String dir = partes[0];
                pro.add(new Producao(esq, dir));
            } catch (Exception e) {
                break;
            }
        }
        return pro;
    }

    /**
     * grava as informações em arquivo
     *
     * @param pro
     * @param ter
     * @param var
     * @param arquivo
     */
    static void gravaArquivo(ArrayList<Producao> pro, ArrayList<Terminal> ter, ArrayList<Variavel> var, FileWriter arquivo) {
        PrintWriter gravarArq = new PrintWriter(arquivo);

        gravarArq.printf("FNC #Identifica o tipo de formalismo\n");

        gravarArq.printf("# Listagem das variáveis\n");
        gravarArq.printf(var.size() + "\t#Número de váriaveis\n");

        for (int i = 0; i < var.size(); i++) {
            gravarArq.printf(var.get(i) + "\t#Váriavel " + i + "\n");
        }

        gravarArq.printf("# Listagem dos Terminais \n");
        gravarArq.printf(ter.size() + "\t#Número de terminais\n");
        for (int i = 0; i < ter.size(); i++) {
            gravarArq.printf(ter.get(i) + "\t#Símbolo Terminal " + i + "\n");
        }

        gravarArq.printf("# Listagem das regras de produção\n");
        for (Producao pro1 : pro) {
            gravarArq.printf(pro1.getLadoEsq() + "\t#Lado esquerdo da produção " + pro1 + "\n");
            gravarArq.printf(pro1.getLadoDir() + "\t#Lado direito da produção " + pro1 + "\n");
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

    public boolean checaComentario(Scanner entrada) {
        String x = "";
        while (true) {
            x = entrada.nextLine();
            if (x.charAt(0) == '#') {
                break;
            }
        }
        return true;
    }
}
