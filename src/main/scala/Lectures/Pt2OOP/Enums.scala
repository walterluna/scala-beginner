package Lectures.Pt2OOP

object Enums extends App {
  println("Enums lecture")

  // Scala 3 adds support for enums
  enum Permissions {
    case READ, WRITE, EXECUTE

    // Since this is a data type, we can add fields or methods
    def openDocument(): Unit =
      if (this == READ) println("opening document...")
      else println("Reading not allowed")

  }

  //  we can also define enums with constructor args
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4) //100
    case WRITE
      extends PermissionsWithBits(2) //010
    case EXECUTE
      extends PermissionsWithBits(1) //001
  }

  //  we can also create companion objects for enums
  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = //whatever
      PermissionsWithBits.READ
  }


  val somePermissions: Permissions = Permissions.READ

  println(somePermissions)
  somePermissions.openDocument()

  // Standard API
  // Get the ordinal position of enum value
  println(somePermissions.ordinal)
  val allPermissions = PermissionsWithBits.values //array of all possible values
  println(allPermissions)

  //  create from string
  val readPermission: Permissions = Permissions.valueOf("READ") //Permissions.RAED
  println(readPermission)
}
