package com.hotelmanagement.ratingservice.ratingservice.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RatingDto {
    private String id;
    private String userId;
    private String hotelId;
    private int rating;
    private String remark;
}
