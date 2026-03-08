object Twofer {
  def twofer(name: String = ""): String = {
    val name2 = if (name.isBlank) "you" else name
    s"One for $name2, one for me."
  }
}
