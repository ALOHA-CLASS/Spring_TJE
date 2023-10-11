package com.aloha.spring.service;

import java.util.List;

import com.aloha.spring.dto.Board;

public interface BoardService {

	// �Խñ� ���
	public List<Board> list() throws Exception;
	
	// �Խñ� ��ȸ
	public Board select(int boardNo) throws Exception;
	
	// �Խñ� ���
	public int insert(Board board) throws Exception;
	
	// �Խñ� ����
	public int update(Board board) throws Exception;
	
	// �Խñ� ����
	public int delete(int boardNo) throws Exception;
	

}
