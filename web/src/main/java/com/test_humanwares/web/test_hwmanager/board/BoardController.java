package com.test_humanwares.web.test_hwmanager.board;

import com.test_humanwares.web.core.board.respoitory.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller   // @Controller 사용하면 springframework가 알아서 아래 코드(public class ItemController { ... }) 가져와서 ShopApplication 클래스 main 함수에 집어 넣어서 아래 웹서버 코드 실행
@RequiredArgsConstructor   // Lombok 문법 @RequiredArgsConstructor 사용
// 접근 제어자 "public" 없으면 같은 폴더(패키지) 안에서만 해당 클래스 사용가능
// 접근 제어자 "public" 붙이면 다른 폴더(패키지) 에서도 해당 클래스 사용 가능
public class BoardController {
    // 여기서 웹서버기능 제작가능

    // 2. DB입출력 원하는 클래스에서 repository 등록
    // private final BoardRepository boardRepository;  // 변수 boardRepository에는 new BoardRepository() 들어있음 (DB입출력문법(함수)(repository.입출력문법함수();) 잔뜩 들어있음.)

    // 웹서버 API - Thymeleaf 템플릿 엔진(Thymeleaf 문법) 사용해서 웹서버데이터를 html에 박아서 보내주는 웹서버 API
    // TODO: 아래 오류 메시지 원인 파악 결과 두 개의 컨트롤러(BoardController.java, BasicController.java)에서 동일한 URL 경로 /test를 사용하는 것으로 확인
    //       하여 각 컨트롤러의 URL을 서로 다르게 설정하기 위해 BoardController.java 소스파일 웹서버 API 메서드 URL 매핑 경로 변경 처리함. (2025.08.22 minjae)
    // (기존) @GetMapping("/test") (변경) @GetMapping("/board/test")
    // 오류 메시지 - Ambiguous mapping. Cannot map 'boardController' method
    //             com.test_humanwares.web.test_hwmanager.board.BoardController#list(Model)
    //             to {GET [/test]}: There is already 'basicController' bean method
    //             com.test_humanwares.web.BasicController#test() mapped.
    // 참고 URL - https://claude.ai/chat/c50759c9-205e-42c6-8cff-6dfe441bcb83
    @GetMapping("/board/test")   // URL 작명시 명사가 좋음.
    String test(Model model) {
        return "test.html";   // 웹페이지(test.html) 사용자 웹브라우저 출력
    }
}

// TODO: 필요시 아래 상상플렉스 소스코드 참고 (2025.08.12 minjae)
//package com.humanwares.web.hwmanager.board;
//
//import com.humanwares.web.core.board.respoitory.*;
//        import com.humanwares.web.core.board.service.BoardFileService;
//import com.humanwares.web.core.board.service.BoardInfoService;
//import com.humanwares.web.core.board.service.BoardService;
//import com.humanwares.web.core.board.support.BoardRepoSupport;
//import com.humanwares.web.core.board.vo.BoardInfoVO;
//import com.humanwares.web.core.board.vo.BoardVO;
//import com.humanwares.web.core.history.service.BoardHistoryService;
//import com.humanwares.web.core.shop.goods.repository.GoodsRepository;
//import com.humanwares.web.core.site.code.service.CodeService;
//import com.humanwares.web.core.HWController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//        import javax.servlet.http.HttpSession;
//import java.util.*;
//        import java.util.stream.IntStream;
//
//
//@Controller
//@RequestMapping(value = HWController.BOARDS)
//public class BoardController extends HWController {
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
//    @RequestMapping(value = "/{boardKey}/")
//    public String index() {
//        return BOARDS + "/list";
//    }
//
//
//    @RequestMapping(value = "/{boardKey}/form/")
//    public String form() {
//        return BOARDS + "/form";
//    }
//
//
//    @RequestMapping(value = "/{boardKey}/view/")
//    public String showDetail(@RequestParam Map<String, String> map) {
//        return BOARDS + "/view";
//    }
//
//
//    @GetMapping(value = "/getBoardList")
//    @ResponseBody
//    public Map<String, Object> getBoardList(@RequestParam Map<String, String> params, Pageable pageable) {
//
//        Map<String, Object> result = new HashMap<>();
//
//        try {
//
//            String boardKey = params.get("boardKey");
//            BoardInfoVO boardInfoVO = boardInfoService.getBoardInfo(params.get("boardKey"));
//
//            if (boardInfoVO == null || boardKey == null || boardKey.isEmpty()) {
//                result.put("msg", "잘못된 게시판 코드입니다.");
//                result.put("status", "fail");
//                return result;
//            }
//
//            Map boardMap = boardService.getBoardList(boardKey, params, pageable, true);
//            Map noticeMap = boardService.getNoticeList(boardKey, params, pageable, true);
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
//    @GetMapping(value = "/getBoardOne/{idx}")
//    @ResponseBody
//    public Map<String, Object> getBoardOne(@PathVariable long idx) {
//
//        Map result = new HashMap<>();
//
//        try {
//
//            result.putAll(boardService.getBoardOne(idx));
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
//    @RequestMapping(value = "/setBoardOne", method = RequestMethod.POST)
//    @ResponseBody
//    public Map<String, Object> setBoardOne(@RequestParam Map<String, String> map, BoardVO boardVO) {
//
//        Map<String, Object> results = new HashMap<>();
//
//        try {
//
//            boardVO = boardService.setBoardOne(boardVO, map.get("fileIdxs"));
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
//    /**
//     * 게시물 상태 코브 변경
//     *
//     * @param params
//     */
//    @RequestMapping(value = "/setStatus", method = RequestMethod.PATCH)
//    @ResponseBody
//    public Map<String, Object> setStatus(@RequestParam Map<String, String> params) {
//
//        Map<String, Object> results = new HashMap<>();
//
//        try {
//
//            results.put("status", boardService.setStatus(params));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            results.put("status", false);
//            results.put("msg", e.getMessage());
//        }
//
//        return results;
//    }
//
//
//    @DeleteMapping(value = "/deleteList")
//    @ResponseBody
//    public Map<String, Object> deleteList(@RequestParam Map<String, String> params) {
//
//        Map result = new HashMap<>();
//
//        try {
//
//            boardService.deleteBoardList(params.get("idxs").split(","));
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
//    @DeleteMapping(value = "/deleteOne/{idx}")
//    @ResponseBody
//    public Map<String, Object> deleteOne(@PathVariable long idx) {
//
//        Map results = new HashMap<>();
//
//        try {
//            boardService.deleteBoardOne(idx);
//            results.put("status", "ok");
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
//     * 일간 주간 월간 게시글 작성 통계
//     *
//     * @return
//     */
//    @RequestMapping(value = "/boardAsis")
//    @ResponseBody
//    public Map<String, Object> boardAsis(@RequestParam Map<String, Object> params) {
//
//        Map<String, Object> result = new HashMap<>();
//
//        try {
//            Map<String, Object> asisResult = new HashMap<>();
//
//            ArrayList<String> keys = new ArrayList<String>(Arrays.asList("board,comment".split(",")));
//            List<String> mode = new ArrayList<String>(Arrays.asList("day,week,month".split(",")));
//
//            keys.forEach(e -> {
//                Map<String, Object> asisOne = new HashMap<>();
//
//                mode.forEach(f -> {
//                    List<Map<String, Object>> list = (boardService.getBoardAsis(params, f, e, null));
//
//                    asisOne.put(f, list);
//                });
//
//                asisResult.put(e, asisOne);
//            });
//
//            result.put("boardInfo", boardRepository.findBoardInfoAll());
//            result.put("asis", asisResult);
//            result.put("status", "ok");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            result.put("status", "fail");
//            result.put("msg", e.getMessage());
//        }
//
//        return result;
//
//    }
//
//    @RequestMapping(value = "/recentComment")
//    @ResponseBody
//    public Map<String, Object> recentComment(@RequestParam Map<String, Object> params, Pageable pageable) {
//
//        Map<String, Object> result = new HashMap<>();
//
//        try {
//
//            result.put("list", boardService.getRecentBoardComment(params, pageable).get("list"));
//            result.put("count", boardService.getRecentBoardComment(params, pageable).get("count"));
//            result.put("status", "ok");
//
//        } catch (Exception e) {
//
//            result.put("status", "fail");
//            result.put("msg", e.getMessage());
//
//        }
//
//        return result;
//
//    }
//}

