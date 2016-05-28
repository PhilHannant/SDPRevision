def flatten[A](as: List[List[A]]): List[A] = as match{
  case Nil => Nil
  case xs :: bs => xs ::: flatten(bs)
}

List[List[Int]](List(1,2,3,4), List(12,3,4)).flatten
