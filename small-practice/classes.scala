trait Shape {
    def getArea: Int
    def getPerimeter: Int
}

class Triangle extends Shape {
    def getArea: Int = return 3
    def getPerimeter: Int= return 5
}

class Rectangle(base:Int, height: Int) extends Shape
{
    def getArea: Int = base*height;
    def getPerimeter:Int = 2*(base+height);
}



object Main {
    def main(args:Array[String]) {
        val t = new Triangle;
        println(t.getArea);
        val r = new Rectangle(3,5);
        println(r.getArea);
        
        val l =List(r,t);
        l.foreach(el=>println(el.getArea));
    }
}