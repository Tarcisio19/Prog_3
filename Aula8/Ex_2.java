import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex_2 extends JFrame {
    
    private JTextField campoNome;
    private JPasswordField campoSenha;
    
    public Ex_2() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));
        
        JLabel labelNome = new JLabel("Nome de usuário:");
        campoNome = new JTextField();
        
        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField();
        
        JButton botaoEntrar = new JButton("Entrar");
        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                JOptionPane.showMessageDialog(Ex_2.this, "Bem-vindo, " + nome + "!");
            }
        });
        
        add(labelNome);
        add(campoNome);
        add(labelSenha);
        add(campoSenha);
        add(new JLabel());
        add(botaoEntrar);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ex_2().setVisible(true);
            }
        });
    }
}