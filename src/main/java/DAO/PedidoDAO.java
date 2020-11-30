package DAO;

import jdbc.Mysql;
import model.Comercio;
import model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.context.FacesContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class PedidoDAO {
    private static ResultSet rs;

    public String inserir(Pedido pedido)  {
        int resultado = 0;
        String page = "";
        try {
            Connection connection = Mysql.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into pedido (razaoSocial, cnpj,colaborador,produto, status ,valor ) values (?,?,?,?,?,?)");
            ps.setString(1, pedido.getRazaoSocial());
            ps.setString(2, pedido.getCnpj());
            ps.setString(3, pedido.getColaborador());
            ps.setString(4, pedido.getProduto());
            ps.setString(5, pedido.getStatus());
            ps.setDouble(6, pedido.getValor());
            ps.executeUpdate();
            connection.close();
        }    catch (Exception e){
            e.printStackTrace();
        }
        if(resultado != 0){
            page = "comercio.xhtml?faces-redirect=true";
        } else {
            page = "pedido.xhtml?faces-redirect=true";
        }
        return page;
    }

    public ArrayList listapedido () {
        ArrayList listaPedido = new ArrayList();
        try
        {
            Connection connection = Mysql.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from pedido");
            rs = ps.executeQuery();
            while (rs.next()){
                Pedido pedido = new Pedido();
                pedido.getComercio(rs.getInt("id"));
                pedido.setCnpj(rs.getString("cnpj"));
                pedido.setRazaoSocial(rs.getString("razaoSocial"));
                pedido.setColaborador(rs.getString("colaborador"));
                pedido.setProduto(rs.getString("produto"));
                pedido.setStatus(rs.getString("status"));
                pedido.setValor(rs.getDouble("valor"));
                listaPedido.add(pedido);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaPedido;
    }


}
