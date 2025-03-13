class Rectangle:
    def __init__(self, width=0, height=0):
        '''Creates a new rectangle with the given width and height
           where both the width and height are positive numbers.

           Parameters:
               width: The postive width of the new Rectangle
               heigth: The positive height of the new Rectangle
        '''
        if ((width <= 0) or (height <= 0)):
            raise ValueError("The width and height must be positive.")
        self.width = width
        self.height = height

    def getArea(self):
        return self.width * self.height

    def getPerimeter(self):
        return 2 * self.height + 2 * self.width

    def getWidth(self):
        return self.width
    
    def setWidth(self, width):
        '''Sets the width of this rectangle to the given positive number.

           Parameters:
               width: The positive width for this Rectangle
        '''
        if (width < 0):
            raise ValueError("The width must be a positive number.")
        self.width = width

    def getHeight(self):
        return self.height
        
    def setHeight(self, height):
        '''Sets the height of this rectangle to the given positive number.

           Parameters:
               heigth: The positive height for this Rectangle
        '''
        if (height <= 0):
            raise ValueError("The height must be a positive number.")
        self.height = height

    def isSquare(self):
        ''' Returns whether or not this Rectangle is square.
        
            Returns:
               True if this Rectangle is square and false otherwise.
        '''
        return self.getWidth() == self.getHeight()

    def __str__(self):
        return "Rectangle(width=" + str(self.getWidth()) + ",height=" + str(self.getHeight()) + ")" 
