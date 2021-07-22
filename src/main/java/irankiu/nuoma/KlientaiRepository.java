package irankiu.nuoma;

import org.springframework.data.repository.CrudRepository;

public interface KlientaiRepository extends CrudRepository<Klientai, Integer> {	
	
	//Iterable<Klientai> findByIdKliento(Integer id);

}
