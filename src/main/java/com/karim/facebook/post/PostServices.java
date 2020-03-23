package com.karim.facebook.post;

import com.karim.facebook.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
public class PostServices {

    @Autowired
    private PostRepository repository ;

    public Post addPost(Post post){
        post.setDate(new Date());
        return repository.save(post);
    }

    public Post updatePost(Post post){
        return repository.save(post);
    }

    public List<Post> getAll(){
        return repository.findAll();
    }

    public Post getOne(long id){
        return repository.findById(id).get();
    }

    public void deleteOne(Post post){
        repository.delete(post);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public List<Post> findByUser(User user){
        return repository.findByUser(user);
    }

}
