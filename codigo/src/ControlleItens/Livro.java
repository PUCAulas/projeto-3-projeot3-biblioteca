package codigo.src.ControlleItens;

public class Livro extends ItemBibli implements ItemEmprestavel {
    private int exemplaresDisponiveis;

    // Construtor que chama o construtor da classe mãe
    public Livro(String autor, String titulo, int ano, int exemplares) {
        super(autor, titulo, ano, exemplares);
        this.exemplaresDisponiveis = exemplares;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    @Override
    public void emprestar() throws Exception {
        if (this.getExemplaresDisponiveis() < 2) {
            throw new Exception("Nao ha exemplares suficientes para pegar emprestado!");
        } else {
            this.exemplaresDisponiveis--;
        }
    }

    @Override
    public void devolver() {
        this.exemplaresDisponiveis++;
    }

}
