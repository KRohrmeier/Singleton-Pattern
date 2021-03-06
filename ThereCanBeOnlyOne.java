/**
 * ThereCanBeOnlyOne is a singleton class - to practice using the static keyword,
 * or, "what can you do with static and why would you want to?"
 * @author kkohler
 */
public class ThereCanBeOnlyOne {

    /** Placeholder for current(and only) singleton object.
     *  Remember, static variables belongs to the class, not to an instance.
     *  Yes, this is weird. The class is holding an instance of itself as a
     *  variable. Kinda chicken-and-egg-y, except when you think about *when*
     *  static variables are created. Static is interesting magic.
     */
    private static ThereCanBeOnlyOne onlyOne = null;

    /** Private constructor means no other class/object can instantiate this
     *  class. Another class/object wants to use the singleton? It can use 
     *  the getInstance() method (further down).
     */
    private ThereCanBeOnlyOne() {
    }

    /** Public method for other classes/objects to ask for the singleton.
     *  Static methods are called on the class itself - no need for an 
     *  object instance. Note the return type! Yup, the class of the 
     *  return type is this class.
     */
    public static ThereCanBeOnlyOne getInstance() {
        if (onlyOne == null) {
            onlyOne = new ThereCanBeOnlyOne(); // calling private constructor
        }
        return onlyOne; // either new (and only) instance created and returned
                        // or the one (and only) instance is returned
    }

    /** Some method that only this class can do, and why we might want a singleton
     *  (e.g. only the President can grant clemency for federal crimes.
     *  There can be only one President, and only the President can pardon).
     *  This is likely an important method, so we'll make it private and place
     *  some logic needed to conduct this method.   
     *  @param String, the request
     *  @param String, the person hoping to be pardoned
     */
    public void requestPardon(String request, String personToPardon) {
        if (request.toLowerCase().contains("please")) {
            System.out.println(grantPardon(personToPardon));
        } else {
            System.out.println(denyPradon(personToPardon));
        }
    }

    /** Private method of the President singleton class - grants pardon
     *  @param String, the person hoping to be pardoned
     *  @return decision to grant pardon
     */
    private String grantPardon(String personToPardon) {
        String decision = "Madame President hereby pardons "
                + personToPardon + ".";
        return decision;
    }

    /** Private method of the President singleton class - denies pardon
     *  @param String, the person hoping to be pardoned
     *  @return decision to deny pardon
     */
    private String denyPradon(String personToPardon) {
        String decision = "Madame President refuses to pardon "
                + personToPardon + ".";
        return decision;
    }
}
