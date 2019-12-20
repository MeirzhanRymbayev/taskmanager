package kz.attractor.lab56.taskmanager.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDto {
    private Long id;
    private String login;
    private String email;

}
