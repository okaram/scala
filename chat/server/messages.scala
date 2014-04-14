// message classes 
package chat {
    package messages {
        case class Register(username:String);
        case class SendMessage(t:String, msg:String);
        case class MsgReceived(from:String, msg:String);
    }
}
