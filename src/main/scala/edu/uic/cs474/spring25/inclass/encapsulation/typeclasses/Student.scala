package edu.uic.cs474.spring25.inclass.encapsulation.typeclasses

object Student:
  opaque type Name = String
  object Name:
    def apply(s: String): Name = s
  opaque type Uin = String
  object Uin:
    def apply(s: String): Uin = s
  opaque type NetId = String
  object NetId:
    def apply(s: String): NetId = s
end Student

import Student.{Name, NetId, Uin}
case class Student(name: Name, uin: Uin, netId: NetId)
