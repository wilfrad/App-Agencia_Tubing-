package scripts.notify;

public interface IMonitor {
    public abstract void listen(String message);
    public abstract void listen(String process, String message, String error);
}
