package pl.sda.restexample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Post addNewPost(@RequestBody Post postToAdd) {
        return postRepository.save(postToAdd);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Post> getPosts() {
        return postRepository.findAll();
    }
//    TODO: write test for get method

//    @DeleteMapping
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    Post deletePost (@RequestParam("id") Long id){
//        postRepository.deleteById(id);
//        return HttpStatus.
//    }

//    TODO: write test for delete method

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    Post updatePost(@PathVariable("id") Long id, @RequestBody Post postToUpdate) {
        return postRepository.save(postToUpdate);
    }
//    TODO: write test for put method and update it to chenge already existing posts not only adding new
}
