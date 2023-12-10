package codigo.src.ControlleItens.FabricaItens;

import codigo.src.ControlleItens.ItemBibli;
import codigo.src.ControlleItens.Revista;

public class FabricaRevista extends Criador{

    @Override
    public ItemBibli criarItemBibli(String autor, String titulo, int ano, int exemplares, String genero) {
        return new Revista(autor, titulo, ano, exemplares, genero);
    }
    
}
