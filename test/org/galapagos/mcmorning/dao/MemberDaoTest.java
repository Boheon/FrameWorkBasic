package org.galapagos.mcmorning.dao;

import org.galapagos.mcmorning.vo.Member;

import java.util.List;

public class MemberDaoTest {
    public static void main(String[] args) {
        testRead();
        testAdd();
        testFindByUserId();
        testUpdate();
        testDelete();
    }

    static void testRead() {
        MemberDao dao = new MemberListDao();
        List<Member> memberList = dao.getMemberList();

        for (Member m : memberList) {
            System.out.println(m);
        }
    }

    static void testAdd() {
        MemberDao dao = new MemberListDao();
        List<Member> memberList = dao.getMemberList();

        int l = memberList.size();
        Member m2 = new Member("dooli", "1234", "둘리", "dooli@gmail.com");
        dao.add(m2);

        assert memberList.size() == l + 1 : "추가실패";
    }

    static void testFindByUserId() {
        MemberDao memberDao = new MemberListDao();

        String userid = "hong";
        Member m = memberDao.findByUserId(userid);
        assert m != null && userid.equals(m.getUserId()) : userid + " 검색 실패";

        userid = "donut";
        m = memberDao.findByUserId(userid);
        assert m == null : userid + " 검색 실패";
    }

    static void testUpdate(){
        MemberDao memberDao = new MemberListDao();

        Member m = new Member("na" , "2143", "나길동", "na@naver.com");
        Member m2 = memberDao.update(m);
        assert m2 != null : "업데이트 실패";

        m = memberDao.findByUserId("hong");
        m.setEmail("hong@gmail.com");
        m2 = memberDao.update(m);
        assert m2 != null && m ==m2 : "업데이트 실패";
    }

    static void testDelete(){
        MemberDao memberDao = new MemberListDao();
        Member m = memberDao.delete("na");

        assert m != null && m.getUserId().equals("na") : "삭제 실패";

    }

}
