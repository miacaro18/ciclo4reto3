package zorrillo.reto2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zorrillo.reto2.model.User;
import zorrillo.reto2.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author LUIS GERMAN ORTEGA M.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(Integer id){
        return userRepository.getUser(id);
    }

    public boolean existeEmail(String email){
        return userRepository.existeEmail(email);
    }

    public User autenticateUser(String email, String password){
        Optional<User> usuario = userRepository.autenticateUser(email, password);
        if (usuario.isEmpty()){
            return new User();
        } else{
            return usuario.get();
        }
    }

    public User create(User user){
        if (user.getId() == null){
            return user;
        } else {
            Optional <User> e = userRepository.getUser(user.getId());
            if (e.isEmpty()){
                if (existeEmail(user.getEmail())== false){
                    return userRepository.create(user);
                } else {
                    return user;
                }
            } else{
                return user;
            }
        }
    }

    public User update(User user){
        if (user.getId() != null){
            Optional<User> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()){
                if(user.getIdentification() != null){
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null){
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null){
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null){
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null){
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null){
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null){
                    userDb.get().setZone(user.getZone());
                }
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        }else {
            return user;
        }
    }

    public boolean delete(int userId){
        Optional<User> usuario = userRepository.getUser(userId);
        if(usuario.isEmpty()){
            return false;
        } else{
            userRepository.delete(usuario.get());
            return true;
        }

    }

    public List<User> birthtDayList(String monthBirthtDay) {
        return userRepository.birthtDayList(monthBirthtDay);
    }
}
