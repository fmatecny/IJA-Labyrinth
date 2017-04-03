package ija.Labyrinth.board;
import java.io.Serializable;
import java.util.*;

/**
 * Trieda reprezentujuca kartu na policku
 * &author xmatec00, xnovak1b
 */
public class MazeCard implements Serializable{

	public ArrayList<MazeCard.CANGO> mazeArr;
	
	/**
	 * vlastnosi policka
	 */
	public static enum CANGO
	{
		LEFT, UP, RIGHT, DOWN,
                PLAYER1, PLAYER2, PLAYER3, PLAYER4,
                POKLAD1, POKLAD2, POKLAD3, POKLAD4, POKLAD5, POKLAD6, 
                POKLAD7, POKLAD8, POKLAD9, POKLAD10, POKLAD11, POKLAD12
	}
	
	/**
	 * Vytvorenie karty s jej vlastnostami
	 * &return maze - vrati novovytvorenu kartu, ktora bola vlozena na policko
	 */	
	public static MazeCard create(String type, int p, int poklad)
	{
		MazeCard maze = new MazeCard();
		maze.mazeArr = new ArrayList<MazeCard.CANGO>(); 
		
		switch (type)
		{
			case "C":   maze.mazeArr.add(CANGO.LEFT);
						maze.mazeArr.add(CANGO.UP);
						break;
			case "L":	maze.mazeArr.add(CANGO.LEFT);
						maze.mazeArr.add(CANGO.RIGHT);
						break;
			case "F":   maze.mazeArr.add(CANGO.LEFT);
						maze.mazeArr.add(CANGO.UP);
						maze.mazeArr.add(CANGO.RIGHT);
						break;
			//default: throw new IllegalArgumentException();	
		}
                
                switch (p)
                {
                    case 1: maze.mazeArr.add(CANGO.PLAYER1);
                            break;
                    case 2: maze.mazeArr.add(CANGO.PLAYER2);
                            break;
                    case 3: maze.mazeArr.add(CANGO.PLAYER3);
                            break;
                    case 4: maze.mazeArr.add(CANGO.PLAYER4);
                            break;
                    
                }
                
                switch (poklad)
                {   
                    case 1: 
                    case 13:maze.mazeArr.add(CANGO.POKLAD1);
                            break;
                    case 2: 
                    case 14:maze.mazeArr.add(CANGO.POKLAD2);
                            break;
                    case 3: 
                    case 15:maze.mazeArr.add(CANGO.POKLAD3);
                            break;
                    case 4: 
                    case 16:maze.mazeArr.add(CANGO.POKLAD4);
                            break;
                    case 5: 
                    case 17:maze.mazeArr.add(CANGO.POKLAD5);
                            break;
                    case 6: 
                    case 18:maze.mazeArr.add(CANGO.POKLAD6);
                            break;
                    case 7: 
                    case 19:maze.mazeArr.add(CANGO.POKLAD7);
                            break;
                    case 8: 
                    case 20:maze.mazeArr.add(CANGO.POKLAD8);
                            break;
                    case 9: 
                    case 21:maze.mazeArr.add(CANGO.POKLAD9);
                            break;
                    case 10:
                    case 22:maze.mazeArr.add(CANGO.POKLAD10);
                            break;
                    case 11:
                    case 23:maze.mazeArr.add(CANGO.POKLAD11);
                            break;
                    case 12:
                    case 24:maze.mazeArr.add(CANGO.POKLAD12);
                            break;
                
                
                
                }

		return maze;
	}
	
	/**
	 * &return canGo - vrati true ak karta obsahuje hladanu vlastnost
	 */
	public boolean canGo(MazeCard.CANGO dir)
	{
		return mazeArr.contains(dir);
	}
	
	     /**
         * pridanie vlastnosti do karty
         */
        public void addCango(MazeCard.CANGO dir){
        
            mazeArr.add(dir);

        }
        
        /**
         * vymazanie nejakej vlastnosti karty
         */
        public void removeCango(MazeCard.CANGO dir){
        
            mazeArr.remove(dir);
        
        }
        
    /**
     * Otoci kartu na policku o 90 stupnov doprava
     */ 
	public void turnRight()
	{
            if ((mazeArr.contains(CANGO.DOWN) == true) && (mazeArr.contains(CANGO.LEFT) == true) && (mazeArr.contains(CANGO.UP) == true)){
                    mazeArr.remove(CANGO.DOWN);
                    mazeArr.add(CANGO.RIGHT);
                    }
            else if ((mazeArr.contains(CANGO.DOWN) == true) && (mazeArr.contains(CANGO.LEFT) == true) && (mazeArr.contains(CANGO.RIGHT) == true)){
                    mazeArr.remove(CANGO.RIGHT);
                    mazeArr.add(CANGO.UP);
                    }
            else if ((mazeArr.contains(CANGO.DOWN) == true) && (mazeArr.contains(CANGO.RIGHT) == true) && (mazeArr.contains(CANGO.UP) == true)){
                    mazeArr.remove(CANGO.UP);
                    mazeArr.add(CANGO.LEFT);
                    }
            else if ((mazeArr.contains(CANGO.LEFT) == true) && (mazeArr.contains(CANGO.RIGHT) == true) && (mazeArr.contains(CANGO.UP) == true)){
                    mazeArr.remove(CANGO.LEFT);
                    mazeArr.add(CANGO.DOWN);
                    }
            else if ((mazeArr.contains(CANGO.RIGHT) == true) && (mazeArr.contains(CANGO.DOWN) == true)){
                    mazeArr.remove(CANGO.RIGHT);
                    mazeArr.add(CANGO.LEFT);
                    }
            else if ((mazeArr.contains(CANGO.UP) == true) && (mazeArr.contains(CANGO.RIGHT) == true)){
                    mazeArr.remove(CANGO.UP);
                    mazeArr.add(CANGO.DOWN);
                    }
            else if ((mazeArr.contains(CANGO.LEFT) == true) && (mazeArr.contains(CANGO.UP) == true)){
                    mazeArr.remove(CANGO.LEFT);
                    mazeArr.add(CANGO.RIGHT);
                    }
            else if ((mazeArr.contains(CANGO.DOWN) == true) && (mazeArr.contains(CANGO.LEFT) == true)){
                    mazeArr.remove(CANGO.DOWN);
                    mazeArr.add(CANGO.UP);
                    }
            else if ((mazeArr.contains(CANGO.DOWN) == true) && (mazeArr.contains(CANGO.UP) == true)){
                    mazeArr.remove(CANGO.UP);
                    mazeArr.remove(CANGO.DOWN);
                    mazeArr.add(CANGO.LEFT);
                    mazeArr.add(CANGO.RIGHT);
                    }
            else if ((mazeArr.contains(CANGO.LEFT) == true) && (mazeArr.contains(CANGO.RIGHT) == true)){
                    mazeArr.remove(CANGO.LEFT);
                    mazeArr.remove(CANGO.RIGHT);
                    mazeArr.add(CANGO.UP);
                    mazeArr.add(CANGO.DOWN);
                    }
            else System.err.println("Chyba v otacani!!!");
	}
	
}
