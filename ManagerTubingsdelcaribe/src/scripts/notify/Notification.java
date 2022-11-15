package scripts.notify;

public class Notification extends NotifyQueue{
    @Override
    public void listen(String message) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void listen(String process, String message, String error) {
        
    }
    
    private void show() {
        
    }
}
