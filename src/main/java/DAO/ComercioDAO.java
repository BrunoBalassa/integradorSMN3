package DAO;
import jdbc.Mysql;
import model.Comercio;
import model.Pedido;

import javax.faces.context.FacesContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

public class ComercioDAO {
    private static ResultSet rs;

    public String inserir(Comercio comercio)  {
        int resultado = 0;
        String page = "";
        try {
            Connection connection = Mysql.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into comercio ( razaoSocial, cnpj, responsavel,telefone) values (?,?,?,?)");
            ps.setString(1, comercio.getRazaoSocial());
            ps.setString(2, comercio.getCnpj());
            ps.setString(3, comercio.getResponsavel());
            ps.setString(4, comercio.getTelefone());
            ps.executeUpdate();
            connection.close();
        }    catch (Exception e){
            e.printStackTrace();
        }
        if(resultado != 0){
            page = "comercio.xhtml?faces-redirect=true";
        } else {
            page = "creatComercio.xhtml?faces-redirect=true";
        }

        return page;
    }

    public ArrayList listaEmpresa () {
        ArrayList listaEmpresa = new ArrayList();
        try
        {
            Connection connection = Mysql.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from comercio");
            rs = ps.executeQuery();
            while (rs.next()){
                Comercio comercio = new Comercio();
                comercio.setId(rs.getInt("id"));
                comercio.setNomeFantasia(rs.getString("razaoSocial"));
                comercio.setCnpj(rs.getString("cnpj"));
                comercio.setResponsavel(rs.getString("responsavel"));
                comercio.setTelefone(rs.getString("telefone"));
                listaEmpresa.add(comercio);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaEmpresa;
    }
    public String RealizarPedido(int id){
        Pedido pedido = null;
        Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        try{
            Connection connection = Mysql.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from comercio c  where c.id = "+ id);
            rs = ps.executeQuery();
            if(rs != null){
                rs.next();
                pedido = new Pedido();
                pedido.setRazaoSocial(rs.getString("razaoSocial"));
                pedido.setCnpj(rs.getString("cnpj"));
                pedido.setColaborador(rs.getString("responsavel"));
            }
            map.put("pedido", pedido);

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "creatPedido.xhtml?faces-redirect=true";
    }
}
