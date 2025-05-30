import utils.*;

/**
 * @overview: An armored vehicle in the game
 * 
 * @attributes
 * HP       Integer     int
 * damage   Integer     int
 * armor    Integer     int
 * price    Integer     int
 * 
 * @object
 * A typical tank is <hp,d,a,p> where HP(hp),damage(d),armor(a),price(p)
 * 
 * @abstract_properties
 * mutable(HP) = true /\ optional(HP) = false /\ min(HP) = 1 /\
 * mutable(damage) = true /\ optional(damage) = false /\ min(damage) = 1 /\
 * mutable(armor) = true /\ optional(armor) = false /\ min(armor) = 0 /\
 * mutable(price) = true /\ optional(price) = false /\ min(price) = 1 /\
 */

public class TankTest {
    @DomainConstraint(type="Integer",mutable=true,optional=false,min=1)
    private int HP;

    @DomainConstraint(type="Integer",mutable=true,optional=false,min=1)
    private int damage;

    @DomainConstraint(type="Integer",mutable=true,optional=false,min=0)
    private int armor;

    @DomainConstraint(type="Integer",mutable=true,optional=false,min=1)
    private int price;

    /**
     * @effects
     *      if hp is valid (i.e hp >= 1)
     *          return true
     *      else
     *          return false
     */
    private boolean validateHP(int hp){
        return hp>=1;
    }

    /**
     * @effects
     *      if damage is valid (damage >= 1)
     *          return true
     *      else
     *          return false
     */
    private boolean validateDamage(int damage){
        return damage >= 1;
    }

    /**
     * @effects
     *      if armor is valid (armor >= 0)
     *          return true
     *      else
     *          return false
     */
    private boolean validateArmor(int armor){
        return armor >= 0;
    }

    /**
     * @effects
     *      if price is valid (price >= 1)
     *          return true
     *      else
     *          return false
     */
    private boolean validatePrice(int price){
        return price >= 1;
    }

    /**
     * @effects
     *      if hp, damage, armor, price are all valid:
     *          initialize tank as <hp,damage,armor,price>
     *      else:
     *          throw NotPossibleException
     * 
     */
    public TankTest(@AttrRef("HP") int hp,@AttrRef("damage") int damage, @AttrRef("armor") int armor, @AttrRef("price") int price) throws NotPossibleException{
        if (!validateHP((hp))){
            throw new NotPossibleException("Invalid HP");
        }
        if (!validateDamage(damage)){
            throw new NotPossibleException("Invalid damage");
        }
        if (!validateArmor(armor)){
            throw new NotPossibleException("Invalid armor");
        }
        if (!validatePrice(price)){
            throw new NotPossibleException("Invalid price");
        }

        this.HP = hp;
        this.damage = damage;
        this.armor = armor;
        this.price = price;
    }

    /**
     * @effects
     *      return hp
     */
    @DOpt(type=OptType.Observer) @AttrRef("hp")
    public int getHP(){
        return this.HP;
    }

    /**
     * @effects
     *      return damage
     */
    @DOpt(type=OptType.Observer) @AttrRef("damage")
    public int getDamage(){
        return this.damage;
    }

    /**
     * @effects
     *      return armor
     */
    @DOpt(type=OptType.Observer) @AttrRef("armor")
    public int getArmor(){
        return this.armor;
    }

    /**
     * @effects
     *      return price
     */
    @DOpt(type=OptType.Observer) @AttrRef("price")
    public int getPrice(){
        return this.price;
    }

    /**
     * @effects
     *      if newHP is valid
     *          set this.hp = newHP
     *          return true
     *      else
     *          return false
     */
    @DOpt(type=OptType.Mutator) @AttrRef("hp")
    public boolean setHP(int newHP){
        if (validateHP(newHP)){
            this.HP = newHP;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @effects
     *      if newDamage is valid
     *          set this.damage = newDamage
     *          return true
     *      else
     *          return false
     */
    @DOpt(type=OptType.Mutator) @AttrRef("damage")
    public boolean setDamage(int newDamage){
        if (validateDamage(newDamage)){
            this.damage = newDamage;
            return true;
        }
        else{
            return false;
        }
    }

    /*
     * @effects
     *  if armor is valid
     *      set this.armor = armor
     *      return true
     *  else
     *      return false
     * 
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("armor")
    public boolean setArmor(int armor){
        if (validateArmor(armor)){
            this.armor = armor;
            return true;
        }
        else{
            return false;
        }
    }

    /*
     * @effects
     *  if price is valid
     *      set this.price = price
     *      return true
     *  else
     *      return false
     * 
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("price")
    public boolean setPrice(int price){
        if (validatePrice(armor)){
            this.price = price;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        return String.format("Tank: <%d,%d,%d,%d>",this.HP,this.damage,this.armor,this.price);
    }
}
