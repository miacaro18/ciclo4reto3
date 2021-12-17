package zorrillo.reto2.model;

import com.mongodb.lang.NonNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "perfumes")
public class Fragance {
    @Id
    private String reference;
    @NonNull
    private String brand;
    @NonNull
    private String category;
    @NonNull
    private String presentation;
    @NonNull
    private String description;
    @NonNull
    private boolean availability = true;
    @NonNull
    private double price;
    @NonNull
    private int quantity;
    @NonNull
    private String photography;
}
