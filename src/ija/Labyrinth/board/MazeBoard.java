package ija.Labyrinth.board;

import ija.Labyrinth.GUI.Screen;
import ija.Labyrinth.Game;
import ija.Labyrinth.players.Player;
import java.io.Serializable;
import java.util.Random;

/**
 * &author xmatec00, xnovak1b
 */
public class MazeBoard implements Serializable{
	
	public static int size;
	public static MazeField[][] matrixArr;
	public static MazeField freeCard;
	private Random random = new Random();
        public static boolean oneShift = true;
        private int[][] pokladArrField;
        
        public static boolean shiftLeft = true;
        public static boolean shiftUp = true;
        public static boolean shiftRight = true;
        public static boolean shiftDown = true;
     
     
    /**
     * Vytvorenie hracej plochy
     * a volneho kamena
     * &return MazeBoard - hracia plocha
     */ 
	public static MazeBoard createMazeBoard(int n)
	{
		size = n;
		MazeBoard mazeBoard = new MazeBoard();
                MazeField tmp;
                
                if (Game.load == false)
                {
                    mazeBoard.matrixArr = new MazeField[n][n];

                    for (int r = 0; r < n ; r++)
                    {
                            for (int s = 0; s < n ; s++)
                            {
                                    tmp = new MazeField();
                                    tmp.x = r+1;
                                    tmp.y = s+1;
                                    mazeBoard.matrixArr[r][s] = tmp;				
                            }			
                    }
                }
                tmp = new MazeField();
		tmp.x = size+1;
		tmp.y = size+1;
                freeCard = tmp;
		return mazeBoard;
	}
	
	/**
	 * Vytvorenie novej hry - kariet s nahodnymi vlastnostami
	 */	
	public void newGame()
	{	
		int randomString;
                int randomRotate;
                int player = 0;
                String pom = "C";

                createTr();
            if (Game.load == false){
		for (int r = 0; r < size; r++)
		{
			for (int s = 0; s < size ; s++)
			{	
				randomString = random.nextInt(4);
                                player = 0;
                                if (r == 0 && s == 0){
                                    randomString = 0;
                                    player = 1;
                                    }
                                else if(r == 0 && s == size-1){
                                    randomString = 0;
                                    player = 2;
                                }
                                else if(r == size-1 && s == 0){
                                    randomString = 0;
                                    player = 3;
                                }
                                else if(r == size-1 && s == size-1){
                                    randomString = 0;
                                    player = 4;
                                }
                                else if((r%2 == 0) && (s%2 == 0)){
                                    randomString = 3;
                                    }

				switch (randomString)
				{
					case 0: pom = "C";
							break;
							
					case 1:
                                        case 2: pom = "L";
							break;
							
                                        case 3: pom = "F";
							break;	
				}
                                
                                matrixArr[r][s].putCard(MazeCard.create(pom, player,  pokladArrField[r][s]));
                                
                                if (r == 0 && s == 0 && pom == "C"){
                                    matrixArr[r][s].getCard().turnRight();
                                    matrixArr[r][s].getCard().turnRight();
                                }
                                else if (r == 0 && s == size-1 && pom == "C"){
                                    matrixArr[r][s].getCard().turnRight();
                                    matrixArr[r][s].getCard().turnRight();
                                    matrixArr[r][s].getCard().turnRight();
                                }
                                else if (r == size-1 && s == 0 && pom == "C"){
                                    matrixArr[r][s].getCard().turnRight();
                                }
                                else if(r == size-1 &&  s == size-1 && pom == "C"){
                                }
                                else if (r%2 == 0 && s == 0 && pom == "F"){
                                    matrixArr[r][s].getCard().turnRight();
                                }
                                else if (r == 0 && s%2 == 0 && pom == "F"){
                                    matrixArr[r][s].getCard().turnRight();
                                    matrixArr[r][s].getCard().turnRight();
                                }
                                else if (r%2 == 0 && s == size-1 && pom == "F"){
                                    matrixArr[r][s].getCard().turnRight();
                                    matrixArr[r][s].getCard().turnRight();
                                    matrixArr[r][s].getCard().turnRight();
                                }
                                else if (r == size-1 && s%2 ==0 && pom == "F"){
                                }
                                else {
                                    randomRotate = random.nextInt(3);
                                    for (int i = 0; i < randomRotate; i++){
                                        matrixArr[r][s].getCard().turnRight();
                                    }
                                
                                }
			}
		}
            }
		randomString = random.nextInt(3);
		switch (randomString)
		{
			case 0: pom = "C";
					break;
					
			case 1: pom = "L";
					break;
					
			case 2: pom = "F";
					break;	
		}
		freeCard.putCard(MazeCard.create(pom, 0, 0));
	}
	
	/**
	 * nahodne generovanie pokladov a ich nahodne rozmiestenie na hracej ploche
	 */
	private void createTr(){
        
            pokladArrField = new int[size][size];
            int r,s;

            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                pokladArrField[i][j] = 0;
                }
            }


            for (int i = 0; i < Game.numCards; i++){

                    r = random.nextInt(size);
                    s = random.nextInt(size);

                    while (((r == 0 || r == size-1) && (s == 0 || s == size-1)) || (pokladArrField[r][s] != 0)){
                            r = random.nextInt(size);
                            s = random.nextInt(size);
                    }
                    pokladArrField[r][s] = i+1;
            }
        
        }
        
        
        
    /**
     * &param r cislo riadku
     * &param c cislo stlpca
     * &return matrixArr - karta na zadanej suradnici
     */    
	public MazeField get(int r, int c)
	{
		if ((r < 1) || (r > size) || (c < 1) || (c > size))
		{
			return null;
		}
		return matrixArr[r-1][c-1];	
	}
	
	
		/**
		 * Vrati poziciu hraca p na hracej ploche
		 * &param p hrac 
		 * &return matrixArr policko na ktorom stoji hrac p
		 */
        public MazeField getPlayer(Player p){
        
        int r = 0;
        int s = 0;
             
        for (r = 0 ; r < size; r++){
            for(s = 0; s < size; s++){
                if ((matrixArr[r][s].getCard().canGo(MazeCard.CANGO.PLAYER1) == true) && (p == Game.p1)){
                    return matrixArr[r][s];
                }
                else if ((matrixArr[r][s].getCard().canGo(MazeCard.CANGO.PLAYER2) == true) && (p == Game.p2)){
                    return matrixArr[r][s];
                }
                else if ((matrixArr[r][s].getCard().canGo(MazeCard.CANGO.PLAYER3) == true) && (p == Game.p3)){
                    return matrixArr[r][s];
                }
                else if ((matrixArr[r][s].getCard().canGo(MazeCard.CANGO.PLAYER4) == true) && (p == Game.p4)){
                    return matrixArr[r][s];
                }
            }
        }   
 
        return matrixArr[r][s];
        }
        
    
    /**
     * &return vrati volnu kartu
     */  
	public MazeCard getFreeCard()
	{
		return freeCard.getCard();
	}
	
	/**
	 * posunutie riadku/stlpca podla mf
	 *&param mf policko na ktore sa kliklo 
	 */
	public void shift(MazeField mf)
	{
		int r = mf.row();
		int s = mf.col();
                //   |
                //  \|/   DOWN
		if ((r == 1) && (s%2 == 0) && (shiftDown == true) && (oneShift == true))
		{	
                        shiftLeft = true;
                        shiftUp = false;
                        shiftRight = true;
                        shiftDown = true;
                        oneShift = false;
                        
                    
			MazeCard pom = matrixArr[size-1][s-1].getCard();
                        
			for (r = size-1; r > 0; r--)
			{
				matrixArr[r][s-1].putCard(matrixArr[r-1][s-1].getCard());
			}
                        
                        matrixArr[0][s-1].putCard(freeCard.getCard());
                        //posun hráča s políčkom
                        shiftTrPlayer(pom, 0, s-1);

			freeCard.putCard(pom);	
		}
                //  /|\
                //   |      UP
		else if ((r == size) && (s%2 == 0) && (shiftUp == true) && (oneShift == true))
		{	
                        shiftLeft = true;
                        shiftUp = true;
                        shiftRight = true;
                        shiftDown = false;
                        oneShift = false;
                        
			MazeCard pom = matrixArr[0][s-1].getCard();

			for (r = 0; r < size-1; r++)
			{
				matrixArr[r][s-1].putCard(matrixArr[r+1][s-1].getCard());
			}
			matrixArr[size-1][s-1].putCard(freeCard.getCard());
                        
                        shiftTrPlayer(pom, size-1, s-1);
                       
                        
			freeCard.putCard(pom);	
		}
                // ___\
                //    /  RIGHT
		else if ((r%2 == 0) && (s == 1) && (shiftRight == true) && (oneShift == true))
		{	
                        shiftLeft = false;
                        shiftUp = true;
                        shiftRight = true;
                        shiftDown = true;
                        oneShift = false;
                        
			MazeCard pom = matrixArr[r-1][size-1].getCard();

			for (s = size-1; s > 0; s--)
			{
				matrixArr[r-1][s].putCard(matrixArr[r-1][s-1].getCard());
			}
			matrixArr[r-1][0].putCard(freeCard.getCard());
                        
                        shiftTrPlayer(pom, r-1, 0);
                        
			freeCard.putCard(pom);	
		}
                //  /___
                //  \       LEFT
		else if ((r%2 == 0) && (s == size) && (shiftLeft == true) && (oneShift == true))
		{	
                        shiftLeft = true;
                        shiftUp = true;
                        shiftRight = false;
                        shiftDown = true;
                        oneShift = false;
                        
			MazeCard pom = matrixArr[r-1][0].getCard();

			for (s = 0; s < size-1; s++)
			{
				matrixArr[r-1][s].putCard(matrixArr[r-1][s+1].getCard());
			}
			matrixArr[r-1][size-1].putCard(freeCard.getCard());

                        shiftTrPlayer(pom, r-1, size-1);
                        
			freeCard.putCard(pom);	
		}
	}
	
		/**
		 * posunutie kraca a pokladu
		 * &param pom karta
		 * &param r riadok
		 * &param s stlpec
		 */
        private void shiftTrPlayer(MazeCard pom, int r, int s){
        
            if (pom.canGo(MazeCard.CANGO.PLAYER1) == true){
                pom.removeCango(MazeCard.CANGO.PLAYER1);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER1);
            }
            if (pom.canGo(MazeCard.CANGO.PLAYER2) == true){
                pom.removeCango(MazeCard.CANGO.PLAYER2);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER2);
            }
            if (pom.canGo(MazeCard.CANGO.PLAYER3) == true){
                pom.removeCango(MazeCard.CANGO.PLAYER3);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER3);
            }
            if (pom.canGo(MazeCard.CANGO.PLAYER4) == true){
                pom.removeCango(MazeCard.CANGO.PLAYER4);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER4);
            }

            //posun pokladu s políčkom 
            if (pom.canGo(MazeCard.CANGO.POKLAD1) == true){
                pom.removeCango(MazeCard.CANGO.POKLAD1);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.POKLAD1);
            }
            if (pom.canGo(MazeCard.CANGO.POKLAD2) == true){
                pom.removeCango(MazeCard.CANGO.POKLAD2);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.POKLAD2);
            }
            if (pom.canGo(MazeCard.CANGO.POKLAD3) == true){
                pom.removeCango(MazeCard.CANGO.POKLAD3);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.POKLAD3);
            }
            if (pom.canGo(MazeCard.CANGO.POKLAD4) == true){
                pom.removeCango(MazeCard.CANGO.POKLAD4);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.POKLAD4);
            }
            if (pom.canGo(MazeCard.CANGO.POKLAD5) == true){
                pom.removeCango(MazeCard.CANGO.POKLAD5);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.POKLAD5);
            }
            if (pom.canGo(MazeCard.CANGO.POKLAD6) == true){
                pom.removeCango(MazeCard.CANGO.POKLAD6);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.POKLAD6);
            }
            if (pom.canGo(MazeCard.CANGO.POKLAD7) == true){
                pom.removeCango(MazeCard.CANGO.POKLAD7);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.POKLAD7);
            }
            if (pom.canGo(MazeCard.CANGO.POKLAD8) == true){
                pom.removeCango(MazeCard.CANGO.POKLAD8);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.POKLAD8);
            }
            if (pom.canGo(MazeCard.CANGO.POKLAD9) == true){
                pom.removeCango(MazeCard.CANGO.POKLAD9);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.POKLAD9);
            }
            if (pom.canGo(MazeCard.CANGO.POKLAD10) == true){
                pom.removeCango(MazeCard.CANGO.POKLAD10);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.POKLAD10);
            }
            if (pom.canGo(MazeCard.CANGO.POKLAD11) == true){
                pom.removeCango(MazeCard.CANGO.POKLAD11);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.POKLAD11);
            }
            if (pom.canGo(MazeCard.CANGO.POKLAD12) == true){
                pom.removeCango(MazeCard.CANGO.POKLAD12);
                matrixArr[r][s].getCard().addCango(MazeCard.CANGO.POKLAD12);
            }

        }
        
        
        
        
        
        /**
         * posuvanie hraca po hracej ploche
         * &param mf policko
         * &param smer smer ktorym chceme s hracom ist
         */
        public void shiftPlayer(MazeField mf, String smer){
        
            
            int r = mf.row();
            int s = mf.col();
            r--;
            s--;
            
            if (smer == "Right")
            {
                s++;
                if (s == size){
                    s = 0;
                    }
                if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.LEFT) == true && mf.getCard().canGo(MazeCard.CANGO.RIGHT))
                {
                     if (Screen.actPlayer == Game.p1){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER1);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER1);}
                     else if (Screen.actPlayer == Game.p2){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER2);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER2);}
                     else if (Screen.actPlayer == Game.p3){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER3);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER3);}
                     else if (Screen.actPlayer == Game.p4){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER4);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER4);
                     }
                     takeTr(r,s);
                }

            }
            else if (smer == "Left")
            {
                s--;
                if (s < 0){
                s = size-1;
                }
                if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.RIGHT) == true && mf.getCard().canGo(MazeCard.CANGO.LEFT)){
                     if (Screen.actPlayer == Game.p1){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER1);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER1);}
                     else if (Screen.actPlayer == Game.p2){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER2);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER2);}
                     else if (Screen.actPlayer == Game.p3){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER3);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER3);}
                     else if (Screen.actPlayer == Game.p4){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER4);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER4);
                     }
                     takeTr(r,s);
                }
            }
            else if (smer == "Up")
            {
                r--;
                if (r < 0){
                r = size-1;
                }
                if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.DOWN) == true && mf.getCard().canGo(MazeCard.CANGO.UP)){
                     if (Screen.actPlayer == Game.p1){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER1);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER1);}
                     else if (Screen.actPlayer == Game.p2){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER2);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER2);
                     }
                     else if (Screen.actPlayer == Game.p3){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER3);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER3);}
                     else if (Screen.actPlayer == Game.p4){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER4);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER4);
                     }
                     takeTr(r,s);
                }
            }
            else if (smer == "Down")
            {
                r++;
                if (r == size){
                r = 0;
                }
                if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.UP) == true && mf.getCard().canGo(MazeCard.CANGO.DOWN))
                {
                     if (Screen.actPlayer == Game.p1){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER1);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER1);}
                     else if (Screen.actPlayer == Game.p2){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER2);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER2);}
                     else if (Screen.actPlayer == Game.p3){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER3);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER3);}
                     else if (Screen.actPlayer == Game.p4){
                        mf.getCard().removeCango(MazeCard.CANGO.PLAYER4);
                        matrixArr[r][s].getCard().addCango(MazeCard.CANGO.PLAYER4);
                     }
                     takeTr(r,s);
                }
            }
        }   
      
    /**
     * Hrac vezme poklad z policka
     * &param r riadok
     * &param s stlpec
     */  
    public void takeTr(int r, int s){
        
        if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.POKLAD1) == true && Screen.actPlayer.cards[Screen.actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD1) == true)
        {
            matrixArr[r][s].getCard().removeCango(MazeCard.CANGO.POKLAD1);
            Screen.actPlayer.nextCard();
            Screen.printCard();
        }
        else if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.POKLAD2) == true && Screen.actPlayer.cards[Screen.actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD2) == true)
        {
            matrixArr[r][s].getCard().removeCango(MazeCard.CANGO.POKLAD2);
            Screen.actPlayer.nextCard();
            Screen.printCard();
        }
        else if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.POKLAD3) == true && Screen.actPlayer.cards[Screen.actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD3) == true)
        {
            matrixArr[r][s].getCard().removeCango(MazeCard.CANGO.POKLAD3);
            Screen.actPlayer.nextCard();
            Screen.printCard();
        } 
        else if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.POKLAD4) == true && Screen.actPlayer.cards[Screen.actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD4) == true)
        {
            matrixArr[r][s].getCard().removeCango(MazeCard.CANGO.POKLAD4);
            Screen.actPlayer.nextCard();
            Screen.printCard();
        } 
        else if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.POKLAD5) == true && Screen.actPlayer.cards[Screen.actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD5) == true)
        {
            matrixArr[r][s].getCard().removeCango(MazeCard.CANGO.POKLAD5);
            Screen.actPlayer.nextCard();
            Screen.printCard();
        } 
        else if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.POKLAD6) == true && Screen.actPlayer.cards[Screen.actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD6) == true)
        {
            matrixArr[r][s].getCard().removeCango(MazeCard.CANGO.POKLAD6);
            Screen.actPlayer.nextCard();
            Screen.printCard();
        } 
        else if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.POKLAD7) == true && Screen.actPlayer.cards[Screen.actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD7) == true)
        {
            matrixArr[r][s].getCard().removeCango(MazeCard.CANGO.POKLAD7);
            Screen.actPlayer.nextCard();
            Screen.printCard();
        } 
        else if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.POKLAD8) == true && Screen.actPlayer.cards[Screen.actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD8) == true)
        {
            matrixArr[r][s].getCard().removeCango(MazeCard.CANGO.POKLAD8);
            Screen.actPlayer.nextCard();
            Screen.printCard();
        } 
        else if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.POKLAD9) == true && Screen.actPlayer.cards[Screen.actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD9) == true)
        {
            matrixArr[r][s].getCard().removeCango(MazeCard.CANGO.POKLAD9);
            Screen.actPlayer.nextCard();
            Screen.printCard();
        } 
        else if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.POKLAD10) == true && Screen.actPlayer.cards[Screen.actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD10) == true)
        {
            matrixArr[r][s].getCard().removeCango(MazeCard.CANGO.POKLAD10);
            Screen.actPlayer.nextCard();
            Screen.printCard(); 
        } 
        else if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.POKLAD11) == true && Screen.actPlayer.cards[Screen.actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD11) == true)
        {
            matrixArr[r][s].getCard().removeCango(MazeCard.CANGO.POKLAD11);
            Screen.actPlayer.nextCard();
            Screen.printCard(); 
        } 
        else if (matrixArr[r][s].getCard().canGo(MazeCard.CANGO.POKLAD12) == true && Screen.actPlayer.cards[Screen.actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD12) == true)
        {
            matrixArr[r][s].getCard().removeCango(MazeCard.CANGO.POKLAD12);
            Screen.actPlayer.nextCard();
            Screen.printCard(); 
        }     
            
        }
                

	
}
