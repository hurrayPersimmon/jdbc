package org.scoula.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// tbl_member 테이블의 한 행을 담는 클래스
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVO {

    private int id;
    private String userid;
    private String password;
    private String name;
    private String email;
    private LocalDateTime regDate;
}