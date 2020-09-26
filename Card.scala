// // //
// Card Traits
sealed trait CardSpeed
case object SorcerySpeed extends CardSpeed
case object InstantSpeed extends CardSpeed

sealed trait CardPermanence
case object Permanent extends CardPermanence
case object NonPermanent extends CardPermanence

sealed trait CardType
case object NonSpell extends CardType
case object Spell extends CardType


// // //
// Base Class
abstract class BaseCard(n: String, t: String, c: String, o: String, s: CardSpeed) {
  /*
   *
   */

  def name : String =  n;
  def typeline: String = t;
  def cost : String =  c;
  def oracletext : String = o;
  def speed: CardSpeed = s;
  
  override def toString(): String = "%s\n%s\n%s\n%s\n".format(name, cost, typeline, oracletext);

}


// // //
// Nonpermanent Card Types
class SorceryCard(n: String, t: String, c: String, o: String) 
  extends BaseCard(n, t, c, o) with SorcerySpeed with NonPermanent with Spell {
  
}

class InstantCard(n: String, t: String, c: String, o: String) 
  extends BaseCard(n, t, c, o) with InstantSpeed with NonPermanent with Spell {
  
} 

// // //
// Permanent Card Types
class LandCard(n: String, t: String, c: String, o: String) 
  extends BaseCard(n, t, c, o) with SorcerySpeed with NonPermanent with NonSpell {

}

class EnchantmentCard(n: String, t: String, c: String, o: String) 
  extends BaseCard(n, t, c, o) with SorcerySpeed with NonPermanent with Spell {

}

class CreatureCard(n: String, t: String, c: String, o: String, po: Integer, to: Integer) 
  extends BaseCard(n, t, c, o) with SorcerySpeed with NonPermanent with Spell {

  def power: Integer = po;
  def tough: Integer = to;
}

class PlaneswalkerCard(n: String, t: String, c: String, o: String, lo: String) 
  extends BaseCard(n, t, c, o) with SorcerySpeed with NonPermanent with Spell {

  def loyalty: String = lo;
}


// // //
//
object Card {
  
  def main (args: Array[String]) {

    val c = new SorceryCard("test", "t1 - t2 t3", "asdf", "zxcv");

    println("Here is stuff ...");

    println(c);

  }
}
