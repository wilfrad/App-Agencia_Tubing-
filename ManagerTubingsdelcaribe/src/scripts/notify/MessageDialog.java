package scripts.notify;

public class MessageDialog implements IMonitor{
    @Override
    public void listen(String message) {
        
    }

    @Override
    public void listen(String process, String message, String error) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void show() {
        
    }
    
}
