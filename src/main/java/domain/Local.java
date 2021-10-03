package domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Local {
    private String cepPontoCentral; //chave primaria
    private Integer raio;
    private Integer populacao;
    private String caracteristicas;
    private String telefoneDefesaCivil;

    public Local() {
    }

    public Local(String cepPontoCentral, Integer raio, Integer populacao, String caracteristicas, String telefoneDefesaCivil) throws Exception {
        setCepPontoCentral(cepPontoCentral);
        this.raio = raio;
        this.populacao = populacao;
        this.caracteristicas = caracteristicas;
        setTelefoneDefesaCivil(telefoneDefesaCivil);
    }

    public String getCepPontoCentral() {
        return cepPontoCentral;
    }

    public void setCepPontoCentral(String cepPontoCentral) throws Exception{
        if (!validaCep(cepPontoCentral)) {
            throw new Exception("CEP inválido!");
        }
        this.cepPontoCentral = cepPontoCentral;
    }

    public Integer getRaio() {
        return raio;
    }

    public void setRaio(Integer raio) {
        this.raio = raio;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getTelefoneDefesaCivil() {
        return telefoneDefesaCivil;
    }

    public void setTelefoneDefesaCivil(String telefoneDefesaCivil) throws Exception {
        if (!validaTelefoneDefesaCivil(telefoneDefesaCivil)) {
            throw new Exception("Telefone inválido!");
        }
        this.telefoneDefesaCivil = telefoneDefesaCivil;
    }

    private Boolean validaCep(String cep) {
        String regex = "[0-9]{5}-[0-9]{3}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(cep).matches();
    }

    private Boolean validaTelefoneDefesaCivil(String telefoneDefesaCivil) {
        String regex = "^[0-9]{2}-([0-9]{5}|[0-9]{4})-([0-9]{4})";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(telefoneDefesaCivil).matches();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Local local = (Local) o;
        return Objects.equals(cepPontoCentral, local.cepPontoCentral) && Objects.equals(raio, local.raio) && Objects.equals(populacao, local.populacao) && Objects.equals(caracteristicas, local.caracteristicas) && Objects.equals(telefoneDefesaCivil, local.telefoneDefesaCivil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cepPontoCentral, raio, populacao, caracteristicas, telefoneDefesaCivil);
    }

    @Override
    public String toString() {
        return "Local{" +
                "cepPontoCentral='" + cepPontoCentral + '\'' +
                ", raio=" + raio +
                ", populacao=" + populacao +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", telefoneDefesaCivil='" + telefoneDefesaCivil + '\'' +
                '}';
    }
}
