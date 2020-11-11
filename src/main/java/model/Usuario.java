package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Id;


@ManagedBean
@RequestScoped
public class Usuario{

    @Id
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String setor;

    public Usuario( String nome, String email, String senha, String setor) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.setor = setor;
    }

    public Usuario() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
