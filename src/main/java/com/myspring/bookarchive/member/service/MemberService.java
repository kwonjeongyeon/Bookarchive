package com.myspring.bookarchive.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.bookarchive.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> listMembers() throws DataAccessException;
	public int addMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
	public MemberVO login(MemberVO memberVO) throws Exception;

}
