package dao;

import domain.Praga;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PragaDAO {
    private LinkedHashMap<String, Praga> pragas;

    public PragaDAO() {
        pragas = new LinkedHashMap<>();
    }

    public void inserirPraga(Praga praga) throws Exception {
        if (pragas.containsValue(praga)) {
            throw new Exception("Praga já cadastrada em nosso sistema. Praga: " + praga);
        }
        pragas.put(praga.getCodigo(), praga);
        System.out.println("Praga inserida com sucesso!");
    }

    public void alterarPraga(Praga praga) throws Exception {
        if (!pragas.containsKey(praga.getCodigo())) {
            throw new Exception("Praga não encontrada para efetuar atualização. Praga: " + praga);
        }
        pragas.replace(praga.getCodigo(), praga);
        System.out.println("Praga alterada com sucesso!");
    }

    public void excluirPraga(Praga praga) throws Exception {
        if (!pragas.containsValue(praga)) {
            throw new Exception("Praga não encontrada para efetuar deleção. Praga: " + praga);
        }
        pragas.remove(praga);
        System.out.println("Praga removida com sucesso!");
    }

    public void excluirPraga(String codigo) throws Exception {
        if (!pragas.containsKey(codigo)) {
            throw new Exception("Praga não encontrada para efetuar deleção. Código: " + codigo);
        }
        pragas.remove(codigo);
        System.out.println("Praga removida com sucesso!");
    }

    public Praga getPraga(String codigo) throws Exception {
        if (!pragas.containsKey(codigo)) {
            throw new Exception("Praga não encontrada. Código: " + codigo);
        }

        return pragas.get(codigo);
    }

    public List<Praga> getPragas() {
        List<Praga> pragaList = new ArrayList<>();
        for (String s : pragas.keySet()) {
            Praga praga = pragas.get(s);
            pragaList.add(praga);
        }
        return pragaList;
    }
}
