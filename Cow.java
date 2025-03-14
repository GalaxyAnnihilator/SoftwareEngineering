import utils.*;

/*
 * @overview: A cow is characterised by attributes name, breed, age
 * @attributes
 *  name    String
 *  breed   String
 *  age     Integer     int
 * 
 * @object
 *  A typical Cow is <n,b,a> where name(n), breed(b), age(a)
 * 
 * @abstract_properties
 *  mutable(name) = true /\ optional(name) = false /\ length(name) = 50
 *  mutable(breed) = true /\ optional(breed) = false /\ length(breed) = 50
 *  mutable(age) = true /\ optional(age) = false /\ min(age) = 0 /\ max(age) = 36
 */

public class Cow{
    @DomainConstraint(type="String",mutable=true,optional=false,length=50)
    private String name;

    @DomainConstraint(type="String",mutable=true,optional=false,length=50)
    private String breed;

    @DomainConstraint(type="Integer",mutable=true,optional=false,min=0,max=36)
    private int age;

    @DOpt(type=OptType.Observer)
    @AttrRef("name")
    public String getName(){
        return this.name;
    }

    @DOpt(type=OptType.Observer)
    @AttrRef("breed")
    public String getBreed(){
        return this.breed;
    }

    @DOpt(type=OptType.Observer)
    @AttrRef("age")
    public int getAge(){
        return this.age;
    }

    @DOpt(type=OptType.Mutator)
    @AttrRef("name")
    public void setName(String name){
        this.name = name;
    }

    @DOpt(type=OptType.Mutator)
    @AttrRef("breed")
    public void setBreed(String breed){
        this.breed = breed;
    }

    @DOpt(type=OptType.Mutator)
    @AttrRef("age")
    public void setAge(int age){
        this.age = age;
    }

    @DOpt(type=OptType.Helper)
    @AttrRef("name")
    public static boolean validateName(String name){
        return name.length() < 50;
    }

    @DOpt(type=OptType.Helper)
    @AttrRef("breed")
    public static boolean validateBreed(String breed){
        return breed.length() < 50;
    }

    @DOpt(type=OptType.Helper)
    @AttrRef("age")
    public static boolean validateAge(int age){
        return (age>0 && age < 36);
    }

    /*
     * @effects:
     *  if name, breed and age are valid
     *      initialize as Cow(name, breed, age)
     *  else
     *      throws Exception
     */
    public Cow(@AttrRef("name") String name, @AttrRef("breed") String breed, @AttrRef("age") int age) throws NotPossibleException{
        this.name = name;
        this.breed = breed;
        this.age = age;
    };
}
