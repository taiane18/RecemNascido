/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.RecemNascido;
/**
 *
 * @author Administrador
 */
public class DaoRecemNascido {
    public static boolean inserir(RecemNascido objeto) {
        String sql = "INSERT INTO recemnascido (sexo, nrquarto, peso, nmae) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSexo());
            ps.setInt(2, objeto.getNrquarto());
            ps.setDouble(3, objeto.getPeso());
            ps.setString(4, objeto.getNmae());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static void main(String[] args) {
        RecemNascido objeto = new RecemNascido();
        objeto.setSexo("F");
        objeto.setNrquarto(43);
        objeto.setPeso(4.13);
        objeto.setNmae("Joelma");
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
    
     public static boolean alterar(RecemNascido objeto) {
        String sql = "UPDATE recemnascido SET sexo = ?, nrquarto = ?, peso = ?, nmae = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getSexo()); 
            ps.setInt(2, objeto.getNrquarto());
            ps.setDouble(3, objeto.getPeso());
            ps.setString(4, objeto.getNmae());
            ps.setInt(5, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
     
     
      public static boolean excluir(RecemNascido objeto) {
        String sql = "DELETE FROM recemnascido WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
