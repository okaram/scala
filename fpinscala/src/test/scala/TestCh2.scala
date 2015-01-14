import org.scalatest._

import ch2.fib
class TestCh2 extends FlatSpec {
	"ch2.fib" should "return 1 when called with 0 or 1" in {
		assert( ch2.fib(0) === 1);
		assert( ch2.fib(1) === 1);
	}

	it should "return 13 when called with 6" in {
		assert( ch2.fib(6) == 13);
	}
}
