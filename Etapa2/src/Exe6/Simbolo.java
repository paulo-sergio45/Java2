package Exe6;


public class Simbolo {

    private String nome;      // nome do identificador

    private int referencia;   // é uma referência usada na geração do código destino

    private static int marcador = 1; // armazena a última referência incluída na tabela

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

       return "Nome:" + this.getNome() + "/" + "Referência:" + this.getReferencia() + "\n";

    }

}