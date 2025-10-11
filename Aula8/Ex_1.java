import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex_1 extends JFrame {
    
    public Ex_1() {
        setTitle("Janela Personalizada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        
        JLabel mensagem = new JLabel("Hello! :>");
        mensagem.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton botaoFechar = new JButton("Fechar");
        botaoFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        setLayout(new java.awt.BorderLayout());
        add(mensagem, java.awt.BorderLayout.CENTER);
        add(botaoFechar, java.awt.BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ex_1().setVisible(true);
            }
        });
    }
}