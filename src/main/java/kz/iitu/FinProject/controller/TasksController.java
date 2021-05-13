package kz.iitu.FinProject.controller;

import kz.iitu.FinProject.model.Task;
import kz.iitu.FinProject.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    private final TaskRepo taskRepo;

    @Autowired
    TasksController(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    @GetMapping
    public String getAllTasks(Model model){
        model.addAttribute("tasks", taskRepo.findAll());
        return "page1";
    }

    @GetMapping("/new")
    public String newTask(Model model) {
        model.addAttribute("task", new Task());
        return "new";
    }
    @PostMapping()
    public String createTask(@ModelAttribute("student") Task newTask) {
        taskRepo.save(newTask);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/edit")
    public String editTask(Model model, @PathVariable("id") long id){
        model.addAttribute("task", taskRepo.getOne(id));
        return "edit";
    }

    @PostMapping("/{id}")
    public String updateTask(@ModelAttribute("task") Task task, @PathVariable long id){
        task.setId(id);
        taskRepo.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id){
        taskRepo.deleteById(id);
        return "redirect:/tasks";
    }

}
