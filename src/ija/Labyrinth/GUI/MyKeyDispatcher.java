package ija.Labyrinth.GUI;

import ija.Labyrinth.*;
import static ija.Labyrinth.GUI.Screen.actPlayer;
import ija.Labyrinth.board.MazeBoard;
import java.awt.event.KeyEvent;

/**
 *
 * @author xmatec00, xnovak1b
 */
public class MyKeyDispatcher implements java.awt.KeyEventDispatcher {


    @Override
    public boolean dispatchKeyEvent(KeyEvent e) 
    {
        
            if (e.getID() == KeyEvent.KEY_PRESSED)
            {
                if (actPlayer.pocetPokladov == Game.numCards/Game.numPlayer)
                {
                 Game.g.setVisible(false);
                 Game.main(null);
                }
                
                Screen.building.shiftPlayer(Screen.building.getPlayer(Screen.actPlayer), KeyEvent.getKeyText(e.getKeyCode()));
                
                for (int i = 0; i < Game.size; i ++)
                {
                    for (int j = 0; j < Game.size; j ++)
                    {  
                        Screen.labelIcon(Screen.labelArr[i][j], MazeBoard.matrixArr[i][j]);
                    }
                }
            } 
            //else if (e.getID() == KeyEvent.KEY_RELEASED) {}
            //else if (e.getID() == KeyEvent.KEY_TYPED) {}
        return true;
    }

}
