// examples from http://www.reactive.io/tips/2014/03/28/getting-started-with-actor-based-programming-using-scala-and-akka/
import akka.actor.{ActorSystem, ActorLogging, Actor, Props}

case object Pint

class Person(name:String) extends Actor with ActorLogging {
    def receive = {
        case Pint => log.info("I'm "+name+" Thanks for the pint")
    }
}

object HowdyAkka extends App {
    val system = ActorSystem("howdy-akka")

    val alice = system.actorOf(Props(new Person("Alice")), "Alice")
    val bob = system.actorOf(Props(new Person("Bob")), "Bob")
        

    alice ! Pint
    bob ! Pint
        
    system.shutdown()
}