package comp_etp_8;



public class Simbolo {

      private String nome;      // nome do identificador
      
      private char tipo; 	// tipo da vari�vel

      private int referencia;   // � uma refer�ncia usada na gera��o do c�digo destino

      private static int marcador = 1; // armazena a �ltima refer�ncia inclu�da na tabela

 

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

                 "\t" + "Refer�ncia:"+this.getReferencia()+ "\n";

       }





}
