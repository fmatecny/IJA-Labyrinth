package ija.Labyrinth.GUI;

import javax.swing.JLabel;

/**
 *
 * @author xmatec00, xnovak1b
 */
public class GameLabelPlayer extends JLabel{
    JLabel player1 = null;
    JLabel player2 = null;
    JLabel player3 = null;
    JLabel player4 = null;
    JLabel poklad = null;
    
    public void addPlayer1 (JLabel p) {
        player1 = p;
        this.add(player1);
}
    public void removePlayer1 () {
        if (player1!=null) 
        this.remove(player1);
        this.revalidate();
        this.repaint();
}    

    public void addPlayer2 (JLabel p) {
        player2 = p;
        this.add(player2);
}
    public void removePlayer2 () {
        if (player2!=null) 
        this.remove(player2);
        this.revalidate();
        this.repaint();
}   
    
    public void addPlayer3 (JLabel p) {
        player3 = p;
        this.add(player3);
}
    public void removePlayer3 () {
        if (player3!=null) 
        this.remove(player3);
        this.revalidate();
        this.repaint();
}  
    
    public void addPlayer4 (JLabel p) {
        player4 = p;
        this.add(player4);
}
    public void removePlayer4 () {
        if (player4!=null) 
        this.remove(player4);
        this.revalidate();
        this.repaint();
}  
    
    public void addPoklad (JLabel p) {
        poklad = p;
        this.add(poklad);
}
    public void removePoklad () {
        if (poklad!=null) 
        this.remove(poklad);
        this.revalidate();
        this.repaint();
}  
}
