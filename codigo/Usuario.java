import java.util.ArrayList;
public class Usuario {

    private int idUsuario;
    private static int proximoId = 1;
    private String nome;
    private ArrayList<ItemBibli> itensEmprestados;
    private ArrayList<ItemBibli> itensAtrasados;
    private ArrayList<Emprestimo> emprestimos;


    public Usuario(String nome) {
        this.idUsuario = proximoId;
        proximoId++;
        this.nome = nome;
        this.itensEmprestados = new ArrayList<ItemBibli>();
        this.itensAtrasados = new ArrayList<ItemBibli>();
        this.emprestimos = new ArrayList<Emprestimo>();
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void addEmprestimos(Emprestimo novoEmprestimo) {
        this.emprestimos.add(novoEmprestimo);
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public ArrayList<ItemBibli> getItensEmprestados() {
        return itensEmprestados;
    }

    public boolean podeEmprestar(){
        if(this.itensEmprestados.size() == 3 || !this.itensAtrasados.isEmpty()){
            return false;
        }
        return true;
    }
    public void pegarItemEmprestado(ItemBibli itemEmprestado) throws Exception {
        if(podeEmprestar() == false){
            throw new Exception("Este usuario nao pode pegar livros emprestados!");
        }
        else{//criar novo emprestimo FALTANDO
        this.itensEmprestados.add(itemEmprestado);
        }
    }

    public ArrayList<ItemBibli> getItensAtrasados() {
        return itensAtrasados;
    }
    public void setItensAtrasados(ItemBibli itemAtrasado) {
        this.itensAtrasados.add(itemAtrasado);
    }
    
}
