package com.rodolfonemes.livraria.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LivroEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  @NotNull
  private Integer year;

  public void update(LivroEntity livro) {
    this.name = livro.name;
    this.year = livro.year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LivroEntity that = (LivroEntity) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name)
        && Objects.equals(year, that.year);
  }

  public @NotBlank String getName() {
    return name;
  }

  public void setName(@NotBlank String name) {
    this.name = name;
  }

  public @NotNull Integer getYear() {
    return year;
  }

  public void setYear(@NotNull Integer year) {
    this.year = year;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, year);
  }


}
