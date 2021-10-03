package domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LocalTest {
    private static Local local ;

    @BeforeAll
    public static void setup() {
        local = new Local();
    }

    @DisplayName("Teste correto set/get cep")
    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"12345-678", "11223-344", "44332-211", "87654-321"})
    public void testSetGetCepPontoCentral(String cep) throws Exception {
        local.setCepPontoCentral(cep);
        assertEquals(cep, local.getCepPontoCentral());
    }

    @DisplayName("Teste incorreto set/get cep")
    @Order(2)
    @ParameterizedTest
    @ValueSource(strings = {"12345678", "1122-3344", "443322-11", "8765432-1"})
    public void testSetGetIncorretoCepPontoCentral(String cep) {
        assertThrows(Exception.class, () -> local.setCepPontoCentral(cep));
    }

    @DisplayName("Teste set/get raio")
    @Order(3)
    @ParameterizedTest
    @ValueSource(ints = {12345, 54321, 9999, 8888, 7777})
    public void testSetGetRaio(Integer raio) {
        local.setRaio(raio);
        assertEquals(raio, local.getRaio());
    }

    @DisplayName("Teste set/get população")
    @Order(4)
    @ParameterizedTest
    @ValueSource(ints = {35000, 250000, 400000, 600000, 1000000})
    public void testSetGetPopulacao(Integer populacao) {
        local.setPopulacao(populacao);
        assertEquals(populacao, local.getPopulacao());
    }

    @DisplayName("Teste set/get caracteristicas")
    @Order(5)
    @ParameterizedTest
    @ValueSource(strings = {"", "aaaaaaaaaaa aaaaa aaa a", "bbbbbbbb", "cc c c c c c c", "ddd", "e", "ff"})
    public void testSetGetCaracteristicas(String caracteristicas) {
        local.setCaracteristicas(caracteristicas);
        assertEquals(caracteristicas, local.getCaracteristicas());
    }

    @DisplayName("Teste correto set/get telefoneDefesaCivil")
    @Order(6)
    @ParameterizedTest
    @ValueSource(strings = {"16-99999-8888", "16-999998888"})
    public void testSetGetTelefoneDefesaCivil(String telefoneDefesaCivil) {
        local.setCaracteristicas(telefoneDefesaCivil);
        assertEquals(telefoneDefesaCivil, local.getCaracteristicas());
    }

    @DisplayName("Teste incorreto set/get telefoneDefesaCivil")
    @Order(7)
    @ParameterizedTest
    @ValueSource(strings = {"16999998888", "99999-4444", "16-9999-4444", "12", ""})
    public void testSetGetIncorretoTelefoneDefesaCivil(String telefoneDefesaCivil) {
        assertThrows(Exception.class, () -> local.setTelefoneDefesaCivil(telefoneDefesaCivil));
    }
}
