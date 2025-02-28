package tute01b_code;
import utils.*;

/**
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

    /**
     * @effects
     *      if id is valid
     *          return true
     *      else
     *          return false
     */
    private boolean validateID(int id){
        return id >= 1;
    }

    /**
     * @effects
     *      if name is valid
     *          return true
     *      else
     *          return false
     * 
     */
    private boolean validateName(String name){
        return name.length() <= 30;
    }

    /**
     * @effects
     *      if phone is valid
     *          return true
     *      else
     *          return false
     */

    private boolean validatePhone(Object phone){
        return phone instanceof MobilePhone;
    }

    /**
     * @effects
     *  if i,n,p are valid:
     *      initialize this as <tt> <i,n,p> </tt>
     *  else:
     *      throw NotPOssibleException
     */
    public Person(@AttrRef("id") int id, @AttrRef("name") String name, @AttrRef("phone") MobilePhone phone) throws NotPossibleException{
        if (!validateID(id)){
            throw new NotPossibleException("Invalid id!");
        }
        if (!validateName(name)){
            throw new NotPossibleException("Invalid name!");
        }
        if (!validatePhone(phone)){
            throw new NotPossibleException("Invalid phone!");
        }
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    /**
     * @effects
     *      return id 
     */
    @DOpt(type=OptType.Observer) @AttrRef("id")
    public int getId(){
        return this.id;
    }

    /**
     * @effects
     *      return name 
     */
    @DOpt(type=OptType.Observer) @AttrRef("name")
    public String getName(){
        return this.name;
    }
    
    /**
     * @effects
     *      return phone 
     */
    @DOpt(type=OptType.Observer) @AttrRef("phone")
    public MobilePhone getPhone(){
        return this.phone;
    }

    /**
     * @effects
     *  if id is valid
     *      set this.id = id
     *      return true
     *  else
     *      return false
     * 
     */
    @DOpt(type=OptType.Mutator) @AttrRef("id")
    public boolean setID(int id){
        if (validateID(id)){
            this.id = id;
            return true;
        }
        return false;
    }

    /**
     * @effects
     *  if name is valid
     *      set this.name = name
     *      return true
     *  else
     *      return false
     * 
     */
    @DOpt(type=OptType.Mutator) @AttrRef("name")
    public boolean setName(String name){
        if (validateName(name)){
            this.name = name;
            return true;
        }
        return false;
    }

    /**
     * @effects
     *  if phone is valid
     *      set this.phone = phone
     *      return true
     *  else
     *      return false
     * 
     */
    @DOpt(type=OptType.Mutator) @AttrRef("phone")
    public boolean setPhone(MobilePhone phone){
        if (validatePhone(phone)){
            this.phone = phone;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return String.format("Person: <%d,%s,%s>",this.id,this.name,this.phone);
    }

    /**
     * @effects
     *  return true if id,name,phone are valid 
     * 
     */
    public boolean repOK(){
        return (validateID(id)&&validateName(name)&&validatePhone(phone));
    }

    /**
     * @effects
     *  return a string to introduce this person 
     * 
     */

     public void greet(){
        System.out.println(String.format("Hi, my name is <%s>, my id is <%d>",this.name,this.id));

    }

    /**
     * @effects
     *  attempting to call another person (p)
     *  if p has a phone (i.e p.phone != null):
     *      return true
     *  return false
     * 
     */
    public boolean call(Person p){
        if (p.phone != null){
            return true;
        }
        return false;
    }
}
