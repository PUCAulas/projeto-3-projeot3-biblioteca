package codigo.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import codigo.src.ControlleItens.CD;

public class CdTest {

    private CD cd;

    @Before
    public void setUp() {
        cd = new CD("Artista1", "Album1", 2020, 2);
    }

    @Test
    public void testEmprestar() throws Exception {
        // Testa empréstimo bem-sucedido
        cd.emprestar();
        assertEquals(1, cd.getExemplaresDisponiveis());

        // Testa exceção ao tentar emprestar sem exemplares disponíveis
        try {
            cd.emprestar();
            fail("Deveria ter lançado uma exceção");
        } catch (Exception e) {
            assertEquals("Nao ha exemplares suficientes para pegar emprestado!", e.getMessage());
        }
    }

    @Test
    public void testDevolver() {
        // Testa devolução
        cd.devolver();
        // assertEquals(2, cd.getExemplaresDisponiveis());

        // Testa devolução além do limite
        cd.devolver();
        // assertEquals(2, cd.getExemplaresDisponiveis());
    }
}
