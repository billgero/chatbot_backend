package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo")
public class MainController {
	
	@Autowired
	private HouseRepository houseRepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewHouse (@RequestParam int price, @RequestParam int size,
		   @RequestParam String location, @RequestParam String phone, @RequestParam int status) {
		// @RequestParam photo field!!!
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		House h = new House();
		h.setPrice(price);
		h.setSize(size);
		h.setLocation(location);
		h.setPhone(phone);
		h.setStatus(status);
		houseRepository.save(h);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<House> getAllUsers() {
		// This returns a JSON or XML with the users
		return houseRepository.findAll();
	}
}
