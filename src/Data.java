import utils.DataEnum;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;

public class Data extends  JFrame {
    private JTextField txtDia;
    private JTextField txtMes;
    private JTextField txtAno;
    private JButton ButtonCalcular;
    private JButton ButtonLimpar;
    private JTextField txtNome;
    private JPanel painel;

    public static void main(String[] args) {
        JFrame data = new JFrame("IMC");
        data.setContentPane(new Data().painel);
        data.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        data.pack();
        data.setVisible(true);
    }

    public Data() {
        ButtonCalcular.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });

        ButtonCalcular.addActionListener(e -> {
            String nome = txtNome.getText();
            Integer dia = Integer.parseInt(txtDia.getText());
            Integer mes = Integer.parseInt(txtMes.getText());
            Integer ano = Integer.parseInt(txtAno.getText());

            Calendar dataCadastrada = Calendar.getInstance();
            dataCadastrada.set(ano, mes, dia);
            Calendar hoje = Calendar.getInstance();

            if (nome.isBlank()) {
                JOptionPane.showMessageDialog(null, "Vai la preencher o nome seu merda");
                txtNome.requestFocus();
            }else{
                Integer resultadoDoCalculo = (hoje.get(Calendar.YEAR) * 365 + hoje.get(Calendar.MONTH) -
                        (dataCadastrada.get(Calendar.YEAR) * 365 + dataCadastrada.get(Calendar.MONTH)) - 180);
                JOptionPane.showMessageDialog(null , " Dias de vida " + resultadoDoCalculo);
            }
        });

        ButtonLimpar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });

        ButtonLimpar.addActionListener( e -> {
            txtNome.setText("");
            txtDia.setText("");
            txtMes.setText("");
            txtAno.setText("");
            txtNome.requestFocus();
        });


        txtNome.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(DataEnum.CARACTERES_NOME.getCaracteres().contains(e.getKeyChar()+"")){
                    e.consume();
                }
            }
        });

        txtDia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!DataEnum.CARACTERES_DATA.getCaracteres().contains(e.getKeyChar()+"")){
                    e.consume();
                }
            }
        });

        txtMes.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!DataEnum.CARACTERES_DATA.getCaracteres().contains(e.getKeyChar()+"")){
                    e.consume();
                }

            }
        });

        txtAno.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!DataEnum.CARACTERES_DATA.getCaracteres().contains(e.getKeyChar()+"")){
                    e.consume();
                }
            }
        });
    }
}
