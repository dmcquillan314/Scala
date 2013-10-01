package week3

object rationals {
	val x = new Rational(1, 3)                //> x  : week3.Rational = 1/3
	val y = new Rational(5, 7)                //> y  : week3.Rational = 5/7
	val z = new Rational(3, 2)                //> z  : week3.Rational = 3/2
	x.numer                                   //> res0: Int = 1
	x.denom                                   //> res1: Int = 3
	x + y                                     //> res2: week3.Rational = 22/21
	-x                                        //> res3: week3.Rational = 1/-3
	
	x - y - z                                 //> res4: week3.Rational = -79/42
	
	y + y                                     //> res5: week3.Rational = 10/7
	
	x < y                                     //> res6: Boolean = true
	x max y                                   //> res7: week3.Rational = 5/7
	
	val strange = new Rational(1, 0)          //> java.lang.IllegalArgumentException: requirement failed: denominator must not
                                                  //|  be zero
                                                  //| 	at scala.Predef$.require(Predef.scala:233)
                                                  //| 	at week3.Rational.<init>(week3.rationals.scala:24)
                                                  //| 	at week3.rationals$$anonfun$main$1.apply$mcV$sp(week3.rationals.scala:19
                                                  //| )
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at week3.rationals$.main(week3.rationals.scala:3)
                                                  //| 	at week3.rationals.main(week3.rationals.scala)
	strange + strange
}

class Rational(x: Int, y: Int) {
	require(y != 0, "denominator must not be zero")

	def this(x: Int) = this(x, 1)

	private def gcd(a: Int, b: Int): Int = if( b == 0) a else gcd(b, a % b)
	val numer = x / gcd(x, y)
	val denom = y / gcd(x, y)
	
	def <( that: Rational ) = numer * that.denom < that.numer * denom
	
	def max(that: Rational) = if(this < that) that else this
	
	def +(that: Rational) =
		new Rational( numer * that.denom + that.numer * denom,
									denom * that.denom)
	
	def unary_- : Rational = new Rational(numer * -1, denom)
	
	def -(that: Rational) =
		this + -that
	
	override def toString = numer + "/" + denom
}