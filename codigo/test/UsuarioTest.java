package codigo.test;

import codigo.src.Usuario;
import codigo.src.Emprestimo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

    private Usuario usuario;

    @Before
    public void setUp() {
        usuario = new Usuario("João");
    }

    @Test
    public void testPodeEmprestar() throws Exception {
        // Teste sem restrições
        assertTrue(usuario.podeEmprestar());

        // Adicione empréstimos ao usuário
        Emprestimo emprestimo1 = new Emprestimo(1, 1, "01/01/2023");
        Emprestimo emprestimo2 = new Emprestimo(1, 2, "02/01/2023");
        usuario.getEmprestimos().add(emprestimo1);
        usuario.getEmprestimos().add(emprestimo2);

        // Teste limite de empréstimos
        assertFalse(usuario.podeEmprestar());

        // Teste empréstimo atrasado
        usuario.getEmprestimos().clear();
        Emprestimo emprestimoAtrasado = new Emprestimo(1, 1, "01/01/2020");
        usuario.getEmprestimos().add(emprestimoAtrasado);

        assertFalse(usuario.podeEmprestar());
    }
}
