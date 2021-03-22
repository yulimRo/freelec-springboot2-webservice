package com.webservice.book.springboot.domain.posts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void BaseTimeEntity_enroll(){
        LocalDateTime now = LocalDateTime.of(2021,02,27,0,0,0);
        postRepository.save(Posts.builder().title("title").content("content").author("author").build());
        List<Posts> postsList = postRepository.findAll();
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+ posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
