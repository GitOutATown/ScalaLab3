package lab.enumeration_type

object Role extends Enumeration {
    type Role = Value
    val NON, VIEW, EDIT, ORG_ADMIN, Q_ADMIN = Value
    
    val roleMap = Map[String, Role.Value] (
            "NON" -> Role.NON,
            "VIEW" -> Role.VIEW,
            "EDIT" -> Role.EDIT,
            "ORG_ADMIN" -> Role.ORG_ADMIN,
            "Q_ADMIN" -> Role.Q_ADMIN
    )
    
    def apply(role: String) = {
        roleMap(role)
    }
}