package com.test_humanwares.web.front.apis.boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

public class BoardRestController {

}

// TODO: 필요시 아래 상상플렉스 소스코드 참고 (2025.08.12 minjae)
//package com.humanwares.web.front.apis.boards;
//
//
//import com.humanwares.web.core.board.respoitory.BoardContentRepository;
//import com.humanwares.web.core.board.respoitory.BoardFileRepository;
//import com.humanwares.web.core.board.respoitory.BoardInfoRepository;
//import com.humanwares.web.core.board.respoitory.BoardRepository;
//import com.humanwares.web.core.board.service.BoardFileService;
//import com.humanwares.web.core.board.service.BoardInfoService;
//import com.humanwares.web.core.board.service.BoardService;
//import com.humanwares.web.core.board.support.BoardRepoSupport;
//import com.humanwares.web.core.board.vo.BoardInfoVO;
//import com.humanwares.web.core.board.vo.BoardVO;
//import com.humanwares.web.core.history.service.BoardHistoryService;
//import com.humanwares.web.core.shop.goods.repository.GoodsRepository;
//import com.humanwares.web.core.site.code.service.CodeService;
//import com.humanwares.web.core.site.code.vo.CodeVO;
//import com.humanwares.web.utils.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.web.bind.annotation.*;
//
//        import javax.servlet.http.HttpSession;
//import java.util.*;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("/api/boards")
//public class BoardRestController {
//
//
//    @Autowired
//    HttpSession httpSession;
//
//    @Autowired
//    BoardInfoService boardInfoService;
//
//    @Autowired
//    BoardRepository boardRepository;
//
//    @Autowired
//    BoardContentRepository boardContentRepository;
//
//    @Autowired
//    BoardService boardService;
//
//    @Autowired
//    BoardFileRepository fileRepository;
//
//    @Autowired
//    BoardFileService fileService;
//
//    @Autowired
//    BoardRepoSupport boardRepoSupport;
//
//    @Autowired
//    BoardHistoryService boardHistoryService;
//
//    @Autowired
//    CodeService codeService;
//
//    @Autowired
//    GoodsRepository goodsRepository;
//
//
//    @Autowired
//    BoardInfoRepository boardInfoRepository;
//
//
//
//
//    /**
//     * 게시판 목록 조회
//     * @param map
//     * @param pageable
//     * @return
//     */
//    @GetMapping(value = "/getBoardInfoList")
//    public Map<String,Object> getBoardInfoList(@RequestParam Map<String, String> map, Pageable pageable) {
//
//        Map<String, Object> results = new HashMap<>();
//        try {
//
//            Page<BoardInfoVO> page;
//            if ( StringUtils.isEmpty(map.get("searchText")) ) {
//                page = boardInfoRepository.findAll(pageable);
//            } else {
//                page = boardInfoRepository.findBySearch( map.get("searchText"), pageable);
//            }
//
//            results.put("list", page.getContent());
//            results.put("count", page.getTotalElements() );
//
//            results.put("status", "ok");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            results.put("status", "fail");
//            results.put("msg", e.getMessage());
//        }
//
//        return results;
//    }
//
//
//    /**
//     * 게시판 크도 설정 조회
//     * @param params
//     * @return
//     */
//    @GetMapping(value = "/getBoardInfo")
//    public Map<String, Object> getBoardInfo(@RequestParam Map<String, String> params ) {
//
//        Map<String, Object> result = new HashMap<String, Object>();
//
//        try {
//
//            BoardInfoVO boardInfoVO = new BoardInfoVO();
//            if ( !StringUtils.isEmpty(params.get("idx")) ) {
//                boardInfoVO = boardInfoRepository.findByIdx( Long.parseLong(params.get("idx")) );
//            } else if ( !StringUtils.isEmpty(params.get("boardKey")) ) {
//                boardInfoVO = boardInfoRepository.findByBoardKey( params.get("boardKey") );
//            }
//
//            if ( boardInfoVO != null ) {
//                if ( boardInfoVO.getIsCategory() && !StringUtils.isEmpty( boardInfoVO.getCateCode() )) {
//                    boardInfoVO.setCateList( codeService.getCodeNode4Logic( boardInfoVO.getCateCode() ) );
//                }
//
//                if(boardInfoVO.getIsStatus()  && !StringUtils.isEmpty( boardInfoVO.getStatusCode() ) ) {
//                    boardInfoVO.setStatusList( codeService.getCodeNode4Logic(boardInfoVO.getStatusCode()));
//                }
//            } else {
//                result.put("status", "fail");
//                result.put("msg", "잘못된 게시판 코드입니다.");
//                return  result;
//            }
//
//            result.put("boardInfoVO", boardInfoVO);
//            result.put("status", "ok");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.put("status", "fail");
//            result.put("msg", e.getMessage());
//        }
//
//        return result;
//    }
//
//
//
//
//
//
//
//    @GetMapping(value = "/getBoardList")
//    public Map<String, Object> getBoardList(@RequestParam Map<String, String> params, Pageable pageable) {
//
//        Map<String, Object> result = new HashMap<>();
//
//        try {
//
//            // 사용자는 표출된 게시물만 표출
//            params.put("isUse", "true");
//
//            String boardKey = params.get("boardKey");
//            BoardInfoVO boardInfoVO = boardInfoService.getBoardInfo( params.get("boardKey") );
//
//            if (boardInfoVO == null || boardKey == null || boardKey.isEmpty() ) {
//                result.put("msg", "잘못된 게시판 코드입니다.");
//                result.put("status", "fail");
//                return result;
//            }
//
//            if ( pageable.getPageNumber() > 0 ) {
//                //pageable.page = 0;
//                pageable = PageRequest.of(0, (pageable.getPageNumber() + 1) * pageable.getPageSize(), pageable.getSort() );
//            }
//
//            Map boardMap = boardService.getBoardList(boardKey, params, pageable );
//
//            /**
//             * 공지사항 1개만 조회
//             */
//            pageable = PageRequest.of(0, 1, pageable.getSort() );
//            Map noticeMap = boardService.getNoticeList(boardKey, params, pageable );
//
//            result.put("boardInfoVO", boardInfoVO);
//            result.put("boardMap", boardMap);
//            result.put("noticeMap", noticeMap);
//
//            result.put("status", "ok");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.put("status", "fail");
//            result.put("msg", e.getMessage());
//        }
//
//        return result;
//    }
//
//
//
//
//
//    /**
//     *  게시물 조회 + 조회내역 저장
//     * @param idx
//     * @param params
//     * @return
//     */
//    @GetMapping(value = "/getBoardOne/{idx}")
//    public Map<String, Object> getBoardOne( @PathVariable long idx, @RequestParam Map<String, String> params ) {
//
//        Map<String, Object> result = new HashMap<>();
//
//        try {
//
//            boardHistoryService.setBoardHistory( idx, params.get("LOGIN_ID"), params.get("LOGIN_NICK") );
//
//            result.putAll( boardService.getBoardOne( idx ) );
//            result.put("status", "ok");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.put("status", "fail");
//            result.put("msg", e.getMessage());
//        }
//
//        return result;
//    }
//
//
//
//
//
//
//
//    @PostMapping(value = "/setBoardOne")
//    public Map<String, Object> setBoardOne(@RequestParam Map<String, String> map, BoardVO boardVO ) {
//
//        Map<String, Object> results = new HashMap<>();
//
//        try {
//
//            boardVO = boardService.setBoardOne(boardVO, map.get("fileIdxs") );
//            results.put("status", "ok");
//            results.put("boardVO", boardVO);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            results.put("status", "fail");
//            results.put("msg", e.getMessage());
//        }
//
//        return results;
//    }
//
//
//
//
//    @DeleteMapping(value = "/deleteList")
//    public Map<String, Object> deleteList(@RequestParam Map<String, String> params) {
//
//        Map<String, Object> result = new HashMap<>();
//
//        try {
//
//            boardService.deleteBoardList( params.get("idxs").split(",") );
//            result.put("status", "ok");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.put("status", "fail");
//            result.put("msg", e.getMessage());
//        }
//
//        return result;
//    }
//
//
//
//
//
//
//    @DeleteMapping(value = "/deleteOne/{idx}")
//    public Map<String, Object> deleteOne( @PathVariable long idx, @RequestParam Map<String, String> params ) {
//
//        Map<String, Object> results = new HashMap<>();
//
//        try {
//
//            String loginId = params.get("LOGIN_ID");
//            BoardVO boardVO = (BoardVO) boardService.getBoardOne( idx ).get("boardVO");
//            if ( boardVO.getWriterKey().equals( loginId ) ) {
//                boardService.deleteBoardOne( idx );
//                results.put("status", "ok");
//            } else {
//                results.put("status", "fail");
//                results.put("msg", "작성자 계정이 아닙니다.");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            results.put("status", "fail");
//            results.put("msg", e.getMessage());
//        }
//
//        return results;
//    }
//
//
//
//
//
//}

