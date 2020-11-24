package DAO;
import jdbc.Mysql;
import model.Comercio;

import java.sql.*;
import java.util.ArrayList;

public class ComercioDAO {
    private static ResultSet rs;

    public String inserir(Comercio comercio)  {
        int resultado = 0;
        String page = "";
        try {
            Connection connection = Mysql.getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into comercio (nomeFantasia, razaoSocial, cnpj, responsavel,telefone,ultimaCompra,valor) values (?,?, ?, ?,?,?,?)");
            ps.setString(1, comercio.getNomeFantasia());
            ps.setString(2, comercio.getRazaoSocial());
            ps.setString(3, comercio.getCnpj());
            ps.setString(4, comercio.getResponsavel());
            ps.setString(5, comercio.getTelefone());
            ps.setDate(5, (Date) comercio.getUltimaCompra());
            ps.setDouble(6, comercio.getValor());
            ps.executeUpdate();
            connection.close();
        }    catch (Exception e){
            e.printStackTrace();
        }
        if(resultado != 0){
            page = "home.xhtml?faces-redirect=true";
        } else {
            page = "createUsuario.xhtml?faces-redirect=true";
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
                comercio.setNomeFantasia(rs.getString("nomeFantasia"));
                comercio.setCnpj(rs.getString("cnpj"));
                comercio.setResponsavel(rs.getString("responsavel"));
                comercio.setTelefone(rs.getString("telefone"));
                comercio.setValor(rs.getDouble("valor"));
                comercio.setUltimaCompra(rs.getDate("ultimaCompra"));
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
}
