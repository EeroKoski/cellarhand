package fi.eerokoski.cellarhand;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.eerokoski.cellarhand.domain.Type;
import fi.eerokoski.cellarhand.domain.Wine;
import fi.eerokoski.cellarhand.domain.WineRepo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class WineRepoTest {
	
	@Autowired
	private WineRepo wirepo;
	
	@Test
	public void findByProducerShouldReturnAlvesDeSousa() {
		List<Wine> wines = wirepo.findByProducer("Alves de Sousa");
		
		assertThat(wines).hasSize(1);
		assertThat(wines.get(0).getProducer()).isEqualTo("Alves de Sousa");
	}
	
	@Test
	public void createNewWine() {
		Wine wine = new Wine("Sclavos", "Orgion", "2018", "IGP Aenos", "Slopes of Aenos", "Greece", "Mavrodaphne", new Type("Punainen"));
		wirepo.save(wine);
		assertThat(wine.getId()).isNotNull();
	}
	
	
	

}
