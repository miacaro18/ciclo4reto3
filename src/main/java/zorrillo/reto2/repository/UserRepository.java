package zorrillo.reto2.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import zorrillo.reto2.model.User;
import zorrillo.reto2.repository.crud.UserCrudRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author LUIS GERMAN ORTEGA M.
 */
@Repository
public class UserRepository {
    /**
     * Inyección Dependecias
     */
    @Autowired
    private UserCrudRepository userCrudRepository;
    /**
     * Consulta por ID
     */
    public Optional<User> getUser(Integer idUser){
        return userCrudRepository.findById(idUser);
    }
    /**
     * Crear Usuario
     */
    public User create(User user){
        return userCrudRepository.save(user);
    }
    /**
     * Actualizar Usuario
     */
    public void update (User user){
        userCrudRepository.save(user);
    }
    /**
     * Consultar Usuarios
     */
    public List<User> getAll(){
        return userCrudRepository.findAll();
    }
    /**
     * Consulta Existe Email
     */
    public boolean existeEmail(String email){
        Optional<User> usuario=userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }
    /**
     * Consulta Email y Contraseña
     */
    public  Optional<User> autenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    /**
     * Borrar Usuario
     */
    public void delete(User user){
        userCrudRepository.delete(user);
    }
    /**
     * Consulta por mes de cumpleaños
     */
    public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
}
