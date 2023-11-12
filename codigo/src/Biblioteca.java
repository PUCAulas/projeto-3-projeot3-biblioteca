import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private ArrayList<ItemBibli> itens;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        this.itens = new ArrayList<ItemBibli>();
        this.usuarios = new ArrayList<Usuario>();
    }
    //Pesquisas 
    // Eu segui o enunciado, entao vc pesquisa por um nome, titulo, autor ou tipo
    // e todos os itens encontrados com o parametro pesquisado sao listados em ordem alfabetica por titulo
    // foi isso que eu entendi no requsito C
    public void pesquisarPorTitulo(String tituloPesq){
        ArrayList<ItemBibli> aux = new ArrayList<>();

        for(ItemBibli itemComTit : this.getItens()){
            if(itemComTit.getTitulo().equals(tituloPesq))
                aux.add(itemComTit);
        }
        
        listarAlfaTitulo(aux);
    }
    public void pesquisarPorAutor(String autorPesq){
        ArrayList<ItemBibli> aux = new ArrayList<>();

        for(ItemBibli itemComAut : this.getItens()){
            if(itemComAut.getTitulo().equals(autorPesq))
                aux.add(itemComAut);
        }
        listarAlfaTitulo(aux);
    }
    public void pesquisarPorAno(int anoPesq){
        ArrayList<ItemBibli> aux = new ArrayList<>();

        for(ItemBibli itemComAno : this.getItens()){
            if(itemComAno.getAno() == anoPesq)
                aux.add(itemComAno);
        }
        listarAlfaTitulo(aux);
    }
    public void pesquisarPorTipo(String tipoPesq){
        ArrayList<ItemBibli> aux = new ArrayList<>();

        for(ItemBibli itemComTipo : this.getItens()){
            if(itemComTipo.getClass().getName().equals(tipoPesq))
                aux.add(itemComTipo);
        }
        listarAlfaTitulo(aux);
    }

    //Funcoes para listar
    //Essa funcao lista so um conjunto passado, por titulo
    public void listarAlfaTitulo(ArrayList<ItemBibli> itensX){
        Collections.sort(itensX, Comparator.comparing(ItemBibli::getTitulo));
        for(ItemBibli item : itensX){
            System.out.println(item.toString());
        }
    }

    //As funcoes a seguir listam todos os itens da biblioteca organizados em ordem alfanumerica para cada atributo
    //nao sei se é necessario
    public void listarPorTitulo(){
        ArrayList<ItemBibli> aux;
        aux = this.getItens();

        Collections.sort(aux, Comparator.comparing(ItemBibli::getTitulo));
        
        for(ItemBibli item : aux){
            System.out.println(item.toString());
        }
    }
    public void listarPorAutor(){
        ArrayList<ItemBibli> aux;
        aux = this.getItens();

        Collections.sort(aux, Comparator.comparing(ItemBibli::getTitulo));
        
        for(ItemBibli item : aux){
            System.out.println(item.toString());
        }
    }
    public void listarPorAno(){
        ArrayList<ItemBibli> aux;
        aux = this.getItens();

        Collections.sort(aux, Comparator.comparing(ItemBibli::getTitulo));
        
        for(ItemBibli item : aux){
            System.out.println(item.toString());
        }
    }
    public void listarPorTipo(){
        Map<String, ArrayList<ItemBibli>> itensPorClasse = new HashMap<>();

        for (ItemBibli item : itens) {
            String nomeClasse = item.getClass().getSimpleName();
            if (!itensPorClasse.containsKey(nomeClasse)) {
                itensPorClasse.put(nomeClasse, new ArrayList<>());
            }
            itensPorClasse.get(nomeClasse).add(item);
        }

        for (Map.Entry<String, ArrayList<ItemBibli>> entry : itensPorClasse.entrySet()) {
            String nomeClasse = entry.getKey();
            System.out.println(nomeClasse+"s");
            for (ItemBibli item : entry.getValue()) {
                System.out.println(item.toString());
            }
            System.out.println("\n");
        }
    }
//////////////////////////////////////////////////////

//Getters e adders
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public void addUsuario(Usuario usuarioNovo){
        this.usuarios.add(usuarioNovo);
    }

    public ArrayList<ItemBibli> getItens() {
        return itens;
    }
    public void addItem(ItemBibli itemNovo){
        this.itens.add(itemNovo);
    }
}
