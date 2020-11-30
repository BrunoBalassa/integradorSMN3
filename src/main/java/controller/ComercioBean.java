package controller;
import DAO.ComercioDAO;
import DAO.UsuarioDAO;
import model.Comercio;
import model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;;

import java.util.ArrayList;
@ManagedBean @RequestScoped
public class ComercioBean {

    public ArrayList listaComercio;
    private ComercioDAO comercioDAO = new ComercioDAO();


    @PostConstruct
    public void init (){
        listaComercio = comercioDAO.listaEmpresa();

    }

    public ArrayList listaComercio ( ) {
        return listaComercio;
    }

    public String salvarComercio(Comercio comercio)  {
        return comercioDAO.inserir(comercio);
    }

    public String getEmpresa(int id){
        return comercioDAO.RealizarPedido(id);
    }

}
