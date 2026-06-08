package org.scoula.service;

import org.apache.ibatis.session.SqlSession;
import org.scoula.database.MyBatisUtil;
import org.scoula.domain.MemberVO;
import org.scoula.mapper.MemberMapper;

import java.util.List;
import java.util.Scanner;

public class MemberServiceImpl implements MemberService {

    private final Scanner sc = new Scanner(System.in);

    // 전체 목록 출력
    @Override
    public void printMembers() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {

            // Mapper 인터페이스 구현 객체를 MyBatis가 자동으로 만들어 준다.
            MemberMapper mapper = session.getMapper(MemberMapper.class);

            List<MemberVO> members = mapper.findAll();

            System.out.println();
            System.out.println("========== 회원 목록 ==========");

            if (members.isEmpty()) {
                System.out.println("등록된 회원이 없습니다.");
                return;
            }

            for (MemberVO member : members) {
                System.out.println(member);
            }

        } catch (Exception e) {
            System.out.println("회원 목록 조회 중 오류 발생");
            e.printStackTrace();
        }
    }

    // 상세 조회 출력
    @Override
    public void printMember() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {

            MemberMapper mapper = session.getMapper(MemberMapper.class);

            System.out.print("조회할 회원 번호 입력: ");
            int id = Integer.parseInt(sc.nextLine());

            MemberVO member = mapper.findById(id);

            System.out.println();
            System.out.println("========== 회원 상세 ==========");

            if (member == null) {
                System.out.println("해당 번호의 회원이 없습니다.");
                return;
            }

            System.out.println(member);

        } catch (Exception e) {
            System.out.println("회원 상세 조회 중 오류 발생");
            e.printStackTrace();
        }
    }

    // 회원 등록
    @Override
    public void registerMember() {
        SqlSession session = null;

        try {
            // 등록, 수정, 삭제는 commit이 필요하다.
            session = MyBatisUtil.getSqlSessionFactory().openSession();

            MemberMapper mapper = session.getMapper(MemberMapper.class);

            System.out.print("아이디 입력: ");
            String userid = sc.nextLine();

            System.out.print("비밀번호 입력: ");
            String password = sc.nextLine();

            System.out.print("이름 입력: ");
            String name = sc.nextLine();

            System.out.print("이메일 입력: ");
            String email = sc.nextLine();

            MemberVO member = MemberVO.builder()
                .userid(userid)
                .password(password)
                .name(name)
                .email(email)
                .build();

            int result = mapper.insert(member);

            if (result == 1) {
                session.commit();
                System.out.println("회원 등록 성공");
            } else {
                session.rollback();
                System.out.println("회원 등록 실패");
            }

        } catch (Exception e) {
            if (session != null) {
                session.rollback();
            }

            System.out.println("회원 등록 중 오류 발생");
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 회원 수정
    @Override
    public void modifyMember() {
        SqlSession session = null;

        try {
            session = MyBatisUtil.getSqlSessionFactory().openSession();

            MemberMapper mapper = session.getMapper(MemberMapper.class);

            System.out.print("수정할 회원 번호 입력: ");
            int id = Integer.parseInt(sc.nextLine());

            MemberVO oldMember = mapper.findById(id);

            if (oldMember == null) {
                System.out.println("해당 번호의 회원이 없습니다.");
                return;
            }

            System.out.println("현재 회원 정보: " + oldMember);

            System.out.print("새 아이디 입력: ");
            String userid = sc.nextLine();

            System.out.print("새 비밀번호 입력: ");
            String password = sc.nextLine();

            System.out.print("새 이름 입력: ");
            String name = sc.nextLine();

            System.out.print("새 이메일 입력: ");
            String email = sc.nextLine();

            MemberVO member = MemberVO.builder()
                .id(id)
                .userid(userid)
                .password(password)
                .name(name)
                .email(email)
                .build();

            int result = mapper.update(member);

            if (result == 1) {
                session.commit();
                System.out.println("회원 수정 성공");
            } else {
                session.rollback();
                System.out.println("회원 수정 실패");
            }

        } catch (Exception e) {
            if (session != null) {
                session.rollback();
            }

            System.out.println("회원 수정 중 오류 발생");
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // 회원 삭제
    @Override
    public void removeMember() {
        SqlSession session = null;

        try {
            session = MyBatisUtil.getSqlSessionFactory().openSession();

            MemberMapper mapper = session.getMapper(MemberMapper.class);

            System.out.print("삭제할 회원 번호 입력: ");
            int id = Integer.parseInt(sc.nextLine());

            MemberVO oldMember = mapper.findById(id);

            if (oldMember == null) {
                System.out.println("해당 번호의 회원이 없습니다.");
                return;
            }

            System.out.println("삭제 대상: " + oldMember);

            System.out.print("정말 삭제하시겠습니까? y/n: ");
            String answer = sc.nextLine();

            if (!answer.equalsIgnoreCase("y")) {
                System.out.println("삭제를 취소했습니다.");
                return;
            }

            int result = mapper.delete(id);

            if (result == 1) {
                session.commit();
                System.out.println("회원 삭제 성공");
            } else {
                session.rollback();
                System.out.println("회원 삭제 실패");
            }

        } catch (Exception e) {
            if (session != null) {
                session.rollback();
            }

            System.out.println("회원 삭제 중 오류 발생");
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}