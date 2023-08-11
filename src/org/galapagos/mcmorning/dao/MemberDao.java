package org.galapagos.mcmorning.dao;

import lombok.*;
import org.galapagos.mcmorning.vo.Member;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@Getter
@Setter

public class MemberDao {
    private List<Member> memberList;

    public MemberDao() {
        memberList = new ArrayList<Member>();
        memberList.add(new Member("hong", "1234", "홍길동", "gildong@naver.com"));
        memberList.add(new Member("tong", "4321", "통길동", "dong@naver.com"));
        memberList.add(new Member("mong", "2134", "만길동", "gil@naver.com"));
        memberList.add(new Member("gong", "1324", "개길동", "ild@naver.com"));

    }

    public void add(Member m) {
        memberList.add(m);
    }

    //userid로 찾기
    public Member findByUserId(String userId) {
//        for(Member m : memberList){
//            if(userId.equals(m.getUserId())){
//                return m;
//            }
//        }

        int ix = indexOf(userId);
        return ix != -1 ? memberList.get(ix) : null;
    }

    //수정
    public Member update(Member m) {
//        for(int i = 0; i < memberList.size(); i++){
//            if(m.getUserId().equals(memberList.get(i).getUserId())){
//                memberList.set(i, m);
//                return memberList.get(i);
//            }
//        }
        int ix = indexOf(m.getUserId());
        if (ix != -1) {
            memberList.set(ix, m);
            return m;
        }
        return null;

    }

    public Member delete(String userId) {
        int ix = indexOf(userId);

        return ix != -1 ? memberList.remove(ix) : null;
    }

    private int indexOf(String userId) {
        for (int i = 0; i < memberList.size(); i++) {
            if (userId.equals(memberList.get(i).getUserId())) {
                return i;
            }
        }
        return -1;
    }

}
