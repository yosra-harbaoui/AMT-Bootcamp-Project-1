/*
 *Author: Yosra Harbaoui
 *Date: October 2017
 *Description: Manage users
*/

package ch.heigvd.amt.yosra.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class UsersManager implements UsersManagerLocal
{
    @Resource(lookup = "jdbc/sakila")
    private DataSource dataSource; 

    @Override
    public boolean validateUser(String userName, String password)
    {       
        try
        {
            Connection connection = dataSource.getConnection();
            
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            
            statement.setString(1, userName);
            statement.setString(2, password);
                        
            ResultSet rs = statement.executeQuery();
            
            connection.close();
                        
            if(rs.next()) 
            {            
                return true;
            }               
        }
        catch (SQLException ex)
        {
            System.out.println(ex.toString());
        }
        
        return false;
    }

    @Override
    public int getUserId(String userName) 
    {
        try
        {
            Connection connection = dataSource.getConnection();
            
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            
            statement.setString(1, userName);
                        
            ResultSet rs = statement.executeQuery();
            
            connection.close();
                        
            if(rs.next()) 
            {            
                return rs.getInt("id");
            }               
        }
        catch (SQLException ex)
        {
            return -1;
        }
        
        return -1;
    }
}