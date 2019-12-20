package kz.attractor.lab56.taskmanager.service;

import kz.attractor.lab56.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaskService {

    private TaskRepository taskRepository;

}
