/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vendaeletronicos;

import Codigo.CelCOD;
import Dados.Celulares;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolas
 */
public class VendaEletronicos {

    public static void main(String[] args) {
        Celulares celulares = new Celulares();
        CelCOD celcod = new CelCOD();
        
        try{ 
        celulares.setNome("Moto G20");
        celulares.setMarca("Motorola");
        celulares.setPreco(900);
        celulares.setEstado("Vendido");
        
        celcod.cadastrarCelulares(celulares);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
    }
}
