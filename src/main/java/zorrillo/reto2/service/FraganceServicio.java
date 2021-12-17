package zorrillo.reto2.service;

import java.util.List;
import java.util.Optional;

import zorrillo.reto2.model.Fragance;
import zorrillo.reto2.repository.FraganceRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraganceServicio {
    @Autowired
    private FraganceRepositorio fraganceRepositorio;

    public Fragance save(Fragance fragance){
        return fraganceRepositorio.save(fragance);
    }

    public List<Fragance>getAll(){
        return fraganceRepositorio.getAll();
    }

    public Optional<Fragance> getFragance(String id){
        return fraganceRepositorio.getFragance(id);
    }

    public boolean deleteFragance(String id){
        Optional<Fragance> consulta=fraganceRepositorio.getFragance(id);
        if (!consulta.isEmpty()) {
            fraganceRepositorio.delete(consulta.get());
            return true;
        }
        return false;
    }

    public Fragance update(Fragance fragance){
        if (fragance.getReference()!=null) {
            Optional<Fragance> consulta=fraganceRepositorio.getFragance(fragance.getReference());
            if (!consulta.isEmpty()) {
                if (fragance.getReference()!=null) {
                    consulta.get().setReference(fragance.getReference());
                }
                if (fragance.getBrand()!=null) {
                    consulta.get().setBrand(fragance.getBrand());
                }
                if (fragance.getCategory()!=null) {
                    consulta.get().setCategory(fragance.getCategory());
                }
                if (fragance.getPresentation()!=null) {
                    consulta.get().setPresentation(fragance.getPresentation());
                }
                if (fragance.getDescription()!=null) {
                    consulta.get().setDescription(fragance.getDescription());
                }

                if (fragance.getPrice()>0.0) {
                    consulta.get().setPrice(fragance.getPrice());
                }

                if (fragance.getQuantity()>0) {
                    consulta.get().setQuantity(fragance.getQuantity());
                }
                
                if (fragance.getPhotography()!=null){
                    consulta.get().setPhotography(fragance.getPhotography());
                }
                return fraganceRepositorio.save(consulta.get());
            }
        }
        return fragance;
    }

    //Reto 5
    public List<Fragance> productByPrice(double price) {
        return fraganceRepositorio.productByPrice(price);
    }

    //Reto 5
    public List<Fragance> findByDescriptionLike(String description) {
        return fraganceRepositorio.findByDescriptionLike(description);
    }

}
