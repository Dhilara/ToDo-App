package com.dhilara.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhilara.todoapp.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long>{

}
