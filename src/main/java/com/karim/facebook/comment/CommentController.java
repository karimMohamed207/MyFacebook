package com.karim.facebook.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService service ;

    //--------------------- Add Comment ----------------------
    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        service.addComment(comment);
        return new ResponseEntity<Comment>(comment,HttpStatus.OK);
    }

    //-------------------- Get All Comments ----------------------------
    @GetMapping("")
    public ResponseEntity<List<Comment>> getAllComments(){
        List<Comment> comments = service.getAll();
        if (comments.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<Comment>>(comments , HttpStatus.OK);
    }

    //------------------ Get Comment ---------------------
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getOne(@PathVariable long id){
        Comment comment = service.getOne(id);
        if (comment == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(comment , HttpStatus.OK);
    }

    //---------------------------- Update Comment -------------------
    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable long id , @RequestBody Comment comment){
        Comment currentComment = service.getOne(id);
        if (currentComment == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        currentComment.setComment(comment.getComment());
        currentComment.setDate(comment.getDate());
        service.updateComment(currentComment);
        return new ResponseEntity<>(comment , HttpStatus.OK);
    }

    //---------------------- delete Comment  ------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable long id){
        Comment comment = service.getOne(id);
        if (comment == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        service.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //---------------------- delete All --------------------------
    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        List<Comment> comments = service.getAll();
        if (comments.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
