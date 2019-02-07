package does.something.fast.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.*;
import com.lmax.disruptor.util.DaemonThreadFactory;

import does.something.fast.values.ValueEvent;
import does.something.fast.values.ValueEventHandler;

@Configuration
public class DisruptorConfiguration
{
	@Bean
	public RingBuffer<ValueEvent> ConfigureDisruptor()
	{
		// Specify the size of the ring buffer, must be power of 2.
		int bufferSize = 1024;

		Disruptor<ValueEvent> disruptor = new Disruptor<>(
				ValueEvent::new, 
				bufferSize, 
				DaemonThreadFactory.INSTANCE,
				ProducerType.SINGLE, 
				new BlockingWaitStrategy());
		
		disruptor.handleEventsWith(new ValueEventHandler());

		disruptor.start();

		return disruptor.getRingBuffer();
	}
}
