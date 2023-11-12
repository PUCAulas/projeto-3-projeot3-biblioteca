import java.util.ArrayList;
import java.util.Calendar;
public class Usuario {

    private int idUsuario;
    private static int proximoId = 1;
    private String nome;
    private ArrayList<Emprestimo> emprestimos;


    public Usuario(String nome) {
        this.idUsuario = proximoId;
        proximoId++;
        this.nome = nome;
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
    public boolean temEmprestimoAtrasado(){
        Calendar calendario = Calendar.getInstance();
        for(Emprestimo emprestimo : this.emprestimos){
            String dataMaxima = emprestimo.getDataDevolucao();
            
            if()
        }
    }

    //public void imprimirItensEmprestados()
    public boolean podeEmprestar(){
        if(this.emprestimos.size() == 3 || !this.itensAtrasados.isEmpty()){
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

    
}
