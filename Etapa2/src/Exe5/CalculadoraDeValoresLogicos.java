/* Generated By:JavaCC: Do not edit this line. CalculadoraDeValoresLogicos.java */
package Exe5;
import java.io.*;

public class CalculadoraDeValoresLogicos implements CalculadoraDeValoresLogicosConstants {
  public static void main(String args []) throws ParseException
  {
    CalculadoraDeValoresLogicos analisador = null;
    try
    {
      analisador = new CalculadoraDeValoresLogicos(new FileInputStream("prog_fonte.my"));
      analisador.inicio();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Erro: arquivo n\u00e3o encontrado");
    }
    catch (TokenMgrError e)
    {
      System.out.println("Erro l\u00e9xico\u005cn" + e.getMessage());
    }
    catch (ParseException e)
    {
      System.out.println("Erro sint\u00e1tico\u005cn" + e.getMessage());
    }
  }

  static final public void inicio() throws ParseException {
  boolean resultado;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VERDADEIRO:
      case FALSO:
      case OP_LOGICO_JAVA:
      case ABRE_PARENTESES:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      resultado = expressao();
      System.out.println("resultado > "+(resultado ? 1 : 0));
    }
    jj_consume_token(0);
  }

  static final public boolean expressao() throws ParseException {
  boolean a, b;
  Token t;
    a = termo();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OP_LOGICO_OU:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      jj_consume_token(OP_LOGICO_OU);
      b = termo();
      a = a || b;
    }
   System.out.println(a + " > expressao");
    {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  static final public boolean termo() throws ParseException {
  boolean a, b;
  Token t;
    a = fator();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case OP_LOGICO_E:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      jj_consume_token(OP_LOGICO_E);
      b = fator();
      a = a && b;
    }
    {if (true) return a;}
    throw new Error("Missing return statement in function");
  }

  static final public boolean fator() throws ParseException {
  Token t;
  boolean res;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OP_LOGICO_JAVA:
      t = jj_consume_token(OP_LOGICO_JAVA);
  System.out.println(t.image + " ");

    {if (true) return !fator();}
      break;
    case VERDADEIRO:
      t = jj_consume_token(VERDADEIRO);
   System.out.println(t.image + " ");
    {if (true) return true;}
      break;
    case FALSO:
      t = jj_consume_token(FALSO);
   System.out.println(t.image + " ");
    {if (true) return false;}
      break;
    case ABRE_PARENTESES:
      jj_consume_token(ABRE_PARENTESES);
      res = expressao();
      jj_consume_token(FECHA_PARENTESES);
    {if (true) return res;}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public CalculadoraDeValoresLogicosTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[4];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x88180,0x40,0x20,0x88180,};
   }

  /** Constructor with InputStream. */
  public CalculadoraDeValoresLogicos(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public CalculadoraDeValoresLogicos(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CalculadoraDeValoresLogicosTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public CalculadoraDeValoresLogicos(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CalculadoraDeValoresLogicosTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public CalculadoraDeValoresLogicos(CalculadoraDeValoresLogicosTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CalculadoraDeValoresLogicosTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 4; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[27];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 4; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 27; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
