from rectangle import Rectangle

def main():
    a = Rectangle(5, 7)
    print(str(a))
    print("area:      %s" % a.getArea())
    print("perimeter: %s" % a.getPerimeter())

    s = Rectangle(6,6)
    print(str(s))
    s.setWidth(0)
    
main()
