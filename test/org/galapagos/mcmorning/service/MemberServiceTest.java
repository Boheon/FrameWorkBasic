package org.galapagos.mcmorning.service;

import org.galapagos.mcmorning.dao.MemberListDao;
import org.galapagos.mcmorning.dao.MemberMapDao;
import org.galapagos.mcmorning.exception.UserIdCountOverExeption;
import org.galapagos.mcmorning.vo.Member;

public class MemberServiceTest {
    public static void main(String[] args) {
        //testInputMember();
        testSearchByName();
    }

    static void testInputMember() {
        MemberService service = new MemberService();

        Member m = null;
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
    }
}
