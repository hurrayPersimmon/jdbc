package org.scoula.travel.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelImageVO {

    private Long no;
    private String filename;
    private Long travelNo;
}