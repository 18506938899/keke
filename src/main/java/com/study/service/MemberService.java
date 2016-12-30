package com.study.service;

import entity.member.Member;

/**service
 * Created by sk on 2016/11/24.
 */

public interface MemberService {
    public Member getMemberById(String id);

    public Member getMemberByUsername(String username);
}
