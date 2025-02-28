package tute01a_design;
import utils.*;

/*
 * @overview: A human being
 * 
 * @attributes
 *  id      Integer     int
 *  name    String
 *  phone   MobilePhone
 * 
 * @object
 *  A typical person is <i,n,p> where id(i), name(n), phone(p)
 * 
 * @abstract_properties
 *  mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\
 *  mutable(name) = true /\ optional(name) = false /\ length(name) = 30 /\
 *  mutable(phone) = true /\ optional(phone) = true /\
 */

public class Person {
    @DomainConstraint(type="Integer",mutable=false,optional=false,min=1)
    private int id;

    @DomainConstraint(type="String",mutable=true,optional=false,length = 30)
    private String name;

    @DomainConstraint(type="MobilePhone",mutable=true,optional = true)
    private MobilePhone phone;

    /*
     * @effects
     *      if id is valid
     *          return true
     *      else
     *          return false
     */
    private boolean validateID(int id){}

    /*
     * @effects
     *      if name is valid
     *          return true
     *      else
     *          return false
     * 
     */
    private boolean validateName(String name){}

    /*
     * @effects
     *      if phone is valid
     *          return true
     *      else
     *          return false
     */

    private boolean validatePhone(Object phone){}

    /*
     * @effects
     *  if i,n,p are valid:
     *      initialize this as <tt> <i,n,p> </tt>
     *  else:
     *      throw NotPOssibleException
     */
    public Person(@AttrRef("id") int id, @AttrRef("name") String name, @AttrRef("phone") MobilePhone phone) throws NotPossibleException{}

    /*
     * @effects
     *      return id 
     */
    @DOpt(type=OptType.Observer) @AttrRef("id")
    public int getId(){}

    /*
     * @effects
     *      return name 
     */
    @DOpt(type=OptType.Observer) @AttrRef("name")
    public String getName(){}
    
    /*
     * @effects
     *      return phone 
     */
    @DOpt(type=OptType.Observer) @AttrRef("phone")
    public MobilePhone getPhone(){}

    /*
     * @effects
     *  if name is valid
     *      set this.name = name
     *      return true
     *  else
     *      return false
     * 
     */
    @DOpt(type=OptType.Mutator) @AttrRef("name")
    public boolean setName(String name){}

    /*
     * @effects
     *  if phone is valid
     *      set this.phone = phone
     *      return true
     *  else
     *      return false
     * 
     */
    @DOpt(type=OptType.Mutator) @AttrRef("phone")
    public boolean setPhone(MobilePhone phone){}

    @Override
    public String toString(){}

    /*
     * @effects
     *  return true if id,name,phone are valid 
     * 
     */
    public boolean repOK(){}

    /*
     * @effects
     *  return a string to introduce this person 
     * 
     */

    public void greet(){
    }

    /*
     * @effects
     *  attempting to call another person (p)
     *  if p has a phone (i.e p.phone != null):
     *      return true
     *  return false
     * 
     */
    public boolean call(Person p){
        
    }
}
