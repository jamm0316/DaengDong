package com.shinhan.daengdong.member.model.repository;

import com.shinhan.daengdong.member.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class MemberRepositoryImpl implements MemberRepositoryInterface{

    @Autowired
    SqlSession sqlSession;
    String namespace = "com.shinhan.member.";

    @Override
    public MemberDTO login(String email){
        MemberDTO result = sqlSession.selectOne(namespace+"login", email);
        log.info("login : " + result);
        return result;
    }

    @Override
    public MemberDTO signUp(MemberDTO memberDTO) {
        int signUpMember = sqlSession.insert(namespace+"signUp", memberDTO);
        return signUpMember == 1 ? memberDTO : null;
    }

}
