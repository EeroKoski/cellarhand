package fi.eerokoski.cellarhand;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.eerokoski.cellarhand.domain.Type;
import fi.eerokoski.cellarhand.domain.TypeRepo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TypeRepoTest {
	@Autowired
	private TypeRepo tyrepo;
	
	@Test
	public void findByNameShouldReturnType() {
		List<Type> types = tyrepo.findByName("Orange");
		
	}
	

}