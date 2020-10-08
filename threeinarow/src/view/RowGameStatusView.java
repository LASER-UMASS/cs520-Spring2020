package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.RowGameController;
import model.RowGameModel;


public class RowGameStatusView implements RowGameView
{
    public JTextArea playerturn = new JTextArea();
    public JPanel messages = new JPanel(new FlowLayout());

    
    public RowGameStatusView(RowGameController gameController) {
	super();

	messages.setBackground(Color.white);
	messages.add(playerturn);
    }

    public void update(RowGameModel gameModel) {
	if (gameModel.getFinalResult() == null) {
	    if (gameModel.player.equals("1")) {
		playerturn.setText("Player 1 to play 'X'");
	    }
	    else {
		playerturn.setText("Player 2 to play 'O'");
	    }
	}
	else {
	    playerturn.setText(gameModel.getFinalResult());
	}	
    }
}
