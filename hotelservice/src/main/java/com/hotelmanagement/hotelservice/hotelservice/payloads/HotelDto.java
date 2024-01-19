package com.hotelmanagement.hotelservice.hotelservice.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private String id;
    @NotEmpty
    @Size(min = 2, message = "Name should have at least 2 characters")
    private String name;
    @NotEmpty
    @Size(min = 2, message = "Location should have at least 2 characters")
    private String location;
    @NotEmpty
    @Size(min = 2, message = "Abou should have at least 2 characters")
    private String about;
}
