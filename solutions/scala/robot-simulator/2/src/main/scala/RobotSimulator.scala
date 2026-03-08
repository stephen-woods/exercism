enum Bearing {
  case North, East, South, West
}

case class Robot(
  bearing: Bearing,
  coordinates: (Int, Int)
) {
  def advance: Robot = {
    var (x, y) = coordinates

    bearing match {
      case Bearing.North => y = y + 1
      case Bearing.East  => x = x + 1
      case Bearing.South => y = y - 1
      case Bearing.West  => x = x - 1
    }
    Robot(bearing, (x, y))
  }

  def turnLeft: Robot = {
    val b2 = bearing match {
      case Bearing.North => Bearing.West
      case Bearing.East  => Bearing.North
      case Bearing.South => Bearing.East
      case Bearing.West  => Bearing.South
    }
    Robot(b2, coordinates)
  }

  def turnRight: Robot = {
    val b2 = bearing match {
      case Bearing.North => Bearing.East
      case Bearing.East  => Bearing.South
      case Bearing.South => Bearing.West
      case Bearing.West  => Bearing.North
    }
    Robot(b2, coordinates)
  }

  def simulate(instructions: String): Robot = 
    instructions.foldLeft(this) { 
      case (r, 'L') => r.turnLeft
      case (r, 'R') => r.turnRight
      case (r, 'A') => r.advance
      case (r, _) => r
    }
}

