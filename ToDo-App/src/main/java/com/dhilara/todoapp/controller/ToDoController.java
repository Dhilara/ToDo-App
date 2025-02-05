package com.dhilara.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dhilara.todoapp.model.ToDo;
import com.dhilara.todoapp.service.ToDoService;

@Controller
public class ToDoController {
	
	@Autowired
	private ToDoService toDoService;
	
	@GetMapping({"/", "toDoView"})
	public String viewAllToDoItems(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list", toDoService.getAllToDoItems());
		model.addAttribute("message", message);
		
		return "ToDoView";
		
	}
	
	@GetMapping("/updateToDoStatus/{id}")
	public String UpdateToDoStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if(toDoService.updateToDoStatus(id)) {
			redirectAttributes.addFlashAttribute("message", "Updated Successfully");
			return "redirect:/toDoView";
		}
		
		redirectAttributes.addFlashAttribute("message" , "Failed to Update");
		return "redirect:/toDoView";  
	}
	
	@GetMapping("/addToDoItem")
	public String addToDoItem(Model model) {
		model.addAttribute("todo", new ToDo());
		return "AddToDoItem";
		
	}
	
	@PostMapping("/saveToDoItem")
	public String saveToDoItem(ToDo todo, RedirectAttributes redirectAttributes) {
		if(toDoService.saveOrUpdateToDoItem(todo)) {
			redirectAttributes.addFlashAttribute("message", "Saved Successfully");
			return "redirect:/toDoView";
		}
		
		redirectAttributes.addFlashAttribute("message", "Failed to Save");
		return "redirect:/addToDoItem";
	}
	
	@GetMapping("/editToDoItem/{id}")
	public String editToDoItem(@PathVariable Long id, Model model) {
		model.addAttribute("todo", toDoService.getToDoItemById(id));
		
		return "EditToDoItem";	
	}
	
	@PostMapping("/editSaveToDoItem")
	public String editSaveToDoItem(ToDo todo, RedirectAttributes redirectAttributes) {
		if(toDoService.saveOrUpdateToDoItem(todo)) {
			redirectAttributes.addFlashAttribute("message", "Editted Successfully");
			return "redirect:/toDoView";
		}
		
		redirectAttributes.addFlashAttribute("message", "Failed to Save");
		return "redirect:/editToDoItem" + todo.getId();
	}
	
	@GetMapping("deleteToDoItem/{id}")
	public String deleteToDoItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if(toDoService.deleteToDoItem(id)) {
			redirectAttributes.addFlashAttribute("message","Deleted Successfully");
			return "redirect:/toDoView";
		}
		
		redirectAttributes.addFlashAttribute("message","Failed to Delete");
		return "redirect:/toDoView";
	}

}
