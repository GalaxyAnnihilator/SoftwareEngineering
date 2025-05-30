import utils.*;

/**
 * @overview: A contact for calling
 * @attributes:
 *  name            String
 *  phoneNumber     String
 * @object: A contact is defined by <n,p> where name(n) and phoneNumber(p)
 * @abstract_properties:
 * mutable(name) = true /\ optional(name) = false /\ length(name) = 50 /\
 * mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length(phoneNumber) = 20 /\
 */
public class Contact{
    @DomainConstraint(type="String",mutable=true,optional=false,length=50)
    private String name;
    @DomainConstraint(type="String",mutable=true,optional=false,length=20)
    private String phoneNumber;

    /**
     * @requires: input name is a string
     * @effects:
     *  if name is valid, i.e length(name)<=50 :
     *      return true
     *  else:
     *      return false
     */
    private boolean validateName(String name){
        return name.length() <= 50;
    }

    /**
     * @requires: input phoneNumber is a string
     * @effects:
     *  if phoneNumber is valid, i.e length(phoneNumber)<=50 :
     *      return true
     *  else:
     *      return false
     */
    private boolean validatePhoneNumber(String phoneNumber){
        return phoneNumber.length() <= 50;
    }

    /**
     * @effects
     * if name and phoneNumber are valid:
     *      initialize Contact as <n,p>
     * else:
     *      throw NotPossibleException
     */
    public Contact(@AttrRef("name") String name, @AttrRef("phoneNumber") String phoneNumber) throws NotPossibleException{
        if (!validateName(name)){
            throw new NotPossibleException("Invalid name");
        }
        if (!validatePhoneNumber(phoneNumber)){
            throw new NotPossibleException("invalid phone number");
        }
    }

}