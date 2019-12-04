
public class Person {
    private String name;
    private String email;
    
    public Person() {}
    
    public Person(String n, String e) {
        name = n;
        email = e;
    }
    
    public void setName(String n) {
        name = n;   
    }
    
    public void setEmail(String e) {
        email = e;   
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;   
    }
    
    public String toString() {
        return name + ", " + email;   
    }
}
