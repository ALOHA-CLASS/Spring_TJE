package com.joeun.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.test.dto.Board;

@Mapper
public interface BoardMapper {

	// 메소드 명은 Mapper.xml 매핑 파일의 SQL 태그 id 값과 일치해야한다.
	public List<Board> list() throws Exception;

	public Integer insert(Board board) throws Exception;

	public Board select(Integer boardNo) throws Exception;

	public Integer update(Board board) throws Exception;

	public Integer delete(Integer boardNo) throws Exception;

}