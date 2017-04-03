package ija.Labyrinth.save;

//import java.io.Serializable;

import ija.Labyrinth.board.MazeBoard;
import ija.Labyrinth.board.MazeField;
import ija.Labyrinth.players.Player;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * Ulozenie hry
 */
public class Save implements Serializable{
    
    private int size = 0;
    private MazeField[][] matrixArr = null;
    private MazeField freeCard = null;
    private boolean oneShift = true;
    private int[][] pokladArrField = null;
        
    private boolean shiftLeft = true;
    private boolean shiftUp = true;
    private boolean shiftRight = true;
    private boolean shiftDown = true;

    private int numPlayer = 0;
    private int numCards = 0;
    private boolean player1 = true;
    private boolean player2 = true;
    private boolean player3 = true;
    private boolean player4 = true;
    
    private Player p1 = null;
    private Player p2 = null;
    private Player p3 = null;
    private Player p4 = null;
    
    private Player actPlayer = null;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MazeField[][] getMatrixArr() {
        return matrixArr;
    }

    public void setMatrixArr(MazeField[][] matrixArr) {
        this.matrixArr = matrixArr;
    }

    public MazeField getFreeCard() {
        return freeCard;
    }

    public void setFreeCard(MazeField freeCard) {
        this.freeCard = freeCard;
    }

    public boolean isOneShift() {
        return oneShift;
    }

    public void setOneShift(boolean oneShift) {
        this.oneShift = oneShift;
    }

    public int[][] getPokladArrField() {
        return pokladArrField;
    }

    public void setPokladArrField(int[][] pokladArrField) {
        this.pokladArrField = pokladArrField;
    }

    public boolean isShiftLeft() {
        return shiftLeft;
    }

    public void setShiftLeft(boolean shiftLeft) {
        this.shiftLeft = shiftLeft;
    }

    public boolean isShiftUp() {
        return shiftUp;
    }

    public void setShiftUp(boolean shiftUp) {
        this.shiftUp = shiftUp;
    }

    public boolean isShiftRight() {
        return shiftRight;
    }

    public void setShiftRight(boolean shiftRight) {
        this.shiftRight = shiftRight;
    }

    public boolean isShiftDown() {
        return shiftDown;
    }

    public void setShiftDown(boolean shiftDown) {
        this.shiftDown = shiftDown;
    }

     public int getNumPlayer() {
        return numPlayer;
    }

    public void setNumPlayer(int numPlayer) {
        this.numPlayer = numPlayer;
    }

    public int getNumCards() {
        return numCards;
    }

    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }

    public boolean isPlayer1() {
        return player1;
    }

    public void setPlayer1(boolean player1) {
        this.player1 = player1;
    }

    public boolean isPlayer2() {
        return player2;
    }

    public void setPlayer2(boolean player2) {
        this.player2 = player2;
    }

    public boolean isPlayer3() {
        return player3;
    }

    public void setPlayer3(boolean player3) {
        this.player3 = player3;
    }

    public boolean isPlayer4() {
        return player4;
    }

    public void setPlayer4(boolean player4) {
        this.player4 = player4;
    }
    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public Player getP3() {
        return p3;
    }

    public void setP3(Player p3) {
        this.p3 = p3;
    }

    public Player getP4() {
        return p4;
    }

    public void setP4(Player p4) {
        this.p4 = p4;
    }
    
    public Player getActPlayer() {
        return actPlayer;
    }

    public void setActPlayer(Player actPlayer) {
        this.actPlayer = actPlayer;
    }
    
    /**
     * Ulozenie hry
     */
    public static void saveGame(Save save)
    {
            try{
                    //vytvoříme output stream
                    System.out.println("Zaciatok ukladania");
                    ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("save"));
                    stream.writeObject(save);
                    System.out.println("Koniec ukladania");
                    stream.close();
            }
            catch(FileNotFoundException ex) {System.out.println(ex); }
            catch(IOException ex) { System.out.println(ex);}
    }      


    /**
     * Nacitanie hry
     * &return load - nacitana hra
     */
    public static Save loadGame() throws IOException, ClassNotFoundException
    {
        Save load = null;
            try{
                    System.out.println("Nacitavam");
                    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("save"));
                    load = (Save) inputStream.readObject();
                    System.out.println("Koniec nacitavania");
                    inputStream.close();

            }
            catch(FileNotFoundException ex) {System.out.println(ex); }
            catch(IOException ex) {System.out.println(ex); }      
            catch(ClassNotFoundException ex) { System.out.println(ex);}

        return load;
    }
}

