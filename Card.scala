// // //
// Cast Type Traits
sealed trait CardSpeed

trait SorcerySpeed extends CardSpeed

trait InstantSpeed extends CardSpeed


// // //
// Permanence Traits
sealed trait CardPermanence

trait Permanent extends CardPermanence

trait NonPermanent extends CardPermanence


// // //
// Spell Type Traits
sealed abstract trait SpellType { def is_castable: Boolean }

trait Spell extends SpellType { 
  def is_castable: Boolean = true; 
  def is_playable: Boolean = true; 

}

trait NonSpell extends SpellType { 
  def is_castable: Boolean = false;
  def is_playable: Boolean = true; 
}


// // //
// Card Type Traits 

sealed trait TypeTrait { def card_types: List[String] }

sealed trait CardType extends TypeTrait { def card_types: List[String] = Nil }

trait Creature extends CardType { 
  override def card_types: List[String] = "Creature" :: super.card_types 
}

trait Artifact extends CardType {
  override def card_types: List[String] = "Artifact" :: super.card_types 
}

trait Enchantment extends CardType {
  override def card_types: List[String] = "Enchantment" :: super.card_types 
}

trait Planeswalker extends CardType {
  override def card_types: List[String] = "Planeswalker" :: super.card_types 
}

trait Sorcery extends CardType {
  override def card_types: List[String] = "Sorcery" :: super.card_types 
}

trait Instant extends CardType {
  override def card_types: List[String] = "Instant" :: super.card_types 
}

trait Land extends CardType {
  override def card_types: List[String] = "Land" :: super.card_types 
}


// // //
// Base Class
abstract class BaseCard(n: String, t: String, c: String, o: String) extends TypeTrait {
  /*
   *
   */

  def name: String =  n;
  var type_line: List[String] = t :: card_types;
  def cost: String =  c;
  def oracle_text: String = o;
  var power: Integer = -1;  
  var tough: Integer = -1;  

  def card_types: List[String] = Nil;

  override def toString(): String = "%s\n%s\n%s\n%s\n".format(name, cost, type_line, oracle_text);

}


// // //
// Nonpermanent Card Types
class SorceryCard(n: String, t: String, c: String, o: String) 
  extends BaseCard(n, t, c, o) with Sorcery with NonPermanent with Spell {
}

class InstantCard(n: String, t: String, c: String, o: String) 
  extends BaseCard(n, t, c, o) with Instant with NonPermanent with Spell {
} 

// // //
// Permanent Card Types
class LandCard(n: String, t: String, c: String, o: String) 
  extends BaseCard(n, t, c, o) with Land with NonPermanent with NonSpell {
}

class ArtifactCard(n: String, t: String, c: String, o: String) 
  extends BaseCard(n, t, c, o) with Artifact with NonPermanent with NonSpell {
}

class EnchantmentCard(n: String, t: String, c: String, o: String) 
  extends BaseCard(n, t, c, o) with Enchantment with NonPermanent with Spell {
}

class CreatureCard(n: String, t: String, c: String, o: String, po: Integer, to: Integer) 
  extends BaseCard(n, t, c, o) with Creature with NonPermanent with Spell {

  def power: Integer = po;
  def tough: Integer = to;
}

class PlaneswalkerCard(n: String, t: String, c: String, o: String, lo: String) 
  extends BaseCard(n, t, c, o) with Planeswalker with NonPermanent with Spell {

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
