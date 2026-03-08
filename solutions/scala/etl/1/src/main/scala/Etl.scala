object Etl {
  def transform(scoreMap: Map[Int, Seq[String]]): Map[String, Int] = {
    val builder = Map.newBuilder[String, Int]

    scoreMap.foreach { case (k, vs) =>
      vs.foreach { v =>
        builder += ((v.toLowerCase(), k))
      }
    }

    builder.result()
  }
}
