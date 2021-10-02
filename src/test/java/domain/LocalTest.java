package domain;

import utils.EqualityTest;

public class LocalTest implements EqualityTest<Local> {


    @Override
    public Local createValue() {
        var local = new Local();
        local.setCaracteristicas("1");
        local.setPopulacao(1);
        local.setRaio(1);
        local.setCepPontoCentral("1");
        local.setTelefoneDefesaCivil("1");
        return local;
    }

    @Override
    public Local createOtherValue() {
        var local = new Local();
        local.setCaracteristicas("2");
        local.setPopulacao(2);
        local.setRaio(2);
        local.setCepPontoCentral("2");
        local.setTelefoneDefesaCivil("2");
        return local;
    }
}