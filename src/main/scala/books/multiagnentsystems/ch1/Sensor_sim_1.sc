package books.multiagnentsystems.ch1

object Sensor_sim_1 {
  import Colors._

  val s1 = new Sensor(1, YELLOW)                  //> s1  : books.multiagnentsystems.ch1.Sensor = Sensor(1,books.multiagnentsystem
                                                  //| s.ch1.Colors$YELLOW$@2208fc73)
  s1.frequency = YELLOW
  
  val s2 = new Sensor(2, RED)                     //> s2  : books.multiagnentsystems.ch1.Sensor = Sensor(2,books.multiagnentsystem
                                                  //| s.ch1.Colors$RED$@733d0fc)
  val s3 = new Sensor(3, GREEN)                   //> s3  : books.multiagnentsystems.ch1.Sensor = Sensor(3,books.multiagnentsystem
                                                  //| s.ch1.Colors$GREEN$@5add5415)
  
  // ---------------------- //
  
  s1.frequency = randomColor
  s2.frequency = randomColor
  s3.frequency = randomColor
  
  s1.frequency                                    //> res0: books.multiagnentsystems.ch1.Color = books.multiagnentsystems.ch1.Colo
                                                  //| rs$RED$@733d0fc
  s2.frequency                                    //> res1: books.multiagnentsystems.ch1.Color = books.multiagnentsystems.ch1.Colo
                                                  //| rs$GREEN$@5add5415
  s3.frequency                                    //> res2: books.multiagnentsystems.ch1.Color = books.multiagnentsystems.ch1.Colo
                                                  //| rs$YELLOW$@2208fc73
  
  // ---------------------- //
  
  val domain = colors                             //> domain  : List[books.multiagnentsystems.ch1.Color] = List(books.multiagnents
                                                  //| ystems.ch1.Colors$RED$@733d0fc, books.multiagnentsystems.ch1.Colors$GREEN$@5
                                                  //| add5415, books.multiagnentsystems.ch1.Colors$YELLOW$@2208fc73)
  
  colors.filter(v => v != GREEN)                  //> res3: List[books.multiagnentsystems.ch1.Color] = List(books.multiagnentsyste
                                                  //| ms.ch1.Colors$RED$@733d0fc, books.multiagnentsystems.ch1.Colors$YELLOW$@2208
                                                  //| fc73)
  
  // ---------------------- //
  
  s1.neighbors += s2
  s1.neighbors += s3
  
  s2.neighbors = Set(s1, s3)
  
  s3.neighbors = Set(s2, s1)
}
/*





*/