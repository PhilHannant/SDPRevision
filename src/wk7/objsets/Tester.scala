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
  val test = set4c.filter(t => t.retweets > c.retweets)
  def highest(tweet1: Tweet, tweet2: Tweet) = {if(tweet1.retweets > tweet2.retweets) tweet1 else tweet2 }
  val look = set4c.descendingByRetweet


}
