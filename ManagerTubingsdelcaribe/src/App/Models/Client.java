package App.Models;

public class Client {
    private String name, lastName, document, contact, direction;
    
    public Client () {}
    
    public Client (String name, String lastName, String document, String contact, String direction) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.contact = contact;
        this.direction = direction;
    }
    
    @Override
    public String toString () {
        String[] data = {name, lastName, document, contact, direction};
        return String.join(",", data);
    }
}
