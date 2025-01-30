/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import Dados.Celulares;
import jakarta.persistence.EntityManager;

/**
 *
 * @author Nicolas
 */
public class CelCOD {
    
    public void cadastrarCelulares(Celulares c){
        EntityManager em = Util.getEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }
       finally{
            Util.closeEntityManager();
        }
    }
    
}
