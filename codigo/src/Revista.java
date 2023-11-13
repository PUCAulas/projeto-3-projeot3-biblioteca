package codigo.src;

public class Revista extends ItemBibli {
    // Construtor que chama o construtor da classe mãe
    public Revista(String autor, String titulo, int ano, int exemplares) {
        super(autor, titulo, ano, exemplares);
    }
}
