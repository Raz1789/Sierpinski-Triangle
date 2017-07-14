/**
  * Created by Navi on 7/14/2017.
  */
object Solution {

  def drawTriangles(n :Int): Unit={
    /*** Variables ***/
    val row = 32
    val col = 63
    val limit = n + 1

    def ST(row_1 :Int, col_1 :Int, level :Int, char: Char):Char = level match{
      case 0 =>{
        ST(row_1, col_1,level+1,'1')
      }
      case `limit` => char
      case _ =>{
        ST(row_1, col_1,level+1,'1')
      }
    }

    for(i <- 0 until row){
      for(j <- 0 until col){
        if(i < math.abs(j - (col/2))){

        }
      }
    }

  }

  def main(args :Array[String]): Unit ={
      drawTriangles(scala.io.StdIn.readInt())
  }
}
