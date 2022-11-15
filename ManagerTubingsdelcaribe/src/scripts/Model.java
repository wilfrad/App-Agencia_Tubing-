package scripts;

import scripts.models.Ally;
import scripts.models.Client;
import scripts.models.Plan;
import scripts.models.Service;
import java.util.ArrayList;

public class Model {
    private static Service _Service;
    private static Client _Client;
    private static Plan _Plan;
    private static ArrayList<Ally> _Allys;
    
    public void setClient (String name, String lastName, String document, String contact, String direction) {
        Client newClient = new Client(name, lastName, document, contact, direction);
        _Client = newClient;
    }
    
    public void setPlan (double valueAdult, double valueKid, int[] amounts) {
        Plan newPlan = new Plan(valueAdult, valueKid, amounts);
        _Plan = newPlan;
    }
    
    public void setAlly (Ally ally) {
        _Allys.add(ally);
    }
    
    public void setService () {
        Service newService = new Service(_Client, _Plan, _Allys);
        _Service = newService;
    }
    
    public Service getService () {
        return _Service;
    }
    
    public Client getClient () {
        return _Client;
    }
    
    public Plan getPlan () {
        return _Plan;
    }
    
    public ArrayList<Ally> getAllys () {
        return _Allys;
    }
    
    public void clear () {
        _Client = null;
        _Plan = null;
        _Allys = null;
        _Service = null;
    }
}
