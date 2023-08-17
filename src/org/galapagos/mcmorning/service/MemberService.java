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

     MemberDao dao;

     public MemberService(MemberDao dao){this.dao = dao; }

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

     public Member login() {
         System.out.println("[로그인]");
         String userId = Input.read("사용자 ID : ");
         String password = Input.read("비밀번호 : ");

         //로그인 검사
         Member m = dao.findByUserId(userId);
         if(m != null) {//사용자 ID가 존재하는 지 검사
             if(password.equals((m.getPwd()))){
                 return m;
             }
         }
         //로그인 실패
         return null;
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

 }
