package codigo.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import codigo.src.ControlleItens.DVD;
import codigo.src.ControlleItens.FabricaItens.Criador;
import codigo.src.ControlleItens.FabricaItens.FabricaDVD;

public class DvdTest {

    private DVD dvd;

    @Before
    public void setUp() {
        Criador fabricaDVD = new FabricaDVD();
        dvd = (DVD) fabricaDVD.criarItemBibli("Autor1", "Livro1", 2000, 2, "Exatas");
    }

    @Test
    public void testEmprestar() throws Exception {
        // Testa empréstimo bem-sucedido
        dvd.emprestar();
        assertEquals(1, dvd.getExemplaresDisponiveis());

        // Testa exceção ao tentar emprestar sem exemplares disponíveis
        try {
            dvd.emprestar();
            fail("Deveria ter lançado uma exceção");
        } catch (Exception e) {
            assertEquals("Nao ha exemplares suficientes para pegar emprestado!", e.getMessage());
        }
    }

    @Test
    public void testDevolver() {
        // Testa devolução
        dvd.devolver();
        // assertEquals(2, dvd.getExemplaresDisponiveis());

        // Testa devolução além do limite
        dvd.devolver();
        // assertEquals(2, dvd.getExemplaresDisponiveis());
    }
}
