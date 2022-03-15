import javax.swing.*;
import java.awt.event.*;

public class LingaguemDeProgramacao {
    private JPanel Painel;
    private JComboBox comboBoxLinguagem;
    private JButton botaoOk;
    private JCheckBox checkBox;

    public static void main(String[] args) {
        JFrame linguagem = new JFrame("IMC");
        linguagem.setContentPane(new LingaguemDeProgramacao().Painel);
        linguagem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        linguagem.pack();
        linguagem.setVisible(true);
    }

    public LingaguemDeProgramacao() {

        comboBoxLinguagem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        botaoOk.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });

        botaoOk.addActionListener( e -> {
            if(comboBoxLinguagem.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null , "Vai preencher o combobox maluco ");
                comboBoxLinguagem.requestFocus();
            }else if (!checkBox.isSelected()) {
                JOptionPane.showMessageDialog(null , "Vai preencher o check seu fiote de rapariga");
                checkBox.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null , "Olha o que tu escolheu " + comboBoxLinguagem.getSelectedItem());
            }

        });


        checkBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });


    }
}
