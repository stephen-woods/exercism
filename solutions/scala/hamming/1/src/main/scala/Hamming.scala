object Hamming {
  def distance(dnaStrandOne: String, dnaStrandTwo: String): Option[Int] = {
    if (dnaStrandOne.length != dnaStrandTwo.length) return None

    Option {
      dnaStrandOne.iterator
        .zip(dnaStrandTwo.iterator)
        .count { case (n1, n2) => n1 != n2 }
    }
  }
}
