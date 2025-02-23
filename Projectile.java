import utils.*;

/*
 * @overview: A projectile that can be fired by the tank
 * 
 * @attributes
 *  damage      Integer     int
 *  radius      Integer     int
 *  angle       Integer     int
 * 
 * @object
 *  A typical Projectile is <d,r,a> where damage(d), radius(r), angle(a)
 * 
 * @abstract_properties
 *  mutable(damage) = true /\ optional(damage) = false /\ min(damage) = 1
 *  mutable(radius) = true /\ optional(radius) = false /\ min(radius) = 0+
 *  mutable(angle) = true /\ optional(angle) = false /\ min(angle) = 0 /\ max(angle) = 360
 */

public class Projectile {
    
    @DomainConstraint(type="Integer", mutable=true, optional=false, min=1)
    private int damage;

    @DomainConstraint(type="Integer", mutable=true, optional=false, min=0)
    private int radius;

    @DomainConstraint(type="Integer", mutable=true, optional=false, min=0, max=360)
    private int angle;

    /*
     * @effects
     *      if damage is valid
     *          return true
     *      else
     *          return false 
     */
    @DOpt(type=OptType.Helper) @AttrRef("damage")
    private boolean validateDamage(int damage) {
        return damage >= 1;
    }

    /*
     * @effects
     *      if radius is valid
     *          return true
     *      else
     *          return false 
     */
    @DOpt(type=OptType.Helper) @AttrRef("radius")
    private boolean validateRadius(int radius) {
        return radius >= 0;
    }

    /*
     * @effects
     *      if angle is valid
     *          return true
     *      else
     *          return false 
     */
    @DOpt(type=OptType.Helper) @AttrRef("angle")
    private boolean validateAngle(int angle) {
        return angle >= 0 && angle <= 360;
    }

    /*
     * @effects
     *  if d, r, a are valid
     *      initialize this as <d,r,a>
     *  else:
     *      throw NotPossibleException
     */
    public Projectile(@AttrRef("damage") int damage, 
                      @AttrRef("radius") int radius, 
                      @AttrRef("angle") int angle) throws NotPossibleException {
        if (!validateDamage(damage)) {
            throw new NotPossibleException("Invalid damage value");
        }
        if (!validateRadius(radius)) {
            throw new NotPossibleException("Invalid radius value");
        }
        if (!validateAngle(angle)) {
            throw new NotPossibleException("Invalid angle value");
        }
        this.damage = damage;
        this.radius = radius;
        this.angle = angle;
    }

    /*
     * @effects
     *      return damage
     */
    @DOpt(type=OptType.Observer) 
    @AttrRef("damage")
    public int getDamage() {
        return damage;
    }

    /*
     * @effects
     *      return radius
     */
    @DOpt(type=OptType.Observer) 
    @AttrRef("radius")
    public int getRadius() {
        return radius;
    }

    /*
     * @effects
     *      return angle
     */
    @DOpt(type=OptType.Observer) 
    @AttrRef("angle")
    public int getAngle() {
        return angle;
    }

    /*
     * @effects
     *  if damage is valid
     *      set this.damage = damage
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("damage")
    public boolean setDamage(int damage) {
        if (validateDamage(damage)) {
            this.damage = damage;
            return true;
        }
        return false;
    }

    /*
     * @effects
     *  if radius is valid
     *      set this.radius = radius
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("radius")
    public boolean setRadius(int radius) {
        if (validateRadius(radius)) {
            this.radius = radius;
            return true;
        }
        return false;
    }

    /*
     * @effects
     *  if angle is valid
     *      set this.angle = angle
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("angle")
    public boolean setAngle(int angle) {
        if (validateAngle(angle)) {
            this.angle = angle;
            return true;
        }
        return false;
    }

    /*
     * @effects
     *      return true if the object satisfies its constraints
     */
    public boolean repOK() {
        return validateDamage(damage) &&
               validateRadius(radius) &&
               validateAngle(angle);
    }

    /*
     * @effects
     *      return string representation of the object
     */
    @Override
    public String toString() {
        return String.format("Projectile: <%d, %d, %d>", damage, radius, angle);
    }
}
