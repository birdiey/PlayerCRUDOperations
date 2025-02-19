/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samuk
 */
public class PlayerManager implements PlayerManagerInterface{
    private Connection conn;

    public PlayerManager(String dbURL,String username,String password) throws SQLException {
        conn = DriverManager.getConnection(dbURL,username,password);
    }

    @Override
    public void addPlayer(Player p) throws SQLException {
        String sql = "INSERT INTO tbl_plaayer VALUES(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,p.getIdNum());
        ps.setString(2, p.getName());
        ps.setInt(3, p.getAge());
        ps.setString(4, p.getArea());
        ps.executeUpdate();
    }

    @Override
    public List<Player> getAll() throws SQLException {
        String sql = "SELECT * FROM tbl_player";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        List<Player> players = new ArrayList<>();
        
        while(rs.next()){
            Integer idNum = rs.getInt("IdNum");
            String name = rs.getString("Name");
            Integer age = rs.getInt("age");
            String area = rs.getString("area");
            
            
            Player p = new Player(name, idNum, age, area);
            players.add(p);
            return players;  
        }
        rs.close();
        return players;
    }

    @Override
    public Player getPlayer(Integer idNum) throws SQLException {
        String sql = "SELECT * FROM tbl_player WHERE IdNum = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idNum);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            Integer iDNum = rs.getInt("IdNum");
            String name = rs.getString("Name");
            Integer age = rs.getInt("age");
            String area = rs.getString("area");
            
            Player p = new Player(name, iDNum, age, area);
            return p;
        }else{
            return null;
        }
    }

    @Override
    public void updatePlayerAge(Integer idNum, Integer age) throws SQLException {
        String sql = "UPDATE tbl_player SET age =? WHERE idNUm =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, age);
        ps.setInt(2, idNum);
        ps.executeUpdate();
    }

    @Override
    public void deletePlayer(Integer idNum) throws SQLException {
     String sql = "DELETE FROM tbl_player WHERE idNum = ?";
     PreparedStatement ps = conn.prepareStatement(sql);
     ps.setInt(1, idNum);
     ps.executeUpdate();
    }

    @Override
    public Player getPlayerBelowAge(Integer age) throws SQLException {
        String sql = "SELECT * FROM tbl_player WHERE age =?";
        PreparedStatement ps =conn.prepareStatement(sql);
        ps.setInt(1, age);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
             Integer idNum = rs.getInt("IdNum");
            String name = rs.getString("Name");
            Integer aGe = rs.getInt("age");
            String area = rs.getString("area");
            
            Player p = new Player(name, idNum, aGe, area);
            return p;
        }else{
            return null;
        }
    }

    @Override
    public Player getPlayerByArea(String area) throws SQLException {
       String sql = "SELECT * FROM tbl_player WHERE area = ?";
       PreparedStatement ps = conn.prepareStatement(sql);
       ResultSet rs = ps.executeQuery();
       
       if(rs.next()){
            Integer idNum = rs.getInt("IdNum");
            String name = rs.getString("Name");
            Integer age = rs.getInt("age");
            String aRea = rs.getString("area");
            
            Player p = new  Player(name, idNum, age, aRea);
            return p;
       }else{
           return null;
       }
    }
    
    
    
}
