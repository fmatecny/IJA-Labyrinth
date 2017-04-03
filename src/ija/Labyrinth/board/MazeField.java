package ija.Labyrinth.board;

import java.io.Serializable;

/**
 * Trieda reprezentujuca policko
 * &author xmatec00, xnovak1b
 */
public class MazeField implements Serializable{

	public int x;
	public int y;
	public MazeCard card = null;
        
	/**
	 * &return x - riadok na ktorom je dane policko
	 */
	public int row()
	{		
		return x;
	}
	
	 /**
	 * &return y - stlpec na ktorom je dane policko
	 */
	public int col()
	{
		return y;
	}
	
	 /**
	 * &return card - karta na policku
	 */
	public MazeCard getCard()
	{
		return card;
	}
	
	 /**
	 * Vlozenie karty na policko
	 */
	public void putCard(MazeCard c)
	{
		card = c;
	}
	
}
