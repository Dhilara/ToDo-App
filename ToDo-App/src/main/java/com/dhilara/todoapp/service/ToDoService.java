package com.dhilara.todoapp.service;

import java.util.List;

import com.dhilara.todoapp.model.ToDo;

public interface ToDoService {
	
	List<ToDo> getAllToDoItems(); 
	
	ToDo getToDoItemById(Long id);
	
	boolean updateToDoStatus(Long id);
	
	boolean saveOrUpdateToDoItem(ToDo todo);
	
	boolean deleteToDoItem(Long id);

}
