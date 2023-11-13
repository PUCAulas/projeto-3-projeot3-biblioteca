import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public void listarEmprestimos(){
        for(Emprestimo emprestimo : this.emprestimos)
            System.out.println("Id Item Emrpestado: "+emprestimo.getItemId() + " Data Maxima De Devolucao: " + emprestimo.getDataDevolucao()
            + " Esta Emprestado: "+ emprestimo.isEmprestado());
    }
    public void listarEmprestimosEmprestados(){
        for(Emprestimo emprestimo : this.emprestimos){
            if(emprestimo.isEmprestado())
            System.out.println("Id Item Emrpestado: "+emprestimo.getItemId() + " Data Maxima De Devolucao: " + emprestimo.getDataDevolucao());
        }
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void addEmprestimos(Emprestimo novoEmprestimo) throws Exception {
        if(podeEmprestar()){
            this.emprestimos.add(novoEmprestimo);
        }
        else{
            throw new Exception("Este usuario nao pode fazer emprestimos!");
        }
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
        Calendar dataAtual = Calendar.getInstance();
        Calendar dataMaxima = Calendar.getInstance();
        for(Emprestimo emprestimo : this.emprestimos){
            String dataMaximaString = emprestimo.getDataDevolucao();
            try {
                dataMaxima.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataMaximaString));
                if(dataAtual.after(dataMaxima) && emprestimo.isEmprestado()){
                    return true;
                }
            } catch (ParseException e) {
                return false;
            }
        }
        return false;
    }

    //public void imprimirItensEmprestados()
    public boolean podeEmprestar(){
        if(this.emprestimos.size() == 3 || temEmprestimoAtrasado()){
            return false;
        }
        return true;
    }
    
    
}
