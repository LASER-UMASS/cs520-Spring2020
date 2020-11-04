import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class RectangleTests
{
	public static final int WIDTH = 3;
	public static final int HEIGHT = 2;
	private Rectangle rectangle;

	@Before
	public void setUp() {
		rectangle = new Rectangle(WIDTH, HEIGHT);
	}

	@After 
	public void tearDown() {
		rectangle = null;
	}
	
	// Check expected output
	@Test(expected=IllegalArgumentException.class)
	public void testNewRectangleViolatesPrecondition() {
		// Given known inputs
		int negativeWidth = - WIDTH;
		Assert.assertFalse(negativeWidth > 0);
		Assert.assertTrue(HEIGHT > 0);
		// Test on those inputs
		Rectangle newRectangle = new Rectangle(negativeWidth, HEIGHT);
	}	
	
	@Test
	public void testNewRectangleSatisfiesPrecondition() {
		// Given known inputs
		Assert.assertTrue(WIDTH > 0);
		Assert.assertTrue(HEIGHT > 0);
		// Check for expected output
		Assert.assertNotNull(rectangle);
		Assert.assertEquals(WIDTH, rectangle.getWidth());
		Assert.assertEquals(HEIGHT, rectangle.getHeight());
	}
	
	@Test
	public void testEqualsNullReturnsFalse() {
		Assert.assertNotNull(rectangle);
		Rectangle nullRectangle = null;
		Assert.assertNull(nullRectangle);
		Assert.assertFalse(rectangle.equals(nullRectangle));
	}

	@Test
	public void testGetAreaOfRectangle() {
		Assert.assertFalse(rectangle.isSquare());
		int expectedArea = rectangle.getWidth() * rectangle.getHeight();
		Assert.assertEquals(expectedArea, rectangle.getArea());
	}

} // end of Rectangle
