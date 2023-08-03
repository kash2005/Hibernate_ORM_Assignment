package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books;
}
