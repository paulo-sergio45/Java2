package Exe6;


public class Simbolo {

    private String nome;      // nome do identificador

    private int referencia;   // � uma refer�ncia usada na gera��o do c�digo destino

    private static int marcador = 1; // armazena a �ltima refer�ncia inclu�da na tabela

    private Object valor;

    public Simbolo(String _nome, Object valor) {

          this.nome = _nome;

          this.referencia = Simbolo.marcador;

          Simbolo.marcador += 2;

          this.valor = valor;

    }

 

    public String getNome() {

          return this.nome;

    }

 

    public int getReferencia() {

          return this.referencia;

    }

   

    public Object getValor() {

      return this.valor;

    }

   

    public void setValor(Object _valor) {

      this.valor = _valor;

    }

 

    public String toString() {

       return "Nome:" + this.getNome() + "/" + "Refer�ncia:" + this.getReferencia() + "\n";

    }

}