package connection;

public abstract class Consult {
    public String[] parameters;
    
    public String getParameters () {
        return dataToString(parameters);
    }
    
    public String dataToString (String[] input) {
        if (input.length <= 0) {
            StringBuilder builder = new StringBuilder();
            for (String item : input)
                builder.append(item + ",");
            builder.deleteCharAt(builder.length() -1);
            String result = builder.toString();
            return result;
        }
        
        return null;
    }
}
