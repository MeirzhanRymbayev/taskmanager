package kz.attractor.lab56.taskmanager.controller;

import kz.attractor.lab56.taskmanager.dto.UserDto;
import kz.attractor.lab56.taskmanager.model.Task;
import kz.attractor.lab56.taskmanager.model.User;
import kz.attractor.lab56.taskmanager.service.TaskService;
import kz.attractor.lab56.taskmanager.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    private final TaskService taskService;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<?> register(@RequestBody User user, HttpServletRequest request) {

        User saved = userService.register(user);

        final String pathInfo = request.getRequestURL().toString();

        final ResponseEntity responseEntity = ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", pathInfo + "/" + saved.getId())
                .build();

        return responseEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll() {
        List<UserDto> users = userService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users);
    }

    @RequestMapping(value = "/{userId}/tasks", method = RequestMethod.GET)
    public ResponseEntity<?> findAllUserTasks(@PathVariable Long userId) {

        List<Task> tasks = taskService.findByUser_Id(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tasks);
    }


}
