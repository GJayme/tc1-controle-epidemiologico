package domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PragaTest {
    private static Praga praga ;

    @BeforeAll
    public static void setup() {
        praga = new Praga();
    }

    @DisplayName("Teste set/get codigo")
    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"XD-8899", "AAAAA", "SM9887221", "B"})
    public void testSetGetCodigo(String codigo) {
        praga.setCodigo(codigo);
        assertEquals(codigo, praga.getCodigo());
    }

    @DisplayName("Teste set/get nome")
    @Order(2)
    @ParameterizedTest
    @ValueSource(strings = {"Ratos", "Pombos", "Mosquitos", "Carrapatos"})
    public void testSetGetNome(String nome) {
        praga.setNome(nome);
        assertEquals(nome, praga.getNome());
    }

    @Test
    @DisplayName("Teste set/get doençasTransmitidas")
    @Order(3)
    public void testSetGetDoencasTransmitidas() {
        List<String> listaDoencasTransmitidas01 = List.of("Leptospirose", "Peste bubônica", "Tifo murino", "Febre da mordida do rato");
        praga.setDoencasTransmitidas(listaDoencasTransmitidas01);
        assertEquals(listaDoencasTransmitidas01, praga.getDoencasTransmitidas());

        List<String> listaDoencasTransmitidas02 = List.of("Criptococose");
        praga.setDoencasTransmitidas(listaDoencasTransmitidas02);
        assertEquals(listaDoencasTransmitidas02, praga.getDoencasTransmitidas());
    }

    @DisplayName("Teste set/get tempoDeVida")
    @Order(4)
    @ParameterizedTest
    @ValueSource(ints = {22, 400, 4000})
    public void testSetGetTempoDeVida(Integer tempoDeVida) {
        praga.setTempoDeVida(tempoDeVida);
        assertEquals(tempoDeVida, praga.getTempoDeVida());
    }

    @Test
    @DisplayName("Teste set/get modosCombate")
    @Order(5)
    public void testSetGetModosCombate() {
        List<String> modosCombate01 = List.of("Detetização", "Limpeza");
        praga.setModosCombate(modosCombate01);
        assertEquals(modosCombate01, praga.getModosCombate());

        List<String> modosCombate02 = List.of("Limpeza");
        praga.setModosCombate(modosCombate02);
        assertEquals(modosCombate02, praga.getModosCombate());
    }
}
