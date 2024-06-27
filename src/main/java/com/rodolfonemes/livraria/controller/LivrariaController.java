package com.rodolfonemes.livraria.controller;

import com.rodolfonemes.livraria.entity.LivroEntity;
import com.rodolfonemes.livraria.service.LivrariaService;
import java.util.List;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/livraria/livros")
@AllArgsConstructor
@CrossOrigin("*")
public class LivrariaController {

  private final LivrariaService livrariaService;

    public LivrariaController() {
        livrariaService = null;
    }


    @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public LivroEntity insertBook(@Valid @RequestBody LivroEntity livro) {
    return livrariaService.insertBook(livro);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public LivroEntity getBookByNameAndYear(@RequestParam String name, @RequestParam Integer year) {
    return livrariaService.getBookByNameAndYear(name, year);
  }

  @GetMapping("/all")
  @ResponseStatus(HttpStatus.OK)
  public List<LivroEntity> getAllbooks() {
    return livrariaService.getAllBooks();
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.OK)
  public void deleteBook(@RequestParam Long id) {
    livrariaService.deleteBook(id);
  }

  @PatchMapping
  @ResponseStatus(HttpStatus.OK)
  public LivroEntity updateBook(@RequestParam Long id, @Valid @RequestBody LivroEntity livro) {
    return livrariaService.updateBook(id, livro);
  }

}
