import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * An example test class, which merely shows how to write JUnit tests.
 */
public class TestExample {
    private ThreeInARowGame game;

    @Before
    public void setUp() {
	game = new ThreeInARowGame();
    }

    @After
    public void tearDown() {
	game = null;
    }

    @Test
    public void testNewGame() {
        assertEquals ("1", game.player);
        assertEquals (9, game.movesLeft);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewBlockViolatesPrecondition() {
	ThreeInARowBlock block = new ThreeInARowBlock(null);
    }
}
