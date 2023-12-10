package codigo.src;

import codigo.src.Biblioteca;
import codigo.src.ControlleItens.Livro;

public class App {
    public static void main(String[] args) {
        Biblioteca bib = Biblioteca.getInstance();

        // Adicionando usuários e itens para teste
        bib.addUsuario("Ana");
        bib.addUsuario("Bruno");

        bib.addItem(new Livro("Autor1", "Livro1", 2020, 1));
        bib.addItem(new Livro("Autor2", "Livro2", 2021, 1));

        // Tentativa de emprestar o mesmo livro duas vezes
        System.out.println("Tentando emprestar Livro1 para Ana...");
        bib.addEmpretimo(1, 1, "10/12/2023"); // Ana tenta pegar Livro1

        System.out.println("Tentando emprestar Livro1 para Bruno...");
        bib.addEmpretimo(2, 1, "10/12/2023"); // Bruno tenta pegar Livro1

        // Verifica o status dos empréstimos
        bib.listarEmprestimos();

        // Devolvendo o Livro1
        System.out.println("Devolvendo Livro1 emprestado por Ana...");
        bib.devolverItem(1, 1);

        // Tentativa de emprestar o Livro1 novamente após a devolução
        System.out.println("Tentando emprestar Livro1 para Bruno novamente...");
        bib.addEmpretimo(2, 1, "11/12/2023"); // Bruno tenta pegar Livro1 novamente

        // Verifica o status dos empréstimos após a devolução
        bib.listarEmprestimos();
    }
}
