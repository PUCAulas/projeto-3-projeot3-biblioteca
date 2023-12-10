package codigo.src.ControlleItens.FabricaItens;

import codigo.src.ControlleItens.DVD;
import codigo.src.ControlleItens.ItemBibli;

public class FabricaDVD extends Criador{

    @Override
    public ItemBibli criarItemBibli(String autor, String titulo, int ano, int exemplares, String genero) {
        return new DVD(autor, titulo, ano, exemplares, genero);
    }
    
}
