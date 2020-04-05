package hu.strong.fish.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PostDTO {

    private String id;
    private String text;

    private String title;

    private String createDate;

    private String editDate;

    private List<String> tags;

    private String user;

}
