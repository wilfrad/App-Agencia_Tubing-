package scripts.models;

import java.util.ArrayList;

public class Service {
    private Client _Client;
    private Plan _Plan;
    private ArrayList<Ally> allys = new ArrayList();
    
    public Service () {}
    
    public Service (Client _Client, Plan _Plan, ArrayList<Ally> allys) {
        this._Client = _Client;
        this._Plan = _Plan;
        this.allys = allys;
    }
    
    public Client getClient () {
        return this._Client;
    }
    
    public Plan getPlan () {
        return this._Plan;
    }
    
    public ArrayList<Ally> getAllys () {
        return this.allys;
    }
}
