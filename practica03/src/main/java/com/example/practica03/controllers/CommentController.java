package com.example.practica03.controllers;

import com.example.practica03.controllers.dtos.requests.CreateCommentRequest;
import com.example.practica03.controllers.dtos.requests.UpdateCommentRequest;
import com.example.practica03.controllers.dtos.responses.GetCommentResponse;
import com.example.practica03.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService service;

    @GetMapping("{id}")
    public GetCommentResponse get(@PathVariable Long id){
        return service.get(id);
    }
    @GetMapping
    public List<GetCommentResponse> list(){
        return service.list();
    }
    @PostMapping
    public GetCommentResponse create(@RequestBody CreateCommentRequest request){
        return service.create(request);
    }
    @PutMapping("{id}")
    public GetCommentResponse update(@PathVariable Long id,@RequestBody UpdateCommentRequest request){
    return service.update(id, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}
