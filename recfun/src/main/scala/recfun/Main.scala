package recfun
import common._
import scala.collection.mutable._

object Main {
  def main(args: Array[String]) {
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    def go(chars: List[Char], open: Int): Boolean = chars match {
      case Nil => open == 0
      case '(' :: tail => go(tail, open + 1)
      case ')' :: tail => open > 0 && go(tail, open - 1) 
      case _   :: tail => go(tail, open)
    }
    
    go( chars, 0 )
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if ( money == 0 ) 1
    else if ( money < 0 ) 0
    else if ( coins.isEmpty ) 0
    else countChange( money - coins.head, coins ) + countChange( money, coins.tail )
  }
}
