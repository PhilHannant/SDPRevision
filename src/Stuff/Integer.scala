package Stuff

/**
  * Created by philhannant on 28/05/2016.
  */

abstract class Integer {
  def isZero: Boolean
  def predecessor: Integer
  def successor: Integer
  def +(that: Integer): Integer
  def -(that: Integer): Integer
}

class Succ(x: Integer) extends Integer {
  override def isZero: Boolean = false
  override def predecessor: Integer = x
  override def successor: Integer = new Succ(this)
  override def +(that: Integer): Integer = x + that.successor
  override def -(that: Integer): Integer = x - that.predecessor
}
object Zero extends Integer {
  override def isZero: Boolean = true
  override def predecessor: Integer = sys.error("negative number")
  override def successor: Integer = new Succ(Zero)
  override def +(that: Integer): Integer = that
  override def -(that: Integer): Integer = if (that.isZero) Zero
  else sys.error("negative number")
}