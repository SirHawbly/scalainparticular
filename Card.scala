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
sealed abstract trait SpellType { 
  def is_castable: Boolean;
  def is_playable: Boolean; 
}

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
//
class Counter(n: String, f: BaseCard => BaseCard, a: Integer = 0) {
  val name: String = n;
  val function: BaseCard => BaseCard = f;
  val amount: Integer = a;
}


// // //
// P/T Tuple Type
// type StatType = (Integer, Integer)


// // //
// Base Class
class BaseCard(na: String, ty: String, co: String, ot: String, st: Option[(Integer, Integer)] = None, cl: List[Counter] = Nil) extends TypeTrait {
  /*
   *
   */

  val name: String =  na;
  val type_line: List[String] = ty 
  val card_class_type : List[String] = card_types;
  val cost: String =  co;
  val converted_cost: Integer = 0;
  val oracle_text: String = ot;
  val init_stats: (Integer, Integer) = st;  
  val curr_stats: (Integer, Integer) = st;  
  
  var counters: List[Counter] = cl;
  var types: List[String] = Nil;

  def card_types: List[String] = Nil;
  def is_token: Boolean = false

  override def toString(): String = "%s\n%s\n%s\n%s\n".format(name, cost, type_line, oracle_text);

}

// // //
//
class Token() extends BaseCard {
  def is_token: Boolean = true
}

// // //
// Nonpermanent Card Types
/*
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

  power = po;
  tough = to;
}

class PlaneswalkerCard(n: String, t: String, c: String, o: String, lo: Integer) 
  extends BaseCard(n, t, c, o) with Planeswalker with NonPermanent with Spell {

  loyalty = lo;
}
*/


// // //
//
object Card {
  
  def main (args: Array[String]) {

    val c = new BaseCard("test", "t1 - t2 t3", "asdf", "zxcv") with Land with Permanent with SorcerySpeed;

    println(c);

  }
}
