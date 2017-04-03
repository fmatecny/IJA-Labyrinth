package ija.Labyrinth.GUI;

import java.awt.*;
import ija.Labyrinth.*;
import ija.Labyrinth.board.*;
import ija.Labyrinth.players.*;
import ija.Labyrinth.save.Save;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.*;


/**
 * Trieda reprezentujuca okno hracej plochy
 * @author xmatec00, xnovak1b
 */
public class Screen extends JPanel  implements ActionListener{

    public GameLabelPlayer labelRoad;
    public GameLabelPlayer labelRoadFree;
    private JPanel boardPanel;
    private JButton tlacica;
    private JButton tlacicaUloz;
    private static JLabel karta;
    private static JLabel playerMan;
    public static GameLabelPlayer[][] labelArr;
    public JFrame frame;
    public static MazeBoard building;
    public static HashMap<String,ImageIcon> iconMap;
    public static Player actPlayer = null;
    private static JLabel scoreLabel;

	/** URL obrazkov*/
    private String[] pathsString = {
        "lib/image/F.jpg",
        "lib/image/F90.jpg",
        "lib/image/F180.jpg",
        "lib/image/F270.jpg",
        "lib/image/C.jpg",
        "lib/image/C90.jpg",
        "lib/image/C180.jpg",
        "lib/image/C270.jpg",
        "lib/image/L.jpg",
        "lib/image/L90.jpg",
        "lib/image/panacikblue.png",
        "lib/image/panacikred.png",
        "lib/image/panacikgreen.png",
        "lib/image/panacikyellow.png",
        "lib/image/poklad1.png",
        "lib/image/poklad2.png",
        "lib/image/poklad3.png",
        "lib/image/poklad4.png",
        "lib/image/poklad5.png",
        "lib/image/poklad6.png",
        "lib/image/poklad7.png",
        "lib/image/poklad8.png",
        "lib/image/poklad9.png",
        "lib/image/poklad10.png",
        "lib/image/poklad11.png",
        "lib/image/poklad12.png",
        "lib/image/w.png",
        "lib/image/i.png",
        "lib/image/n.png"
    
    };
    
    /**
     * Vytvorenie novej GUI
     */
    public  Screen() {
        super();
        
        initComponents();
    }
    
    /**
     * Vykreslenie hracej plochy 
     */
    public static void labelIcon(GameLabelPlayer label, MazeField arr){

        if ((arr.getCard().canGo(MazeCard.CANGO.LEFT) == true) && (arr.getCard().canGo(MazeCard.CANGO.RIGHT) == true) && (arr.getCard().canGo(MazeCard.CANGO.UP) == true))
        {//_|_
            label.setIcon(iconMap.get("lib/image/F.jpg")); // NOI18N
        }
        else if((arr.getCard().canGo(MazeCard.CANGO.DOWN) == true) && (arr.getCard().canGo(MazeCard.CANGO.RIGHT) == true) && (arr.getCard().canGo(MazeCard.CANGO.UP) == true))
        {// |
         // --
         // |
                label.setIcon(iconMap.get("lib/image/F90.jpg")); // NOI18N
        }
        else if((arr.getCard().canGo(MazeCard.CANGO.DOWN) == true) && (arr.getCard().canGo(MazeCard.CANGO.RIGHT) == true) && (arr.getCard().canGo(MazeCard.CANGO.LEFT) == true))
        {//_ _
         // |
                label.setIcon(iconMap.get("lib/image/F180.jpg")); // NOI18N
        }
        else if((arr.getCard().canGo(MazeCard.CANGO.DOWN) == true) && (arr.getCard().canGo(MazeCard.CANGO.LEFT) == true) && (arr.getCard().canGo(MazeCard.CANGO.UP) == true))
        {// |
         //--
         // |
                label.setIcon(iconMap.get("lib/image/F270.jpg")); // NOI18N
        }
        else if ((arr.getCard().canGo(MazeCard.CANGO.LEFT) == true) && (arr.getCard().canGo(MazeCard.CANGO.UP) == true))
        {//_|
                label.setIcon(iconMap.get("lib/image/C.jpg")); // NOI18N
        }
        else if ((arr.getCard().canGo(MazeCard.CANGO.RIGHT) == true) && (arr.getCard().canGo(MazeCard.CANGO.UP) == true))
        {//L
                label.setIcon(iconMap.get("lib/image/C90.jpg")); // NOI18N
        }
        else if ((arr.getCard().canGo(MazeCard.CANGO.RIGHT) == true) && (arr.getCard().canGo(MazeCard.CANGO.DOWN) == true))
        {//_
        //|
                label.setIcon(iconMap.get("lib/image/C180.jpg")); // NOI18N
        }
        else if ((arr.getCard().canGo(MazeCard.CANGO.LEFT) == true) && (arr.getCard().canGo(MazeCard.CANGO.DOWN) == true))
        {//_
        //  |
                label.setIcon(iconMap.get("lib/image/C270.jpg")); // NOI18N
        }
        else if ((arr.getCard().canGo(MazeCard.CANGO.LEFT) == true) && (arr.getCard().canGo(MazeCard.CANGO.RIGHT) == true))
        {//_
                label.setIcon(iconMap.get("lib/image/L.jpg")); // NOI18N
        }
        else if ((arr.getCard().canGo(MazeCard.CANGO.DOWN) == true) && (arr.getCard().canGo(MazeCard.CANGO.UP) == true))
        {//|
                label.setIcon(iconMap.get("lib/image/L90.jpg")); // NOI18N
        }


        JLabel labelPlayer;
        label.removePlayer1();
        label.removePlayer2();
        label.removePlayer3();
        label.removePlayer4();

        if (arr.getCard().canGo(MazeCard.CANGO.PLAYER1) == true && Game.player1 == true){
            labelPlayer = new javax.swing.JLabel();
            labelPlayer.setIcon(iconMap.get("lib/image/panacikblue.png")); // NOI18N
            labelPlayer.setBounds(2,2,24,40);        
            label.addPlayer1(labelPlayer);
        }
        if (arr.getCard().canGo(MazeCard.CANGO.PLAYER2) == true && Game.player2 == true){
            labelPlayer = new javax.swing.JLabel();
            labelPlayer.setIcon(iconMap.get("lib/image/panacikred.png")); // NOI18N
            labelPlayer.setBounds(55,2,23,40);
            label.addPlayer2(labelPlayer);
        }
        if (arr.getCard().canGo(MazeCard.CANGO.PLAYER3) == true && Game.player3 == true){
            labelPlayer = new javax.swing.JLabel();
            labelPlayer.setIcon(iconMap.get("lib/image/panacikgreen.png")); // NOI18N
            labelPlayer.setBounds(2,38,24,40);
            label.addPlayer3(labelPlayer);
        }
        if (arr.getCard().canGo(MazeCard.CANGO.PLAYER4) == true && Game.player4 == true){
            labelPlayer = new javax.swing.JLabel();
            labelPlayer.setIcon(iconMap.get("lib/image/panacikyellow.png")); // NOI18N
            labelPlayer.setBounds(55,38,23,40);
            label.addPlayer4(labelPlayer);
        }


        JLabel labelPoklad;
        label.removePoklad();
        if (arr.getCard().canGo(MazeCard.CANGO.POKLAD1) == true)
        {
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/poklad1.png")); // NOI18N
                labelPoklad.setBounds(25,25,45,24);
                label.addPoklad(labelPoklad);
        }
        else if (arr.getCard().canGo(MazeCard.CANGO.POKLAD2) == true)
        {
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/poklad2.png")); // NOI18N
                labelPoklad.setBounds(20,20,40,48);
                label.addPoklad(labelPoklad);
        }
        else if (arr.getCard().canGo(MazeCard.CANGO.POKLAD3) == true)
        {
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/poklad3.png")); // NOI18N
                labelPoklad.setBounds(25,25,40,41);
                label.addPoklad(labelPoklad);
        }
        else if (arr.getCard().canGo(MazeCard.CANGO.POKLAD4) == true)
        {
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/poklad4.png")); // NOI18N
                labelPoklad.setBounds(25,25,40,34);
                label.addPoklad(labelPoklad);
        }
        else if (arr.getCard().canGo(MazeCard.CANGO.POKLAD5) == true)
        {
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/poklad5.png")); // NOI18N
                labelPoklad.setBounds(25,25,22,44);
                label.addPoklad(labelPoklad);
        }
        else if (arr.getCard().canGo(MazeCard.CANGO.POKLAD6) == true)
        {
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/poklad6.png")); // NOI18N
                labelPoklad.setBounds(25,25,40,35);
                label.addPoklad(labelPoklad);
        }
        else if (arr.getCard().canGo(MazeCard.CANGO.POKLAD7) == true)
        {
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/poklad7.png")); // NOI18N
                labelPoklad.setBounds(25,25,45,29);
                label.addPoklad(labelPoklad);
        }
        else if (arr.getCard().canGo(MazeCard.CANGO.POKLAD8) == true)
        {
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/poklad8.png")); // NOI18N
                labelPoklad.setBounds(25,25,25,44);
                label.addPoklad(labelPoklad);
        }
        else if (arr.getCard().canGo(MazeCard.CANGO.POKLAD9) == true)
        {
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/poklad9.png")); // NOI18N
                labelPoklad.setBounds(25,25,40,41);
                label.addPoklad(labelPoklad);
        }
        else if (arr.getCard().canGo(MazeCard.CANGO.POKLAD10) == true)
        {//|
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/poklad10.png")); // NOI18N
                labelPoklad.setBounds(25,25,44,23);
                label.addPoklad(labelPoklad);
        }
        else if (arr.getCard().canGo(MazeCard.CANGO.POKLAD11) == true)
        {//|
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/poklad11.png")); // NOI18N
                labelPoklad.setBounds(25,25,43,30);
                label.addPoklad(labelPoklad);
        }
        else if (arr.getCard().canGo(MazeCard.CANGO.POKLAD12) == true)
        {//|
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/poklad12.png")); // NOI18N
                labelPoklad.setBounds(25,25,36,44);
                label.addPoklad(labelPoklad);
        }

        if (actPlayer.pocetPokladov == Game.numCards/Game.numPlayer && (arr.x == (Game.size/2)+1) && (arr.y == (Game.size/2)))
        {
                label.removePoklad();
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/w.png")); // NOI18N
                labelPoklad.setBounds(0,20,80,40);
                label.addPoklad(labelPoklad);
        }
        else if (actPlayer.pocetPokladov == Game.numCards/Game.numPlayer && (arr.x == (Game.size/2)+1) && (arr.y == (Game.size/2)+1))
        {
                label.removePoklad();
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/i.png")); // NOI18N
                labelPoklad.setBounds(0,20,80,40);
                label.addPoklad(labelPoklad);
        }
        else if (actPlayer.pocetPokladov == Game.numCards/Game.numPlayer && (arr.x == (Game.size/2)+1) && (arr.y == (Game.size/2)+2))
        {
                label.removePoklad();
                labelPoklad = new javax.swing.JLabel();
                labelPoklad.setIcon(iconMap.get("lib/image/n.png")); // NOI18N
                labelPoklad.setBounds(0,20,80,40);
                label.addPoklad(labelPoklad);
        }
    }
                  
    /**
     * inicializacia komponentov na vytvorenie okna a vykreslenie hracej plochy
     */          
    private void initComponents() {
        
       if (Game.load == false)
       {
            if (Game.player1 == true){actPlayer = Game.p1;}
            else if(Game.player2 == true){actPlayer = Game.p2;}
            else if(Game.player3 == true){actPlayer = Game.p3;}
       }
        
        building = MazeBoard.createMazeBoard(Game.size);
        building.newGame();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JPanel gamePanel = new JPanel(); 
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(Game.size,Game.size));
        labelArr = new GameLabelPlayer[Game.size][Game.size];
        labelRoadFree = new GameLabelPlayer();
       
        initImageIcons();

        //do labelArr prida icony
        for (int i = 0; i < Game.size; i++)
        {
            for(int j = 0; j < Game.size; j++)
            {
                
                labelRoad = new GameLabelPlayer();
                
                labelIcon(labelRoad, MazeBoard.matrixArr[i][j]);
                
                labelRoad.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {LabelMouseClicked(evt, building);}});
                
                labelArr[i][j] = labelRoad;
            }
        }

        //pridanie hracej plochy do panel
        gamePanel.add(boardPanel);
                
        //volny kamen - ikona
        labelIcon(labelRoadFree, MazeBoard.freeCard);
        labelRoadFree.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    LabelFreeMouseClicked(evt);}});
        
        //pridanie volneho kamena do panel
        gamePanel.add(labelRoadFree);
        this.add(gamePanel);


        for (int i = 0; i < Game.size; i++)
        {
            for(int j = 0; j < Game.size; j++)
            {
                boardPanel.add(labelArr[i][j],new Integer(1));
            }
        }
        
        boardPanel.requestFocus();
        
        JPanel playerPanel = new JPanel();
        JPanel savePanel = new JPanel();
        
        tlacicaUloz = new JButton ("Ulozit hru");
        tlacicaUloz.addActionListener(this);
        tlacicaUloz.setActionCommand("save");
        
        tlacica = new JButton ("Ukonci tah");
        tlacica.addActionListener(this);
        tlacica.setActionCommand("endTurn");

        karta = new JLabel ();
        playerMan = new JLabel ();
        scoreLabel = new JLabel ();
       
        playerPanel.add(playerMan);
        playerPanel.add(scoreLabel);
        playerPanel.add(karta);
        playerPanel.add(tlacica);
        savePanel.add(playerPanel);
        savePanel.add(tlacicaUloz);
        savePanel.setLayout(new BoxLayout(savePanel, BoxLayout.X_AXIS));
        this.add(savePanel);
        
         printCard();
    } 
    
    /**
     * Listener na mys - po kliknuti posunie stlpec/riadok
     */
    private void LabelMouseClicked(java.awt.event.MouseEvent evt, MazeBoard building) {                                     

        if (actPlayer.pocetPokladov == Game.numCards/Game.numPlayer)
        {
                 Game.g.setVisible(false);
                 Game.main(null);
        }   
        else 
        {
            for (int i = 0; i < Game.size; i++)
            {
                for (int j = 0; j < Game.size; j++)
                {
                    if (evt.getSource() == labelArr[i][j])
                    {
                        building.shift(building.get(i+1, j+1));
                    }
                }        
            }

            for (int i = 0; i < Game.size; i ++)
            {
                for (int j = 0; j < Game.size; j ++)
                {  
                    labelIcon(labelArr[i][j], MazeBoard.matrixArr[i][j]);
                }
            }
            
            labelIcon(labelRoadFree, MazeBoard.freeCard);
        }
    }    
    
    /**
     * Listner pre mys - vyvola akciu orotovania volnej karty o 90 stupnov
     * &see MazeBoard
     */
    private void LabelFreeMouseClicked(java.awt.event.MouseEvent evt){

        MazeBoard.freeCard.getCard().turnRight();
    
        labelIcon(labelRoadFree, MazeBoard.freeCard);
    }
	
	/**
	 * inicializacia obrazkov
	 */
    private void initImageIcons() {
        iconMap = new HashMap<>();
        Vector<String> paths = new Vector<String>(Arrays.asList(pathsString));
        
        for (int i = 0; i<paths.size(); i++) 
        {
            iconMap.put(paths.elementAt(i), new ImageIcon(paths.elementAt(i)));
        }
    }

	/**
	 * dalsi hrac
	 */
    private void nextPlayer(){
        
        if (actPlayer == Game.p1)
        {
            if (Game.player2 == true){actPlayer = Game.p2;}
            else if(Game.player3 == true){actPlayer = Game.p3;}
            else if(Game.player4 == true){actPlayer = Game.p4;}
        }
        else if(actPlayer == Game.p2)
        {
            if (Game.player3 == true){actPlayer = Game.p3;}
            else if(Game.player4 == true){actPlayer = Game.p4;}
            else if(Game.player1 == true){actPlayer = Game.p1;}

        }
        else if(actPlayer == Game.p3)
        {
            if (Game.player4 == true){actPlayer = Game.p4;}
            else if(Game.player1 == true){actPlayer = Game.p1;}
            else if(Game.player2 == true){actPlayer = Game.p2;}
        }
        else if(actPlayer == Game.p4)
        {
            if (Game.player1 == true){actPlayer = Game.p1;}
            else if(Game.player2 == true){actPlayer = Game.p2;}
            else if(Game.player3 == true){actPlayer = Game.p3;}
        }
    }
    
    
    public static void printCard(){
    
        if (actPlayer.pocetPokladov < Game.numCards/Game.numPlayer)
        {

            if(actPlayer.cards[actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD1) == true){
                karta.setIcon(iconMap.get("lib/image/poklad1.png"));
            }
            else if(actPlayer.cards[actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD2) == true){
                karta.setIcon(iconMap.get("lib/image/poklad2.png"));
            }
            else if(actPlayer.cards[actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD3) == true){
                 karta.setIcon(iconMap.get("lib/image/poklad3.png"));
            }
            else if(actPlayer.cards[actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD4) == true){
                 karta.setIcon(iconMap.get("lib/image/poklad4.png"));
            }
            else if(actPlayer.cards[actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD5) == true){
                 karta.setIcon(iconMap.get("lib/image/poklad5.png"));
            }
            else if(actPlayer.cards[actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD6) == true){
                 karta.setIcon(iconMap.get("lib/image/poklad6.png"));
            }
            else if(actPlayer.cards[actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD7) == true){
                 karta.setIcon(iconMap.get("lib/image/poklad7.png"));
            }
            else if(actPlayer.cards[actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD8) == true){
                 karta.setIcon(iconMap.get("lib/image/poklad8.png"));
            }
            else if(actPlayer.cards[actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD9) == true){
                 karta.setIcon(iconMap.get("lib/image/poklad9.png"));
            }
            else if(actPlayer.cards[actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD10) == true){
                 karta.setIcon(iconMap.get("lib/image/poklad10.png"));
            }
            else if(actPlayer.cards[actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD11) == true){
                 karta.setIcon(iconMap.get("lib/image/poklad11.png"));
            }
            else if(actPlayer.cards[actPlayer.pocetPokladov].canGo(MazeCard.CANGO.POKLAD12) == true){
                 karta.setIcon(iconMap.get("lib/image/poklad12.png"));
            }
        }
        else
        {
            for (int i = 0; i < Game.size; i ++)
            {
                for (int j = 0; j < Game.size; j ++)
                {  
                    labelIcon(labelArr[i][j], MazeBoard.matrixArr[i][j]);
                }
            }
           
        }
        
        if (actPlayer == Game.p1)
            playerMan.setIcon(iconMap.get("lib/image/panacikblue.png"));
        else if (actPlayer == Game.p2)
            playerMan.setIcon(iconMap.get("lib/image/panacikred.png"));
        else if (actPlayer == Game.p3)
            playerMan.setIcon(iconMap.get("lib/image/panacikgreen.png"));
        else if (actPlayer == Game.p4)
            playerMan.setIcon(iconMap.get("lib/image/panacikyellow.png"));
        
        scoreLabel.setText("  " + actPlayer.pocetPokladov + "/" + (Game.numCards/Game.numPlayer) + "        Karta: ");
        
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (actPlayer.pocetPokladov == Game.numCards/Game.numPlayer)
        {
                 Game.g.setVisible(false);
                 Game.main(null);
        }
        else
        {
            switch (e.getActionCommand())
            {
                case "save" :
                    //System.out.println("saveujem1");
                    Save save = new Save();
                    save.setSize(Game.size);
                    save.setMatrixArr(MazeBoard.matrixArr);
                    save.setFreeCard(MazeBoard.freeCard);
                    save.setOneShift(MazeBoard.oneShift);
                    save.setShiftLeft(MazeBoard.shiftLeft);
                    save.setShiftUp(MazeBoard.shiftUp);
                    save.setShiftRight(MazeBoard.shiftRight);
                    save.setShiftDown(MazeBoard.shiftDown);
                    save.setNumPlayer(Game.numPlayer);
                    save.setNumCards(Game.numCards);
                    save.setPlayer1(Game.player1);
                    save.setPlayer2(Game.player2);
                    save.setPlayer3(Game.player3);
                    save.setPlayer4(Game.player4);
                    save.setP1(Game.p1);
                    save.setP2(Game.p2);
                    save.setP3(Game.p3);
                    save.setP4(Game.p4);
                    save.setActPlayer(actPlayer);
                    Save.saveGame(save);
                    break;
                    
                case "endTurn":
                    MazeBoard.oneShift = true;
                    nextPlayer();
                    printCard();
                    break;
            }
        }
    }
}
