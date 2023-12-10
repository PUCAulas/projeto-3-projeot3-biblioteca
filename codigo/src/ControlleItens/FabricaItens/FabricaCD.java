package codigo.src.ControlleItens.FabricaItens;

import codigo.src.ControlleItens.CD;
import codigo.src.ControlleItens.ItemBibli;

public class FabricaCD extends Criador {

    @Override
    public ItemBibli criarItemBibli(String autor, String titulo, int ano, int exemplares, String genero) {
        return new CD(autor, titulo, ano, exemplares , genero);
    }
    
}
