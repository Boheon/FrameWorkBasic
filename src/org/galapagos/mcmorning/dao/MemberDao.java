package org.galapagos.mcmorning.dao;

import java.util.List;

import org.galapagos.mcmorning.vo.Member;

public interface MemberDao {

    List<Member> getMemberList();

    void add(Member m);

    // userid로 찾기
    Member findByUserId(String userid);

    // 수정
    Member update(Member m);

    // 삭제
    Member delete(String userid);

    List<Member> searchByName(String name); // name : 홍길동, 길동, 길, 동 ..

}