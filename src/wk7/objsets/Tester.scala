package wk7.objsets

/**
  * Created by sa837 on 20/05/2016.
  */
object Tester extends App{


  val set1 = new Empty
  val set2 = set1.incl(new Tweet("a", "a body", 20))
  val set3 = set2.incl(new Tweet("b", "b body", 20))
  val c = new Tweet("c", "c body", 7)
  val set4c = set3.incl(c)
  set4c.filter(tw => tw.retweets > 10)

}
