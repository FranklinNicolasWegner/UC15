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
    
public List<Celulares> listarPesquisa(String filtroMarca, String filtroNome){
        EntityManager em = Util.getEntityManager();
        List televisores = null;
        
        try{
            String textoQuery = "Select c from Televisores t" + 
                    "where (:descricao is null OR d.descricao LIKE :descricao )" +
                    "and (:descricao2 is null OR d2.descricao2 LIKE :descricao2 )";
            
            Query consulta = em.createQuery(textoQuery);
            
            consulta.setParameter("descricao", filtroMarca.isEmpty() ? null : "%" + filtroMarca + "%" );
            consulta.setParameter("descricao2", filtroNome.isEmpty() ? null : "%" + filtroNome + "%" );
            
            televisores = consulta.getResultList();
        }finally{
            Util.closeEntityManager();
        }
        return televisores;
    }



}
