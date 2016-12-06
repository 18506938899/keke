package com.study.service;

import com.study.dao.MemberDao;
import com.study.dao.MemberMapper;
import entity.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by sk on 2016/11/24.
 */

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired(required =false)
    private MemberMapper memberDao;

    public Member getMemberById(String id) {
        return memberDao.getMemberById(id);
    }

    public Member getMemberByUsername(String username) {
        return memberDao.getMemberByUsername(username);
    }
}
