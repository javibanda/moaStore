package moa.store.person.model.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;



@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Person extends BaseEntity{

    private String name;

    private String firstLastName;

    private String secondLastName;

    private String idDocument;

    @Override
    public String toString(){
        return "Id: " + getId() + ": " + name;
    }

}
