// for 3.25 and following

// from book; no nil tree allowed
sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A],right:Tree[A]) extends Tree[A]


object Tree {
	val t1=Branch( Leaf(3), Branch( Leaf(4), Leaf(5)))
	val t2=Branch(Leaf(7),t1)

	def size[A](t:Tree[A]):Int = {
		t match { 
			case Leaf(_) => 1
			case Branch(t1,t2) => size(t1)+size(t2)
		}
	}

	def max(t:Tree[Int]):Int = {
		t match {
			case Leaf(a) => a
			case Branch(t1,t2) => max(t1).max( max(t2) ) 
		}
	}
	
	def depth[A](t:Tree[A]):Int = {
		t match {
			case Leaf(a) => 1
			case Branch(t1,t2) => 1+( depth(t1) max depth(t2))
		}
	}

	def map[A,B](t: Tree[A], f: (A)=>B) : Tree[B] = {
		t match {
			case Leaf(a) => Leaf( f(a) )
			case Branch(t1,t2) => Branch( map(t1,f), map(t2,f))
		}
	}

	def fold[A,B](t:Tree[A], leaf_func:(A)=>B, combine:(B,B)=>B):B = {
		t match {
			case Leaf(a) => leaf_func(a)
			case Branch(t1,t2) => combine( fold(t1,leaf_func,combine), fold(t2,leaf_func,combine) )
		}
	} 

	def max2(t:Tree[Int]):Int = fold(t, (x:Int)=>x, (x:Int, y:Int)=>x max y)
	def depth2[A](t:Tree[A]):Int = fold(t, (x:A)=>1, (x:Int, y:Int)=>x.max(y)+1)
	def size2[A](t:Tree[A]):Int = fold(t, (x:A)=>1, (x:Int, y:Int) => x+y)
	

}
