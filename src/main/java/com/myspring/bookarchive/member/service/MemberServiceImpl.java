package com.myspring.bookarchive.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.bookarchive.member.dao.MemberDAO;
import com.myspring.bookarchive.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberVO login(Map loginMap) throws Exception {
		return memberDAO.login(loginMap);
	}

	@Override
	public void addMember(MemberVO memberVO) throws Exception {
		memberDAO.insertNewMember(memberVO);
	}

	@Override
	public String overlapped(String id) throws Exception {
		return memberDAO.selectOverlappedID(id);
	}

}
