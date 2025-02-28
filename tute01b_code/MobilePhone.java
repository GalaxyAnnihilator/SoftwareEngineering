package tute01b_code;
import utils.*;

enum Color {
    RED('R'), ORANGE('O'), YELLOW('Y'), BLUE('B'), PURPLE('P');

    private final char code;

    Color(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Color fromChar(char c) {
        for (Color color : Color.values()) {
            if (color.code == c) {
                return color;
            }
        }
        throw new IllegalArgumentException("Invalid color code: " + c);
    }
}

/**
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
    
    @DomainConstraint(type="String", mutable=true, optional=false, length=30)
    private String manName;

    @DomainConstraint(type="String", mutable=false, optional=false, length=30)
    private String model;

    @DomainConstraint(type="Character", mutable=false, optional=false, length=1)
    private Character color;

    @DomainConstraint(type="Integer", mutable=false, optional=false, min=1)
    private int year;

    @DomainConstraint(type="Boolean", mutable=true, optional=false)
    private Boolean guaranteed;

    /**
     * @effects
     *      if manName is valid
     *          return true
     *      else
     *          return false 
     */
    @DOpt(type=OptType.Helper) @AttrRef("manName")
    private boolean validateManName(String manName) {
        return manName != null && manName.length() <= 30;
    }

    /**
     * @effects
     *      if model is valid
     *          return true
     *      else
     *          return false 
     */
    @DOpt(type=OptType.Helper) @AttrRef("model")
    private boolean validateModel(String model) {
        return model != null && model.length() <= 30 && model.matches("M-[A-Z]{3}-/d{3}");
    }

    /**
     * @effects
     *      if color is valid
     *          return true
     *      else
     *          return false 
     */
    @DOpt(type=OptType.Helper) @AttrRef("color")
    private boolean validateColor(Character color) {
        return Color.fromChar(color) != null;
    }

    /**
     * @effects
     *      if year is valid
     *          return true
     *      else
     *          return false 
     */
    @DOpt(type=OptType.Helper) @AttrRef("year")
    private boolean validateYear(int year) {
        return year >= 1;
    }

    /**
     * @effects
     *      if guaranteed is valid
     *          return true
     *      else
     *          return false 
     */
    @DOpt(type=OptType.Helper) @AttrRef("guaranteed")
    private boolean validateGuaranteed(Boolean guaranteed) {
        return guaranteed != null;
    }

    /**
     * @effects
     *  if n, m, c, y, g are valid
     *      initialize this as <n,m,c,y,g>
     *  else:
     *      throw NotPossibleException
     */
    public MobilePhone(@AttrRef("manName") String manName, 
                       @AttrRef("model") String model, 
                       @AttrRef("color") Character color, 
                       @AttrRef("year") int year, 
                       @AttrRef("guaranteed") boolean guaranteed) throws NotPossibleException {
        if (!validateManName(manName)) {
            throw new NotPossibleException("Invalid manufacturer name");
        }
        if (!validateModel(model)) {
            throw new NotPossibleException("Invalid model");
        }
        if (!validateColor(color)) {
            throw new NotPossibleException("Invalid color");
        }
        if (!validateYear(year)) {
            throw new NotPossibleException("Invalid year");
        }
        if (!validateGuaranteed(guaranteed)) {
            throw new NotPossibleException("Invalid guaranteed value");
        }
        this.manName = manName;
        this.model = model;
        this.color = color;
        this.year = year;
        this.guaranteed = guaranteed;
    }

    /**
     * @effects
     *      return manName
     */
    @DOpt(type=OptType.Observer) 
    @AttrRef("manName")
    public String getManName() {
        return manName;
    }

    /**
     * @effects
     *      return model
     */
    @DOpt(type=OptType.Observer) 
    @AttrRef("model")
    public String getModel() {
        return model;
    }

    /**
     * @effects
     *      return color
     */
    @DOpt(type=OptType.Observer) 
    @AttrRef("color")
    public Character getColor() {
        return color;
    }

    /**
     * @effects
     *      return year
     */
    @DOpt(type=OptType.Observer) 
    @AttrRef("year")
    public int getYear() {
        return year;
    }

    /**
     * @effects
     *      return guaranteed
     */
    @DOpt(type=OptType.Observer) 
    @AttrRef("guaranteed")
    public Boolean getGuaranteed() {
        return guaranteed;
    }

    /**
     * @effects
     *  if manName is valid
     *      set this.manName = manName
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("manName")
    public boolean setManName(String manName) {
        if (validateManName(manName)) {
            this.manName = manName;
            return true;
        }
        return false;
    }

    /**
     * @effects
     *  if guaranteed is valid
     *      set this.guaranteed = guaranteed
     *      return true
     *  else
     *      return false
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("guaranteed")
    public boolean setGuaranteed(Boolean guaranteed) {
        if (validateGuaranteed(guaranteed)) {
            this.guaranteed = guaranteed;
            return true;
        }
        return false;
    }

    /**
     * @effects
     *      return true if the object satisfies its constraints
     */
    public boolean repOK() {
        return validateManName(manName) &&
               validateModel(model) &&
               validateColor(color) &&
               validateYear(year) &&
               validateGuaranteed(guaranteed);
    }

    /**
     * @effects
     *      return string representation of the object
     */
    @Override
    public String toString() {
        return String.format("MobilePhone: <%s, %s, %c, %d, %b>", manName, model, color, year, guaranteed);
    }
}
