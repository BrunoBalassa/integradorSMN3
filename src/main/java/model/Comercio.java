package model;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.Date;
@ManagedBean
@RequestScoped
public class Comercio {
    private Integer id;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private String responsavel;
    private String telefone;
    private Date ultimaCompra;
    private Double valor;
    private Pedido pedido;

    public Comercio(Integer id, String nomeFantasia, String razaoSocial, String cnpj, String responsavel, String telefone, Date ultimaCompra, Double valor) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.responsavel = responsavel;
        this.telefone = telefone;
        this.ultimaCompra = ultimaCompra;
        this.valor = valor;
    }
    public Comercio (){}

    public Comercio(String cnpj, String colaborador, String razaoSocial) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getUltimaCompra() {
        return ultimaCompra;
    }

    public void setUltimaCompra(Date ultimaCompra) {
        this.ultimaCompra = ultimaCompra;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

}
