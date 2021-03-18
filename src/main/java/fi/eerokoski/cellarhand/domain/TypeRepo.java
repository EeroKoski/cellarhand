package fi.eerokoski.cellarhand.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TypeRepo extends CrudRepository<Type, Long> {
	
	List<Type> findByName(String name);

}
