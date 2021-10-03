package dao;

import domain.Praga;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PragaDAOTest {
    private PragaDAO pragaDAO;

    @BeforeEach
    public void setup() {
        pragaDAO = new PragaDAO();
    }

    @Test
    @DisplayName("Teste inserir nova praga")
    @Order(1)
    public void testInserirPraga() throws Exception {
        Praga praga = new Praga("AX-9982", "Rato",
                List.of("Leptospirose", "Peste bubônica", "Tifo murino", "Febre da mordida do rato"), 500,
                List.of("Detetização", "Limpeza"));

        pragaDAO.inserirPraga(praga);

        assertEquals(pragaDAO.getPraga(praga.getCodigo()), praga);
    }

    @Test
    @DisplayName("Teste inserir praga que já foi inserida")
    @Order(2)
    public void testInserirPragaInserida() throws Exception {
        Praga praga = new Praga("AX-9982", "Rato",
                List.of("Leptospirose", "Peste bubônica", "Tifo murino", "Febre da mordida do rato"), 500,
                List.of("Detetização", "Limpeza"));

        pragaDAO.inserirPraga(praga);
        assertThrows(Exception.class, () -> pragaDAO.inserirPraga(praga));
    }

    @Test
    @DisplayName("Teste alterar praga")
    @Order(3)
    public void testAlterarPragaInserida() throws Exception {
        Praga praga01 = new Praga("AX-9982", "Rato",
                List.of("Leptospirose", "Peste bubônica", "Tifo murino", "Febre da mordida do rato"), 500,
                List.of("Detetização", "Limpeza"));

        pragaDAO.inserirPraga(praga01);

        Praga praga02 = new Praga("AX-9982", "Pombos",
                List.of("Criptococose"), 500,
                List.of("Limpeza"));

        pragaDAO.alterarPraga(praga02);

        assertEquals(pragaDAO.getPraga(praga01.getCodigo()), praga02);
    }
}
