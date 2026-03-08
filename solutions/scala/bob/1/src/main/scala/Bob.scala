object Bob {

  def response(statement: String): String = {
    def noLetters(s: String): Boolean = !s.exists(_.isLetter)
    def shouting(s: String): Boolean = s.forall(x => !x.isLetter || x.isUpper)
    def asking(s: String): Boolean = s.endsWith("?")
    def silent(s: String): Boolean = s.trim.isEmpty

    val trimmed = statement.trim

    if (silent(trimmed)) {
      return "Fine. Be that way!"
    }

    if (noLetters(trimmed)) {
      return if (asking(trimmed)) "Sure." else "Whatever."
    }

    (shouting(trimmed), asking(trimmed)) match {
      case (true, true)   => "Calm down, I know what I'm doing!"
      case (true, false)  => "Whoa, chill out!"
      case (false, true)  => "Sure."
      case (false, false) => "Whatever."
    }
  }
}
