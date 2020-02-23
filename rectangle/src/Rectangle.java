/**
 * The Rectangle class specifies a rectangle by its width and height.
 * Both the width and height must be positive numbers.
 */
public class Rectangle
{
	private int width;
	private int height;


	/**
	 * Creates a new rectangle with the given width and height
	 * where both the width and height are positive numbers.
	 * 
	 * @param width The width for the new rectangle
	 * @param height The height for the new rectangle
	 * 
	 * @throws IllegalArgumentException when either the width or height 
	 *         is a negative number
	 */
	public Rectangle(int width, int height) {
		super();

		if ((width <= 0) || (height <= 0)) {
			throw new IllegalArgumentException("The width and height must be positive.");
		}

		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return this.width;
	}

	/**
	 * Sets the width of this rectangle to the given positive number.
	 * 
	 * @param width The new width
	 * 
	 * @throws IllegalArgumentException when the width is a negative number
	 */
	public void setWidth(int width) {
		if (width < 0) {
			throw new IllegalArgumentException("The width must be a positive number.");
		}
		
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	/**
	 * Sets the height of this rectangle to the given positive number.
	 * 
	 * @param height The new height
	 * 
	 * @throws IllegalArgumentException when the height is a negative number
	 */
	public void setHeight(int height) {
		if (height <= 0) {
			throw new IllegalArgumentException("The height must be positive.");
		}		
		
		this.height = height;
	}

	/**
	 * Gets the area of this rectangle.
	 * 
	 * @return The area
	 */
	public int getArea() {
		return this.getWidth() * this.getWidth();
	}

	/**
	 * Returns true if this rectangle is a square and
	 * false otherwise.
	 * 
	 * @return True if a square and false otherwise
	 */
	public boolean isSquare() {
		return this.getWidth() == this.getHeight();
	}

	public boolean equals(Object obj2) {
		if (obj2 == null) {
			return false;
		}

		if (! (obj2 instanceof Rectangle)) {
			return false;
		}

		Rectangle rec2 = (Rectangle)obj2;

		if (rec2.getWidth() != this.getWidth()) {
			return false;
		}

		if (rec2.getHeight() != this.getHeight()) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		return this.toString().hashCode();
	}

	public String toString() {
		String toReturn =
				"Square(" +
						"width=" + this.getWidth() +
						", height=" + this.getHeight() +
						")";

		return toReturn;
	}
}
