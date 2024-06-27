package com.rodolfonemes.livraria.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import com.rodolfonemes.livraria.repository.LivrariaRepository;
import com.rodolfonemes.livraria.entity.LivroEntity;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.main.banner-mode=off")
@AutoConfigureDataJpa
@AutoConfigureTestDatabase
class LivrariaServiceTest {

  @Autowired
  private LivrariaService livrariaService;

  @Autowired
  private LivrariaRepository livrariaRepository;


  @Before(value = "")
  public void setup() {
    livrariaRepository = mock(LivrariaRepository.class);
  }



  @Test
  @DisplayName("Insert a new book in a empty database")
  void insertNewBookInAEmptyDatabase() {
    LivroEntity livro = new LivroEntity(null, "Java", 2023);

    LivroEntity livroEntity = livrariaService.insertBook(livro);

    LivroEntity after = livrariaRepository.findById(livroEntity.getId()).get();

    assertEquals(after.getName(), livro.getName());
    assertEquals(after.getYear(), livro.getYear());
  }
}