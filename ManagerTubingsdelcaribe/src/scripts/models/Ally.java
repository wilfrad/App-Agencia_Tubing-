package scripts.models;

public class Ally {
    private String document;
    private boolean isKid;
    
    public Ally (String document, boolean isKid) {
        this.document = document;
        this.isKid = isKid;
    }
    
    public String getDocument () {
        return this.document;
    }
    
    public boolean getState () {
        return this.isKid;
    }
}
