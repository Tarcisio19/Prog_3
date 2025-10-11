import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.time.LocalDate;

public class GerenciadorItens {
    private List<Item> ListaItens = new ArrayList<>();

    public void adicionarItem(Item item) throws CampoVazioException {
        if (item == null) {
            throw new CampoVazioException("item");
        }
        ListaItens.add(item);
    }

    List<Item> listarTodos() { //Retorna a referencia da lista de itens 
        return ListaItens;
    }

    List<Item> buscarPorTitulo(String titulo) throws CampoVazioException {
        if (titulo.trim().isEmpty()) {
            throw new CampoVazioException("titulo");
        }
        return ListaItens.stream()
                .filter(item -> item.getTitulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toList());
    }

    Map<String, Long> contarPorTipo() {
        return ListaItens.stream()
                .collect(Collectors.groupingBy(item -> item.getClass().getSimpleName(), Collectors.counting()));
    }

    List<Item> listarOrdenado() {
        return ListaItens.stream()
            .sorted((i1, i2) -> i1.getTitulo().compareToIgnoreCase(i2.getTitulo()))
            .collect(Collectors.toList());
    }

    void exportarParaArquivo(String caminho) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (Item item : ListaItens) {
                writer.write(item.exportarParaLinha());
                writer.newLine();
            }
        }
    }

    void importarDeArquivo(String caminho) throws IOException, CampoVazioException {
        ListaItens.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length >= 6) {
                    String tipo = partes[0];
                    String titulo = partes[1];
                    String descricao = partes[2];
                    LocalDate data = LocalDate.parse(partes[3]);
                    
                    if ("Livro".equals(tipo)) {
                        String autor = partes[4];
                        int numeroPg = Integer.parseInt(partes[5]);
                        Livro livro = new Livro(titulo, descricao, autor, numeroPg);
                        livro.setData(data);
                        ListaItens.add(livro);
                    } else if ("Filme".equals(tipo)) {
                        String diretor = partes[4];
                        int duracao = Integer.parseInt(partes[5]);
                        Filme filme = new Filme(titulo, descricao, diretor, duracao);
                        filme.setData(data);
                        ListaItens.add(filme);
                    }
                }
            }
        }
    }
}
