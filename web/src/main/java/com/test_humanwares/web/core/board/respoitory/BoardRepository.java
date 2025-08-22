package com.test_humanwares.web.core.board.respoitory;

import com.test_humanwares.web.core.board.vo.BoardVO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

// TODO: 아래 오류 메시지 출력으로 인해 인터페이스 BoardRepository에 @Repository 추가 (2025.08.22 minjae)
// 오류 메시지: Not a managed type: class com.test_humanwares.web.core.board.vo.BoardVO
// 참고 URL - https://claude.ai/chat/dbf56b0d-2c1a-40e5-a51f-e186a65ad35b
//@Repository
//public interface BoardRepository extends CrudRepository<BoardVO, Long> {
//}

public interface BoardRepository {

}

// TODO: 필요시 아래 상상플렉스 소스코드 참고 (2025.08.12 minjae)
//package com.humanwares.web.core.board.respoitory;
//
//
//import com.humanwares.web.core.board.vo.BoardInfoVO;
//import com.humanwares.web.core.board.vo.BoardVO;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.List;
//
//
//@Repository
//public interface BoardRepository extends CrudRepository<BoardVO, Long> {
//
//
//    @Query(value = "SELECT DISTINCT b FROm BoardVO b " +
//            "LEFT JOIN FETCH b.thumbFile " +
//            "WHERE b.idx = ?1 ",
//            countQuery = "SELECT COUNT(b) FROm BoardVO b " +
//                    "WHERE b.idx = ?1 ")
//    BoardVO findByIdx(long idx);
//
//
//
//
//    /**
//     * 게시물의 상태코드 변경
//     * @param idxs
//     * @param _statusCode
//     */
//    @Modifying
//    @Transactional
//    @Query("UPDATE BoardVO b SET b.statusCode = ?2 WHERE b.idx IN (?1)")
//    void updateStatus(List<Long> idxs, String _statusCode );
//
//
//    /**
//     * 파일번호 사용중인 게시물의 썸네일 번호 null 처리
//     * @param _fidx
//     */
//    @Modifying
//    @Transactional
//    @Query("UPDATE BoardVO b SET b.thumbIdx = NULL WHERE b.thumbIdx = ?1")
//    void updateThumbIdx( long _fidx );
//
//
//
//    /**
//     * 답변 없는 글 카운팅
//     * @param boardKey
//     * @param isUse
//     * @return
//     */
//    @Query(value = "SELECT COUNT(TB.idx)" +
//            "FROM (" +
//            "       SELECT" +
//            "         A.idx," +
//            "         A.title," +
//            "         A.create_date," +
//            "         COUNT(B.idx) AS commentCount" +
//            "       FROM" +
//            "         cms_board_data A" +
//            "         LEFT JOIN cms_board_comment B ON B.tb_idx = A.idx" +
//            "       WHERE" +
//            "         A.board_key = ?1 " +
//            "         AND A.is_use = ?2 " +
//            "         AND A.create_date >= ?3 " +
//            "       GROUP BY A.idx" +
//            "       ORDER BY A.idx DESC" +
//            "     ) AS TB " +
//            "WHERE TB.commentCount <= 0", nativeQuery = true)
//    int countByNoReply(String boardKey, boolean isUse, Date prev );
//
//
//
//    @Query(value = "SELECT MAX(tree_level) FROM cms_board_data WHERE board_key = ?1 AND tree_level LIKE CONCAT( ?2, '%' ) AND LENGTH(tree_level) = LENGTH( ?2 ) + 3", nativeQuery = true)
//    String findByMaxTreeLevel(String boardKey, String tree_level);
//
//    /**
//     * 게시판 key 종류 조회
//     *
//     * @return
//     */
//    @Query("SELECT CASE WHEN(bi.boardKey IS NULL OR bi.boardKey = '') THEN 'unknown' ELSE bi.boardKey END FROM BoardInfoVO bi")
//    List<String> findBoardKeyType();
//
//    @Query("SELECT bi FROM BoardInfoVO bi")
//    List<BoardInfoVO> findBoardInfoAll();
//
//
//    /**
//     * 파일번호 썸네일 삭제
//     * @param thumbIdx
//     */
//    @Modifying
//    @Query("UPDATE BoardVO b SET b.thumbIdx = NULL WHERE b.thumbIdx = ?1 ")
//    void deleteThumbIdx( long thumbIdx );
//
//
//}
