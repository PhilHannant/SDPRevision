def all_except_option(str: String, lst: List[String]): Option[List[String]] = lst match {
  case Nil => None
  case (head :: tail) => {
    if (head == str) Some(lst.filter(_ != str))
    else all_except_option(str, tail)
  }
  }



def get_substitutions1(subsitutions: List[List[String]], s: String): List[String] = subsitutions match {
  case Nil => List.empty
  case (head :: tail) => all_except_option(s, head) match {
    case None => get_substitutions1(tail, s)
    case Some(result) => result ::: get_substitutions1(tail, s)
  }

  }




val listTest = List(List("Fred","Fredrick"), List("Elizabeth","Betty"),
  List("Freddie","Fred","F"))
get_substitutions1(listTest, "Fred")

List(List(1), List(1, 1), List(1, 1, 1), List(1, 1, 1, 1))
.filter(x => x.length > 1).map(x => x.reduceRight((a,b) => a * b))

List(List(1,1,1), List(1,1,1), List(1,1,1), List(1,1,1)).map(x => x.reduceLeft((a,b) => a * b))
//lst.find(x => x == str) match {
//  case None => None
//  case Some(result) => Some(lst.filter(_ != str))
//}


  def flatten(lst: List[_]): List[Any] = lst match {
    case Nil => Nil
    case (head: List[_]) :: tail => flatten(head) ::: flatten(tail)
    case head :: tail => head :: flatten(tail)
  }

  val lst = List(1, 2, List("w", "w", List(34,6),8), 12, List(6, 7))
  println(lst)
  println(flatten(lst))

