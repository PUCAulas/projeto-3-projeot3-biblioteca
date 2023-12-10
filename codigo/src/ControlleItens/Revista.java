package codigo.src.ControlleItens;

public class Revista extends ItemBibli {
    // Construtor que chama o construtor da classe mãe
    public Revista(String autor, String titulo, int ano, int exemplares, String genero) {
        super(autor, titulo, ano, exemplares, genero);
    }
}
