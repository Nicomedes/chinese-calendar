/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ncmds.chineseCalendar.dao;

import br.com.ncmds.chineseCalendar.jdbc.ConnectionFactory;
import br.com.ncmds.chineseCalendar.modelo.NomeData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juliano
 */
public class NomeDataDAO {
    private Connection connection;

    public NomeDataDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(NomeData nomeData) throws SQLException{
        String sql = "insert into nome_data (nome, anoNascimento,"
                + "idade, signo_chines,) values (?,?,?,?)";
        try{
            
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, nomeData.getNome());
            stmt.setInt(2, nomeData.getAnoNascimento());
            stmt.setInt(3, nomeData.getIdade());
            stmt.setString(4, nomeData.getSignoChines());
            stmt.execute();
            stmt.close();
       
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
        
        finally{
            connection.close();
        }
            
        
    }
    
    public List<NomeData> getLista() throws SQLException{
        
        try{
            
            List<NomeData> nomes = new ArrayList<NomeData>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from nome_data");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                NomeData nomeData = new NomeData();
                nomeData.setNome(rs.getString("nome"));
                nomeData.setIdade(rs.getInt("idade"));
                nomeData.setSignoChines(rs.getString("signo_chines"));
                nomeData.setAnoNascimento(rs.getInt("anoNascimento"));
                
                nomes.add(nomeData);
            }
            
            rs.close();
            stmt.close();
            return nomes;
            
            
            
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally{
            connection.close();
        }
        
        
    }
    
    
}
