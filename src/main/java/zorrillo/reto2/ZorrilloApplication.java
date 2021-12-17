package zorrillo.reto2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zorrillo.reto2.repository.crud.UserCrudRepository;
//import zorrillo.reto2.repository.crud.FraganceCrudRepositorio;


@SpringBootApplication
public class ZorrilloApplication implements CommandLineRunner {
	@Autowired
	private UserCrudRepository userCrudRepository;
	//private FraganceCrudRepositorio fraganceCrudRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(ZorrilloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userCrudRepository.deleteAll();  //Borra la base de datos tabla usuario
		//fraganceCrudRepositorio.deleteAll();
	}
}
