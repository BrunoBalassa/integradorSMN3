package controller;

import DAO.PedidoDAO;
import DAO.UsuarioDAO;
import model.Pedido;
import model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;

@ManagedBean
@RequestScoped
public class PedidoBean {
    public ArrayList listaPedido;
    private PedidoDAO pedidoDAO = new PedidoDAO();


    @PostConstruct
    public void init (){
        listaPedido = pedidoDAO.listapedido();

    }
    public ArrayList listaPedido ( ) {
        return listaPedido;
    }

    public String salvarPedido(Pedido pedido)  {
        return pedidoDAO.inserir(pedido);
    }

}
