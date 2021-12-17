package zorrillo.reto2.repository;


import zorrillo.reto2.model.Fragance;
import zorrillo.reto2.repository.crud.FraganceCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FraganceRepositorio {
    @Autowired
    FraganceCrudRepositorio fraganceCrudRepositorio;

    public Fragance save(Fragance fragance){
        return fraganceCrudRepositorio.save(fragance);
    }

    public List<Fragance> getAll(){
        return (List<Fragance>) fraganceCrudRepositorio.findAll();
    }

    public Optional<Fragance> getFragance(String id){
        return fraganceCrudRepositorio.findById(id);
    }

    public void delete(Fragance fragance){
        fraganceCrudRepositorio.delete(fragance);
    }

    public void update(Fragance fragance) {
        fraganceCrudRepositorio.save(fragance);
    }

    public List<Fragance> productByPrice(double precio){
        return fraganceCrudRepositorio.findByPriceLessThanEqual(precio);
    }

    public List<Fragance> findByDescriptionLike(String description){
        return fraganceCrudRepositorio.findByDescriptionLike(description);
    }
}
