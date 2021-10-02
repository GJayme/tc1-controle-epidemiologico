package domain;

import java.util.List;
import java.util.Objects;

public class Praga {
    private String codigo; //chave primaria
    private String nome;
    private List<String> doencasTransmitidas;
    private Integer tempoDeVida;
    private List<String> modosCombate;

    public Praga() {
    }

    public Praga(String codigo, String nome, List<String> doencasTransmitidas, Integer tempoDeVida, List<String> modosCombate) {
        this.codigo = codigo;
        this.nome = nome;
        this.doencasTransmitidas = doencasTransmitidas;
        this.tempoDeVida = tempoDeVida;
        this.modosCombate = modosCombate;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getDoencasTransmitidas() {
        return doencasTransmitidas;
    }

    public void setDoencasTransmitidas(List<String> doencasTransmitidas) {
        this.doencasTransmitidas = doencasTransmitidas;
    }

    public Integer getTempoDeVida() {
        return tempoDeVida;
    }

    public void setTempoDeVida(Integer tempoDeVida) {
        this.tempoDeVida = tempoDeVida;
    }

    public List<String> getModosCombate() {
        return modosCombate;
    }

    public void setModosCombate(List<String> modosCombate) {
        this.modosCombate = modosCombate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Praga praga = (Praga) o;
        return Objects.equals(codigo, praga.codigo) && Objects.equals(nome, praga.nome) && Objects.equals(doencasTransmitidas, praga.doencasTransmitidas) && Objects.equals(tempoDeVida, praga.tempoDeVida) && Objects.equals(modosCombate, praga.modosCombate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, doencasTransmitidas, tempoDeVida, modosCombate);
    }

    @Override
    public String toString() {
        return "Praga{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", doencasTransmitidas=" + doencasTransmitidas +
                ", tempoDeVida=" + tempoDeVida +
                ", modosCombate=" + modosCombate +
                '}';
    }
}
