/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vendaeletronicos;

import GUI.Menu;



/**
 *
 * @author Nicolas
 */
public class VendaEletronicos {

    public static void main(String[] args) {
        Menu Menu = new Menu();
        java.awt.EventQueue.invokeLater(new Runnable() {
              public void run() {
                  new Menu().setVisible(true);
              }
          });
        
    }
}
