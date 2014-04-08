// represents a deterministic finite automata
class DFA[StateType]
(
    Q:Set[StateType],
    F:Set[StateType],
    q0:StateType, 
    delta: (StateType,Char)=>StateType,
    Sigma:Set[Char]
)
{
    private def accepts(state:StateType,input:List[Char]):Boolean ={
        input match {
            case Nil => F contains state
            case head::tail => accepts(delta(state,head),tail)
        }
    }
    def accepts(input:List[Char]):Boolean =accepts(q0,input)
}

// represents a non-deterministic finite automata
class NFA[StateType]
(
    Q:Set[StateType],
    F:Set[StateType],
    q0:StateType, 
    delta: (StateType,Char)=>Set[StateType],
    Sigma:Set[Char]
)
{

//    def accepts(input:List[Char]):Boolean =accepts(q0,input)    
}


object Main {
    // sample DFA transition function
    def f1(state:Int,inp:Char)={
        state match {
            case 1=>
                if(inp=='a') 1 else 2;
            case 2=>
                if(inp=='a') 3 else 1;
            case 3=> 3
        }
    }
    
    def main(args:Array[String]) {
        val Q=Set(1,2,3);
        val F=Set(3);
        val d=new DFA(Q,F,1,f1,Set('a','b'));
        println(d.accepts(List('b','a')));
    }
}