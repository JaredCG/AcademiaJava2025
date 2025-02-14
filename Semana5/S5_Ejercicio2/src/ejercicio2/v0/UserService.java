package ejercicio2.v0;

import java.util.HashMap;

public class UserService {
	//private final UserRepository userRepository;
	private final HashMap<Long, Usuario> usuarios = new HashMap<>();
	
    public Usuario crearUsuario (Long id, String nombre) {
    	//return usuarios.put(id, new Usuario(id,nombre));//error al obtener el usuario
    	//Solucion
    	usuarios.put(id, new Usuario(id,nombre));
    	return usuarios.get(id);
    }
    
    public Usuario getUsuario (Long id) {
    	return usuarios.get(id);
    }
    
    public Usuario putUsuario (Long id, String nombre) {
    	return usuarios.put(id, new Usuario(id,nombre));
    }

}
