package fi.eerokoski.cellarhand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.eerokoski.cellarhand.domain.AppUser;
import fi.eerokoski.cellarhand.domain.AppUserRepository;
import fi.eerokoski.cellarhand.domain.Type;
import fi.eerokoski.cellarhand.domain.TypeRepo;
import fi.eerokoski.cellarhand.domain.Wine;
import fi.eerokoski.cellarhand.domain.WineRepo;



@SpringBootApplication
public class CellarhandApplication {
	private static final Logger log = LoggerFactory.getLogger(CellarhandApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CellarhandApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner cellarHand(WineRepo wirepo, TypeRepo tyrepo, AppUserRepository urepository) {
		return (args) -> {
			log.info("esimerkkiviinit");


					tyrepo.save(new Type("Red"));
					tyrepo.save(new Type("White"));
					tyrepo.save(new Type("Orange"));
					tyrepo.save(new Type("Rosé"));
					tyrepo.save(new Type("Fortified"));
					tyrepo.save(new Type("Sparkling"));
					
					wirepo.save(new Wine("Alves de Sousa", "Abandonado", 2011, "Douro", "Portugal", "Touriga Nacional, Touriga Franca", tyrepo.findByName("Red").get(0)));
					wirepo.save(new Wine("R. Lopez de Heredia", "Vina Tondonia Gran Reserva", 1995, "Rioja", "Spain", "Tempranillo", tyrepo.findByName("Red").get(0)));
					wirepo.save(new Wine("Domaine Georges Vernay", "Terrasses de l'Empire", 2019, "Condrieu", "France", "Viognier", tyrepo.findByName("White").get(0)));
					wirepo.save(new Wine("La Stoppa", "Ageno", 2011, "Emilia-Romagna", "Italy", "Malvasia", tyrepo.findByName("Orange").get(0)));
					wirepo.save(new Wine("Domaine Schoffit", "Cuvee Catherine", 2000, "Douro", "Portugal", "Touriga Nacional, Touriga Franca", tyrepo.findByName("White").get(0)));
					wirepo.save(new Wine("Bollinger", "La Grande Annee", 1988, "Champagne", "France", "Pinot Noir, Chardonnay, Pinot Meunier", tyrepo.findByName("Sparkling").get(0)));
					
					AppUser user1 = new AppUser("user", "\n"
							+ "$2y$12$ZNscmmykeTinqMmLE6aOyOOD3XWjtr8B1lL1qkaQc3xZ3Cv5DbVMG\n"
							+ "", "USER");
					AppUser user2 = new AppUser("admin", "$2y$12$ZsW3J2iKTEhZ1N7GmuT9YOwydpB1aBScGM92htbX4TlFagTTtIdfW", "ADMIN");
					// admin + user
					urepository.save(user1);
					urepository.save(user2);
					
					log.info("fetch all wines");
					for (Wine wine : wirepo.findAll()) {
							log.info(wine.toString());
					}
			};
		}
	}
		
