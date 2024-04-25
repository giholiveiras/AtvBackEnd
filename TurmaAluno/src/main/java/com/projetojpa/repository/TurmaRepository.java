package com.projetojpa.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projetojpa.entities.Aluno;
import com.projetojpa.entities.Turma;


public interface TurmaRepository extends JpaRepository <Turma, Long> {
	List <Turma> findByNome (String nome);
	List <Turma> findByDescricao (String descricao);
	
	//Buscar todos os alunos de uma determinada turma:
	@Query ("SELECT  a FROM Aluno a JOIN a.turma t WHERE t.id = :turmaId")
	List <Aluno> findByTurmaId (@Param("turmaId")Long turmaId);
}
