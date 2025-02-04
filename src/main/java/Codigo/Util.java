/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Nicolas
 */
public class Util {
    private static final String  PERSISTENCE_UNIT = "vendaeletronicos";
    
    private static EntityManager em;
    private static EntityManagerFactory fabrica;
    
    public static EntityManager getEntityManager(){
        if(fabrica == null || !fabrica.isOpen()){
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
    
        if(em == null || !em.isOpen()){
            em = fabrica.createEntityManager();
        }
    return em;
    }
    
public static void closeEntityManager(){
    if(em.isOpen() && em != null){
        em.close();
        fabrica.close();
    }
}
public Connection conn = null;
public boolean Connection(){
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vendaeletronicos", "root", "bancodedadosbrabao");
            return true;
            
        } catch (ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + ex.getMessage());
        return false;
        }
        
    }

public void desconectar(){
try{    
conn.close();
}catch(SQLException ex){
    
}
}





}
