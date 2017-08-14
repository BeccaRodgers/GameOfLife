package bbc.codingtests.gameoflife.gamestate;

public class GameStateImpl implements GameState {

	public String currentState;
	
    //TODO implement this method such that live cells are represented as a '*' and dead cells are represented by a '.'
    //TODO use newline ('\n') to separate rows
    @Override
    public String toString() {
        return currentState;
    }

    //TODO implement this constructor to parse an input string and return a new GameStateImpl object representing what you got in the string
    //TODO as above, live cells are '*' and dead cells are '.' Rows are separated by newline ('\n')
    public GameStateImpl(String input) {
        currentState = input;
    }

    //TODO implement this method according to explanation in GameState.java
    public boolean isCellAliveAt(int row, int col) {
    	
    	String cell = currentState.substring((row + 1) * col + (row * 2), (row + 1) * col + (row * 2) + 1);
    	boolean result = false;
    	if (cell.equals("*")) {
    		result = true;
    	}
    	return result;
    }

    public int getRows() {
    	
    	//Unsure why this method isn't working
    	/*int rows = 1;
        for (int i = 0; i < currentState.length(); i++) {
        	rows = currentState.substring(i, i+1).equals("n") ? rows + 1 : rows;
        }*/
    	
    	int rows = (currentState.length() + 2)/(getCols() + 2) + 1;
        
        return rows;
    }

    public int getCols() {
    	
    	int cols = 0;
        int i = 0;
        while (currentState.substring(i, i+1).equals("*") || currentState.substring(i, i+1).equals(".")) {
        	cols += 1;
        	i++;
        }
        
        return cols;
    }
}
