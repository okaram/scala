// ChatServer.scala
import akka.actor.{ActorSystem, ActorLogging, Actor, Props,ActorRef}

import chat.messages._

class ChatServer extends Actor with ActorLogging {
    var users=collection.mutable.Map[String,ActorRef]();
  def receive = {
    case Register(username) => {
        log.info("registered: "+username);
        users.put(username,sender);
    }
    case SendMessage(t,msg) =>
        if(users.contains(t)) {
            users(t) ! MsgReceived("anon",msg);
        }
  }
    
}