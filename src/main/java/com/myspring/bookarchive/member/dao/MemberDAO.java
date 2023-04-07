package com.myspring.bookarchive.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.myspring.bookarchive.member.vo.MemberVO;

public interface MemberDAO {

	public void insertNewMember(MemberVO memberVO) throws DataAccessException;

	public String selectOverlappedID(String id) throws DataAccessException;

	public MemberVO login(Map loginMap) throws DataAccessException;

}
