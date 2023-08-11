package org.galapagos.mcmorning.service;

import org.galapagos.mcmorning.cli.Input;
import org.galapagos.mcmorning.dao.MemberDao;
import org.galapagos.mcmorning.exception.UserIdCountOverExeption;
import org.galapagos.mcmorning.vo.Member;

import java.util.Scanner;

public class MemberService {
    MemberDao dao = new MemberDao();

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
}
