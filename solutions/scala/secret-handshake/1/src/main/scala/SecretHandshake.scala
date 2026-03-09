import scala.annotation.tailrec
object SecretHandshake {
  def commands(code: Int): List[String] = {

    val handshakes = Array(
      "",
      "wink",
      "double blink",
      "",
      "close your eyes",
      "",
      "",
      "",
      "jump"
    )

    @tailrec
    def recX(
      i: Int,
      acc: List[String],
      fnt: Int => Boolean,
      fns: Int => Int): List[String] = {

      if (fnt(i)) return acc

      val acc2 = if ((code & i) != 0) handshakes(i) :: acc else acc
      recX( fns(i), acc2, fnt, fns)
    }

    if ((code & 16) != 0)
      // Reverse. Recursively shift left
      recX(1, Nil, _ > 8, _ << 1) 
    else
      // Forward. Recursivley shift right
      recX(8, Nil, _ == 0, _ >> 1)
  }
} 
