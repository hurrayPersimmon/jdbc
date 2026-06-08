package org.scoula.mapper;

import org.scoula.domain.MemberVO;

import java.util.List;

// JDBC의 DAO 역할을 MyBatis에서는 Mapper가 담당한다.
public interface MemberMapper {

    // 전체 목록 조회
    List<MemberVO> findAll();

    // 상세 조회
    MemberVO findById(int id);

    // 회원 등록
    int insert(MemberVO member);

    // 회원 수정
    int update(MemberVO member);

    // 회원 삭제
    int delete(int id);
}