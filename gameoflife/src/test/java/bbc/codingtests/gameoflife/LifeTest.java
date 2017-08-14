package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class LifeTest {

	//TODO make this test pass
	@Test
	public void testEmptyGrid() {
		String emptyStateInput = "...\n...\n...";

		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(emptyStateInput);
		assertEquals("An empty grid should stay the same", emptyStateInput, testLife.evolve(emptyState).toString());
	}

	//TODO implement further tests for the other cases in the instructions
	@Test
	//Not working but can't work out what is wrong
	public void testMiddleRowAlive() {
		String input = "...\n***\n...";
		String output = ".*.\n.*.\n.*.";

		Life testLife = new LifeImpl();
		GameState inputState = new GameStateImpl(input);
		assertEquals("Centre cell should survive and vertical neighbours should spawn", output, testLife.evolve(inputState).toString());
	}
	
	@Test
	//Not working but can't work out what is wrong
	public void testMiddleColAlive() {
		String input = ".*.\n.*.\n.*.";
		String output = "...\n***\n...";

		Life testLife = new LifeImpl();
		GameState inputState = new GameStateImpl(input);
		assertEquals("Centre cell should survive and horizontal neighbours should spawn", output, testLife.evolve(inputState).toString());
	}
}
