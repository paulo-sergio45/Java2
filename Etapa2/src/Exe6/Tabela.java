package Exe6;

import java.util.HashMap;

public class Tabela {

      private HashMap<String,Simbolo> tab;

      public Tabela() {

            this.tab = new HashMap<String,Simbolo>();

      }

      public boolean inclui(Simbolo _simb) {

            if(this.tab.containsKey(_simb.getNome()))

                  return false;

            else {

                  this.tab.put(_simb.getNome(),_simb);

                  return true;

            }

      }

      public int consultaReferencia(String _chave) {

            return ((Simbolo)this.tab.get(_chave)).getReferencia();

      }

      public Simbolo getSimbolo(String _chave) {

              return (Simbolo) this.tab.get(_chave);         

      }

      public boolean isExiste(String _chave) {

            return this.tab.containsKey(_chave);

      }

      public int getNumeroSimbolos() {

        return this.tab.size();

      }

      public String toString() {

          return this.tab.toString();

      }

}
