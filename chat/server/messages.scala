// message classes 
import akka.actor.{ActorRef}
package chat {
    package messages {
        case class Registration(username:String);
        case class Register(username:String,server:ActorRef);
        case class SendMessage(t:String, msg:String);
        case class MessageReceived(from:String, msg:String);
    }
}
