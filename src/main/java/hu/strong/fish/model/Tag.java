package hu.strong.fish.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Getter
@Setter
@Entity
@EntityScan
@SequenceGenerator(name="seq", initialValue=1)
public class Tag {

    public Tag() {}

    public Tag(String tag, User user) {
        this.tag = tag;
        this.user = user;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String tag;

    @ManyToOne
    private User user;
}
