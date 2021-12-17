package zorrillo.reto2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zorrillo.reto2.model.User;
import zorrillo.reto2.service.UserService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author LUIS GERMAN ORTEGA M.
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    /**
     * Inyección Dependecias
     */
    @Autowired
    private UserService userService;
    /**
     * Consulta todos los usuarios
     */
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    /**
     * Consulta por ID
     */
    @GetMapping("{id}")
    public Optional<User> getUser(@PathVariable("id") Integer idUs){
        return userService.getUser(idUs);
    }
    /**
     * Consulta si Existe Email
     */
    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return userService.existeEmail(email);
    }
    /**
     * Consulta por Email y Password
     */
    @GetMapping("/{email}/{password}")
    public User autenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.autenticateUser(email, password);
    }
    /**
     * Crear Nuevo Usuario
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){
        return userService.create(user);
    }
    /**
     * Actualizar Usuario
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }
    /**
     * Borrar Usuario
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idUser){
        return userService.delete(idUser);
    }

    @GetMapping("/birthday/{month}")
    public List<User> birthtDayList(@PathVariable("month") String monthBirthtDay) {
        return userService.birthtDayList(monthBirthtDay);
    }
}
