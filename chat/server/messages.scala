// message classes 
package chat {
    package messages {
        case class Register(username:String);
        case class SendMessage(t:String, msg:String);
        case class MessageReceived(from:String, msg:String);
    }
}
