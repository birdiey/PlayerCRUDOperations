/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author samuk
 */
public interface PlayerManagerInterface {
    public void addPlayer(Player p) throws SQLException;
    public List<Player> getAll() throws SQLException;
    public Player getPlayer(Integer idNum)throws SQLException;
    public void updatePlayerAge(Integer idNum,Integer age) throws SQLException;
    public void deletePlayer(Integer idNum)throws SQLException;
    public Player getPlayerBelowAge(Integer age) throws SQLException;
    public Player getPlayerByArea(String area) throws SQLException;
    
    
}
