package com.study.dao;

import entity.member.Member;

/**
 * Created by sk on 2016/12/6.
 */
public interface MemberDao {

    public Member getMembersById(String id);
}
