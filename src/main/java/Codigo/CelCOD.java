/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import Dados.Celulares;
import Dados.Televisores;
import GUI.CadastroCelular;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, e);
        }
       finally{
            Util.closeEntityManager();
        }
    }
    
    
    
    
    
    public List<Celulares> listarPesquisa(String filtroMarca, String filtroNome){
        EntityManager em = Util.getEntityManager();
        List celulares = null;
        
        try{
            String textoQuery = "Select c from Celulares c " + 
                    " where (:marca is null OR c.marca LIKE :marca )" +
                    " and (:nome is null OR c.nome LIKE :nome )";
            
            Query consulta = em.createQuery(textoQuery);
            
            consulta.setParameter("marca", filtroMarca.isEmpty() ? null : "%" + filtroMarca + "%" );
            consulta.setParameter("nome", filtroNome.isEmpty() ? null : "%" + filtroNome + "%" );
            
            celulares = consulta.getResultList();
        }finally{
            Util.closeEntityManager();
        }
        return celulares;
    }
   
    public List<Celulares> listar(){
      EntityManager em = Util.getEntityManager();
      try{
          Query consulta = em.createQuery("select c from Celulares c where estado = 'A venda'");
          List<Celulares> celulares = consulta.getResultList();
          return celulares;
      }finally{
          Util.closeEntityManager();
      }
    }  

public List<Celulares> listarVendidos(){
      EntityManager em = Util.getEntityManager();
      try{
          Query consulta = em.createQuery("select c from Celulares c where estado = 'Vendido'");
          List<Celulares> celulares = consulta.getResultList();
          return celulares;
      }finally{
          Util.closeEntityManager();
      }
    } 

public void excluir(int id){
    
    EntityManager em = Util.getEntityManager();
    
    try{
        Celulares c = em.find(Celulares.class, id);
        
        if(c != null){
            em.getTransaction().begin();
            em.remove(c);
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
