/**
  * Created by Navi on 7/14/2017.
  */
object Solution {

  def drawTriangles(n :Int): Unit={
    /*** Variables ***/
    val row = 32
    val col = 63
    val limit = n + 1
    def downTriangle(i :Int, j :Int, size :Int):Char={
      val col_mod = math.abs(j - size/2)
      //print(col_mod)
      if(i >= (size + 1)/4){
        if(col_mod <= ((size + 1)/2 - i - 1)){
          '_'
        } else {
          '1'
        }
      } else {
        '1'
      }
    }

    def ST(row_1 :Int, col_1 :Int, level :Int = 1, char: Char = '1'):Char = level match{
      case `limit` => char
      case _ =>{
        val size: Int = col/math.pow(2,level - 1).toInt
        val c_shift: Int = size + 1
        val r_shift: Int = if(level == 1 || ((row_1/((size+1)/2))%2 == 1) ) col_1  else col_1 + c_shift/2
        val c_1: Int = r_shift - (c_shift*(r_shift/c_shift))
        val r_1: Int = row_1 % ((size +1) / 2)
        val ch: Char = downTriangle(r_1,c_1,size)
        if(ch == '1')
          ST(row_1,col_1,level+1,ch)
        else
          '_'
      }
    }

    for(i <- 0 until row){
      for(j <- 0 until col){
        if(i >= math.abs(j - (col/2))){
            print(ST(i,j))
        } else {
            print('_')
        }
      }
      println("")
    }

  }

  def main(args :Array[String]): Unit ={
      drawTriangles(scala.io.StdIn.readInt())
  }
}
