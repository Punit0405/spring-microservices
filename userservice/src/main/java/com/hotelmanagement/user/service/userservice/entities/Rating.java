package com.hotelmanagement.user.service.userservice.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor@NoArgsConstructor@Getter@Setter
@Builder
public class Rating {
    private String id;
    private String userId;
    private String hotelId;
    private int rating;
    private String remark;
    private Hotel hotel;
}
