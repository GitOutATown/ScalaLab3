package books.multiagnentsystems.ch1

object Sensor_sim_1 {
  import Colors._

  val s1 = new Sensor(1)                          //> s1  : books.multiagnentsystems.ch1.Sensor = Sensor(1,None)
  s1.frequency = yellow
  
  val s2 = new Sensor(2, red)                     //> s2  : books.multiagnentsystems.ch1.Sensor = Sensor(2,Some(books.multiagnents
                                                  //| ystems.ch1.Colors$RED$@2dbae104))
  val s3 = new Sensor(3, green)                   //> s3  : books.multiagnentsystems.ch1.Sensor = Sensor(3,Some(books.multiagnents
                                                  //| ystems.ch1.Colors$GREEN$@480ae510))
  
  // ---------------------- //
  
  s1.frequency = randomColor
  s2.frequency = randomColor
  s3.frequency = randomColor
  
  s1.frequency                                    //> res0: Option[books.multiagnentsystems.ch1.Color] = Some(books.multiagnentsys
                                                  //| tems.ch1.Colors$YELLOW$@5373b318)
  s2.frequency                                    //> res1: Option[books.multiagnentsystems.ch1.Color] = Some(books.multiagnentsys
                                                  //| tems.ch1.Colors$GREEN$@480ae510)
  s3.frequency                                    //> res2: Option[books.multiagnentsystems.ch1.Color] = Some(books.multiagnentsys
                                                  //| tems.ch1.Colors$YELLOW$@5373b318)
  
  // ---------------------- //
  
  val domain = colors                             //> domain  : List[books.multiagnentsystems.ch1.Color] = List(books.multiagnents
                                                  //| ystems.ch1.Colors$RED$@2dbae104, books.multiagnentsystems.ch1.Colors$GREEN$@
                                                  //| 480ae510, books.multiagnentsystems.ch1.Colors$YELLOW$@5373b318)
  
  colors.filter(v => v != GREEN)                  //> res3: List[books.multiagnentsystems.ch1.Color] = List(books.multiagnentsyste
                                                  //| ms.ch1.Colors$RED$@2dbae104, books.multiagnentsystems.ch1.Colors$YELLOW$@537
                                                  //| 3b318)
  
  // ---------------------- //
  
  s1.neighbors += s2
  s1.neighbors += s3
  
  s2.neighbors = Set(s1, s3)
  
  s3.neighbors = Set(s2, s1)
}
/*





*/