package com.example.practica03.services.interfaces;

import com.example.practica03.controllers.dtos.requests.CreateCommentRequest;
import com.example.practica03.controllers.dtos.requests.UpdateCommentRequest;
import com.example.practica03.controllers.dtos.responses.CreateCommentResponse;
import com.example.practica03.controllers.dtos.responses.GetCommentResponse;

import java.util.List;

public interface ICommentService {
    GetCommentResponse get(Long id);

    List<GetCommentResponse> list();
    GetCommentResponse create(CreateCommentRequest request);
    GetCommentResponse update(Long id, UpdateCommentRequest request);
    void delete(Long id);
}
