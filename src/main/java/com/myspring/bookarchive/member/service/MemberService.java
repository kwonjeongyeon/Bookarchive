package com.myspring.bookarchive.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.bookarchive.member.vo.MemberVO;

public interface MemberService {
	public void addMember(MemberVO memberVO) throws Exception;
	public String overlapped(String id) throws Exception;
	public MemberVO login(Map loginMap) throws Exception;

}
