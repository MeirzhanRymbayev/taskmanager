package kz.attractor.lab56.taskmanager.repository;

import kz.attractor.lab56.taskmanager.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
