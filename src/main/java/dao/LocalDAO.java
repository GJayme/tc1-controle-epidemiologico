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

    public void inserirLocal(Local local) {
        if (locais.containsValue(local)) {
            System.out.println("Local já cadastrado em nosso sistema. Local: " + local);
            return;
        }
        locais.put(local.getCepPontoCentral(), local);
        System.out.println("Local inserido com sucesso!");
    }

    public void alterarLocal(Local local) {
        if (!locais.containsValue(local)) {
            System.out.println("Local não encontrado para efetuar atualização. Local: " + local);
            return;
        }
        locais.replace(local.getCepPontoCentral(), local);
        System.out.println("Local alterado com sucesso!");
    }

    public void excluirLocal(Local local) {
        if (!locais.containsValue(local)) {
            System.out.println("Local não encontrado para efetuar deleção. Local: " + local);
            return;
        }
        locais.remove(local);
        System.out.println("Local removido com sucesso!");
    }

    public void excluirLocal(String cepPontoCentral) {
        if (!locais.containsKey(cepPontoCentral)) {
            System.out.println("Local não encontrado para efetuar deleção. CEP: " + cepPontoCentral);
            return;
        }
        locais.remove(cepPontoCentral);
        System.out.println("Local removido com sucesso!");
    }

    public Local getLocal(String cepPontoCentral) {
        if (!locais.containsKey(cepPontoCentral)) {
            System.out.println("Local não encontrado. CEP: " + cepPontoCentral);
            return null;
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


