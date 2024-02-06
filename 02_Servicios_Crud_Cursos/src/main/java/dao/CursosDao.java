package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Curso;

public interface CursosDao  extends JpaRepository<Curso, Integer> {

}
