package zorrillo.reto2.repository.crud;

import org.springframework.data.mongodb.repository.Query;
import zorrillo.reto2.model.Fragance;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FraganceCrudRepositorio extends MongoRepository<Fragance,String>{
    public List<Fragance> findByPriceLessThanEqual(double precio);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Fragance> findByDescriptionLike(String description);
}
