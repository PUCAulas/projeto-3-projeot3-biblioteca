package codigo.src.ControlleItens.FabricaItens;

import codigo.src.ControlleItens.ItemBibli;

public abstract class Criador{
    public abstract ItemBibli criarItemBibli(String autor, String titulo, int ano, int exemplares);
}