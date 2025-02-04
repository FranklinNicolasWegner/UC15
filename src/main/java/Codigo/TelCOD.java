/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;


import Dados.Celulares;
import Dados.Televisores;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class TelCOD {
    
    public void cadastrarTelevisores(Televisores t){
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
    
public List<Televisores> listarPesquisa(String filtroMarca, String filtroNome){
        EntityManager em = Util.getEntityManager();
        List televisores = null;
        
        try{
            String textoQuery = "Select t from Televisores t " + 
                    " where (:marca is null OR t.marca LIKE :marca )" +
                    " and (:nome is null OR t.nome LIKE :nome )";
            
            Query consulta = em.createQuery(textoQuery);
            
            consulta.setParameter("marca", filtroMarca.isEmpty() ? null : "%" + filtroMarca + "%" );
            consulta.setParameter("nome", filtroNome.isEmpty() ? null : "%" + filtroNome + "%" );
            
            televisores = consulta.getResultList();
        }finally{
            Util.closeEntityManager();
        }
        return televisores;
    }

public List<Televisores> listar(){
      EntityManager em = Util.getEntityManager();
      try{
          Query consulta = em.createQuery("select t from Televisores t where estado = 'A venda'");
          List<Televisores> televisores = consulta.getResultList();
          return televisores;
      }finally{
          Util.closeEntityManager();
      }
    }  

public List<Televisores> listarVendidos(){
      EntityManager em = Util.getEntityManager();
      try{
          Query consulta = em.createQuery("select t from Televisores t where estado = 'Vendido'");
          List<Televisores> televisores = consulta.getResultList();
          return televisores;
      }finally{
          Util.closeEntityManager();
      }
    } 

public void excluir(int id){
    
    EntityManager em = Util.getEntityManager();
    
    try{
        Televisores t = em.find(Televisores.class, id);
        
        if(t != null){
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        }
    }catch(Exception e){
        em.getTransaction().rollback();
        throw e;
    }
    finally{
        Util.closeEntityManager();
    }
    
}


}
