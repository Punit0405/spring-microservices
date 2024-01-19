package com.hotelmanagement.user.service.userservice.payloads;

import java.util.List;

import com.hotelmanagement.user.service.userservice.entities.Rating;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String id;
    @NotEmpty
    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min = 2, message = "About should have atleast 2 characters")
    private String about; 
    private List<Rating> ratings;
}
