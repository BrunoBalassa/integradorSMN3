package controller;

import DAO.UsuarioDAO;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


@ManagedBean(name = "LoginBean")
@ViewScoped
public class LoginBean {
    private String email;
    private String senha;
    private String setor;
    private String nome;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();


    public String logar() throws Exception {
       Boolean valid = usuarioDAO.auth(email, senha);
        if(valid == false) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario não encontrado",
                            "Erro no login"));
            return null;
        }else {
            return "home.xhtml";
        }
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



}
