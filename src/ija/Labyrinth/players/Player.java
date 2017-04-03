package ija.Labyrinth.players;

import ija.Labyrinth.board.*;
import ija.Labyrinth.*;
import java.io.Serializable;
import java.util.Random;

/**
 * Trieda reprezentujuca hracov
 * @author xmatec00, xnovak1b
 */
public class Player implements Serializable{
    
    private static int[] pokladArrPlayers = null;
    
    public int pocetPokladov = 0;
    public MazeCard[] cards;
    private int n;
    private Random random = new Random();
    
    /**
     * Vytvorenie hraca
     * Pridelia sa mu nahodne karty
     */
    public void createPlayer(){
        
        n = Game.numCards/Game.numPlayer;
        
        if (pokladArrPlayers == null)
        {
            pokladArrPlayers = new int[Game.numCards];
            
            for (int i = 0; i < Game.numCards; i++)
            {
                pokladArrPlayers[i] = i+1;
            }
        }
        
        int poklad;
        cards = new MazeCard[n];

        for (int i = 0; i < n; i++)
        {   
            poklad = random.nextInt(Game.numCards);
            
            while (pokladArrPlayers[poklad] == 0)
            {
                poklad = random.nextInt(Game.numCards);
            }
            
            cards[i] = MazeCard.create("",0,poklad+1);
            pokladArrPlayers[poklad] = 0;
        }
    
    }
    
    /**
     * inkrementacia ziskanych pokladov
     */
    public void nextCard(){
    
        this.pocetPokladov++;
    
    }
    
}
