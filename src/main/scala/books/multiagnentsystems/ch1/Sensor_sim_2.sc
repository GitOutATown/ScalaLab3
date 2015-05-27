package books.multiagnentsystems.ch1

object Sensor_sim_2 {
  import Colors._
  
  val s1 = new Sensor(1, RED)                     //> s1  : books.multiagnentsystems.ch1.Sensor = Sensor(1,books.multiagnentsystem
                                                  //| s.ch1.Colors$RED$@53c9f789)
  val s2 = new Sensor(2, GREEN)                   //> s2  : books.multiagnentsystems.ch1.Sensor = Sensor(2,books.multiagnentsystem
                                                  //| s.ch1.Colors$GREEN$@f286799)
  val s3 = new Sensor(3, YELLOW)                  //> s3  : books.multiagnentsystems.ch1.Sensor = Sensor(3,books.multiagnentsystem
                                                  //| s.ch1.Colors$YELLOW$@25a97595)
  // ------------------- //
  
  s1.neighbors = Set(s2, s3)
  s2.neighbors = Set(s1, s3)
  s3.neighbors = Set(s2, s1)
  
  s1.domain                                       //> res0: scala.collection.immutable.Set[books.multiagnentsystems.ch1.Color] = S
                                                  //| et(books.multiagnentsystems.ch1.Colors$RED$@53c9f789, books.multiagnentsyste
                                                  //| ms.ch1.Colors$GREEN$@f286799, books.multiagnentsystems.ch1.Colors$YELLOW$@25
                                                  //| a97595)
  s2.domain                                       //> res1: scala.collection.immutable.Set[books.multiagnentsystems.ch1.Color] = S
                                                  //| et(books.multiagnentsystems.ch1.Colors$RED$@53c9f789, books.multiagnentsyste
                                                  //| ms.ch1.Colors$GREEN$@f286799, books.multiagnentsystems.ch1.Colors$YELLOW$@25
                                                  //| a97595)
  s3.domain                                       //> res2: scala.collection.immutable.Set[books.multiagnentsystems.ch1.Color] = S
                                                  //| et(books.multiagnentsystems.ch1.Colors$RED$@53c9f789, books.multiagnentsyste
                                                  //| ms.ch1.Colors$GREEN$@f286799, books.multiagnentsystems.ch1.Colors$YELLOW$@25
                                                  //| a97595)
  
  // ------------------- //
  
  List(s1, s2, s3).map(s => s.coordFreq)          //> res3: List[Unit] = List((), (), ())

  s1.domain                                       //> res4: scala.collection.immutable.Set[books.multiagnentsystems.ch1.Color] = S
                                                  //| et(books.multiagnentsystems.ch1.Colors$GREEN$@f286799, books.multiagnentsyst
                                                  //| ems.ch1.Colors$YELLOW$@25a97595, books.multiagnentsystems.ch1.Colors$RED$@53
                                                  //| c9f789)
  s2.domain                                       //> res5: scala.collection.immutable.Set[books.multiagnentsystems.ch1.Color] = S
                                                  //| et(books.multiagnentsystems.ch1.Colors$YELLOW$@25a97595, books.multiagnentsy
                                                  //| stems.ch1.Colors$GREEN$@f286799, books.multiagnentsystems.ch1.Colors$RED$@53
                                                  //| c9f789)
  s3.domain                                       //> res6: scala.collection.immutable.Set[books.multiagnentsystems.ch1.Color] = S
                                                  //| et(books.multiagnentsystems.ch1.Colors$RED$@53c9f789, books.multiagnentsyste
                                                  //| ms.ch1.Colors$YELLOW$@25a97595, books.multiagnentsystems.ch1.Colors$GREEN$@f
                                                  //| 286799)
}
/*




*/