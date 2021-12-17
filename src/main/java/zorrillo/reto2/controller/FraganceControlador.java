package zorrillo.reto2.controller;

import java.util.List;
import java.util.Optional;

import zorrillo.reto2.model.Fragance;
import zorrillo.reto2.service.FraganceServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/fragance")
@CrossOrigin("*")
public class FraganceControlador {
    @Autowired
    private FraganceServicio fraganceServicio;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance save(@RequestBody Fragance fragance){
        return fraganceServicio.save(fragance);
    }
    
    @GetMapping("/all")
    public List<Fragance>getFragance(){
        return fraganceServicio.getAll();
    }

    @GetMapping("{id}")
    public Optional<Fragance>getFragance(@PathVariable("id") String id){
        return fraganceServicio.getFragance(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteFragance(@PathVariable("id") String id){
        return fraganceServicio.deleteFragance(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance update(@RequestBody Fragance fragance){
        return fraganceServicio.update(fragance);
    }

    @GetMapping("/price/{price}")
    public List<Fragance> fraganceByPrice(@PathVariable("price") double precio){
        return fraganceServicio.productByPrice(precio);
    }

    @GetMapping("/description/{description}")
    public List<Fragance> findByDescriptionLike(@PathVariable("description") String description) {
        return fraganceServicio.findByDescriptionLike(description);
    }
}
