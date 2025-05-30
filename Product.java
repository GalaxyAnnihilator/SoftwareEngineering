import utils.*;

/**
 * @overview: a simple product
 * @attributes
 *  code    String
 *  name    String
 * 
 * @object
 * A typical product is presented by <c,n> where code(c) and n(name)
 * 
 * @abstract_properties
 * mutable(code) = false /\ optional(code) = false /\ length(code) = 10 /\
 * mutable(name) = true /\ optional(name) = false /\ length(name) = 50 /\
 */

public class Product{
    @DomainConstraint(type="String",mutable=false,optional=false,length=10)
    private String code;

    @DomainConstraint(type="String",mutable=true,optional=false,length=50)
    private String name;

    /**
     * @effects
     *      if code is valid (length smaller than 10)
     *          return true
     *      else
     *          return false
     */
    private boolean validateCode(String code){
        return code.length() <= 10 && code!=null;
    }

    /**
     * @effects
     *      if name is valid (length smaller than 50)
     *          return true
     *      else
     *          return false
     */
    private boolean validateName(String name){
        return name.length() <= 50 && name!=null;
    }

    /**
     * @effects
     *      if code and name are valid:
     *          initialize Product as <code,name>
     *      else:
     *          throw NotPossibleException
     */
    public Product(@AttrRef("code") String code, @AttrRef("name") String name) throws NotPossibleException{
        if (!validateCode(code)){
            throw new NotPossibleException("invalid code");
        }
        if (!validateName(name)){
            throw new NotPossibleException("Invalid name");
        }
        this.code = code;
        this.name = name;
    }

    /**
     * @effects
     *      return code
     */
    @DOpt(type=OptType.Observer) @AttrRef("code")
    public String getCode(){
        return this.code;
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
     *      if name is valid:
     *          set this.name = name
     *          return true
     *      else:
     *          return false
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

    @Override
    public String toString(){
        return String.format("Product: <%s,%s>",this.code,this.name);
    }
}