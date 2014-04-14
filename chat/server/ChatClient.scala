// ChatServer.scala
import akka.actor.{ActorSystem, ActorLogging, Actor, Props,ActorRef}

import chat.messages._

class ChatClient extends Actor with ActorLogging {
    def receive = {
        case MessageReceived(from,msg) =>
            log.info("Receiving from:"+from+" : "+msg);
    }
        
    def send(to:String, msg:String)={
    }
}