package week2
import math.abs

object exercise2 {
		/*def sum(f: Int => Int, a: Int, b: Int) = {
			def loop(a: Int, acc: Int): Int =
				if( a > b ) acc
				else loop(a + 1, f(a) + acc)
				
			loop(a, 0)
		}
		sum( x => x * x, 3, 4)*/
		
		def sum(f: Int => Int): (Int, Int) => Int = {
			def sumF(a: Int, b: Int): Int =
				if( a > b) 0
				else f(a) + sumF(a + 1, b)
			sumF
		}                                 //> sum: (f: Int => Int)(Int, Int) => Int

		def sumInts = sum(x => x)         //> sumInts: => (Int, Int) => Int
		def sumCubes = sum( x => x * x * x)
                                                  //> sumCubes: => (Int, Int) => Int
		
		sum ( x => x * x * x ) (1, 10)    //> res0: Int = 3025
		
		
		def product(f: Int => Int)(a: Int, b: Int): Int =
			if (a > b) 1
			else f(a) * product(f)(a + 1, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
			
		product( x => x * x)(3,4)         //> res1: Int = 144
		
		def fact(n: Int) = product(x => x)(1, n)
                                                  //> fact: (n: Int)Int
		
		fact(4)                           //> res2: Int = 24
		
		def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
			if(a > b) zero
			else combine( f(a), mapReduce(f, combine, zero)(a + 1, b))
		}                                 //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
		
		def product2(f: Int=> Int)(a: Int, b: Int): Int = mapReduce(f, (x,y) => x * y, 1)(a, b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
                                                  
    product(x => x)(3,4)                          //> res3: Int = 12
    
    
}