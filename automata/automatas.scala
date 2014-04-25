// represents a deterministic finite automata
class DFA[StateType]
(
    val Q:Set[StateType],
    val F:Set[StateType],
    val q0:StateType, 
    val delta: (StateType,Char)=>StateType,
    val Sigma:Set[Char]
)
{
    private def accepts(state:StateType,input:List[Char]):Boolean ={
        input match {
            case Nil => {
//                println("Empty list -- "+state.toString);
                F contains state
            }
            case head::tail => {
//                println("Inp="+head+"\tState ="+state.toString);
                accepts(delta(state,head),tail)
            }
        }
    }
    def accepts(input:List[Char]):Boolean =accepts(q0,input)
}

// represents a non-deterministic finite automata
class NFA[StateType]
(
    val Q:Set[StateType],
    val F:Set[StateType],
    val q0:StateType, 
    val delta: (StateType,Char)=>Set[StateType],
    val Sigma:Set[Char]
)
{
    private def accepts(states:Set[StateType],input:List[Char]):Boolean ={
        input match {
            case Nil => !(F intersect states).isEmpty
            case head::tail => accepts(states flatMap ((state:StateType)=>delta(state,head)),tail)
        }
    }
    def accepts(input:List[Char]):Boolean =accepts(Set(q0),input)    

}


object Main {
    // sample DFA transition function
    def dfa1_delta(state:Int,inp:Char)={
        state match {
            case 0=>
                if(inp=='a') 0 else 1;
            case 1=>
                if(inp=='a') 2 else 1;
            case 2=> 2
        }
    }
    
    def nfa1_delta(state:Int, inp:Char)={
        state match {
            case 0=> Set(0,1);
            case 1=> Set(2);
            case 2=> Set[Int]();
        }
    }

    def power[A](t: Set[A]): Set[Set[A]] = {
        @annotation.tailrec 
        def pwr(t: Set[A], ps: Set[Set[A]]): Set[Set[A]] =
            if (t.isEmpty) ps
            else pwr(t.tail, ps ++ (ps map (_ + t.head)))

        pwr(t, Set(Set.empty[A])) //Powerset of ∅ is {∅}
    }
    
    def NFAtoDFA[StateType](n:NFA[StateType]):DFA[Set[StateType]]={
        def delta(states:Set[StateType],inp:Char):Set[StateType]=states flatMap ((state:StateType)=>n.delta(state,inp));
        val Q=power(n.Q);
        val F=for(s <- Q if !(s intersect n.F).isEmpty) yield s;
        new DFA(Q,F,Set(n.q0),delta,n.Sigma);
    }

    def main(args:Array[String]) {
        val Q=Set(0,1,2);
        val F=Set(2);
        val d=new DFA(Q,F,0,dfa1_delta,Set('a','b'));
        println(d.accepts(List('b','a')));
        val n=new NFA[Int](Q,F,0,nfa1_delta,Set('a','b'));
        println(n.accepts(List('a')));
        println(n.accepts(List('a','b')));
        
        val d2=NFAtoDFA(n);
        println(d2.accepts(List('a')));
        println(d2.accepts(List('a','b')));
    }
}