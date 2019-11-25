/*************************************************************************
 * This class is the blueprint of a family member  
 * A family member has:
 *      - a first name, 
 *      - a last name, and 
 *      - a number of siblings 
 * You are not allowed to modify this code.
 *************************************************************************/ 
//FamilyMember is not a Comparable object. Should implement the Comparable Interface
public class FamilyMember /*implements Comparable<FamilyMember>*/ {
    private String fname;
    private String lname;
    private int siblings;
    
    // Constructors ****************************************************************
    public FamilyMember() {}
    
    public FamilyMember(String fn, String ln, int s) {
        fname = fn;
        lname = ln;
        siblings = s;
    }

    // Setters *********************************************************************
    public void setFName(String fn) {
        fname = fn;
    }
    
    public void setLName(String ln) {
        lname = ln;
    }
    
    public void setSiblings(int s) {
        siblings = s;
    }
    
    // Getters **********************************************************************
    public String getFName() {
        return fname;   
    }
    
    public String getLName() {
        return lname;   
    }
    
    public int getSiblings() {
        return siblings;   
    }
    
    // Other methods ***************************************************************
    public String toString() {
        return fname + " " + lname + ", who had: " + siblings + " siblings.";   
    }
    /*
    @Override
    public int compareTo(FamilyMember fam) {
        if(this.getSiblings() <= fam.getSiblings()) {
            return -1;
        } else if (this.getSiblings() > fam.getSiblings()) {
            return 1;
        } else {
            return 0;
        }
    }
     */
}