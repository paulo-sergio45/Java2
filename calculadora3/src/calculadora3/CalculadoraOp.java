/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora3;

/**
 *
 * @author paulo
 */
public class CalculadoraOp {

    private static StringBuffer expressao = new StringBuffer();

    public static StringBuffer getExpressao() {
        return expressao;
    }

    public static void setExpressao(StringBuffer chave) {
        expressao = chave;
    }

    public static void montaExpressao(String chave) {
        expressao.append(chave);
    }

    public static Double efetuaCalculoSoma(Double nump, Double nums) {
        return null;
    }

    public static Double efetuaCalculoSubt(Double nump, Double nums) {
        return null;
    }

    public static Double efetuaCalculoMulti(Double nump, Double nums) {
        return null;
    }

    public static Double efetuaCalculoDivi(Double nump, Double nums) {
        return null;
    }

    public static Double efetuaCalculoRaiz(Double nbase, Double eindr) {

        return Math.pow(nbase, 1 / eindr);

    }

//    public static Double efetuaCalculoLog(Double nbase, Double nlogari) {
//        Double novo10;
//        novo10 = Math.log10(nlogari) / Math.log10(nbase);
//        return novo10;
//
//    }

    public static Double efetuaCalculoPotencia(Double nbase, Double exp) {
        Double n;
        n = Math.pow(nbase, exp);
        return n;

    }

    public static Double efetuaESeparaCalculo() {
       
        String replace = expressao.substring(0,expressao.length()).replace("+", " + ");
        replace = replace.replace("-", " - ");
        replace = replace.replace("*", " * ");
        replace =replace.replace("/", " / ");
        replace =replace.replace("log", " log ");
        replace =replace.replace("raiz", " raiz ");
        replace = replace.replace("^", " ^ ");
        String[] vet = replace.split(" ");
        for (int i = 0; i < vet.length; i++) {
            /*
            1°() log
            2° ^ raiz
            3° * /
            4° + -
            */
            
        }
        return null;
    }
}