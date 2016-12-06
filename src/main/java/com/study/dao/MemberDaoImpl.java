package com.study.dao;

import entity.member.Member;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by sk on 2016/12/6.
 */
@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public Member getMembersById(String id) {
        SqlSession sqlSession = this.getSqlSession();
        return sqlSession.selectOne("com.study.dao.MemberMapper.getMemberById",id);
    }
}
