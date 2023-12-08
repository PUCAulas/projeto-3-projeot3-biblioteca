package codigo.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private static Biblioteca instance;
    private ArrayList<ItemBibli> itens;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;

    //Singleton
    private Biblioteca() {
        this.itens = new ArrayList<ItemBibli>();
        this.usuarios = new ArrayList<Usuario>();
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public static Biblioteca getInstance(){
        if (instance == null) {
            instance = new Biblioteca();
        }
        return instance;
    }
    //
    
    // Pesquisas

    public void pesquisarPorTitulo(String tituloPesq) {
        ArrayList<ItemBibli> aux = new ArrayList<>();

        for (ItemBibli itemComTit : this.getItens()) {
            if (itemComTit.getTitulo().equals(tituloPesq))
                aux.add(itemComTit);
        }

        listarAlfaTitulo(aux);
    }

    public void pesquisarPorAutor(String autorPesq) {
        ArrayList<ItemBibli> aux = new ArrayList<>();

        for (ItemBibli itemComAut : this.getItens()) {
            if (itemComAut.getAutor().equals(autorPesq))
                aux.add(itemComAut);
        }
        listarAlfaTitulo(aux);
    }

    public void pesquisarPorAno(int anoPesq) {
        ArrayList<ItemBibli> aux = new ArrayList<>();

        for (ItemBibli itemComAno : this.getItens()) {
            if (itemComAno.getAno() == anoPesq)
                aux.add(itemComAno);
        }
        listarAlfaTitulo(aux);
    }

    public void pesquisarPorTipo(String tipoPesq) {
        ArrayList<ItemBibli> aux = new ArrayList<>();

        for (ItemBibli itemComTipo : this.getItens()) {
            if (itemComTipo.getClass().getName().equals(tipoPesq))
                aux.add(itemComTipo);
        }
        listarAlfaTitulo(aux);
    }

    // Funcoes para listar
    // Essa funcao lista so um conjunto passado, por titulo
    public void listarAlfaTitulo(ArrayList<ItemBibli> itensX) {
        Collections.sort(itensX, Comparator.comparing(ItemBibli::getTitulo));
        for (ItemBibli item : itensX) {
            System.out.println(item.toString());
        }
    }

    // As funcoes a seguir listam todos os itens da biblioteca organizados em ordem
    // alfanumerica para cada atributo
    // nao sei se é necessario
    public void listarItens() {
        for (ItemBibli item : this.itens) {
            System.out.println(item.toString());
        }
    }

    public void listarEmprestaveis() {
        for (ItemBibli item : this.itens) {
            if (item instanceof ItemEmprestavel) {
                System.out.println(item.toString());
            }
        }
    }

    public void listarPorTitulo() {
        ArrayList<ItemBibli> aux;
        aux = this.getItens();

        Collections.sort(aux, Comparator.comparing(ItemBibli::getTitulo));

        for (ItemBibli item : aux) {
            System.out.println(item.toString());
        }
    }

    public void listarPorAutor() {
        ArrayList<ItemBibli> aux;
        aux = this.getItens();

        Collections.sort(aux, Comparator.comparing(ItemBibli::getAutor));

        for (ItemBibli item : aux) {
            System.out.println(item.toString());
        }
    }

    public void listarPorAno() {
        ArrayList<ItemBibli> aux;
        aux = this.getItens();

        Collections.sort(aux, Comparator.comparing(ItemBibli::getAno));

        for (ItemBibli item : aux) {
            System.out.println(item.toString());
        }
    }

    public void listarPorTipo() {
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
            System.out.println(nomeClasse + "s");
            for (ItemBibli item : entry.getValue()) {
                System.out.println(item.toString());
            }
            System.out.print("\n");
        }
    }
    //////////////////////////////////////////////////////

    // listar emprestimos
    public void listarEmprestimos() {
        for (Emprestimo emprestimo : this.emprestimos) {
            System.out.println("Id Usuario do Emprestimo: " + emprestimo.getIdUser() + "Id Item do Emprestimo: "
                    + emprestimo.getItemId());
        }
    }

    public void listarEmprestimosUsuario(int idUsuario) {
        Usuario usuario = getUsuarioPorId(idUsuario);
        usuario.listarEmprestimos();
    }

    public void listarEmprestimosUsuarioEmprestado(int idUsuario) {
        Usuario usuario = getUsuarioPorId(idUsuario);
        usuario.listarEmprestimosEmprestados();
    }

    ///////////////// q
    // Getters e adders
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void imprimirUsuarios() {
        for (Usuario user : usuarios) {
            System.out.println(user.getIdUsuario() + " - " + user.getNome());
        }
    }

    public void addUsuario(String nome) {
        Usuario user = new Usuario(nome);
        this.usuarios.add(user);
    }

    public Usuario getUsuarioPorId(int id) {
        for (Usuario user : usuarios) {
            if (user.getIdUsuario() == id) {
                return user;
            }
        }
        return null;
    }

    public ItemBibli getItemPorId(int id) {
        for (ItemBibli item : itens) {
            if (item.getID() == id) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<ItemBibli> getItens() {
        return itens;
    }

    public void addItem(ItemBibli itemNovo) {
        this.itens.add(itemNovo);
    }

    public void addEmpretimo(int idUsuario, int idItem, String dataEmprestimo) {
        try {

            Emprestimo novEmprestimo = new Emprestimo(idUsuario, idItem, dataEmprestimo);
            getUsuarioPorId(idUsuario).addEmprestimos(novEmprestimo);
            ItemBibli itemEmprestimo = getItemPorId(idItem);
            if (itemEmprestimo instanceof ItemEmprestavel) {
                ((ItemEmprestavel) itemEmprestimo).emprestar();
                this.emprestimos.add(novEmprestimo);
                System.out.println("Item emprestado com sucesso!");
            } else {
                System.out.println("Nao foi possivel emprestar esse item!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Emprestimo getEmprestimoPorId(int idUsuario, int idItem) {
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.getIdUser() == idUsuario && emprestimo.getItemId() == idItem) {
                return emprestimo;
            }
        }
        return null;
    }

    //
    public void devolverItem(int idUsuario, int idItem) {
        ItemBibli itemEmprestimo = getItemPorId(idItem);
        if (itemEmprestimo instanceof ItemEmprestavel)
            ((ItemEmprestavel) itemEmprestimo).devolver();
        getEmprestimoPorId(idUsuario, idItem).devolver();
    }

    // relatorio
    public void relatorioItensEmprestimos() {
        ArrayList<ItemBibli> aux;
        aux = this.getItens();
        Collections.sort(aux, Comparator.comparing(ItemBibli::getAno));

        for (ItemBibli item : aux) {
            int itemId = item.getID();
            int vezesEmprestado = vezesItemEmprestado(itemId);
            System.out.println(
                    item.getTitulo() + " de " + item.getAno() + " foi emprestado " + vezesEmprestado + " vezes");
        }
    }

    public int vezesItemEmprestado(int id) {
        int i = 0;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getItemId() == id) {
                i++;
            }
        }
        return i;
    }

    public void relatorioUsuariosEmprestimos() {
        ArrayList<Usuario> aux;
        aux = this.getUsuarios();
        Collections.sort(aux, Comparator.comparing(Usuario::getNome));

        for (Usuario user : aux) {
            ArrayList<Emprestimo> auxEmprestimos;
            auxEmprestimos = user.getEmprestimos();
            ArrayList<String> itensPorUsuario = new ArrayList<>();
            for (Emprestimo emprestimo : auxEmprestimos) {
                for (ItemBibli item : itens) {
                    if (item.getID() == emprestimo.getItemId()) {
                        itensPorUsuario.add(item.getTitulo());
                    }
                }
            }
            Collections.sort(itensPorUsuario);
            System.out.print("\n" + user.getNome() + " - ");
            for (String titulo : itensPorUsuario) {
                System.out.print(titulo + ", ");
            }
        }
    }
}
