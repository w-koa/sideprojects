package com.techelevator.zinogreFanSite;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GalleryController {
	
	@RequestMapping(path="/gallery", method = RequestMethod.GET)
	public String displayGallery() {
		
		return "gallery";
	}

}
