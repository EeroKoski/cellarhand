package fi.eerokoski.cellarhand.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AppUserRepo extends CrudRepository<AppUser, Long> {
	List<AppUser> findByUsername(String username);
}