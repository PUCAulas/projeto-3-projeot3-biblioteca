package codigo.src.ControlleItens;

public class CD extends ItemBibli implements ItemEmprestavel {
    private int exemplaresDisponiveis;

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    // Construtor que chama o construtor da classe mãe
    public CD(String autor, String titulo, int ano, int exemplares, String genero) {
        super(autor, titulo, ano, exemplares, genero);
        this.exemplaresDisponiveis = exemplares;
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
