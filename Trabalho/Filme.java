public class Filme extends Item {
    private String Diretor;
    private int DuracaoMin;

    public Filme() {
        super();
    }

    public Filme(String titulo, String descricao, String diretor, int duracaoMin) throws CampoVazioException {
        super(titulo, descricao);
        setDiretor(diretor);
        setDuracaoMin(duracaoMin);
    }

    void setDiretor(String diretor) throws CampoVazioException {
        if(diretor.trim().isEmpty()) {
            throw new CampoVazioException("diretor");
        }
        Diretor = diretor;
    }

    void setDuracaoMin(int duracaoMin) throws CampoVazioException {
        if(duracaoMin <= 0) {
            throw new CampoVazioException("duracaoMin");
        }
        DuracaoMin = duracaoMin;
    }
    String getDiretor(){
        return Diretor;
    }
    int getDuracaoMin(){
        return DuracaoMin;
    }
    @Override
    public String exibirDetalhes() {
        return "Titulo: " + getTitulo() + "\n" + 
        "Descricao: " + getDescricao() + "\n" + 
        "Data do cadastro: " + getData().toString() + "\n" + 
        "Diretor: " + Diretor + "\n" + 
        "Duracao (min): " + DuracaoMin + "\n";
    }

    @Override
    public String exportarParaLinha() {
        return "Filme|" + getTitulo() + "|" + getDescricao() + "|" + getData().toString() + "|" + Diretor + "|" + DuracaoMin;
    }
}
