// ChatServer.scala
import akka.actor.{ActorSystem, ActorLogging, Actor, Props,ActorRef}

import chat.messages._

class ChatServer extends Actor with ActorLogging {
    var users=collection.mutable.Map[String,ActorRef]();
    def receive = {
        case Register(username) => {
            log.info("registered: "+username);
            register(username,sender);
        }
        case SendMessage(to,msg) =>
            send(to,msg)
    }
    
    def register(username:String, sender:ActorRef)={
        users.put(username,sender);
    }
    
    def send(to:String, msg:String)={
        if(users.contains(to)) {
            users(to) ! MessageReceived("anon",msg);
        }    
    }
}