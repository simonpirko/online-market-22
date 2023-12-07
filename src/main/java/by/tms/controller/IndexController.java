package by.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Simon Pirko on 19.11.23
 */

@Controller
@RequestMapping("/index")
public class IndexController {

	@GetMapping
	public String getIndex() {
		return "index.html";
	}
}
