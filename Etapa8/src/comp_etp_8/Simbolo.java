package comp_etp_8;



public class Simbolo {

      private String nome;      // nome do identificador
      
      private char tipo; 	// tipo da variável

      private int referencia;   // é uma referência usada na geração do código destino

      private static int marcador = 1; // armazena a última referência incluída na tabela

 

      public Simbolo(String _nome, char _tipo) {

            this.nome = _nome;
            
            this.tipo = _tipo;

            this.referencia = Simbolo.marcador;

            Simbolo.marcador += 2;

      }
      
      public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public char getTipo() {
    	  return this.tipo;

  	}

      public String getNome() {

            return this.nome;

      }

      public int getReferencia() {

            return this.referencia;

      }

      
      public String toString() {

          return "\n" + "Nome:"+this.getNome() + "\t" + "Tipo:"+this.getTipo() +

                 "\t" + "Referência:"+this.getReferencia()+ "\n";

       }





}
