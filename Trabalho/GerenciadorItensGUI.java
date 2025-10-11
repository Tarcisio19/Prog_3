import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;

public class GerenciadorItensGUI extends JFrame { //JFrame -> cria uma janela
    private GerenciadorItens gerenciador;
    private JTextField txtTitulo, txtDescricao;
    private JTextField txtAutor, txtNumeroPg, txtDiretor, txtDuracao;
    private JComboBox<String> cmbTipo;
    private JButton btnAdicionar, btnListar, btnExportar, btnImportar;
    private JTextField txtBusca;
    private JButton btnFiltrar;
    private JTextArea txtResultados;
    private JPanel painelEsquerdo, painelEntrada, painelTipo, painelCampos;
    private JPanel painelBotoes, painelBusca, painelArquivos, painelResultados;
    
    public GerenciadorItensGUI() {
        gerenciador = new GerenciadorItens();
        initComponents();
        setupLayout();
        setupEventHandlers();
        personalizarCores();
    }
    
    private void initComponents() {
        setTitle("Gerenciador de Itens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 700);
        setLocationRelativeTo(null);
        
        txtTitulo = new JTextField(20);
        txtDescricao = new JTextField(20);
        
        String[] tipos = {"Livro", "Filme"};
        cmbTipo = new JComboBox<>(tipos);
        
        txtAutor = new JTextField(15);
        txtNumeroPg = new JTextField(15);
        txtDiretor = new JTextField(15);
        txtDuracao = new JTextField(15);
        
        btnAdicionar = new JButton("Adicionar");
        btnListar = new JButton("Listar");
        btnExportar = new JButton("Exportar Dados");
        btnImportar = new JButton("Importar Dados");
        
        txtBusca = new JTextField(20);
        btnFiltrar = new JButton("Filtrar");
        
        txtResultados = new JTextArea(15, 50);
        txtResultados.setEditable(false);
        txtResultados.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        painelEsquerdo = new JPanel();
        painelEsquerdo.setLayout(new BoxLayout(painelEsquerdo, BoxLayout.Y_AXIS));
        painelEsquerdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        painelEntrada = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelEntrada.add(new JLabel("Título:"));
        painelEntrada.add(txtTitulo);
        painelEntrada.add(new JLabel("Descrição:"));
        painelEntrada.add(txtDescricao);
        
        painelTipo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelTipo.add(new JLabel("Tipo:"));
        painelTipo.add(cmbTipo);
        
        painelCampos = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelCampos.add(new JLabel("Autor:"));
        painelCampos.add(txtAutor);
        painelCampos.add(new JLabel("Nº Páginas:"));
        painelCampos.add(txtNumeroPg);
        painelCampos.add(new JLabel("Diretor:"));
        painelCampos.add(txtDiretor);
        painelCampos.add(new JLabel("Duração (min):"));
        painelCampos.add(txtDuracao);
        
        painelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelBotoes.add(btnAdicionar);
        painelBotoes.add(btnListar);
        
        painelBusca = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelBusca.add(new JLabel("Buscar por título:"));
        painelBusca.add(txtBusca);
        painelBusca.add(btnFiltrar);
        
        painelArquivos = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelArquivos.add(btnExportar);
        painelArquivos.add(btnImportar);
        
        painelEsquerdo.add(painelEntrada);
        painelEsquerdo.add(painelTipo);
        painelEsquerdo.add(painelCampos);
        painelEsquerdo.add(painelBotoes);
        painelEsquerdo.add(painelBusca);
        painelEsquerdo.add(painelArquivos);
        
        painelResultados = new JPanel(new BorderLayout());
        painelResultados.setBorder(new TitledBorder("Resultados"));
        painelResultados.add(txtResultados, BorderLayout.CENTER);
        
        add(painelEsquerdo, BorderLayout.WEST);
        add(painelResultados, BorderLayout.CENTER);
    }
    
    private void setupEventHandlers() {
        btnAdicionar.addActionListener(this::adicionarItem);
        btnListar.addActionListener(this::listarItens);
        btnFiltrar.addActionListener(this::filtrarItens);
        btnExportar.addActionListener(this::exportarDados);
        btnImportar.addActionListener(this::importarDados);
    }
    
    private void personalizarCores() {
        
        //Color corGeradaAluno = GeradorCorAluno.getCorGeradaAluno();
        
        setTitle("Gerenciador de Itens - Cor Personalizada");
        getContentPane().setBackground(Color.decode("#E164E7"));

        painelEsquerdo.setBackground(Color.decode("#E164E7"));
        painelEntrada.setBackground(Color.decode("#E164E7"));
        painelTipo.setBackground(Color.decode("#E164E7"));
        painelCampos.setBackground(Color.decode("#E164E7"));
        painelBotoes.setBackground(Color.decode("#E164E7"));
        painelBusca.setBackground(Color.decode("#E164E7"));
        painelArquivos.setBackground(Color.decode("#E164E7"));
        painelResultados.setBackground(Color.decode("#E164E7"));

        btnAdicionar.setBackground(Color.WHITE);
        btnAdicionar.setForeground(Color.BLACK);
        
        btnListar.setBackground(Color.WHITE);
        btnListar.setForeground(Color.BLACK);
        
        btnExportar.setBackground(Color.WHITE);
        btnExportar.setForeground(Color.BLACK);
        
        btnImportar.setBackground(Color.WHITE);
        btnImportar.setForeground(Color.BLACK);
        
        btnFiltrar.setBackground(Color.WHITE);
        btnFiltrar.setForeground(Color.BLACK);
    }
    
    private void adicionarItem(ActionEvent e) {
        try {
            String titulo = txtTitulo.getText().trim();
            String descricao = txtDescricao.getText().trim();
            String tipo = (String) cmbTipo.getSelectedItem();
            
            Item item = null;
            
            if ("Livro".equals(tipo)) {
                String autor = txtAutor.getText().trim();
                String numeroPgStr = txtNumeroPg.getText().trim();
                
                if (numeroPgStr.isEmpty()) {
                    throw new CampoVazioException("numeroPg");
                }
                
                int numeroPg = Integer.parseInt(numeroPgStr);
                item = new Livro(titulo, descricao, autor, numeroPg);
                
            } else if ("Filme".equals(tipo)) {
                String diretor = txtDiretor.getText().trim();
                String duracaoStr = txtDuracao.getText().trim();
                
                if (duracaoStr.isEmpty()) {
                    throw new CampoVazioException("duracao");
                }
                
                int duracao = Integer.parseInt(duracaoStr);
                item = new Filme(titulo, descricao, diretor, duracao);
            }
            
            if (item != null) {
                gerenciador.adicionarItem(item);
                limparCampos();
                txtResultados.setText("Item adicionado com sucesso!");
            }
            
        } catch (CampoVazioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void listarItens(ActionEvent e) {
        List<Item> itens = gerenciador.listarTodos();
        if (itens.isEmpty()) {
            txtResultados.setText("Nenhum item cadastrado.");
        } else {
            StringBuilder Listagem = new StringBuilder();
            Listagem.append("=== LISTA DE ITENS ===\n\n");
            for (int i = 0; i < itens.size(); i++) {
                Listagem.append("Item ").append(i + 1).append(":\n");
                Listagem.append(itens.get(i).exibirDetalhes()).append("\n");
            }

            Listagem.append("\n=== ESTATÍSTICAS ===\n");
            gerenciador.contarPorTipo().forEach((tipo, quantidade) ->
                Listagem.append(tipo).append(": ").append(quantidade).append("\n"));

            txtResultados.setText(Listagem.toString());
        }
    }
    
    private void filtrarItens(ActionEvent e) {
        try {
            String termoBusca = txtBusca.getText().trim();
            if (termoBusca.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Digite um termo para busca.", "Campo Vazio", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            List<Item> itensEncontrados = gerenciador.buscarPorTitulo(termoBusca);
            
            if (itensEncontrados.isEmpty()) {
                txtResultados.setText("Nenhum item encontrado com o título: " + termoBusca);
            } else {
                StringBuilder Listagem = new StringBuilder();
                Listagem.append("=== RESULTADOS DA BUSCA: \"").append(termoBusca).append("\" ===\n\n");
                for (int i = 0; i < itensEncontrados.size(); i++) {
                    Listagem.append("Resultado ").append(i + 1).append(":\n");
                    Listagem.append(itensEncontrados.get(i).exibirDetalhes()).append("\n");
                }
                txtResultados.setText(Listagem.toString());
            }
            
        } catch (CampoVazioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void exportarDados(ActionEvent e) {
        JFileChooser GerenciadorArquivos = new JFileChooser(); //Abre o gerenciador de arquivos
        GerenciadorArquivos.setDialogTitle("Salvar arquivo de dados");
        GerenciadorArquivos.setSelectedFile(new File("dados_itens.txt"));

        int result = GerenciadorArquivos.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                String caminho = GerenciadorArquivos.getSelectedFile().getAbsolutePath();
                gerenciador.exportarParaArquivo(caminho);
                txtResultados.setText("Dados exportados com sucesso para: " + caminho);
            } catch (Exception excecao) {
                JOptionPane.showMessageDialog(this, "Erro ao exportar dados: " + excecao.getMessage(),"Erro de Exportação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void importarDados(ActionEvent e) {
        JFileChooser GerenciadorArquivos = new JFileChooser(); //Abre o gerenciador de arquivos
        GerenciadorArquivos.setDialogTitle("Carregar arquivo de dados");

        int result = GerenciadorArquivos.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                String caminho = GerenciadorArquivos.getSelectedFile().getAbsolutePath();
                gerenciador.importarDeArquivo(caminho);
                txtResultados.setText("Dados importados com sucesso de: " + caminho);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao importar dados: " + ex.getMessage(), 
                    "Erro de Importação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void limparCampos() {
        txtTitulo.setText("");
        txtDescricao.setText("");
        txtAutor.setText("");
        txtNumeroPg.setText("");
        txtDiretor.setText("");
        txtDuracao.setText("");
        txtBusca.setText("");
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GerenciadorItensGUI().setVisible(true);
        });
    }
}