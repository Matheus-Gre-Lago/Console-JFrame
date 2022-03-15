import utils.CalculadoraDeDescontoEnum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CalculadoraDeDesconto {
    private JTextField txtValor;
    private JPanel Painel;
    private JComboBox comboBoxDesconto;
    private JButton ButtonLimpar;
    private JButton ButtonCalcular;
    private float desconto;

    public static void main(String[] args) {
        JFrame calculadora = new JFrame("CalculadoraDeDesconto");
        calculadora.setContentPane(new CalculadoraDeDesconto().Painel);
        calculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculadora.pack();
        calculadora.setVisible(true);
    }

    public CalculadoraDeDesconto(){

        txtValor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
               if(!CalculadoraDeDescontoEnum.CARACTERES_VALOR.getCaracteres().contains(e.getKeyChar()+"")){
                   e.consume();
               }
            }
        });

        comboBoxDesconto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (comboBoxDesconto.getSelectedIndex()) {
                    case 1:
                        desconto = 5;
                        break;
                    case 2:
                        desconto = 10;
                        break;
                    case 3:
                        desconto = 15;
                        break;
                    case 4:
                        desconto = 20;
                        break;
                    case 5:
                        desconto = 30;
                        break;
                    case 6:
                        desconto = 44;
                        break;
                    case 7:
                        desconto = 50;
                        break;
                    case 8:
                        desconto = 100;
                        break;
                    default:
                        desconto = 0;
                        break;
                }
            }
        });

        ButtonLimpar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });

        ButtonLimpar.addActionListener( e->{
            txtValor.setText("");
            comboBoxDesconto.setSelectedIndex(0);
            txtValor.requestFocus();
        });

        ButtonCalcular.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });

        ButtonCalcular.addActionListener(e -> {
            if(!txtValor.getText().isBlank()){
                float resultadoDaCompra , valorDoProduto;
                valorDoProduto = Float.parseFloat(txtValor.getText());

                if(desconto != 0){

                    resultadoDaCompra =  valorDoProduto - (valorDoProduto * (desconto/100));

                    if (desconto != 100) {
                        JOptionPane.showMessageDialog(null , "O valor da compra é R$" + resultadoDaCompra +
                                " com " + comboBoxDesconto.getSelectedItem() + " de desconto");
                    }else{
                        JOptionPane.showMessageDialog(null , "DEU A LOUCA NO PATRAO, RAPIDO COMPRA CARNE E BREJA SEU FILHOTE DE CRUZ CREDO" +
                                "QUE TU VAI PAGAR R$"+resultadoDaCompra+" PILA");
                    }
                }else{
                    JOptionPane.showMessageDialog(null , "Vai arrumar esse DESCONTO seu bundao");
                }
            }else{
                JOptionPane.showMessageDialog(null , "Vai arrumar esse VALOR seu bundao");
            }
        });
    }
}
