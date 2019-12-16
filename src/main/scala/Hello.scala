object Hello extends  App {

  println("Hello")

  sealed trait LivingBeing {
    def jump()
  }

  case class Person(name: String, age: Int) extends LivingBeing {
    override def jump(): Unit = println("Person Jump")
  }

  case class Animal(name: Option[String], age: Int) extends LivingBeing {
    override def jump(): Unit = println("Animal Jump")
  }


  val lb1 = Person(name = "Pedro", age = 45)
  val a2 = Animal(name = Some("Gigio"), age = 5)

  val animals = List(lb1, a2)

  val personNames = animals.collect({a => a match {
    case Person(n, _) => n
  }})

  println(personNames)

}
