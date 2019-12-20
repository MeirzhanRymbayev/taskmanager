package kz.attractor.lab56.taskmanager.repository;

import kz.attractor.lab56.taskmanager.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {



}
