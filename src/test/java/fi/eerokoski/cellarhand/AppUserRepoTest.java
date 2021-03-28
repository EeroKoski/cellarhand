package fi.eerokoski.cellarhand;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.eerokoski.cellarhand.domain.AppUser;
import fi.eerokoski.cellarhand.domain.AppUserRepo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserRepoTest {
	@Autowired
	private AppUserRepo aurepo;
	
	@Test
	public void findByUserNameShouldReturnUser() {
		List<AppUser> appUsers = aurepo.findByUsername("user");
		
		assertThat(appUsers).hasSize(1);
		assertThat(appUsers.get(0).getUsername()).isEqualTo("user");
	}
	
	@Test
	public void createNewUser() {
		AppUser appuser = new AppUser("guest", "oisjf0u89q32roisnehf", "USER");
		aurepo.save(appuser);
		assertThat(appuser.getId()).isNotNull();
	}
	
	
	

}
