package week2
import math.abs

object exercise2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(382); 
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
		};System.out.println("""sum: (f: Int => Int)(Int, Int) => Int""");$skip(29); 

		def sumInts = sum(x => x);System.out.println("""sumInts: => (Int, Int) => Int""");$skip(38); 
		def sumCubes = sum( x => x * x * x);System.out.println("""sumCubes: => (Int, Int) => Int""");$skip(36); val res$0 = 
		
		sum ( x => x * x * x ) (1, 10);System.out.println("""res0: Int = """ + $show(res$0));$skip(110); 
		
		
		def product(f: Int => Int)(a: Int, b: Int): Int =
			if (a > b) 1
			else f(a) * product(f)(a + 1, b);System.out.println("""product: (f: Int => Int)(a: Int, b: Int)Int""");$skip(32); val res$1 = 
			
		product( x => x * x)(3,4);System.out.println("""res1: Int = """ + $show(res$1));$skip(46); 
		
		def fact(n: Int) = product(x => x)(1, n);System.out.println("""fact: (n: Int)Int""");$skip(13); val res$2 = 
		
		fact(4);System.out.println("""res2: Int = """ + $show(res$2));$skip(182); 
		
		def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
			if(a > b) zero
			else combine( f(a), mapReduce(f, combine, zero)(a + 1, b))
		};System.out.println("""mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int)Int""");$skip(93); 
		
		def product2(f: Int=> Int)(a: Int, b: Int): Int = mapReduce(f, (x,y) => x * y, 1)(a, b);System.out.println("""product2: (f: Int => Int)(a: Int, b: Int)Int""");$skip(76); val res$3 = 
                                                  
    product(x => x)(3,4);System.out.println("""res3: Int = """ + $show(res$3))}
    
    
}
