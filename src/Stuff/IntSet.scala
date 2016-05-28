package Stuff

trait IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(that: IntSet): IntSet
  def intersect(other: IntSet): IntSet
  def isEmpty: Boolean
  def excl(x: Int): IntSet
}
case class EmptySet() extends IntSet {
  override def contains(x: Int): Boolean = false
  override def incl(x: Int): IntSet =
    new NonEmptySet(x, new EmptySet, new EmptySet)
  def union(that: IntSet): IntSet = that
  def intersect(other: IntSet): IntSet = other
  def isEmpty: Boolean = true
  def excl(x: Int) = throw new NoSuchElementException("EmptySetDummy")
}
case class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  override def contains(x: Int): Boolean =
    if (x < elem) left.contains(x)
    else if (x > elem) right.contains(x)
    else true

  override def incl(x: Int): IntSet = {
    if (x < elem) new NonEmptySet(elem, left.incl(x), right)
    else if (x > elem) new NonEmptySet(elem, left, right.incl(x))
    else this
  }

  def union(other: IntSet): IntSet =
    left.union(right).union(other).incl(elem)


  def intersect(other: IntSet): IntSet = {
    val newSet = new EmptySet
    if (other.contains(elem))
      newSet.incl(elem)
    right.intersect(other)
    left.intersect(other)
  }

  def isEmpty: Boolean = false

  def excl(x: Int): IntSet =
    if(x == elem) left.union(right)
    else if (x < elem) left.excl(x).union(right).incl(elem)
    else  left.union(right.excl(x)).incl(elem)

  override def toString(): String  = {
    print(elem + "::")
    right.toString
    left.toString
  }

}

object test extends App{


  val test = new NonEmptySet(0, new EmptySet, new EmptySet)
  val test2 = test.incl(1)
  val test3 = test2.incl(2)
  val test4 = test3.incl(3)
  val test5 = test4.incl(4)

  val test6 = new NonEmptySet(0, new EmptySet, new EmptySet)
  val test7 = test6.incl(2)
  val test8 = test7.incl(3)
  test5.toString
  test8.toString
  println()
  println(test5.intersect(test8).toString)
  val newTest = test5.excl(3)
  println(newTest.toString)
}