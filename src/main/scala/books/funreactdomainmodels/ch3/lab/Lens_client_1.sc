package books.funreactdomainmodels.ch3.lab

import LensLab2._

object Lens_client_1 {

  val addrV1 = Address("322", "Main St.", "Des Moines", "IA", "32303")
                                                  //> addrV1  : books.funreactdomainmodels.ch3.lab.LensLab2.Address = Address(322,
                                                  //| Main St.,Des Moines,IA,32303)
  val addrV2 = addrNoLens.set(addrV1, "422")      //> addrV2  : books.funreactdomainmodels.ch3.lab.LensLab2.Address = Address(422,
                                                  //| Main St.,Des Moines,IA,32303)
  
  val addrV3 = addrStreetLens.set(addrV2, "Euclid")
                                                  //> addrV3  : books.funreactdomainmodels.ch3.lab.LensLab2.Address = Address(422,
                                                  //| Euclid,Des Moines,IA,32303)
  
  addrStreetLens.get(addrV3)                      //> res0: String = Euclid
  
  val custV1 = Customer("c1", "Joe Blow", addrV1) //> custV1  : books.funreactdomainmodels.ch3.lab.LensLab2.Customer = Customer(c1
                                                  //| ,Joe Blow,Address(322,Main St.,Des Moines,IA,32303))
  
  val custV2 = custAddrLens.set(custV1, addrV3)   //> custV2  : books.funreactdomainmodels.ch3.lab.LensLab2.Customer = Customer(c1
                                                  //| ,Joe Blow,Address(422,Euclid,Des Moines,IA,32303))
  custAddrNoLens.get(custV2)                      //> res1: String = 422
  
  val custV3 = custAddrNoLens.set(custV1, "422")  //> custV3  : books.funreactdomainmodels.ch3.lab.LensLab2.Customer = Customer(c1
                                                  //| ,Joe Blow,Address(422,Main St.,Des Moines,IA,32303))
  
  
  '''                                             //> res2: Char('\'') = '
}