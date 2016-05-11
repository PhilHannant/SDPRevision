//package wk8
//
//sealed trait IntList {
//
//  def fold[T](end: T, f: (Int, T) => T): T =
//    this match {
//      case End => end
//      case Pair(hd, tl) => f(hd, tl.fold(end, f))
//    }
//
//  def length: Int =
//    fold(0, (_, tl) => 1 + tl)
//
//
//  def product: Int =
//    fold(0, (hd, tl) => hd * tl)
//
//  def sum: Int =
//    fold(0, (hd, tl) => hd + tl)
//
//  def double: IntList =
//    fold[IntList](End, (hd, tl) => Pair(hd * 2, tl.double))
//
//
//  final case object End extends IntList
//
//  final case class Pair(head: Int, tail: IntList) extends IntList
//
//}