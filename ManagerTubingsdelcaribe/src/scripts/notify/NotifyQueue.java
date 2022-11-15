package scripts.notify;

import java.util.ArrayList;

public abstract class NotifyQueue implements IMonitor{
    private ArrayList<INotifier> notifiers;
    
    private void unsubcribe(INotifier notifier) {
        notifiers.remove(notifier);
    }
}
