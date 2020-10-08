package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.RowGameController;
import model.RowGameModel;


public class RowGameBoardView implements RowGameView
{
    public JButton[][] blocks = new JButton[3][3];
    public JPanel gamePanel = new JPanel(new FlowLayout());

    
    public RowGameBoardView(RowGameController gameController) {
	super();

        JPanel game = new JPanel(new GridLayout(3,3));
        gamePanel.add(game, BorderLayout.CENTER);
	
       // Initialize a JButton for each cell of the 3x3 game board.
        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
                game.add(blocks[row][column]);
                blocks[row][column].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
			gameController.move((JButton)e.getSource());
                    }
                });
            }
        }	
    }

    /**
     * Updates the game view after the game model
     * changes state.
     *
     * @param gameModel The current game model
     */
    public void update(RowGameModel gameModel) {
	for (int row = 0; row < 3; row++) {
	    for (int column = 0; column < 3; column++) {
		this.updateBlock(gameModel, row, column);
	    } // end for col
	} // end for row	
    }

    /**
     * Updates the block view at the given row and column 
     * after the game model changes state.
     *
     * @param gameModel The game model
     * @param row The row that contains the block
     * @param column The column that contains the block
     */
    protected void updateBlock(RowGameModel gameModel, int row, int col) {
	blocks[row][col].setText(gameModel.blocksData[row][col].getContents());
	blocks[row][col].setEnabled(gameModel.blocksData[row][col].getIsLegalMove());	
    }
}
