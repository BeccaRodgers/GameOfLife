package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;

public class LifeImpl implements Life
{
	public String newState;
	public int numNeighbours;
	
	public GameState evolve(GameState currentState) {
		int rows = currentState.getRows();
        int cols = currentState.getCols();
        newState = "";
        for (int row = 0; row < rows; row++ ) {
        	for (int col = 0; col < cols; col++ ) {
        		
        		//add up number of neighbours
        		numNeighbours = 0;

                //Top left
                if ((row - 1 >= 0) && (col - 1 >= 0)) {
                    numNeighbours = currentState.isCellAliveAt(row-1, col-1) ? numNeighbours + 1 : numNeighbours;
                }
                //Left
                if ((row >= 0) && (col - 1 >= 0)) {
                    numNeighbours = currentState.isCellAliveAt(row, col-1) ? numNeighbours + 1 : numNeighbours;
                }
                //Bottom left
                if ((row + 1 < rows) && (col - 1 >= 0)) {
                    numNeighbours = currentState.isCellAliveAt(row+1, col-1) ? numNeighbours + 1 : numNeighbours;
                }
                //Bottom
                if ((row + 1 < rows) && (col < cols)) {
                    numNeighbours = currentState.isCellAliveAt(row+1, col) ? numNeighbours + 1 : numNeighbours;
                }
                //Bottom right
                if ((row + 1 < rows) && (col + 1 < cols)) {
                    numNeighbours = currentState.isCellAliveAt(row+1, col+1) ? numNeighbours + 1 : numNeighbours;
                }
                //Right
                if ((row < rows) && (col + 1 < cols)) {
                    numNeighbours = currentState.isCellAliveAt(row, col+1) ? numNeighbours + 1 : numNeighbours;
                }
                //Top right
                if ((row - 1 >= 0) && (col + 1 < cols)) {
                    numNeighbours = currentState.isCellAliveAt(row-1, col+1) ? numNeighbours + 1 : numNeighbours;
                }
                //Top
                if ((row - 1 >= 0) && (col < cols)) {
                    numNeighbours = currentState.isCellAliveAt(row-1, col) ? numNeighbours + 1 : numNeighbours;
                }
                
                boolean cellState = currentState.isCellAliveAt(row, col);
                System.out.println(numNeighbours);
                // underpopulation or overcrowding
                if ((numNeighbours < 2) || (numNeighbours > 3)) {
                    cellState = false;
                }

                // cell stays same - no change so statement not needed
                /*if (numNeighbours == 2) {
                    cellState = cellState;
                }*/

                // creation of life or stays alive
                if (numNeighbours == 3) {
                    cellState = true;
                }
                
        		if (cellState) {
        			newState += "*";
        		} else {
        			newState += ".";
        		}
        	}
        	newState += "\n";
        }
        
        //remove last "\n" from string
        newState = newState.substring(0, newState.length()-1);
        
        GameState newGameState = new GameStateImpl(newState);
        return newGameState;
	}
}
