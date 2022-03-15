import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;

public class IMC extends  JFrame{

    private JButton calcularButton;
    protected JPanel painel;
    private JTextField txtNome;
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JButton limparButton;

    public static void main(String[] args) {
        JFrame imc = new JFrame("IMC");
        imc.setContentPane(new IMC().painel);
        imc.pack();
        imc.setVisible(true);
        imc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public IMC(){
        calcularButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });

        calcularButton.addActionListener(e -> {
            String nome, resultadoIMC;
            float peso, altura, imc;

            nome = txtNome.getText();
            nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();


            peso = Float.parseFloat(txtPeso.getText());
            altura = Float.parseFloat(txtAltura.getText());

            imc = peso / (altura * altura);

            if( imc <= 5){
                resultadoIMC = "Algo deu errado tente novamente mais tarde";
            } else if ( imc <= 18.5) {
                resultadoIMC = " O calculo do seu IMC apontou que você está ABAIXO do peso ideal ";
            } else if ( imc <= 24.9) {
                resultadoIMC = " O calculo do seu IMC apontou que você está no seu peso ideal ";
            } else if ( imc <= 29.9) {
                resultadoIMC = " O calculo do seu IMC apontou que você está ACIMA do seu peso ";
            } else  {
                resultadoIMC = " O calculo do seu IMC apontou que você está MUITO ACIMA do seu peso, até confudi com a baleia da sua mãe ";
            }

            JOptionPane.showMessageDialog(null , nome + "Seu imc deu " + String.format("%.2f" , imc) + resultadoIMC);
            limparButton.doClick();
        });

        limparButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });

        limparButton.addActionListener(e -> {
            txtNome.setText("");
            txtAltura.setText("");
            txtPeso.setText("");
            txtNome.requestFocus();
        });

        txtNome.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });

        txtNome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });

        txtNome.addActionListener(e -> {
            if(txtNome.getText().isBlank()) {
                JOptionPane.showMessageDialog(null , "Infome um nome");
                txtNome.requestFocus();
            }
        });


        txtPeso.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });

        txtPeso.addActionListener(e -> {
            if(txtNome.getText().isBlank()) {
                JOptionPane.showMessageDialog(null , "Infome um peso");
                txtNome.requestFocus();
            }
        });

        txtAltura.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });

        txtAltura.addActionListener(e -> {
            if(txtNome.getText().isBlank()) {
                JOptionPane.showMessageDialog(null , "Infome uma altura");
                txtNome.requestFocus();
            }
        });


    }

}
