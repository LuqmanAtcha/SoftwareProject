/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectcode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luqma
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Check if can ask for cards
     */
    @Test
    public void testAskOtherPlayerForCard() {
        System.out.println("askOtherPlayerForCard");
        Player player = null;
        Game instance = null;
        Player expResult = null;
        Player result = instance.askOtherPlayerForCard(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of can choose rank from hands
     */
    @Test
    public void testChooseRankFromHand() {
        System.out.println("chooseRankFromHand");
        Player player = null;
        Game instance = null;
        String expResult = "";
        String result = instance.chooseRankFromHand(player);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCardFromOtherPlayer method, of class Game.
     */
    @Test
    public void testGetCardFromOtherPlayer() {
        System.out.println("getCardFromOtherPlayer");
        Player player = null;
        Player otherPlayer = null;
        Game instance = null;
        Card expResult = null;
        Card result = instance.getCardFromOtherPlayer(player, otherPlayer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

  
    /**
     * Check if users have four of a kind
     */
    @Test
    public void testCheckIfPlayerHasFourOfAKind() {
        System.out.println("checkIfPlayerHasFourOfAKind");
        Player player = null;
        Game instance = null;
        instance.checkIfPlayerHasFourOfAKind(player);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    
}
