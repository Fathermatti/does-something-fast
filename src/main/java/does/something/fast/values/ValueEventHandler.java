package does.something.fast.values;

import com.lmax.disruptor.EventHandler;

public class ValueEventHandler implements EventHandler<ValueEvent>
{
    public void onEvent(ValueEvent event, long sequence, boolean endOfBatch)
    {
        System.out.println("Event: " + event.get());
    }
}
