object Test extends Enumeration {
  type Team = Value

  private val BLUE = Value(1, "BLUE")
  private val RED = Value(2)
  private val GREEN = Value(3)
  private val YELLOW = Value(4)
}

val holder = Test(1)

holder.toString