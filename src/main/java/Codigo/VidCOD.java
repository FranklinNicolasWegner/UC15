/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;


import Dados.Celulares;
import Dados.Videogames;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class VidCOD {
    
    public void cadastrarVideogames(Videogames v){
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
    
    public List<Videogames> listarPesquisa(String filtroMarca, String filtroNome){
        EntityManager em = Util.getEntityManager();
        List videogames = null;
        
        try{
            String textoQuery = "Select v from Videogames v " + 
                    " where (:marca is null OR v.marca LIKE :marca )" +
                    " and (:nome is null OR v.nome LIKE :nome )";
            
            Query consulta = em.createQuery(textoQuery);
            
            consulta.setParameter("marca", filtroMarca.isEmpty() ? null : "%" + filtroMarca + "%" );
            consulta.setParameter("nome", filtroNome.isEmpty() ? null : "%" + filtroNome + "%" );
            
            videogames = consulta.getResultList();
        }finally{
            Util.closeEntityManager();
        }
        return videogames;
    }
    
    public List<Videogames> listar(){
      EntityManager em = Util.getEntityManager();
      try{
          Query consulta = em.createQuery("select v from Videogames v where estado = 'A venda'");
          List<Videogames> videogames = consulta.getResultList();
          return videogames;
      }finally{
          Util.closeEntityManager();
      }
    }  

public List<Videogames> listarVendidos(){
      EntityManager em = Util.getEntityManager();
      try{
          Query consulta = em.createQuery("select v from Videogames v where estado = 'Vendido'");
          List<Videogames> videogames = consulta.getResultList();
          return videogames;
      }finally{
          Util.closeEntityManager();
      }
    }  


public void excluir(int id){
    
    EntityManager em = Util.getEntityManager();
    
    try{
        Videogames v = em.find(Videogames.class, id);
        
        if(v != null){
            em.getTransaction().begin();
            em.remove(v);
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
