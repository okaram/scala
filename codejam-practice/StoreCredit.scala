// https://code.google.com/codejam/contest/351101/dashboard#s=p0
object StoreCredit extends App {
    
    
    def processTestCase(i:Int, lines:Iterator[String]):Unit = {
        val totMoney=lines.next().toInt
        
        val numProducts=lines.next().toInt
        val prices=lines.next().split(" ").map(_.toInt)
        
        for(n1<-prices; n2<-prices) {
            if(n1+n2==totMoney) {
                println("Case #%d: %d %d".format(i,n1,n2));
                return;
            }
        }
    }
    
    val lines = scala.io.Source.fromFile(args(0)).getLines;
    val numCases=lines.next().toInt
    (1 to numCases).foreach(i => processTestCase(i,lines));
    println(numCases);
}
