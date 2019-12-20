package kz.attractor.lab56.taskmanager.repository;

import kz.attractor.lab56.taskmanager.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    List<Task> findByUserId(Long id);

}
