package dao;

import domain.Local;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocaoDAOTest {
    private LocalDAO localDAO;

    @BeforeEach
    public void setup() {
        localDAO = new LocalDAO();
    }

    @Test
    @DisplayName("Teste inserir novo local")
    @Order(1)
    public void testInserirLocal() throws Exception {
        Local local = new Local("13546-040", 500, 35000, "caracteristicas",
                "16-99999-8888");

        localDAO.inserirLocal(local);
        assertEquals(localDAO.getLocal(local.getCepPontoCentral()), local);
    }

    @Test
    @DisplayName("Teste inserir local que já foi inserido")
    @Order(2)
    public void testInserirLocalInserido() throws Exception {
        Local local = new Local("13546-040", 500, 35000, "caracteristicas",
                "16-99999-8888");

        localDAO.inserirLocal(local);
        assertThrows(Exception.class, () -> localDAO.inserirLocal(local));
    }

    @Test
    @DisplayName("Teste alterar local")
    @Order(3)
    public void testAlterarLocalInserido() throws Exception {
        Local local01 = new Local("13546-040", 500, 35000, "caracteristicas",
                "16-99999-8888");

        localDAO.inserirLocal(local01);

        Local local02 = new Local("13546-040", 600, 350000, "caracteristicas02",
                "16-11111-8888");

        localDAO.alterarLocal(local02);

        assertEquals(localDAO.getLocal(local01.getCepPontoCentral()), local02);
    }

    @Test
    @DisplayName("Teste alterar local não cadastrada")
    @Order(4)
    public void testAlterarLocalNaoInserido() throws Exception {
        Local local = new Local("13546-040", 500, 35000, "caracteristicas",
                "16-99999-8888");

        assertThrows(Exception.class, () -> localDAO.alterarLocal(local));
    }

    @Test
    @DisplayName("Teste excluir local")
    @Order(5)
    public void testExcluirLocal() throws Exception {
        Local local01 = new Local("13546-040", 500, 35000, "caracteristicas",
                "16-99999-8888");

        localDAO.inserirLocal(local01);
        assertEquals(localDAO.getLocais(), List.of(local01));

        localDAO.excluirLocal(local01.getCepPontoCentral());
        assertEquals(localDAO.getLocais(), List.of());
    }

    @Test
    @DisplayName("Teste excluir local não inserida")
    @Order(6)
    public void testExcluirLocalNaoInserido() throws Exception {
        Local local = new Local("13546-040", 500, 35000, "caracteristicas",
                "16-99999-8888");

        assertThrows(Exception.class, () -> localDAO.excluirLocal(local));
    }

    @Test
    @DisplayName("Teste encontrar local")
    @Order(7)
    public void testEncontrarLocal() throws Exception {
        Local local01 = new Local("13546-040", 500, 35000, "caracteristicas",
                "16-99999-8888");

        localDAO.inserirLocal(local01);
        assertEquals(localDAO.getLocal(local01.getCepPontoCentral()), local01);
    }

    @Test
    @DisplayName("Teste encontrar local não cadastrada")
    @Order(8)
    public void testEncontrarLocalNaoCadastrada() throws Exception {
        Local local = new Local("13546-040", 500, 35000, "caracteristicas",
                "16-99999-8888");

        assertThrows(Exception.class, () -> localDAO.excluirLocal(local));
    }

    @Test
    @DisplayName("Teste encontrar lista de locais")
    @Order(9)
    public void testEncontrarListaLocais() throws Exception {
        Local local01 = new Local("13546-040", 500, 350000, "caracteristicas",
                "16-99999-8888");

        localDAO.inserirLocal(local01);

        Local local02 = new Local("14140-000", 50, 35000, "caracteristicas02",
                "16-91818-1212");

        localDAO.inserirLocal(local02);

        assertEquals(localDAO.getLocais(), List.of(local01, local02));
    }

    @Test
    @DisplayName("Teste encontrar lista de locais com local não cadastrado")
    @Order(10)
    public void testEncontrarListaLocalNaoCadastrado() throws Exception {
        assertEquals(localDAO.getLocais(), List.of());
    }
}
