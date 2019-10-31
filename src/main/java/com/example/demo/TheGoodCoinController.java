package com.example.demo;

import java.util.List;

import javax.validation.Valid;
import com.example.demo.Annonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TheGoodCoinController {

	@Autowired
	TheGoodCoinService myService;
	

	
	@RequestMapping("/")
	public String home (Model m) {
		
		List<Annonce> annonces= myService.findAll();
		m.addAttribute("annonces", annonces);	
		return "index";
	}
	
//@RequestMapping(value="/addAnnonce", method = RequestMethod.POST)
//public String submit(@Valid @ModelAttribute("annonce")Annonce annonce, Model m) {
//	m.addAttribute("title", myAnnonce.getTitle());
//	m.addAttribute("description", myAnnonce.getDescription());
//	m.addAttribute("prix", myAnnonce.getPrix());
//	m.addAttribute("codePostal", myAnnonce.getCodePostal());
//	m.addAttribute("ville", myAnnonce.getVille());
//	m.addAttribute("date", myAnnonce.getDate());
//	return "index";
//}
//		
//	}

}
