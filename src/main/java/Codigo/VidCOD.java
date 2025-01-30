/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;


import Dados.Videogames;
import jakarta.persistence.EntityManager;

/**
 *
 * @author Nicolas
 */
public class VidCOD {
    
    public void cadastrarCelulares(Videogames v){
        EntityManager em = Util.getEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(v);
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
