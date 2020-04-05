package hu.strong.fish.config;

import hu.strong.fish.model.Field;
import hu.strong.fish.model.Status;
import hu.strong.fish.model.Tag;
import hu.strong.fish.model.User;
import hu.strong.fish.model.post.Post;
import hu.strong.fish.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.HashMap;

@Component
public class TestData {


    @Order(1)
    @Bean
    public CommandLineRunner addUser(UserRepository userRepository) {
        return args -> {
            System.out.println("idejut");
            User user = new User();
            user.setUsername("joska");
            user.setPassword("benajelszo");

            userRepository.save(user);
        };
    }

    @Order(2)
    @Bean
    public CommandLineRunner addTag(TagRepository tagRepository, UserRepository userRepository) {
        return args -> {
            Tag tag = new Tag();
            tag.setTag("alvás");
            User user = userRepository.getOne(1L);
            tag.setUser(user);

            tagRepository.save(tag);
        };
    }

    @Order(3)
    @Bean
    public CommandLineRunner addPosts(PostRepository postRepository, TagRepository tagRepository, UserRepository userRepository) {
        return args -> {
            Post post = new Post();
            Tag tag = tagRepository.getOne(1L);
            User user = userRepository.getOne(1L);
            post.setCreateDate(new Timestamp(System.currentTimeMillis()));
            post.setTitle("hurrá");
            post.setText("zzzzzzzzzzzzzzzzzzzzzz");
            post.setUser(user);

            postRepository.save(post);
        };
    }

    @Order(4)
    @Bean
    public CommandLineRunner addFields(FieldRepository fieldRepository, UserRepository userRepository) {
        return args -> {
            Field field1 = new Field();
            User user = userRepository.getOne(1L);
            field1.setField("mezőke");;
            field1.setUser(user);

            fieldRepository.save(field1);

            Field field2 = new Field();
            field2.setField("másik mezőke");;
            field2.setUser(user);

            fieldRepository.save(field2);
        };
    }

    @Order(5)
    @Bean
    public CommandLineRunner addStatus(StatusRepository statusRepository, FieldRepository fieldRepository, UserRepository userRepository) {
        return args -> {
            Status status = new Status();
            Field field1 = fieldRepository.getOne(1L);
            Field field2 = fieldRepository.getOne(2L);
            User user = userRepository.getOne(1L);
            status.setDate(new Timestamp(System.currentTimeMillis()));
            HashMap<Field, String> fieldValues = new HashMap<>();
            fieldValues.put(field1, "első mezőke értéke");
            fieldValues.put(field2, "második érték");
            status.setUser(user);
            status.setFieldsValues(fieldValues);

            statusRepository.save(status);
        };
    }
}
