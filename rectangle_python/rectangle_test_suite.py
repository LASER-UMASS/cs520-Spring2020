from rectangle_tests import RectangleTests
import unittest

def RectangleTestSuite():
    suite = unittest.TestSuite()
    suite.addTest(RectangleTests('test_new_rectangle_satisfies_preconditions'))
    suite.addTest(RectangleTests('test_new_rectangle_violates_preconditions'))
    suite.addTest(RectangleTests('test_is_square_returns_true'))
    suite.addTest(RectangleTests('test_set_width_satisfies_precondition'))
    suite.addTest(RectangleTests('test_set_width_violates_precondition'))
    return suite

if __name__ == '__main__':
    runner = unittest.TextTestRunner()
    runner.run(RectangleTestSuite())