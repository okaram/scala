object PlayWithIris {
    
    def main(args:Array[String])
    {
        val freqs=collection.mutable.Map[String,Int]();
        val tags=for(line <- scala.io.Source.fromFile("iris.txt").getLines if line.split("\t").length>=4) yield line.split("\t")(4);
        tags.foreach((tag)=>freqs(tag)=freqs.getOrElse(tag,0)+1);
        println(freqs.getOrElse("I.setosa",0)+" "+freqs.getOrElse("I.versicolor",0)+" "+freqs.getOrElse("I.virginica",0));
    }
}