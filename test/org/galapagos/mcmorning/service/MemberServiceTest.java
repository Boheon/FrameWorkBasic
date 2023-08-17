package org.galapagos.mcmorning.service;

import org.galapagos.mcmorning.dao.MemberListDao;
import org.galapagos.mcmorning.dao.MemberMapDao;
import org.galapagos.mcmorning.exception.UserIdCountOverExeption;
import org.galapagos.mcmorning.vo.Member;

public class MemberServiceTest {
    public static void main(String[] args) {
        //testInputMember();
        testLogin();
        testSearchByName();
    }

    static void testInputMember() {
//        MemberService service = new MemberService(new MemberMapDao());
        MemberService service = new MemberService(new MemberListDao());

        Member m;
        try {
            m = service.inputMemberInfo();
            System.out.println(m);
        } catch (UserIdCountOverExeption e) {
            System.out.println(e.getMessage());
        }
        //
    }

    static void testSearchByName(){
        MemberService service = new MemberService(new MemberMapDao());
        service.searchByName();
    }

    static void testLogin(){
        MemberService service = new MemberService(new MemberMapDao());
        Member m = service.login();

        System.out.println(m);
        //로그인 성공시 'xxx님 환영합니다'
        //로그인 실패시 에러메세지
        if(m!=null){
            System.out.println(m.getUserId()+"님 환영합니다.");
        }else{
            System.out.println("사용자 ID 또는 비밀번호가 올바르지 않습니다.");
        }
    }
}
