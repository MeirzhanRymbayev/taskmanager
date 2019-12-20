package kz.attractor.lab56.taskmanager.service;

import kz.attractor.lab56.taskmanager.model.Task;
import kz.attractor.lab56.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TaskService {

    private static long counter;

    private TaskRepository taskRepository;

    public Task generate(Task task) {
        task.setId(++counter);
        return taskRepository.save(task);
    }

    public void deleteAll() {
        taskRepository.deleteAll();
    }

    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }



    public List<Task> findByUser_Id(Long userId) {
        return taskRepository.findByUserId(userId);
    }


}
