public class Livro extends Item {
    private String Autor;
    private int NumeroPg;

    public Livro() {
        super();
    }

    public Livro(String titulo, String descricao, String autor, int numeroPg) throws CampoVazioException {
        super(titulo, descricao);
        setAutor(autor);
        setNumeroPg(numeroPg);
    }

    void setAutor(String autor) throws CampoVazioException {
        if(autor.trim().isEmpty()) {
            throw new CampoVazioException("autor");
        }
        Autor = autor;
    }

    void setNumeroPg(int numeroPg) throws CampoVazioException {
        if(numeroPg <= 0) {
            throw new CampoVazioException("numeroPg");
        }
        NumeroPg = numeroPg;
    }

            String getAutor(){
                return Autor;
            }

            int getNumeroPg(){
                return NumeroPg;
            }

    @Override
    public String exibirDetalhes() {
        return "Titulo: " + getTitulo() + "\n" + 
        "Descricao: " + getDescricao() + "\n" + 
        "Data do cadastro: " + getData().toString() + "\n" + 
        "Autor: " + Autor + "\n" + 
        "Numero de páginas: " + NumeroPg + "\n";
    }

    @Override
    public String exportarParaLinha() {
        return "Livro|" + getTitulo() + "|" + getDescricao() + "|" + getData().toString() + "|" + Autor + "|" + NumeroPg;
    }
}
