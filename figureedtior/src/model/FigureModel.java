package model;

import javax.swing.ImageIcon;


public class FigureModel 
{
    public ImageIcon getImage() {
	//TODO
	return null;
    }

    /**
     * Sets the image to the given non-null ImageIcon.
     *
     * @param newImage The ImageIcon must be non-null
     *
     * @throws IllegalArgumentException if the ImageIcon is null
     */
    public void setImage(ImageIcon newImage) {
	//TODO
    }

    public String getCaption() {
	//TODO
	return null;
    }

    /**
     * Sets the caption to the given non-null and non-empty String.
     *
     * @param newCaption The String must be non-null and non-empty
     *
     * @throws IllegalArgumentException if the String is null or empty
     */
    public void setCaption(String newCaption) {
	//TODO
    }

    /**
     * Returns true if this figure is complete, meaning its Image 
     * is non-null and its caption is non-null and non-empty, and
     * false otherwise.
     *
     * @return True if this figure is complete and false otherwise
     */
    public boolean isComplete() {
	//TODO
	return false;
    }
}
