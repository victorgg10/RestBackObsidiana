package org.obisidiana.app;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.obisidiana.app.entity.User;
import org.obisidiana.app.repository.IUserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UsuarioRepositoryTest {

	@Autowired
	private IUserRepostory usuarioRespository;
	
	@Test
	public void whenFindById_thenReturnListUser() {
		User user01 = User.builder()
				.userName("pepe")
				.passWord("elpepe")
				.email("elpepe1@gmail.com")
				.firstName("pepe")
				.lastName("piolas")
				.status("created").build();
		usuarioRespository.save(user01);
		
		List<User> founds = usuarioRespository.findById(1);
		
		Assertions.assertThat(founds.size()).isEqualTo(2);
		
	}
	
	
}
