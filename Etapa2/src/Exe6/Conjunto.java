package Exe6;

import java.util.Iterator;

import java.util.LinkedList;

@SuppressWarnings("serial")

public class Conjunto extends LinkedList<String> {

      public Conjunto() {

            super();

      }

      public static Conjunto uniao(Conjunto conj1, Conjunto conj2) {

            Conjunto conjAux = (Conjunto) conj1.clone();

            Iterator<String> it = conj2.iterator();

            while(it.hasNext()) {

                  String elemento = it.next();

                  if (!Conjunto.pertence(elemento, conjAux)) {

                        conjAux.add(elemento);

                  }

            }

            return conjAux;

      }

 

      public static Conjunto intersecao(Conjunto conj1, Conjunto conj2) {

            Conjunto conjAux = new Conjunto();

            Iterator<String> it = conj1.iterator();

            while(it.hasNext()) {

                  int indice = conj2.lastIndexOf(it.next());

                  if (indice > -1) {

                        conjAux.add(conj2.get(indice));

                  }

            }

            return conjAux;        

      }

     

      public static boolean pertence(String elemento, Conjunto conj) {

            return conj.lastIndexOf(elemento) > -1;

      }

     

      public static boolean estaContido(Conjunto conj1, Conjunto conj2) {

            boolean estaContido = true;

            Iterator<String> it = conj1.iterator();

            while(it.hasNext() && estaContido) {

                  estaContido = Conjunto.pertence(it.next(), conj2);  

            }

            return estaContido;    

      }

     

      public String toString() {

            StringBuilder strConjunto = new StringBuilder();

            Iterator<String> it = this.iterator();

            strConjunto.append("{");

            while(it.hasNext()) {

                  strConjunto.append(it.next().toString());

                  if(it.hasNext()) {

                        strConjunto.append(", ");

                  }                

            }

            strConjunto.append("}");

            return strConjunto.toString();

      }    

}