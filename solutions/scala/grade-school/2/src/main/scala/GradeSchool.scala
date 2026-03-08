class School {
  type DB = Map[Int, Seq[String]]

  private var _db: DB = Map.empty

  def add(name: String, g: Int) = {
    _db = _db.updatedWith(g) {
      case None     => Some(name :: Nil)
      case Some(xs) => Some(name +: xs)
    }
  }

  def db: DB = _db

  def grade(g: Int): Seq[String] = _db.getOrElse(g, Nil)

  def sorted: DB = _db.view.mapValues(_.sorted).toMap
}
