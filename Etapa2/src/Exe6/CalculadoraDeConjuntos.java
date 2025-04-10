/* Generated By:JavaCC: Do not edit this line. CalculadoraDeConjuntos.java */
package Exe6;
import java.util.LinkedList;
import java.io.*;

public class CalculadoraDeConjuntos implements CalculadoraDeConjuntosConstants {
  static Tabela tabela = new Tabela();

  public static void main(String args []) throws ParseException
  {
    CalculadoraDeConjuntos analisador = null;
    try
    {
      analisador = new CalculadoraDeConjuntos(new FileInputStream("prog_fonte.my"));
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
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
      case IDENT:
      case NUM:
      case ABRE_CHAVES:
      case ABRE_PAR:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      linhaComando();
    }
    jj_consume_token(0);
  }

  static final public void linhaComando() throws ParseException {
    comando();
    jj_consume_token(PT_VIRG);
  }

  static final public void comando() throws ParseException {
    if (jj_2_1(2)) {
      atribuicao();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VAR:
      case IDENT:
      case NUM:
      case ABRE_CHAVES:
      case ABRE_PAR:
        expressao();
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void expressao() throws ParseException {
  Token t;
  Conjunto conj1 = null;
  Conjunto conj2 = null;
  boolean result;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENT:
    case NUM:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUM:
        t = jj_consume_token(NUM);
        break;
      case IDENT:
        t = jj_consume_token(IDENT);
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(PERTENCE);
      conj1 = expLogica();
      result = Conjunto.pertence(t.image, conj1);
      if (result)
      {
        System.out.println("VERDADEIRO");
      }
      else
      {
        System.out.println("FALSO");
      }
      break;
    case VAR:
    case ABRE_CHAVES:
    case ABRE_PAR:
      conj1 = expLogica();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ESTA_CONTIDO:
        jj_consume_token(ESTA_CONTIDO);
        conj2 = expLogica();
        result = Conjunto.estaContido(conj1, conj2);
        if (result)
        {
          System.out.println("VERDADEIRO");
        }
        else
        {
          System.out.println("FALSO");
        }
        break;
      default:
        jj_la1[3] = jj_gen;
        ;
      }
      if (conj2 == null)
      {
        System.out.println(conj1.toString());
      }
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public Conjunto expLogica() throws ParseException {
  Conjunto conj1, conj2;
    conj1 = fator();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case UNIAO:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_2;
      }
      jj_consume_token(UNIAO);
      conj2 = fator();
      conj1 = Conjunto.uniao(conj1, conj2);
    }
    {if (true) return conj1;}
    throw new Error("Missing return statement in function");
  }

  static final public Conjunto fator() throws ParseException {
  Conjunto conj1, conj2;
    conj1 = termo();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTERSECAO:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
      jj_consume_token(INTERSECAO);
      conj2 = termo();
      conj1 = Conjunto.intersecao(conj1, conj2);
    }
    {if (true) return conj1;}
    throw new Error("Missing return statement in function");
  }

  static final public Conjunto termo() throws ParseException {
  Token t;
  Conjunto conj = new Conjunto();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ABRE_PAR:
      jj_consume_token(ABRE_PAR);
      conj = expLogica();
      jj_consume_token(FECHA_PAR);
      break;
    case ABRE_CHAVES:
      conj = conjunto();
      break;
    case VAR:
      t = jj_consume_token(VAR);
      String var = t.image.substring(0, 2);
      if (tabela.isExiste(var))
      {
        conj = (Conjunto) tabela.getSimbolo(var).getValor();
      }
      else
      {
        System.out.println("Erro sem\u00e2ntico\u005cnA vari\u00e1vel " + t.image + " n\u00e3o foi inicializada");
      }
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return conj;}
    throw new Error("Missing return statement in function");
  }

  static final public void atribuicao() throws ParseException {
  Simbolo simb;
  Token t;
  Conjunto conj;
    t = jj_consume_token(VAR);
    jj_consume_token(IGUAL);
    conj = expLogica();
    String var = t.image.substring(0, 2);
    simb = new Simbolo(var, conj);
    if (tabela.isExiste(var))
    {
      tabela.getSimbolo(var).setValor(conj);
      System.out.println(conj.toString());
    }
    else
    {
      if (tabela.getNumeroSimbolos() > 25)
      {
        System.out.println("Erro sem\u00e2ntico\u005cnS\u00e3o permitidas apenas 26 vari\u00e1veis.");
      }
      else
      {
        tabela.inclui(simb);
        System.out.println(conj.toString());
      }
    }
  }

  static final public Conjunto conjunto() throws ParseException {
  Token t;
  Conjunto conj = new Conjunto();
  String aux;
    t = jj_consume_token(ABRE_CHAVES);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENT:
    case NUM:
      elemento(conj);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case VIRG:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_4;
        }
        t = jj_consume_token(VIRG);
        elemento(conj);
      }
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    // ? PARA PREVER O CONJUNTO VAZIO { }
      t = jj_consume_token(FECHA_CHAVES);
    {if (true) return conj;}
    throw new Error("Missing return statement in function");
  }

  static final public void elemento(Conjunto conj) throws ParseException {
  Token t;
  int a, b;
  StringBuilder strAux = new StringBuilder();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM:
      t = jj_consume_token(NUM);
      a = Integer.parseInt(t.image);
      conj.add(t.image);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PONTO:
        jj_consume_token(PONTO);
        jj_consume_token(PONTO);
        jj_consume_token(PONTO);
        t = jj_consume_token(NUM);
        b = Integer.parseInt(t.image);
        if (a + 1 < b)
        {
          for (int i = a + 1; i <= b; i++)
          {
            conj.add(String.valueOf(i));
          }
        }
        else
        {
          System.out.println("Erro sem\u00e2ntico\u005cnO intervalo informado \u005c"" + a + "..." + b + "\u005c" n\u00e3o \u00e9 v\u00e1lido.");
        }
        break;
      default:
        jj_la1[10] = jj_gen;
        ;
      }
      break;
    case IDENT:
      t = jj_consume_token(IDENT);
      conj.add(t.image);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_3R_5() {
    if (jj_scan_token(VAR)) return true;
    if (jj_scan_token(IGUAL)) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_5()) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public CalculadoraDeConjuntosTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[12];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x500e0,0x500e0,0xc0,0x4000,0x500e0,0x1000,0x2000,0x50020,0x100,0xc0,0x400,0xc0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[1];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public CalculadoraDeConjuntos(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public CalculadoraDeConjuntos(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CalculadoraDeConjuntosTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
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
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public CalculadoraDeConjuntos(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CalculadoraDeConjuntosTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public CalculadoraDeConjuntos(CalculadoraDeConjuntosTokenManager tm) {
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
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(CalculadoraDeConjuntosTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 12; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
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
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[20];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 12; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 20; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
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

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
