package lab.enumeration_type

object role_client_1 {

  case class Agent(role: Role.Value)
  
  val viewRole = Role("VIEW")                     //> viewRole  : lab.enumeration_type.Role.Value = VIEW
  
  Agent(viewRole)                                 //> res0: lab.enumeration_type.role_client_1.Agent = Agent(VIEW)

  '''                                             //> res1: Char('\'') = '
}