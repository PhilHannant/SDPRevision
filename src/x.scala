

import atomic.AtomicTest._


/**
  * Created by philhannant on 18/04/2016.
  */
object x extends App {



  val r1 = Range(0, 10)

  val total = {
    var x = 0;
    for (i <- 1 to 10) {
      x = x + i
    }
  }
  total is 55


  var totalEvens = {
    var x = 0
    for (i <- 1 to 10) {
      if (i % 2 == 0)
        x = x + i
    }
  }

  totalEvens is 30


  var evens = {
    var even = 0
    var odd = 0
    for (i <- 1 to 10) {
      if (i % 2 == 0)
        even = even + 1
      else
        odd = odd + 1
    }
    even
  }

  evens is 30


  def sentence = {
    val vec = Vector("The", "dog", "visited", "the", "firehouse")
    var str = ""
    vec.foreach((str1: String) => str = str + str1 + " ")
    str
  }

  val sent = sentence
  sent.toString() is "The dog visited the firehouse "

  val theString = sent.toString.replace("firehouse ", "firehouse!")
  theString is "The dog visited the firehouse!"

  def sentenceRev = {
    val vec = Vector("The", "dog", "visited", "the", "firehouse")
    var str = ""
    vec.foreach((str1: String) => str = str + str1.reverse + " ")
    str
  }

  val sent2 = sentenceRev
  sent2 is "ehT god detisiv eht esuoherif "

  def sentence2 = {
    val vec = Vector("The", "dog", "visited", "the", "firehouse")
    var str = ""
    vec.foreach((str1: String) => str = str1 + " " + str)
    str
  }

  val sent3 = sentence2
  sent3 is "firehouse the visited dog The "

  val ints = Vector(1, 2, 3, 4)
  val doubles = Vector(1.2, 2.2, 2.3, 2.4)

  println(ints.sum)
  println(doubles.sum)
  println(ints.min)
  println(doubles.min)
  println(ints.max)
  println(doubles.max)

  val vec = Vector("The", "dog", "visited", "the", "firehouse")
  //  println(vec.sum)
  println(vec.min)
  println(vec.max)

  val ran = 1 to 10
  println(ran.sum)

  def palindrome(str: String) = {
    if (str.equals(str.reverse)) true
    else false
  }

  palindrome("mum") is true
  palindrome("dad") is true
  palindrome("street") is false


  def forecast(int: Int): Any = int match {
    case 100 => "Sunny"
    case 80 => "Mostly Sunny"
    case 50 => "Partly Sunny"
    case 20 => "Mostly Cloudy"
    case 0 => "Cloudy"
    case _ => "Unknown"
  }

  forecast(100) is "Sunny"
  forecast(80) is "Mostly Sunny"
  forecast(50) is "Partly Sunny"
  forecast(20) is "Mostly Cloudy"
  forecast(0) is "Cloudy"
  forecast(15) is "Unknown"


  class SimpleTime(val hours: Int, val minutes: Int) {
  }

  val t = new SimpleTime(hours = 5, minutes = 30)
  t.hours is 5
  t.minutes is 30

  class SimpleTime2(val hours: Int, val minutes: Int = 0) {
  }

  val t2 = new SimpleTime2(hours = 10)
  t2.hours is 10
  t2.minutes is 0

  class Planet(name: String, descriptions: String, moons: Int) {
    def hasMoon = {
      var bo = false
      if (moons > 0)
        bo = true
      bo
    }
  }


  val p = new Planet(name = "Mercury", descriptions = "small and hot planet", moons = 0)
  p.hasMoon is false
}

case class Person(first: String, last: String, email: String) {



}

case class Name(firstName: String, lastName: String)

object test extends App{
  val p = Person("Jane", "Smile", "jane@smile.com")
  p.first is "Jane"
  p.last is "Smile"
  p.email is "jane@smile.com"

  val people = Vector(
    Person("Jane","Smile","jane@smile.com"),
    Person("Ron","House","ron@house.com"),
    Person("Sally","Dove","sally@dove.com")
  )

  people(0) is "Person(Jane,Smile,jane@smile.com)"
  people(1) is "Person(Ron,House,ron@house.com)"
  people(2) is "Person(Sally,Dove,sally@dove.com)"

  val m = Map("sally@taylor.com"-> Name("Sally","Taylor"))
  m("sally@taylor.com") is Name("Sally", "Taylor")

  var m2 = Map("sally@taylor.com"-> Name("Sally","Taylor"), "jiminy@cricket.com" -> Name("Jiminy","Cricket"))
  m2("jiminy@cricket.com") is Name("Jiminy","Cricket")
  m2("sally@taylor.com") is Name("Sally", "Taylor")

  var language = Set("English", "French", "Spanish", "German", "Chinese")
//  val langauge = Set("English", "French", "Spanish", "German", "Chinese", "Turkish")
  language = language + "Turkish"
  println(language.toString())
  language = language + "French"
  println(language.toString())
  language = language - "Spanish"
  println(language.toString())

  m2 - "jiminy@cricket.com"
  println(m2.toString())

}



