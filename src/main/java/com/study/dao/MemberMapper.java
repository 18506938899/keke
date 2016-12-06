package com.study.dao;

import entity.member.Member;
import org.springframework.stereotype.Repository;

/**
 * Created by sk on 2016/12/6.
 */
public interface MemberMapper {
    public Member getMemberById(String id);

    public Member getMemberByUsername(String username);
}
