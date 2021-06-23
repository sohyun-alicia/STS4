package com.rubypaper.persistence;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	List<Board> findByTitle(String searchKeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	
//	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(String searchKeyword);
//	
//	
//	@Query("Select b FROM Board b "
//			+ "WHERE b.title like %:searchKeyword% "
//			+ "ORDER BY b.seq DESC")
//	List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
//	
//	
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate "
//			+ "FROM Board b "
//			+ "WHERE b.title like %?1% "
//			+ "ORDER BY b.seq DESC")
//	List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);
//	
//	
////	네이티브 쿼리 사용하기
//	@Query(value="SELECT seq, title, writer, create_date "
//			+ "FROM Board WHERE title like '%'||?1||'%' "
//			+ "ORDER BY seq DESC", nativeQuery=true)
//	List<Object[]> queryAnnotationTest4(String searchKeyword);
//	
////	페이징 및 정렬하기
//	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest5(Pageable paging);
	
	
}
