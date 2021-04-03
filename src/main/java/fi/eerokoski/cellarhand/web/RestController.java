package fi.eerokoski.cellarhand.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.eerokoski.cellarhand.domain.Type;
import fi.eerokoski.cellarhand.domain.TypeRepo;
import fi.eerokoski.cellarhand.domain.Wine;
import fi.eerokoski.cellarhand.domain.WineRepo;

public class RestController {

	@Autowired
	private TypeRepo tyrepo;
	
	
	@Autowired
	private WineRepo wirepo;
	
	@RequestMapping("/wines")
	public List <Wine>wineListRest() {
			return (List<Wine>) wirepo.findAll();
	}
	
	@RequestMapping("/types")
	public List <Type>typeListRest() {
			return (List<Type>) tyrepo.findAll();
	}
	
	
}
