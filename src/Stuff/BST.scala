package Stuff

abstract class BST

case class Node(left: BST, value: Int, right: BST) extends BST

case class Empty() extends BST

object BST {
  def insert(x: Int, t: BST): BST = {
    t match {
      case Empty() => Node(Empty(), x, Empty())
      case Node(left, value, right) =>
        if (x < value) Node(left, value, insert(x, right))
        else if (value < x) Node(insert(x, left), value, right)
        else t
    }
  }

  def lookup(x: Int, t: BST): Boolean = t match {
    case Empty() => false
    case Node(l, v, r) => {
      if(x == v) true
      else if (x < v) lookup(x, l)
      else lookup(x, r)
    }
  }

}