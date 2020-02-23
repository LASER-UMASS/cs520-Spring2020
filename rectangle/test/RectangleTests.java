import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class RectangleTests
{
	public static final int WIDTH = 3;
	public static final int HEIGHT = 2;
	private Rectangle rectangle;
	private Rectangle square;

	@Before
	public void setUp() {
		rectangle = new Rectangle(WIDTH, HEIGHT);
		square = new Rectangle(WIDTH, WIDTH);	
	}

	@After 
	public void tearDown() {
		rectangle = null;
		square = null;
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
	public void testIsSquareReturnsTrue() {
		Assert.assertTrue(square.getWidth() == square.getHeight());
		Assert.assertTrue(square.isSquare());
	}	

	@Test
	public void testSetWidthSatisfiesPrecondition() {
		Assert.assertEquals(WIDTH, rectangle.getWidth());
		int expectedWidth = WIDTH + 1;
		Assert.assertTrue(expectedWidth > 0);
		rectangle.setWidth(expectedWidth);
		Assert.assertEquals(expectedWidth, rectangle.getWidth());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetWidthViolatesPrecondition() {
		Assert.assertEquals(WIDTH, rectangle.getWidth());
		int negativeWidth = 0;
		Assert.assertFalse(negativeWidth > 0);
		rectangle.setWidth(negativeWidth);
	}

	@Test
	public void testGetAreaOfRectangle() {
		Assert.assertFalse(rectangle.isSquare());
		int expectedArea = rectangle.getWidth() * rectangle.getHeight();
		Assert.assertEquals(expectedArea, rectangle.getArea());
	}
	
	@Test
	public void testGetAreaOfSquare() {
		Assert.assertTrue(square.isSquare());
		int expectedArea = square.getWidth() * square.getHeight();
		Assert.assertEquals(expectedArea, square.getArea());
	}	

} // end of Rectangle
