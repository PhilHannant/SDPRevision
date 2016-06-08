package mockStuff

/**
  * Created by philhannant on 03/06/2016.
  */
object personTest extends App{


  def all_except_option(str: String, lst: List[String]): Option[List[String]] = lst match {
    case Nil => None
    case (head :: tail) => {
      if (head == str) Some(lst.filter(_ != str))
      else all_except_option(str, tail).map(head +: _)
    }
  }



  def get_substitutions1(subsitutions: List[List[String]], s: String): List[String] = subsitutions match {
    case Nil => List.empty
    case (head :: tail) => all_except_option(s, head) match {
      case None => get_substitutions1(tail, s)
      case Some(result) => result ::: get_substitutions1(tail, s)
    }
  }

  def get_substitutions2(subsitutions: List[List[String]], s: String): List[String] = {

    def iter(subsitutions: List[List[String]], result: List[String]): List[String] = subsitutions match {
      case Nil => result
      case head :: tail => iter(tail, result ::: all_except_option(s, head).getOrElse(List.empty))
    }

    iter(subsitutions, List.empty)
  }

  case class Person(first: String, middle: String, last: String)


  def similar_names(names: List[List[String]], person: Person): List[Person] = {
    val newFirsts1 = get_substitutions2(names, person.first)
    val nameList = List.empty


    def newFirsts(nameList: List[String], retList: List[Person]): List[Person] = nameList match {
      case Nil => retList
      case head :: tail => newFirsts(tail, retList ::: createPerson(head, person.middle, person.last))
    }

    newFirsts(newFirsts1, nameList)

  }



  def createPerson(first: String, middle: String, last: String): List[Person] = {
    val per = List(Person(first, middle, last))
    per
  }

  val listTest = List(List("Fred","Fredrick"), List("Elizabeth","Betty"),
    List("Freddie","Fred","F"))
  val per = Person(first="Fred", middle="W", last="Smith")
println(similar_names(listTest, per))
  println(all_except_option("fred", List("fred", "james", "john")))
}
