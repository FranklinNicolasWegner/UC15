/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
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




}
