import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Enumeration;

public class FormasDePagamento {
    private JPanel Painel;
    private JRadioButton radioButtonDinheiro;
    private JRadioButton radioButtonCartaoDebito;
    private JRadioButton radioButtonCartaoDeCredito;
    private JRadioButton radioButtonPix;
    private JButton buttonMostrar;
    private JButton buttonLimpar;
    private ButtonGroup grupoDeBotoes;


    public static void main(String[] args) {
        JFrame estadoCivil = new JFrame("FormasDePagamento");
        estadoCivil.setContentPane(new FormasDePagamento().Painel);
        estadoCivil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        estadoCivil.pack();
        estadoCivil.setVisible(true);
    }

    public FormasDePagamento() {
        KeyAdapter listener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        };
        radioButtonDinheiro.addKeyListener(listener);
        radioButtonCartaoDebito.addKeyListener(listener);
        radioButtonCartaoDeCredito.addKeyListener(listener);
        radioButtonPix.addKeyListener(listener);


        buttonMostrar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });

        buttonMostrar.addActionListener(e -> {
            for(Enumeration<AbstractButton> botao = grupoDeBotoes.getElements(); botao.hasMoreElements();){
                AbstractButton recebeBotao = botao.nextElement();
                if(recebeBotao.isSelected()){
                    JOptionPane.showMessageDialog(null , "Forma de pagamento " + recebeBotao.getText());
                    break;
                }
            }
        });


        buttonLimpar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });

        buttonLimpar.addActionListener(e -> {
            grupoDeBotoes.clearSelection();
            Painel.requestFocus();
        });
    }
}
