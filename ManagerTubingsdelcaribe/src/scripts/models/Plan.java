package scripts.models;

import java.util.ArrayList;

public class Plan {
    private ArrayList<Instrument> instruments = new ArrayList();
    private double valueAdult;
    private double valueKid;
    
    public Plan () {}
    
    public Plan (double valueAdult, double valueKid, int[] amounts) {
        setValues(valueAdult, valueKid);
        setInstruments(amounts);
    }
    
    private class Instrument {
        private int amount = 0;
        public void setAmount (int amount) {
            this.amount = amount;
        }
        public int getAmount () {
            return this.amount;
        }
    }
    
    public void setValues (double valueAdult, double valueKid) {
        this.valueAdult = valueAdult;
        this.valueKid = valueKid;
    }
    
    public double getValueAdult () {
        return this.valueAdult;
    }
    
    public double getValueKid () {
        return this.valueKid;
    }
    
    private void setInstruments (int[] amounts) {
        for (int num : amounts) {
            Instrument ins = new Instrument();
            ins.setAmount(num);
            instruments.add(ins);
        }
    }
}
