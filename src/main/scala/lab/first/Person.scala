package lab.first

enum Person:
  case Student(name: String, year: Int)
  case Teacher(name: String, course: String)

object Person:
  def name(person: Person): String = person match
    case Student(name, year) => name
    case Teacher(name, course) => name

  def isTeacher(person: Person): Boolean = person match
    case Teacher(_, _) => true
    case _ => false

def main(): Unit =
  import Person.* 
  val prof = Person.Teacher("Gianluca Aguzzi", "PPS")
  val myself = Student("Alex Mazzoni", 2025)
  println(name(myself))