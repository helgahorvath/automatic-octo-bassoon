package hu.strong.fish.model.post;

import hu.strong.fish.model.Tag;
import hu.strong.fish.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@EntityScan
@SequenceGenerator(name="seq", initialValue=1)
@NoArgsConstructor
public class Post {

    public Post(String title, String text, Date createDate, User user) {
        this.title = title;
        this.text = text;
        this.createDate = createDate;
        this.user = user;
    }

    public Post(String title, String text, Date createDate, List<Tag> tag, User user) {
        this.title = title;
        this.text = text;
        this.createDate = createDate;
        this.tag = tag;
        this.user = user;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Column(columnDefinition = "text")
    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @CollectionTable
    private List<Tag> tag;

    @ManyToOne
    private User user;


}
