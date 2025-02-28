package tute01a_design;
import utils.*;

/***
 * @overview: A communication device
 * 
 * @attributes
 *  manName     String
 *  model       String
 *  color       Character
 *  year        Integer     int
 *  guaranteed  Boolean
 * 
 * @object
 *  A typical phone is <n,m,c,y,g> where manName(n),model(m),color(c),year(y),guaranteed(g)
 * 
 * @abstract_properties
 *  mutable(manName) = true /\ optional(manName) = false /\ length(manName) = 30 /\
 *  mutable(model) = false /\ optional(model) = false /\ length(model) = 30 /\
 *  mutable(color) = false /\ optional(color) = false /\ length(color) = 1 /\
 *  mutable(year) = false /\ optional(year) = false /\ min(year) = 1 /\
 *  mutable(guaranteed) = true /\ optional(guaranteed) = false 
 * 
 */
public class MobilePhone {

    @DomainConstraint(type = "String", mutable = true, optional = false, length = 30)
    private String manName;

    @DomainConstraint(type = "String", mutable = false, optional = false, length = 30)
    private String model;

    @DomainConstraint(type = "Character", mutable = false, optional = false, length = 1)
    private Character color;

    @DomainConstraint(type = "Integer", mutable = false, optional = false, min = 1)
    private int year;

    @DomainConstraint(type = "Boolean", mutable = true, optional = false)
    private Boolean guaranteed;

    /**
     * @effects
     * if manName is valid
     * return true
     * else
     * return false
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("manName")
    private boolean validateManName(String manName) {
    }

    /**
     * @effects
     * if model is valid
     * return true
     * else
     * return false
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("model")
    private boolean validateModel(String model) {
    }

    /**
     * @effects
     * if color is valid
     * return true
     * else
     * return false
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("color")
    private boolean validateColor(Character color) {
    }

    /**
     * @effects
     * if year is valid
     * return true
     * else
     * return false
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("year")
    private boolean validateYear(int year) {
    }

    /**
     * @effects
     * if guaranteed is valid
     * return true
     * else
     * return false
     */
    @DOpt(type = OptType.Helper)
    @AttrRef("guaranteed")
    private boolean validateGuaranteed(Boolean guaranteed) {
    }

    /**
     * @effects
     * if n, m, c, y, g are valid
     * initialize this as <n,m,c,y,g>
     * else:
     * throw NotPossibleException
     */
    public MobilePhone(@AttrRef("manName") String manName,
            @AttrRef("model") String model,
            @AttrRef("color") Character color,
            @AttrRef("year") int year,
            @AttrRef("guaranteed") boolean guaranteed) throws NotPossibleException {
    }

    /**
     * @effects
     * return manName
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("manName")
    public String getManName() {
    }

    /**
     * @effects
     * return model
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("model")
    public String getModel() {
    }

    /**
     * @effects
     * return color
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("color")
    public Character getColor() {
    }

    /**
     * @effects
     * return year
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("year")
    public int getYear() {
    }

    /**
     * @effects
     * return guaranteed
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("guaranteed")
    public Boolean getGuaranteed() {
    }

    /**
     * @effects
     * if manName is valid
     * set this.manName = manName
     * return true
     * else
     * return false
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("manName")
    public boolean setManName(String manName) {
    }

    /**
     * @effects
     * if guaranteed is valid
     * set this.guaranteed = guaranteed
     * return true
     * else
     * return false
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("guaranteed")
    public boolean setGuaranteed(Boolean guaranteed) {
    }

    /**
     * @effects
     * return true if the object satisfies its constraints
     */
    public boolean repOK() {
    }

    /**
     * @effects
     * return string representation of the object
     */
    @Override
    public String toString() {
    }
}
