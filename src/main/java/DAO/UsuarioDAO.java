package DAO;

import model.Usuario;
import jdbc.Mysql;

import javax.faces.context.FacesContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class UsuarioDAO {

    private static ResultSet rs;
    public static Boolean auth(String email, String senha) throws SQLException, ClassNotFoundException {
        boolean ret = false;

        Connection connection = Mysql.getConnection();
        PreparedStatement ps = connection.prepareStatement("select email from usuario where email=? and senha=?");
        ps.setString(1,email);
        ps.setString(2,senha);
        rs = ps.executeQuery();
        if(rs.next()){
            ret = true;
        }
        connection.close();

        return ret;
    }

    public String inserir(Usuario usuario)  {
        int resultado = 0;
        String page = "";
       try {
           Connection connection = Mysql.getConnection();
           PreparedStatement ps = connection.prepareStatement("insert into usuario (nome, email, senha, setor) values (?, ?, ?, ?)");
           ps.setString(1, usuario.getNome());
           ps.setString(2, usuario.getEmail());
           ps.setString(3, usuario.getSenha());
           ps.setString(4, usuario.getSetor());
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

    public String deletar(int id){
        try{
            Connection connection = Mysql.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM usuario where id = " + id);

            ps.executeUpdate();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "home.xhtml?faces-redirect=true";

    }

    public String update(Usuario updateUsuario){
        try{
            Connection connection = Mysql.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE usuario set nome = ?, email = ? senha = ? setor = ? where id = ?");
            ps.setString(1, updateUsuario.getNome());
            ps.setString(2,updateUsuario.getEmail());
            ps.setString(3,updateUsuario.getSenha());
            ps.setString(4,updateUsuario.getSetor());
            ps.setInt(5, updateUsuario.getId());
            ps.executeUpdate();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    return "home.xhtml?faces-redirect=true";
    }

    public String editUsuario(int id){
        Usuario usuario = null;
        Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        try{
            Connection connection = Mysql.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from usuario where id = "+ id);
            rs = ps.executeQuery();
            if(rs != null){
                rs.next();
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSetor(rs.getString("setor"));
                usuario.setSenha(rs.getString("senha"));
            }
            map.put("usuario", usuario);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "updateUsuario.xhtml?faces-redirect=true";
    }


    public ArrayList listarUsuario () {
        ArrayList listaUsuario = new ArrayList();
        try
        {
            Connection connection = Mysql.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from usuario");
            rs = ps.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setEmail(rs.getString("email"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSetor(rs.getString("setor"));
                listaUsuario.add(usuario);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaUsuario;
    }


}

