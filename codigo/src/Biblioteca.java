import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private ArrayList<ItemBibli> itens;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;

    public Biblioteca() {
        this.itens = new ArrayList<ItemBibli>();
        this.usuarios = new ArrayList<Usuario>();
        this.emprestimos = new ArrayList<Emprestimo>();
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
            if(itemComAut.getAutor().equals(autorPesq))
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

        Collections.sort(aux, Comparator.comparing(ItemBibli::getAutor));
        
        for(ItemBibli item : aux){
            System.out.println(item.toString());
        }
    }
    public void listarPorAno(){
        ArrayList<ItemBibli> aux;
        aux = this.getItens();

        Collections.sort(aux, Comparator.comparing(ItemBibli::getAno));
        
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
            System.out.print("\n");
        }
    }
//////////////////////////////////////////////////////

//Getters e adders
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void imprimirUsuarios() {
        for (Usuario user : usuarios) {
            System.out.println(user.getIdUsuario() + " - " + user.getNome());
        }
    }
    public void addUsuario(String nome){
        Usuario user = new Usuario(nome);
        this.usuarios.add(user);
    }

    public Usuario getUsuarioPorId(int id) {
        for(Usuario user : usuarios) {
            if(user.getIdUsuario() == id) {
                return user;
            }
        }
        return null;
    }

    public ItemBibli getItemPorId(int id) {
        for(ItemBibli item : itens) {
            if(item.getID() == id) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<ItemBibli> getItens() {
        return itens;
    }
    public void addItem(ItemBibli itemNovo){
        this.itens.add(itemNovo);
    }

    public void addEmpretimo(int idUsuario, int idItem, String dataEmprestimo){
        if(getUsuarioPorId(idUsuario))
        try {
            Emprestimo novEmprestimo = new Emprestimo(idUsuario, idItem, dataEmprestimo);
            this.emprestimos.add(novEmprestimo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    


    //relatorio
    public void relatorioItensEmprestimos() {
        ArrayList<ItemBibli> aux;
        aux = this.getItens();
        Collections.sort(aux, Comparator.comparing(ItemBibli::getAno));

        for(ItemBibli item : aux) {
            int itemId = item.getID();
            int vezesEmprestado = vezesItemEmprestado(itemId);
            System.out.println(item.getTitulo() + " foi emprestado" + vezesEmprestado + "vezes");
        }
    }

    public int vezesItemEmprestado(int id) {
        int i = 0;
        for(Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getItemId() == id) {
                i++;
            }
        }
        return i;
    }

    public void relatorioUsuariosEmprestimos() {
        ArrayList<Usuario> aux;
        aux = this.getUsuarios();
        Collections.sort(aux, Comparator.comparing(Usuario::getNome));

        for(Usuario user : aux) {
            ArrayList<Emprestimo> auxEmprestimos;
            auxEmprestimos = user.getEmprestimos();
            ArrayList<String> itensPorUsuario = new ArrayList<>();
            for(Emprestimo emprestimo : auxEmprestimos) {
                for(ItemBibli item : itens) {
                    if (item.getID() == emprestimo.getItemId()) {
                        itensPorUsuario.add(item.getTitulo());
                    }
                }
            }
            Collections.sort(itensPorUsuario);
            System.out.println(user.getNome() + " - ");
            for(String titulo : itensPorUsuario) {
                System.out.print(titulo + ", ");
            }
        }
    }
}
