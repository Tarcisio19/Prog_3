import java.time.LocalDate;
import java.io.Serializable;

public abstract class Item implements Serializable, Exportavel {
    
    private String Titulo;
        private String Descricao;
        private LocalDate dataCadastro;

        Item(){
            Titulo = "";
            Descricao = "";
            dataCadastro = LocalDate.now();
        }

        Item(String titulo, String descricao) throws CampoVazioException {
            if(titulo.trim().isEmpty()) {
                throw new CampoVazioException("titulo");
            }
            if(descricao.trim().isEmpty()) {
                throw new CampoVazioException("descricao");
            }
            this.Titulo = titulo;
            this.Descricao = descricao;
            this.dataCadastro = LocalDate.now();
        }

        String getTitulo(){
            return Titulo;
        }

        String getDescricao(){
            return Descricao;
        }

        LocalDate getData(){
            return dataCadastro;
        }

        void setTitulo(String titulo) throws CampoVazioException {
            if(titulo.trim().isEmpty()) {
                throw new CampoVazioException("titulo");
            }
            Titulo = titulo;
        }

        void setDescricao(String descricao) throws CampoVazioException {
            if(descricao.trim().isEmpty()) {
                throw new CampoVazioException("descricao");
            }
            Descricao = descricao;
        }

        void setData(LocalDate dataCadastro){
            this.dataCadastro = dataCadastro;
        }

        public abstract String exibirDetalhes();

    }

