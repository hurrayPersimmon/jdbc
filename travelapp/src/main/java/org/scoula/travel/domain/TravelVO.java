package org.scoula.travel.domain;

import java.util.List;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelVO {
    private Long no;
    private String district;
    private String title;
    private String description;
    private String address;
    private String phone;

    private List<TravelImageVO> images;
}
