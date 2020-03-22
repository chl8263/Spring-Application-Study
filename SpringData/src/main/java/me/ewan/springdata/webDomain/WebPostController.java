package me.ewan.springdata.webDomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class WebPostController {

    @Autowired
    WebPostRepository webPostRepository;

    @GetMapping("/post/{id}")
    //public String getPost(@PathVariable("id") Long id){
    public String getPost(@PathVariable("id") WebPost webPost){
        return webPost.getTitle();
    }

    @GetMapping("/posts")
    public Page<WebPost> getPosts(Pageable pageable, PagedResourcesAssembler<WebPost> webPostPagedResourcesAssembler){
        System.out.println("---------------");
        System.out.println(pageable);
        return webPostRepository.findAll(pageable);
    }
}
