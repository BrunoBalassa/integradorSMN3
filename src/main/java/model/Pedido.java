package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Pedido{
    private Integer id;
    private Double valor;
    private String razaoSocial;
    private String cnpj;
    private String colaborador;
    private String produto;
    private String status;

    public Pedido(Integer id, Double valor, String cnpj, String colaborador, String produto, String status) {
        this.id = id;
        this.valor = valor;
        this.produto = produto;
        this.status = status;
        this.cnpj = cnpj;
        this.colaborador = colaborador;
    }

    public Pedido() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getStatus() {
        return status = "PENDENTE";
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void getComercio(int id) {
    }
}
