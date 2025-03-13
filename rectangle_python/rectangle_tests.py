from rectangle import Rectangle
import unittest

WIDTH = 3
HEIGHT = 2

class RectangleTests(unittest.TestCase):

    def setUp(self):
        self.rectangle = Rectangle(WIDTH,HEIGHT)
        self.square = Rectangle(WIDTH,WIDTH)

    def tearDown(self):
        self.rectangle = None
        self.square = None
        
    def test_new_rectangle_satisfies_preconditions(self):
        # Check pre-conditions
        self.assertTrue(WIDTH >= 0)
        self.assertTrue(HEIGHT >= 0)
        # Call the unit under test (See the setUp)
        # Check the post-conditions
        self.assertIsNotNone(self.rectangle)
        self.assertEqual(WIDTH, self.rectangle.getWidth())
        self.assertEqual(HEIGHT, self.rectangle.getHeight())

    def test_new_rectangle_violates_preconditions(self):
        # Check pre-conditions
        negative_width = - WIDTH
        self.assertFalse(negative_width >= 0)
        self.assertTrue(HEIGHT >= 0)
        with self.assertRaises(ValueError):
            # Check the pre-condition above
            new_rectangle = Rectangle(negative_width,HEIGHT)

    def test_is_square_returns_true(self):
        # Check pre-conditions (See the setUp)
        self.assertIsNotNone(self.square)
        self.assertEqual(WIDTH, self.square.getWidth())
        self.assertEqual(WIDTH, self.square.getHeight())
        # Call the system under test
        is_square_result = self.square.isSquare()
        # Check the post-conditions
        self.assertTrue(is_square_result)

    def test_set_width_satisfies_precondition(self):
        # Check the pre-conditions
        self.assertEqual(WIDTH, self.rectangle.getWidth())
        expected_width = WIDTH + 1
        self.assertTrue(expected_width >= 0)
        # Call the unit under test
        self.rectangle.setWidth(expected_width)
        # Check the pre-conditions
        self.assertEqual(expected_width, self.rectangle.getWidth())

    def test_set_width_violates_precondition(self):
        # Check the pre-conditions
        self.assertEqual(WIDTH, self.rectangle.getWidth())
        negative_width = 0
        self.assertFalse(negative_width > 0)
        # Call the unit under test
        with self.assertRaises(ValueError):
            # Check the pre-condition above
            self.rectangle.setWidth(negative_width)
        
if __name__ == '__main__':
    unittest.main(verbosity=2)
