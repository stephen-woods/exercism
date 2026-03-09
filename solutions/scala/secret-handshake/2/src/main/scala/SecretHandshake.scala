import scala.annotation.tailrec
object SecretHandshake {
  def commands(code: Int): List[String] = {

    def prepend(v: Vector[String], x: String) = v.prepended(x)
    def append(v: Vector[String], x: String) = v.appended(x)

    val handshakes = Array("wink", "double blink", "close your eyes", "jump")

    val fn = if ((code & 16) != 0) prepend else append

    (0 until handshakes.length)
      .foldLeft(Vector.empty: Vector[String]) { case (acc, i) =>
        if ((code & 1 << i) != 0) fn(acc, handshakes(i)) else acc
      }
      .toList
  }
}
