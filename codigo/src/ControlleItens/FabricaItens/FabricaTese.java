package codigo.src.ControlleItens.FabricaItens;

import codigo.src.ControlleItens.ItemBibli;
import codigo.src.ControlleItens.Tese;

public class FabricaTese extends Criador{

    @Override
    public ItemBibli criarItemBibli(String autor, String titulo, int ano, int exemplares) {
        return new Tese(autor, titulo, ano, exemplares);
    }
    
}
