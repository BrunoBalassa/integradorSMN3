package controller;

import DAO.UsuarioDAO;
import model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;;

import java.util.ArrayList;

@ManagedBean @RequestScoped
public class UsuarioBean {

    public ArrayList listarUsuarios;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();


    @PostConstruct
    public void init (){
        listarUsuarios = usuarioDAO.listarUsuario();

    }
    public ArrayList listarUsuarios ( ) {
       return listarUsuarios;
    }

    public String salvarUsuario(Usuario usuario)  {
        return usuarioDAO.inserir(usuario);
    }

    public String update (Usuario usuario){
       return usuarioDAO.update(usuario);
    }

    public String delete (int id){
       return usuarioDAO.deletar(id);
    }

    public String getUsuarioUpdate(int id){
        return usuarioDAO.editUsuario(id);
    }


}
