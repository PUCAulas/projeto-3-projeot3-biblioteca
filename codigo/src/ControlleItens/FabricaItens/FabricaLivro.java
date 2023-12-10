package codigo.src.ControlleItens.FabricaItens;

import codigo.src.ControlleItens.ItemBibli;
import codigo.src.ControlleItens.Livro;

public class FabricaLivro extends Criador{

    @Override
    public ItemBibli criarItemBibli(String autor, String titulo, int ano, int exemplares) {
        return new Livro(autor, titulo, ano, exemplares);
    }
    
}
