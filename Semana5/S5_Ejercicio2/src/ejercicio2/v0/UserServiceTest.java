package ejercicio2.v0;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

	private UserService servicioUser;
	@BeforeEach
	public void setup() {
		servicioUser = new UserService();
	}
	
	@DisplayName("Anotación para poner un titulo o descripción")
	@Test
	public void test1 () {
		Usuario expectedUser = new Usuario (1L,"Juan");//"Pepe"
		//UserService servicioUser = new UserService();
		final Usuario res = servicioUser.crearUsuario(1L,"Juan");
		//assertEquals compara (¿?) los datos esperardos esperados con los datos recibidos
		Assertions.assertEquals(expectedUser, res);
		//Assertions.assertEquals(expectedUser.id/*nombre*/, res.id/*nombre*/);
		//Assertions.assertNotEquals(expectedUser, res);
		//Assertions.fail();
	}
}
