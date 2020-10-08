package controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import view.RowGameGUI;


/**
 * Java implementation of the 3 in a row game, using the Swing framework.
 *
 * This quick-and-dirty implementation violates a number of software engineering
 * principles and needs a thorough overhaul to improve readability,
 * extensibility, and testability.
 */
public class RowGameController {
    public static final String GAME_END_NOWINNER = "Game ends in a draw";

    public RowGameModel gameModel;
    public RowGameGUI gameView;


    /**
     * Creates a new game initializing the GUI.
     */
    public RowGameController() {
	gameModel = new RowGameModel();
	gameView = new RowGameGUI(this);
	
	resetGame();
    }

    public RowGameModel getModel() {
	return this.gameModel;
    }

    public RowGameGUI getView() {
	return this.gameView;
    }

    public void startUp() {
	gameView.gui.setVisible(true);
    }

    /**
     * Moves the current player into the given block.
     *
     * @param block The block to be moved to by the current player
     */
    public void move(JButton block) {
	gameModel.movesLeft = gameModel.movesLeft - 1;

	String player = gameModel.player;
	int movesLeft = gameModel.movesLeft;
	if(player.equals("1")) {
	    // Check whether player 1 won
	    if(block==gameView.gameBoardView.blocks[0][0]) {
		gameModel.blocksData[0][0].setContents("X");
		gameModel.blocksData[0][0].setIsLegalMove(false);
		gameModel.player = "2";
		if(movesLeft<7) {
		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[0][1]) {
		gameModel.blocksData[0][1].setContents("X");
		gameModel.blocksData[0][1].setIsLegalMove(false);
		gameModel.player = "2";
		if(movesLeft<7) {
		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[0][2]) {
		gameModel.blocksData[0][2].setContents("X");
		gameModel.blocksData[0][2].setIsLegalMove(false);
		gameModel.player = "2";
		if(movesLeft<7) {
		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[1][0]) {
		gameModel.blocksData[1][0].setContents("X");
		gameModel.blocksData[1][0].setIsLegalMove(false);
		// Enable the space on top of this one
		gameModel.blocksData[0][0].setIsLegalMove(true);
		gameModel.player = "2";
		if(movesLeft<7) {
		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[1][1]) {
		gameModel.blocksData[1][1].setContents("X");
		gameModel.blocksData[1][1].setIsLegalMove(false);
		// Enable the space on top of this one
		gameModel.blocksData[0][1].setIsLegalMove(true);
		gameModel.player = "2";
		if(movesLeft<7) {
		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[1][2]) {
		gameModel.blocksData[1][2].setContents("X");
		gameModel.blocksData[1][2].setIsLegalMove(false);
		// Enable the space on top of this one
		gameModel.blocksData[0][2].setIsLegalMove(true);
		gameModel.player = "2";
		if(movesLeft<7) {
		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[2][0]) {
		gameModel.blocksData[2][0].setContents("X");
		gameModel.blocksData[2][0].setIsLegalMove(false);
		// Enable the space on top of this one
		gameModel.blocksData[1][0].setIsLegalMove(true);
		gameModel.player = "2";
		if(movesLeft<7) {
		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(movesLeft==0) {
		       gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[2][1]) {
		gameModel.blocksData[2][1].setContents("X");
		gameModel.blocksData[2][1].setIsLegalMove(false);
		// Enabled the space on top of this one
		gameModel.blocksData[1][1].setIsLegalMove(true);
		gameModel.player = "2";
		if(movesLeft<7) {
		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
		        gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[2][2]) {
		gameModel.blocksData[2][2].setContents("X");
		gameModel.blocksData[2][2].setIsLegalMove(false);
		// Enable the space on top of this one
		gameModel.blocksData[1][2].setIsLegalMove(true);
		gameModel.player = "2";
		if(movesLeft<7) {
		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    }
	} else {
	    // Check whether player 2 won
	    if(block==gameView.gameBoardView.blocks[0][0]) {
		gameModel.blocksData[0][0].setContents("O");
		gameModel.blocksData[0][0].setIsLegalMove(false);
		gameModel.player = "1";
		if(movesLeft<7) {
		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[0][1]) {
		gameModel.blocksData[0][1].setContents("O");
		gameModel.blocksData[0][1].setIsLegalMove(false);
		gameModel.player = "1";
		if(movesLeft<7) {
		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[0][2]) {
		gameModel.blocksData[0][2].setContents("O");
		gameModel.blocksData[0][2].setIsLegalMove(false);
		gameModel.player = "1";
		if(movesLeft<7) {
		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[1][0]) {
		gameModel.blocksData[1][0].setContents("O");
		gameModel.blocksData[1][0].setIsLegalMove(false);
		// Enable the space on top of this one
		gameModel.blocksData[0][0].setIsLegalMove(true);
		gameModel.player = "1";
		if(movesLeft<7) {
		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[1][1]) {
		gameModel.blocksData[1][1].setContents("O");
		gameModel.blocksData[1][1].setIsLegalMove(false);
		// Enable the space on top of this one
		gameModel.blocksData[0][1].setIsLegalMove(true);
		gameModel.player ="1";
		if(movesLeft<7) {
		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[1][2]) {
		gameModel.blocksData[1][2].setContents("O");
		gameModel.blocksData[1][2].setIsLegalMove(false);
		// Enable the space on top of this one
		gameModel.blocksData[0][2].setIsLegalMove(true);
		gameModel.player ="1";
		if(movesLeft<7) {
		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[2][0]) {
		gameModel.blocksData[2][0].setContents("O");
		gameModel.blocksData[2][0].setIsLegalMove(false);
		// Enable the space on top of this one
		gameModel.blocksData[1][0].setIsLegalMove(true);
		gameModel.player ="1";
		if(movesLeft<7) {
		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[2][1]) {
		gameModel.blocksData[2][1].setContents("O");
		gameModel.blocksData[2][1].setIsLegalMove(false);
		// Enable the space on top of this one
		gameModel.blocksData[1][1].setIsLegalMove(true);
		gameModel.player ="1";
		if(movesLeft<7) {
		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    } else if(block==gameView.gameBoardView.blocks[2][2]) {
		gameModel.blocksData[2][2].setContents("O");
		gameModel.blocksData[2][2].setIsLegalMove(false);
		// Enable the space on top of this one
		gameModel.blocksData[1][2].setIsLegalMove(true);
		gameModel.player = "1";
		if(movesLeft<7) {
		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(movesLeft==0) {
			gameModel.setFinalResult(GAME_END_NOWINNER);
		    }
		}
	    }
	}

	gameView.update(gameModel);
    }

    /**
     * Ends the game disallowing further player turns.
     */
    public void endGame() {
	for(int row = 0;row<3;row++) {
	    for(int column = 0;column<3;column++) {
		this.gameModel.blocksData[row][column].setIsLegalMove(false);
	    }
	}

	gameView.update(gameModel);
    }

    /**
     * Resets the game to be able to start playing again.
     */
    public void resetGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                gameModel.blocksData[row][column].reset();
		// Enable the bottom row
	        gameModel.blocksData[row][column].setIsLegalMove(row == 2);
            }
        }
	gameModel.player = "1";
	gameModel.movesLeft = 9;
	gameModel.setFinalResult(null);

	gameView.update(gameModel);
    }
}
