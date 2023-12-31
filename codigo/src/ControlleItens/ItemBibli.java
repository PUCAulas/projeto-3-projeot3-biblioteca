package codigo.src.ControlleItens;

import java.util.List;

import codigo.src.Emprestimo;

public abstract class ItemBibli {

    // atributos
    private String autor, titulo, genero;
    private int id, ano, exemplares;
    private static int proximoId = 1;
    private List<Emprestimo> emprestimo;


    // construtor
    public ItemBibli(String autor, String titulo, int ano, int exemplares, String genero) {
        this.autor = autor;
        this.titulo = titulo;
        this.id = proximoId;
        proximoId++;
        this.ano = ano;
        this.exemplares = exemplares;
        this.genero = genero;
    }

    // Isso nao deveria ser papel da interface de imprestavel?
    // o item nao tem varios exemplares?
    public boolean isEmprestado() {
        for (Emprestimo emprestimo : emprestimo) {
            if (emprestimo.isEmprestado()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", titulo: " + titulo + ", autor: " + autor + ", Ano: " + ano;
    }

    // métodos getters e setters
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getID() {
        return id;
    }
    
    public void setID(int iD) {
        id = iD;
    }
    
    public int getAno() {
        return ano;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Emprestimo> getlistaEmprestimos() {
        return this.emprestimo;
    }

    public int getExemplares() {
        return this.exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    public void adicionaEmprestimo(Emprestimo nEmprestimo) {
        emprestimo.add(nEmprestimo);
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }

}
