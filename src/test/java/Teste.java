/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Codigo.CelCOD;
import Dados.Celulares;
import Dados.Televisores;
import Dados.Videogames;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Nicolas
 */
public class Teste {
    
    public Teste() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    
    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}


@Test
public void testaGetterSetterCelulares(){
    Celulares celulares = new Celulares();
    
    celulares.setId(1);
    celulares.setMarca("Motorola");
    celulares.setNome("G20");
    celulares.setPreco(1500);
    
    int testeId = 1;
    String testeMarca = "Motorola";
    String testeNome = "G20";
    int testePreco = 1500;
    
    assertEquals(testeId, celulares.getId());
    assertEquals(testeMarca, celulares.getMarca());
    assertEquals(testeNome, celulares.getNome());
    assertEquals(testePreco, celulares.getPreco());
    
}

@Test
public void testaGetterSetterTelevisores(){
    Televisores televisores = new Televisores();
    
    televisores.setId(2);
    televisores.setMarca("Sony");
    televisores.setNome("Bravia");
    televisores.setPreco(2000);
    
    int testeId = 2;
    String testeMarca = "Sony";
    String testeNome = "Bravia";
    int testePreco = 2000;
    
    assertEquals(testeId, televisores.getId());
    assertEquals(testeMarca, televisores.getMarca());
    assertEquals(testeNome, televisores.getNome());
    assertEquals(testePreco, televisores.getPreco());
    
}

@Test
public void testaGetterSetterVideogames(){
    Videogames videogames = new Videogames();
    
    videogames.setId(3);
    videogames.setMarca("Microsoft");
    videogames.setNome("Xbox");
    videogames.setPreco(2500);
    
    int testeId = 3;
    String testeMarca = "Microsoft";
    String testeNome = "Xbox";
    int testePreco = 2500;
    
    assertEquals(testeId, videogames.getId());
    assertEquals(testeMarca, videogames.getMarca());
    assertEquals(testeNome, videogames.getNome());
    assertEquals(testePreco, videogames.getPreco());
    
}

}
