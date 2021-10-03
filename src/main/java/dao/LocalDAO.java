package dao;

import domain.Local;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LocalDAO {
    private LinkedHashMap<String,Local> locais;

    public LocalDAO() {
        locais = new LinkedHashMap<>();
    }

    public void inserirLocal(Local local) throws Exception {
        if (locais.containsValue(local)) {
            throw new Exception("Local já cadastrado em nosso sistema. Local: " + local);
        }
        locais.put(local.getCepPontoCentral(), local);
        System.out.println("Local inserido com sucesso!");
    }

    public void alterarLocal(Local local) throws Exception {
        if (!locais.containsKey(local.getCepPontoCentral())) {
            throw new Exception("Local não encontrado para efetuar atualização. Local: " + local);
        }
        locais.replace(local.getCepPontoCentral(), local);
        System.out.println("Local alterado com sucesso!");
    }

    public void excluirLocal(Local local) throws Exception {
        if (!locais.containsValue(local)) {
            throw new Exception("Local não encontrado para efetuar deleção. Local: " + local);
        }
        locais.remove(local);
        System.out.println("Local removido com sucesso!");
    }

    public void excluirLocal(String cepPontoCentral) throws Exception {
        if (!locais.containsKey(cepPontoCentral)) {
            throw new Exception("Local não encontrado para efetuar deleção. CEP: " + cepPontoCentral);
        }
        locais.remove(cepPontoCentral);
        System.out.println("Local removido com sucesso!");
    }

    public Local getLocal(String cepPontoCentral) throws Exception {
        if (!locais.containsKey(cepPontoCentral)) {
            throw new Exception("Local não encontrado. CEP: " + cepPontoCentral);
        }

        return locais.get(cepPontoCentral);
    }

    public List<Local> getLocais() {
        List<Local> localList = new ArrayList<>();
        for (String s : locais.keySet()) {
            Local local = locais.get(s);
            localList.add(local);
        }
        return localList;
    }
}


