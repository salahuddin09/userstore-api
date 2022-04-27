package com.userstore.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.userstore.domain.UserProgress;

@Repository
public interface UserProgressRepository extends CrudRepository<UserProgress, Long> {

	@Query(value = " SELECT RANK () OVER ("
			+ "ORDER BY userprogress_tbl.score DESC"
			+ ") AS rank, "
			+ "  userprogress_tbl.level AS level,"
			+ " (SELECT users_tbl.name FROM users_tbl WHERE users_tbl.progress_id = userprogress_tbl.id) AS name,"
			+ "  userprogress_tbl.score AS score "
			+ "FROM userprogress_tbl LIMIT :limit" 
			, nativeQuery = true)
	List<LeaderBoardView> findUserListByScore(@Param("limit") Integer limit);
	
	@Query(value = " SELECT rank, level, name,score,user_id "
			+ " FROM "
			+ " ( "
			+ "  SELECT RANK () OVER (ORDER BY userprogress_tbl.score DESC) AS rank, "
			+ "	userprogress_tbl.level AS level, "
			+ "	(SELECT users_tbl.name FROM users_tbl "
			+ "	 WHERE users_tbl.progress_id = userprogress_tbl.id) AS name, "
			+ "	 userprogress_tbl.score AS score, "
			+ "	(SELECT users_tbl.id FROM users_tbl "
			+ "	 WHERE users_tbl.progress_id = userprogress_tbl.id) AS user_id FROM userprogress_tbl "
			+ " ) all_users "
			+ " WHERE user_id = :userId " 
			, nativeQuery = true)
	LeaderBoardView findUserScoreByUserId(@Param("userId") Long userId);
	
	
	
	public interface LeaderBoardView {
	    String getRank();
	    String getLevel();
	    String getName();
	    String getScore();
	}
}

