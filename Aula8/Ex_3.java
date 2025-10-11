import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex_3 extends JFrame {
    
    private JTextField campo1;
    private JTextField campo2;
    private JComboBox<String> operacao;
    private JCheckBox mostrarEmJane;
    
    public Ex_3() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 5, 5));
        
        JLabel label1 = new JLabel("Primeiro número:");
        campo1 = new JTextField();
        
        JLabel label2 = new JLabel("Segundo número:");
        campo2 = new JTextField();
        
        JLabel labelOp = new JLabel("Operação:");
        operacao = new JComboBox<>(new String[]{"Somar", "Subtrair", "Multiplicar", "Dividir"});
        
        mostrarEmJane = new JCheckBox("Mostrar resultado em JOptionPane");
        
        JButton botaoCalcular = new JButton("Calcular");
        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });
        
        add(label1);
        add(campo1);
        add(label2);
        add(campo2);
        add(labelOp);
        add(operacao);
        add(mostrarEmJane);
        add(new JLabel());
        add(new JLabel());
        add(botaoCalcular);
    }
    
    private void calcular() {
        try {
            double num1 = Double.parseDouble(campo1.getText());
            double num2 = Double.parseDouble(campo2.getText());
            double resultado = 0;
            String op = (String) operacao.getSelectedItem();
            
            switch (op) {
                case "Somar":
                    resultado = num1 + num2;
                    break;
                case "Subtrair":
                    resultado = num1 - num2;
                    break;
                case "Multiplicar":
                    resultado = num1 * num2;
                    break;
                case "Dividir":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Erro: Divisão por zero!");
                        return;
                    }
                    break;
            }
            
            String mensagem = "Resultado: " + resultado;
            
            if (mostrarEmJane.isSelected()) {
                JOptionPane.showMessageDialog(this, mensagem);
            } else {
                System.out.println(mensagem);
            }
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro: Por favor, insira números válidos!");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ex_3().setVisible(true);
            }
        });
    }
}