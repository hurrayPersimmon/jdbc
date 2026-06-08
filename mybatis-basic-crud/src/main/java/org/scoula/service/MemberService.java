package org.scoula.service;

public interface MemberService {

    // 전체 목록 출력
    void printMembers();

    // 상세 조회 출력
    void printMember();

    // 회원 등록
    void registerMember();

    // 회원 수정
    void modifyMember();

    // 회원 삭제
    void removeMember();
}