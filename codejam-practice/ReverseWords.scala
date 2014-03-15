// https://code.google.com/codejam/contest/351101/dashboard#s=p1

import java.io.PrintWriter
    
object ReverseWords extends App {
    
    
    def processTestCase(i:Int, lines:Iterator[String], out:PrintWriter ):Unit = {
        val words=lines.next().split(" ")
        val rev=words.reverse.fold(""){_+" "+_}
        
        out.println("Case #%d:%s".format(i,rev));
    }
    
    val lines = scala.io.Source.fromFile(args(0)).getLines;
    val out=new PrintWriter(args(1))
    val numCases=lines.next().toInt
    (1 to numCases).foreach(i => processTestCase(i,lines,out));
    out.close
}
