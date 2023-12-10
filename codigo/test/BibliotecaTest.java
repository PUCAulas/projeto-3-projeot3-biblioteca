package codigo.test;

import codigo.src.Biblioteca;
import codigo.src.ControlleItens.Livro;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaTest {

    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        biblioteca = Biblioteca.getInstance();
    }

    @Test
    public void testRelatorioItensEmprestimos() throws Exception {
        // Adiciona usuários
        biblioteca.addUsuario("Alice");
        biblioteca.addUsuario("Bob");

        // Adiciona itens
        biblioteca.addItem(new Livro("Autor1", "Livro1", 2000, 1));
        biblioteca.addItem(new Livro("Autor2", "Livro2", 2010, 1));

        // Empréstimos
        biblioteca.addEmpretimo(1, 1, "01/01/2023");
        biblioteca.addEmpretimo(1, 2, "02/01/2023");
        biblioteca.addEmpretimo(2, 1, "03/01/2023");

        // Testa o relatório de itens emprestados
        ArrayList<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("Livro1 de 2000 foi emprestado 2 vezes");
        expectedOutput.add("Livro2 de 2010 foi emprestado 1 vezes");

        // assertEquals(expectedOutput,
        // getOutput(biblioteca::relatorioItensEmprestimos));
    }

    // Método auxiliar para capturar a saída do System.out.println()
    private ArrayList<String> getOutput(Runnable action) {
        try {
            ArrayList<String> outputLines = new ArrayList<>();
            System.setOut(new PrintStream(new ByteArrayOutputStream()) {
                public void println(String str) {
                    outputLines.add(str);
                }
            });

            action.run();

            System.out.flush();
            System.setOut(System.out);

            return outputLines;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
