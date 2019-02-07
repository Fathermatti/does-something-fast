package does.something.fast.values;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lmax.disruptor.RingBuffer;


@RestController
public class ValueController
{

	private RingBuffer<ValueEvent> ringBuffer;

	public ValueController(RingBuffer<ValueEvent> ringBuffer)
	{
		this.ringBuffer = ringBuffer;
	}

	@RequestMapping(value = "/do-something/{value}", method = RequestMethod.GET)
	public ResponseEntity<HttpStatus> changeInNothing(@PathVariable long value)
	{
		ringBuffer.publishEvent((event, sequence, buffer) -> event.set(value), value);

		return ResponseEntity.ok(HttpStatus.OK);
	}
}
