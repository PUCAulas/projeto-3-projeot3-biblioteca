package codigo.test;

import codigo.src.Livro;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LivroTest {

    private Livro livro;

    @Before
    public void setUp() {
        livro = new Livro("Autor1", "Livro1", 2000, 2);
    }

    @Test
    public void testEmprestar() throws Exception {
        // Testa empréstimo bem-sucedido
        livro.emprestar();
        assertEquals(1, livro.getExemplaresDisponiveis());

        // Testa exceção ao tentar emprestar sem exemplares disponíveis
        try {
            livro.emprestar();
            fail("Deveria ter lançado uma exceção");
        } catch (Exception e) {
            assertEquals("Nao ha exemplares suficientes para pegar emprestado!", e.getMessage());
        }
    }

}
