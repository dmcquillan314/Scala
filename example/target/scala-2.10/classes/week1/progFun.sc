package week1

object progFun {
  1 + 3                                           //> res0: Int(4) = 4
  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double
  
 		
  def sqrt(x: Double) = {
  
	  def sqrtIter( guess: Double): Double =
	  	if (isGoodEnough(guess)) guess
	  	else sqrtIter(improve(guess))
	  	
	 	def isGoodEnough(guess: Double ) =
	 		abs(guess * guess - x) / x < 0.001
	 		
	 	def improve(guess: Double) =
	 		(guess + x / guess) / 2
	 		
  	sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double
  
  sqrt(2)                                         //> res1: Double = 1.4142156862745097
  
  sqrt(4)                                         //> res2: Double = 2.000609756097561
}