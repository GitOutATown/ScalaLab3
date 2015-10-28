package books.funreactdomainmodels.ch3.lab

object LensLab2 {
    
    // O = object type, i.e. Address. V = field/attr value type, i.e. no.
    case class Lens[O, V](
        get: O => V,
        set: (O, V) => O
    )
    
    def nestedLens[Outer, Inner, Value](
        outer: Lens[Outer, Inner],
        inner: Lens[Inner, Value]
    ) = Lens[Outer, Value](
        get = outer.get andThen inner.get,
        set = (obj, value) => outer.set(obj, inner.set(outer.get(obj), value))
    )
    
    // ---- ADT Entities ---- //
    
    case class Address(
        no: String, street: String, city: String, state: String, zip: String
    )
    
    case class Customer(id: String, name: String, address: Address)

    // ---- Address Lenses ---- //
    
    val addrNoLens = Lens[Address, String] (
        get = _.no,
        set = (o, v) => o.copy(no = v)
    )
    
    val addrStreetLens = Lens[Address, String] (
        get = _.street,
        set = (o, v) => o.copy(street = v)
    )
    
    // ---- Customer Lenses ---- //
    
    val custAddrLens = Lens[Customer, Address] (
        get = _.address,
        set = (o, v) => o.copy(address = v)
    )
    
    // ---- Nested Lenses ---- //
    
    val custAddrNoLens = nestedLens(custAddrLens, addrNoLens)
}




