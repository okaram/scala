
object ch2 {
	def slow_fib(n:Int) : Int = {
		if(n<=1)
			1
		else
			fib(n-1)+fib(n-2)
	}

	def fib(n:Int) : Int = {
		@annotation.tailrec
		def fib_tr(n:Int, f1:Int, f2:Int) : Int = {
			if(n<=1) 
				f1
			else
				fib_tr(n-1,f1+f2,f1)
		}
		fib_tr(n,1,1)
	}

	def isSorted[A](arr:Array[A], ordered:(A,A)=>Boolean):Boolean = {
		var idx=0;
		for(idx <- 1 to arr.length) {
			if(!ordered(arr(idx-1),arr(idx)))
				return false;
		}
		return true;
	}
}
