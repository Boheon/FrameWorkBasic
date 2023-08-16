package org.galapagos.mcmorning.service;

import lombok.NoArgsConstructor;
import org.galapagos.mcmorning.cli.Input;
import org.galapagos.mcmorning.dao.MemberDao;
import org.galapagos.mcmorning.dao.MemberListDao;
import org.galapagos.mcmorning.dao.MemberMapDao;
import org.galapagos.mcmorning.exception.UserIdCountOverExeption;
import org.galapagos.mcmorning.vo.Member;

import java.util.List;
 @NoArgsConstructor

public class MemberService {
    MemberDao dao = new MemberDao() {
        @Override
        public List<Member> getMemberList() {
            return null;
        }

        @Override
        public void add(Member m) {

        }

        @Override
        public Member findByUserId(String userid) {
            return null;
        }

        @Override
        public Member update(Member m) {
            return null;
        }

        @Override
        public Member delete(String userid) {
            return null;
        }

        @Override
        public List<Member> searchByName(String name) {
            return null;
        }
    };

    public MemberService(MemberListDao memberListDao) {
    }

     public MemberService(MemberMapDao memberMapDao) {
     }

     public void signUp() {

        Member newUser = null;
        try {
            newUser = inputMemberInfo();
            //리스트에 넣기(dao)
            dao.add(newUser);
        } catch (UserIdCountOverExeption e) {
            System.out.println(e.getMessage());
        }

    }

    public Member inputMemberInfo() throws UserIdCountOverExeption {
        //member 정보입력
        String userId = inputUserId();
        String userPwd = Input.read("사용자 Password : ");
        String userName = Input.read("사용자 이름 : ");
        String userEmail = Input.read("사용자 이메일 : ");


        Member newUser = new Member(userId, userPwd, userName, userEmail);
        return newUser;
    }


    //facade 패턴
    public String inputUserId() throws UserIdCountOverExeption {
        //id 중복체크
        String userId = "";
        for (int i = 0; i < 3; i++) {
            userId = Input.read("사용자 ID : ");
            Member m = dao.findByUserId(userId);

            if (m != null) {//중복이라면
                System.out.println(userId + "는 중복된 ID입니다.");
            } else {
                return userId;
            }
        }
        throw new UserIdCountOverExeption();
    }

    public void searchByName(){
        System.out.println("[이름으로 찾기]");
        String keyword = Input.read("검색어 : ");

        List<Member> list = dao.searchByName(keyword);
        System.out.printf("검색 결과 : %d건\n", list.size());
        for(Member m : list){
            System.out.println(m);
        }
    }

     public Member login() {
         return null;
     }
 }
