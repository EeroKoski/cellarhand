package fi.eerokoski.cellarhand.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.eerokoski.cellarhand.domain.TypeRepo;
import fi.eerokoski.cellarhand.domain.Wine;
import fi.eerokoski.cellarhand.domain.WineRepo;

@Controller
public class CellarController {
	
	
	
	@Autowired
	private TypeRepo tyrepo;
	
	
	@Autowired
	private WineRepo wirepo;
	
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
	}
	
	@RequestMapping(value= {"/", "/cellar"})
	public String wineList(Model model) {
		model.addAttribute("wines", wirepo.findAll());
		return "cellar";
	}
	
	@RequestMapping(value= "/add")
	public String addWine(Model model) {
		model.addAttribute("wine", new Wine());
		model.addAttribute("types", tyrepo.findAll());
		return "addwine";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Wine wine){
        wirepo.save(wine);
        return "redirect:cellar";
	}
        
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteWine(@PathVariable("id") Long Id, Model model) {
    	wirepo.deleteById(Id);
        return "redirect:../cellar";
    }
    
    
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editWine(@PathVariable("id") Long Id, Model model){
    	model.addAttribute("wine", wirepo.findById(Id));
		model.addAttribute("types", tyrepo.findAll());
        return "editwine";
    }         
    
    
	
	
}
