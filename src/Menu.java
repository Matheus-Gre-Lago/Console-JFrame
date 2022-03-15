import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menu extends JFrame implements ActionListener {

    JTextArea output;
    JScrollPane scrollPane;

    public JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();


        JMenu menu = new JMenu("Formularios");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);

        JMenuItem menuItem;

        menuItem = new JMenuItem("Calculadora IMC" , KeyEvent.VK_C);
        menuItem.setActionCommand("menuIMC");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C , ActionEvent.SHIFT_MASK));
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Dias De Vida" , KeyEvent.VK_D);
        menuItem.setActionCommand("menuDiasVida");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        menuItem = new JMenuItem("Pesquisa" , KeyEvent.VK_P);
        menuItem.setActionCommand("menuPesquisa");
        menuItem.addActionListener(this);
        menu.add(menuItem);

        return  menuBar;
    }

    public Container createContentPane(){
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(true);

        output = new JTextArea(5 , 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        contentPanel.add(scrollPane , BorderLayout.CENTER);

        return contentPanel;
    }

    private static void createAndShowGui(){
        JFrame janela = new JFrame("Menu Principal");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Menu menu =  new Menu();
        janela.setJMenuBar(menu.createMenuBar());
        janela.setContentPane(menu.createContentPane());
        janela.setSize(450, 260);
        janela.setVisible(true);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGui();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("menuIMC".equals(e.getActionCommand())){
            IMC imc = new IMC();
            imc.setContentPane(new IMC().painel);
            imc.setSize(300 , 200);
            imc.setVisible(true);
            imc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        if("menuDiasVida".equals(e.getActionCommand())){
            Data data = new Data();
        }
    }
}
