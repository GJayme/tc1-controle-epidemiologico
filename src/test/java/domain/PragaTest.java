package domain;

import utils.EqualityTest;

import java.util.List;

class PragaTest implements EqualityTest<Praga> {


    @Override
    public Praga createValue() {
        var praga = new Praga();
        praga.setCodigo("1");
        praga.setDoencasTransmitidas(List.of("A", "B", "C"));
        praga.setModosCombate(List.of("A", "B", "C"));
        praga.setNome("A");
        praga.setTempoDeVida(1);
        return praga;
    }

    @Override
    public Praga createOtherValue() {
        var praga = new Praga();
        praga.setCodigo("2");
        praga.setDoencasTransmitidas(List.of("D", "B", "C"));
        praga.setModosCombate(List.of("D", "B", "C"));
        praga.setNome("D");
        praga.setTempoDeVida(2);
        return praga;
    }
}