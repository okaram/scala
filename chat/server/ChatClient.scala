// ChatServer.scala
import akka.actor.{ActorSystem, ActorLogging, Actor, Props,ActorRef}

import chat.messages._

class ChatClient(var server:ActorRef) extends Actor with ActorLogging {
    def receive = {
        case MessageReceived(from,msg) =>
            println(msg);
        case Register(username,_server)=>
            server=_server;
            server ! Registration(username);
        case SendMessage(to,msg) =>
            server ! SendMessage(to,msg);
    }       
}

object Client extends App {
    val system = ActorSystem("chat-client")
    val client = system.actorOf(Props(new ChatClient(null)), "client")
    val server=client.actorOf()
    val msg=readLine();
    println(msg);
}