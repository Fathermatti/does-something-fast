package does.something.fast;

import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController
{

	@RequestMapping(value = "/")
	public String changeInNothing()
	{
		return "It works fine!";
	}
}
