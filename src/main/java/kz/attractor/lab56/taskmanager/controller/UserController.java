package kz.attractor.lab56.taskmanager.controller;

import kz.attractor.lab56.taskmanager.model.User;
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

@AllArgsConstructor
@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @RequestMapping(method = RequestMethod.POST)
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


}
