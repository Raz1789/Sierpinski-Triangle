/**
  * Created by Navi on 7/14/2017.
  */
object Solution {

  def drawTriangles(n :Int): Unit={
    /*** Variables ***/
    val row = 32
    val col = 63
    val limit = n + 1

    //HELPER FUNCTION

    def downTriangle(i :Int, j :Int, size :Int):Char={
      val col_mod = math.abs(j - size/2)
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

    // Main function
    def ST(row_1 :Int, col_1 :Int, level :Int = 1, char: Char = '1'):Char = level match{
      case `limit` => char
      case _ =>{
        /*** Variables ***/
        //Size as the level increases
        val size: Int = col/math.pow(2,level - 1).toInt

        //shift in pattern due to column
        val c_shift: Int = size + 1
        //shift in pattern due to row
        val r_shift: Int = if(level == 1 || ((row_1/((size+1)/2))%2 == 1) ) col_1  else col_1 + c_shift/2

        //transforming the actual co-ordinates
        val c_1: Int = r_shift - (c_shift*(r_shift/c_shift))
        val r_1: Int = row_1 % ((size +1) / 2)

        //getting the character for the transformed co-ordinates
        val ch: Char = downTriangle(r_1,c_1,size)
        if(ch == '1')
          ST(row_1,col_1,level+1,ch)
        else
          '_'
      }
    }

    /*** MAIN FOR LOOP ***/
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
