package codigo.src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Usuario {

    private int idUsuario;
    private static int proximoId = 1;
    private String nome, curso;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<String> interesses;

    public Usuario(String nome, String curso) {
        this.idUsuario = proximoId;
        proximoId++;
        this.nome = nome;
        this.curso = curso;
        this.emprestimos = new ArrayList<Emprestimo>();
        this.interesses = new ArrayList<String>();
    }

    public ArrayList<String> getInteresses() {
        return interesses;
    }

    public void addInteresse(String interesse) {
        interesses.add(interesse)
    }

    public void listarEmprestimos() {
        for (Emprestimo emprestimo : this.emprestimos)
            System.out.println("Id Item Emprestado: " + emprestimo.getItemId() + " Data Maxima De Devolucao: "
                    + emprestimo.getDataDevolucao()
                    + " Esta Emprestado: " + emprestimo.isEmprestado());
    }

    public void listarEmprestimosEmprestados() {
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.isEmprestado())
                System.out.println("Id Item Emprestado: " + emprestimo.getItemId() + " Data Maxima De Devolucao: "
                        + emprestimo.getDataDevolucao());
        }
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public ArrayList<String> getGenerosEmprestimos() {

    }
    
    public void addEmprestimos(Emprestimo novoEmprestimo) throws Exception {
        if (podeEmprestar()) {
            this.emprestimos.add(novoEmprestimo);
        } else {
            throw new Exception("Este usuario nao pode fazer emprestimos! Livro Atrasado ou Numero Total de Emprestimos por vez Atingido");
        }
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean temEmprestimoAtrasado() {
        Calendar dataAtual = Calendar.getInstance();
        Calendar dataMaxima = Calendar.getInstance();
        for (Emprestimo emprestimo : this.emprestimos) {
            String dataMaximaString = emprestimo.getDataDevolucao();
            try {
                dataMaxima.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataMaximaString));
                if (dataAtual.after(dataMaxima) && emprestimo.isEmprestado()) {
                    return true;
                }
            } catch (ParseException e) {
                return false;
            }
        }
        return false;
    }

    // public void imprimirItensEmprestados()
    public boolean podeEmprestar() {
        if (this.emprestimos.size() == 3 || temEmprestimoAtrasado()) {
            return false;
        }
        return true;
    }

}
