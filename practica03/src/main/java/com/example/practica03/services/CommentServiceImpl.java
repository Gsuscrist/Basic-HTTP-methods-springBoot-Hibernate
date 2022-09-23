package com.example.practica03.services;

import com.example.practica03.controllers.dtos.requests.CreateCommentRequest;
import com.example.practica03.controllers.dtos.requests.UpdateCommentRequest;
import com.example.practica03.controllers.dtos.responses.CreateCommentResponse;
import com.example.practica03.controllers.dtos.responses.GetCommentResponse;
import com.example.practica03.entities.Comment;
import com.example.practica03.repositories.ICommentRepository;
import com.example.practica03.services.interfaces.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentRepository repository;

    @Override
    public GetCommentResponse get(Long id){
        return from(id);
    }
    @Override
    public List<GetCommentResponse> list(){
        return repository.findAll()
                .stream()
                .map(this::from)
                .collect(Collectors.toList());
    }
    @Override
    public GetCommentResponse create(CreateCommentRequest request){
        Comment comment =from(request);
        return from(repository.save(comment));
    }
    @Override
    public GetCommentResponse update(Long id, UpdateCommentRequest request){
     Comment comment= repository.findById(id).orElseThrow(()-> new RuntimeException("The comment donnot exist"));
     comment = update(comment, request);
     return from(comment);
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }

    private Comment update(Comment comment, UpdateCommentRequest request){
        comment.setUserName(request.getName());
        comment.setContent(request.getContent());
        return repository.save(comment);
    }

    private Comment from(CreateCommentRequest request){
        Comment comment= new Comment();
        comment.setUserName(request.getName());
        comment.setContent(request.getContent());
        return comment;

    }


    private GetCommentResponse from(Comment comment){
        GetCommentResponse response= new GetCommentResponse();
        response.setId(comment.getId());
        response.setName(comment.getUserName());
        response.setContent(comment.getContent());
        return response;
    }

    private GetCommentResponse from(long idComment){
        return repository.findById(idComment)
                .map(this::from)
                .orElseThrow(()-> new RuntimeException("The comment donnot exist"));
    }
}
