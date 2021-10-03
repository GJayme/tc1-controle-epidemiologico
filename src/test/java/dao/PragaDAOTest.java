package dao;

import domain.Praga;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Teste alterar praga não cadastrada")
    @Order(4)
    public void testAlterarPragaNaoInserida() throws Exception {
        Praga praga = new Praga("AX-9982", "Pombos",
                List.of("Criptococose"), 500,
                List.of("Limpeza"));

        assertThrows(Exception.class, () -> pragaDAO.alterarPraga(praga));
    }

    @Test
    @DisplayName("Teste excluir praga")
    @Order(5)
    public void testExcluirPraga() throws Exception {
        Praga praga01 = new Praga("AX-9982", "Rato",
                List.of("Leptospirose", "Peste bubônica", "Tifo murino", "Febre da mordida do rato"), 500,
                List.of("Detetização", "Limpeza"));

        pragaDAO.inserirPraga(praga01);
        assertEquals(pragaDAO.getPragas(), List.of(praga01));

        pragaDAO.excluirPraga(praga01.getCodigo());
        assertEquals(pragaDAO.getPragas(), List.of());
    }

    @Test
    @DisplayName("Teste excluir praga não inserida")
    @Order(6)
    public void testExcluirPragaNaoInserida() {
        Praga praga = new Praga("AX-9982", "Rato",
                List.of("Leptospirose", "Peste bubônica", "Tifo murino", "Febre da mordida do rato"), 500,
                List.of("Detetização", "Limpeza"));

        assertThrows(Exception.class, () -> pragaDAO.excluirPraga(praga));
    }

    @Test
    @DisplayName("Teste encontrar praga")
    @Order(7)
    public void testEncontrarPraga() throws Exception {
        Praga praga01 = new Praga("AX-9982", "Rato",
                List.of("Leptospirose", "Peste bubônica", "Tifo murino", "Febre da mordida do rato"), 500,
                List.of("Detetização", "Limpeza"));

        pragaDAO.inserirPraga(praga01);
        assertEquals(pragaDAO.getPraga(praga01.getCodigo()), praga01);
    }

    @Test
    @DisplayName("Teste encontrar praga não cadastrada")
    @Order(8)
    public void testEncontrarPragaNaoCadastrada() {
        Praga praga = new Praga("AX-9982", "Rato",
                List.of("Leptospirose", "Peste bubônica", "Tifo murino", "Febre da mordida do rato"), 500,
                List.of("Detetização", "Limpeza"));

        assertThrows(Exception.class, () -> pragaDAO.excluirPraga(praga));
    }

    @Test
    @DisplayName("Teste encontrar lista de pragas")
    @Order(9)
    public void testEncontrarListaPraga() throws Exception {
        Praga praga01 = new Praga("AX-9982", "Rato",
                List.of("Leptospirose", "Peste bubônica", "Tifo murino", "Febre da mordida do rato"), 500,
                List.of("Detetização", "Limpeza"));

        pragaDAO.inserirPraga(praga01);

        Praga praga02 = new Praga("PB-0398", "Pombos",
                List.of("Criptococose"), 500,
                List.of("Limpeza"));

        pragaDAO.inserirPraga(praga02);

        assertEquals(pragaDAO.getPragas(), List.of(praga01, praga02));
    }

    @Test
    @DisplayName("Teste encontrar lista de pragas com praga não cadastrada")
    @Order(10)
    public void testEncontrarListaPragaNaoCadastrada() throws Exception {
       assertEquals(pragaDAO.getPragas(), List.of());
    }
}
