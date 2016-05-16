import atomic.AtomicTest._

sealed trait Shape{
  def sides:Int
  def perimeter:Double
  def area:Double
  def colour: Colour
}


case class Circle(r: Int, colour: Colour) extends Shape{

  def sides: Int = {
    1
  }

  def perimeter: Double = {
    2 * r * math.Pi
  }

  def area: Double = {
    r * r * math.Pi
  }

  def colour: Colour = {
    this.colour = colour
  }
}

case class Square(x: Int) extends Shape{

  def sides: Int = {
    4
  }
  def perimeter: Double = {
    4 * x
  }

  def area: Double = {
    x * x
  }

  def colour: Colour = this.colour
}

case class Rectangle(w: Int, l: Int) extends Shape{

  def sides: Int = {
    4
  }

  def perimeter: Double = {
    w + w + l + l
  }

  def area: Double = {
    w * l
  }
  def colour: Colour = this.colour
}

abstract class Rectangular extends Shape {
  def sides: Int = {
    4
  }
}
case class Square2(x: Int) extends Rectangular{

  def perimeter: Double = {
    4 * x
  }

  def area: Double = {
    x * x
  }
  def colour: Colour = this.colour
}

case class Rectangle2(w: Int, l: Int) extends Rectangular{


  def perimeter: Double = {
    w + w + l + l
  }

  def area: Double = {
    w * l
  }
  def colour: Colour = this.colour
}



object Draw {
  def apply(shape: Shape): String = shape match {
    case circle: Circle => "A circle has a radius " + circle.r + "colour is " + circle.colour
    case square: Square => "A square has 4 sides = " + square.x + "colour is " + square.colour
    case rectangle: Rectangle => "A rectangle has a width: " + rectangle.w + " and a length: " + rectangle.l + "colour is " + rectangle.colour
  }

  def getColour(shape: Shape): String = shape.colour match {
    case r: Red => "Red"
    case y: Yellow => "Yellow"
    case p: Pink => "Pink"
    case  c: custom => lightDark(c)
  }
}

val d = Draw
d.apply(Circle(10)) is "A circle of radius 10cm"
d.apply(Square(12)) is "A Square of width 12cm"
d.apply(Rectangle(11, 9)) is "A Rectangle of height 9cm and length 11cm"


sealed trait Colour {

  var R = 0
  var G = 0
  var B = 0
}
  class Red extends Colour {
    R = 255
    G = 0
    B = 0
  }

  class Yellow extends Colour {
    R = 255
    G = 256
    B = 0
  }

  class Pink extends Colour {
    R = 192
    G = 256
    B = 203
  }

  class custom(r: Int, g: Int, b: Int) extends Colour {
      this.R = r
      this.G = g
      this.B = b
  }

def lightDark(colour: Colour): String = {
  val colList = List(colour.B, colour.G, colour.R)
  if (colList.reduce((sum, n) => sum + n) > (255*3/2)) "dark"
  else "light"
}


