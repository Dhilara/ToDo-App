package com.dhilara.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhilara.todoapp.model.ToDo;
import com.dhilara.todoapp.repository.ToDoRepository;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	ToDoRepository toDoRepo;
	
	@Override
	public List<ToDo> getAllToDoItems() {
		return toDoRepo.findAll();
	}

	@Override
	public ToDo getToDoItemById(Long id) {
		return toDoRepo.findById(id)
	               .orElseThrow(() -> new RuntimeException("ToDo item not found for id: " + id));
	}

	@Override
	public boolean updateToDoStatus(Long id) {
		ToDo todo = getToDoItemById(id);
		todo.setStatus("Completed");
		
		return saveOrUpdateToDoItem(todo);		
	}

	@Override
	public boolean saveOrUpdateToDoItem(ToDo todo) {
		ToDo updatedObj = toDoRepo.save(todo);
		
		if(getToDoItemById(updatedObj.getId()) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteToDoItem(Long id) {
		toDoRepo.deleteById(id);
		if(toDoRepo.findById(id).isEmpty()) {
			return true;
		}
		return false;
	}

}
