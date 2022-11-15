package scripts.notify;

public interface INotifier {
    public abstract void alert(String message);
    public abstract void alert(String process, String message, String error);
}
