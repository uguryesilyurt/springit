package com.ugur.springit;

import com.ugur.springit.domain.Comment;
import com.ugur.springit.domain.Link;
import com.ugur.springit.repository.CommentRepository;
import com.ugur.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableJpaAuditing
public class SpringItApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringItApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringItApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("Getting Started with Spring Boot 2", "https://therealdanvega.com/spring-boot-2");
            linkRepository.save( link );

            Comment comment = new Comment("This Spring Boot 2 Link is awesome", link);
            commentRepository.save(comment);

            link.addComment(comment);

            Link firstLink = linkRepository.findByTitle("Getting Started with Spring Boot 2");
            System.out.println(firstLink.getTitle());
        };
    }

}
