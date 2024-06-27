package com.rodolfonemes.livraria.service;

import com.rodolfonemes.livraria.entity.LivroEntity;
import com.rodolfonemes.livraria.exception.BookNotFoundException;
import com.rodolfonemes.livraria.exception.DuplicatedBookException;
import com.rodolfonemes.livraria.repository.LivrariaRepository;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LivrariaService {

  private LivrariaRepository livrariaRepository;

  public LivroEntity insertBook(LivroEntity livro) {
    if (livrariaRepository.existsByNameAndYear(livro.getName(), livro.getYear())) {
      throw new DuplicatedBookException(HttpStatus.BAD_REQUEST, "Livro já cadastrado");
    }
    return livrariaRepository.save(livro);
  }

  public List<LivroEntity> getAllBooks() {
    return livrariaRepository.findAll();
  }

  public LivroEntity getBookByNameAndYear(String name, Integer year) {
    if (!livrariaRepository.existsByNameAndYear(name, year)) {
      throw new BookNotFoundException(HttpStatus.BAD_REQUEST, "Livro não encontrado");
    }
    return livrariaRepository.findByNameAndYear(name, year);
  }

  public void deleteBook(Long id) {
    if (!livrariaRepository.existsById(id)) {
      throw new BookNotFoundException(HttpStatus.BAD_REQUEST, "Livro não encontrado");
    }
    livrariaRepository.deleteById(id);
  }

  public LivroEntity updateBook(Long id, LivroEntity livro) {
    if (livrariaRepository.existsByNameAndYear(livro.getName(), livro.getYear())) {
      throw new DuplicatedBookException(
          HttpStatus.BAD_REQUEST,
          "Já existe um livro com esse nome e ano"
      );
    }
      LivroEntity livroEntity = livrariaRepository.getReferenceById(id);

      livroEntity.update(livro);
      return livrariaRepository.save(livroEntity);
  }

}
