/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;


import Dados.Televisores;
import jakarta.persistence.EntityManager;

/**
 *
 * @author Nicolas
 */
public class TelCOD {
    
    public void cadastrarCelulares(Televisores t){
        EntityManager em = Util.getEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(t);
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
