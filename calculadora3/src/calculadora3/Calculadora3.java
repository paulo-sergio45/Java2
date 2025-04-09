/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora3;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author paulo
 */
public class Calculadora3 implements ActionListener {

    private JFrame frame;
    private JTextField textoprincipal;
    private JTextField textosecundario;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculadora3 window = new Calculadora3();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Calculadora3() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculadora");
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(0, 0, 434, 75);
        panel.add(panel_1);
        panel_1.setLayout(null);

        textoprincipal = new JTextField();
        textoprincipal.setBounds(0, 0, 434, 74);
        textoprincipal.setFont(new Font("Verdana", Font.PLAIN, 20));
        panel_1.add(textoprincipal);
        textoprincipal.setColumns(10);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.LIGHT_GRAY);
        panel_2.setBounds(0, 75, 434, 50);
        panel.add(panel_2);
        panel_2.setLayout(null);

        textosecundario = new JTextField();
        textosecundario.setBounds(0, 0, 271, 50);
        textosecundario.setFont(new Font("Verdana", Font.PLAIN, 20));
        panel_2.add(textosecundario);
        textosecundario.setColumns(10);

        JButton btn_Excluir = new JButton("Excluir");
        btn_Excluir.addActionListener(this);
        btn_Excluir.setBounds(335, 0, 99, 48);
        panel_2.add(btn_Excluir);

        JButton btn_Mostra = new JButton("M");
        btn_Mostra.addActionListener(this);
        btn_Mostra.setBounds(273, 0, 60, 50);
        panel_2.add(btn_Mostra);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.LIGHT_GRAY);
        panel_3.setBounds(0, 152, 434, 109);
        panel.add(panel_3);
        panel_3.setLayout(new GridLayout(4, 4, 0, 0));

        JButton btn_7 = new JButton("7");
        btn_7.addActionListener(this);
        panel_3.add(btn_7);

        JButton btn_8 = new JButton("8");
        btn_8.addActionListener(this);
        panel_3.add(btn_8);

        JButton btn_9 = new JButton("9");
        btn_9.addActionListener(this);
        panel_3.add(btn_9);

        JButton btn_divi = new JButton("/");
        btn_divi.addActionListener(this);
        panel_3.add(btn_divi);

        JButton btn_4 = new JButton("4");
        btn_4.addActionListener(this);
        panel_3.add(btn_4);

        JButton btn_5 = new JButton("5");
        btn_5.addActionListener(this);
        panel_3.add(btn_5);

        JButton btn_6 = new JButton("6");
        btn_6.addActionListener(this);
        panel_3.add(btn_6);

        JButton btn_mult = new JButton("*");
        btn_mult.addActionListener(this);
        panel_3.add(btn_mult);

        JButton btn_01 = new JButton("1");
        btn_01.addActionListener(this);
        panel_3.add(btn_01);

        JButton btn_2 = new JButton("2");
        btn_2.addActionListener(this);
        panel_3.add(btn_2);

        JButton btn_3 = new JButton("3");
        btn_3.addActionListener(this);
        panel_3.add(btn_3);

        JButton btn_meno = new JButton("-");
        btn_meno.addActionListener(this);
        panel_3.add(btn_meno);

        JButton btn_pont = new JButton(".");
        btn_pont.addActionListener(this);
        panel_3.add(btn_pont);

        JButton btn_0 = new JButton("0");
        btn_0.addActionListener(this);
        panel_3.add(btn_0);

        JButton btn_igua = new JButton("=");
        btn_igua.addActionListener(this);
        panel_3.add(btn_igua);

        JButton btn_mais = new JButton("+");
        btn_mais.addActionListener(this);
        panel_3.add(btn_mais);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(0, 123, 433, 29);
        panel.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 6, 0, 0));

        JButton btn_esqpar = new JButton("(");
        btn_esqpar.addActionListener(this);
        panel_4.add(btn_esqpar);

        JButton btn_dirpar = new JButton(")");
        btn_dirpar.addActionListener(this);
        panel_4.add(btn_dirpar);

        JButton btn_l = new JButton("log");
        btn_l.addActionListener(this);
        panel_4.add(btn_l);

        JButton btn_poten = new JButton("^");
        btn_poten.addActionListener(this);
        panel_4.add(btn_poten);

        JButton btn_r = new JButton("raiz");
        btn_r.addActionListener(this);
        panel_4.add(btn_r);

        JButton btn_apa = new JButton("<");
        btn_apa.addActionListener(this);
        panel_4.add(btn_apa);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String key = ((JButton) e.getSource()).getText();
        switch (key) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":

                CalculadoraOp.montaExpressao(key);
                textoprincipal.setText(key);
                textosecundario.setText(CalculadoraOp.getExpressao().toString());

                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case ".":
            case "(":
            case ")":
            case "log":
            case "^":
            case "raiz":
                if (CalculadoraOp.getExpressao().length() != 0
                        && !CalculadoraOp.getExpressao().substring(CalculadoraOp.getExpressao().length() - 1,
                                CalculadoraOp.getExpressao().length()).equals("-")
                        && !CalculadoraOp.getExpressao().substring(CalculadoraOp.getExpressao().length() - 1,
                                CalculadoraOp.getExpressao().length()).equals("+")
                        && !CalculadoraOp.getExpressao().substring(CalculadoraOp.getExpressao().length() - 1,
                                CalculadoraOp.getExpressao().length()).equals("/")
                        && !CalculadoraOp.getExpressao().substring(CalculadoraOp.getExpressao().length() - 1,
                                CalculadoraOp.getExpressao().length()).equals("*")
                        && !CalculadoraOp.getExpressao().substring(CalculadoraOp.getExpressao().length() - 1,
                                CalculadoraOp.getExpressao().length()).equals(".")
                        && !CalculadoraOp.getExpressao().substring(CalculadoraOp.getExpressao().length() - 1,
                                CalculadoraOp.getExpressao().length()).equals("(")
                        && !CalculadoraOp.getExpressao().substring(CalculadoraOp.getExpressao().length() - 1,
                                CalculadoraOp.getExpressao().length()).equals(")")
                        && !CalculadoraOp.getExpressao().substring(CalculadoraOp.getExpressao().length() - 1,
                                CalculadoraOp.getExpressao().length()).equals("g")
                        && !CalculadoraOp.getExpressao().substring(CalculadoraOp.getExpressao().length() - 1,
                                CalculadoraOp.getExpressao().length()).equals("^")
                        && !CalculadoraOp.getExpressao().substring(CalculadoraOp.getExpressao().length() - 1,
                                CalculadoraOp.getExpressao().length()).equalsIgnoreCase("z")) {

                    CalculadoraOp.montaExpressao(key);
                    textoprincipal.setText(key);
                    textosecundario.setText(CalculadoraOp.getExpressao().toString());
                } else {

                }
                break;
            case "=":

                CalculadoraOp.efetuaESeparaCalculo();
                textoprincipal.setText(key);
                textosecundario.setText(CalculadoraOp.getExpressao().toString());

                break;

            case "<":
                
                if (CalculadoraOp.getExpressao().length() != 0) {
                    CalculadoraOp.setExpressao(CalculadoraOp.getExpressao().delete(CalculadoraOp.getExpressao().length() - 1,
                            CalculadoraOp.getExpressao().length()));
                }
                
                textoprincipal.setText(key);
                textosecundario.setText(CalculadoraOp.getExpressao().toString());

                break;
            case "Excluir":
                
                if (CalculadoraOp.getExpressao().length() != 0) {
                    CalculadoraOp.setExpressao(CalculadoraOp.getExpressao().delete(0,
                            CalculadoraOp.getExpressao().length()));
                
                textoprincipal.setText(key);
                textosecundario.setText(CalculadoraOp.getExpressao().toString());
                }
                
                

                break;
            case "M":

                
                textoprincipal.setText(key);
                textosecundario.setText(CalculadoraOp.getExpressao().toString());

                break;
            default:

                break;
        }

    }
}
