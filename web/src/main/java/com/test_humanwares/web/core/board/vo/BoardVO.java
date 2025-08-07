package com.test_humanwares.web.core.board.vo;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.Serializable;
import java.util.List;

// TODO: JPA(ORM) 라이브러리 - @Entity 사용해서 자바 class "BoardVO" 생성 및 해당 클래스 사용해서 MySQL DB에도 DB 테이블이 자동생성 되도록 구현 (2025.08.08 minjae)
public class BoardVO {
}


// TODO: 필요시 아래 상상플렉스 소스코드 참고 (2025.08.08 minjae)
//package com.humanwares.web.core.board.vo;
//
//import com.humanwares.web.core.HWVO;
//import com.humanwares.web.core.company.vo.CompanyInfoVO;
//import com.humanwares.web.core.history.vo.BoardHisVO;
//import com.humanwares.web.core.site.code.vo.CodeVO;
//import com.humanwares.web.utils.CryptUtils;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.*;
//        import org.springframework.beans.factory.annotation.Value;
//
//import javax.persistence.*;
//        import javax.persistence.Entity;
//import javax.persistence.Index;
//import javax.persistence.Table;
//import java.io.Serializable;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//
//
//@Entity
//@Getter
//@Setter
//@Table(
//        name = "cms_board_data",
//        indexes = {
//                @Index(columnList = "boardKey", name = "index_board_key")
//        }
//)
//public class BoardVO extends HWVO implements Serializable {
//
//
//    private static final long serialVersionUID = 9155834738525426107L;
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    long idx = 0;
//
//    long pidx = 0;
//
//    String treeLevel = "";
//
//    int depth = 0;
//
//    @Column(length = 50)
//    String boardKey;
//
//    @Column(length = 100)
//    String writerKey;  //id
//
//    @Column(length = 50)
//    String writer;  //이름
//
//    @Column(length = 200)
//    String writerPw;
//
//    @Column(length = 200)
//    String title;
//
//    @Lob
//    String contentText;
//
//    @Transient
//    String contentHtml;
//
//    @Column(nullable = false)
//    Boolean isUse = true;
//
//    @Column(nullable = false)
//    Boolean isNotice = false;
//
//    @Column(nullable = false)
//    Boolean isSecret = false;
//
//    String regIp;
//
//    long views = 0;
//
//    @Column(length = 100)
//    String opt1;
//
//    @Column(length = 100)
//    String opt2;
//
//    @Column(length = 100)
//    String opt3;
//
//    @Column(length = 100)
//    String opt4;
//
//    @Column(length = 100)
//    String opt5;
//
//    @Column(length = 20)
//    String cateCode;
//
//    /**
//     * 게시물의 진행상태 코드
//     */
//    @Column(length = 20)
//    String statusCode;
//
//    @Transient
//    String statusName;
//
//    @Transient
//    CodeVO statusVO;
//
//
//    /**
//     * 회사코드
//     * 기본 본사 www
//     */
//    @Column(length = 10)
//    @ColumnDefault("'www'")
//    String coCode = "www";
//
//
//    /**
//     * 회사정보 이름
//     */
//    @Transient
//    String coName;
//
//
//    /**
//     * 회사정보 VO
//     */
//    @Transient
//    CompanyInfoVO coinfoVO;
//
//
//    @Transient
//    String cateName;
//
//    @Transient
//    CodeVO cateVO;
//
//
//    @Column(length = 100)
//    String receiver;
//
//
//    /**
//     * 썸네일
//     */
//    Long thumbIdx = null;
//
//    @OneToOne(targetEntity = BoardFileVO.class)
//    @JoinColumn(name = "thumbIdx", insertable = false, updatable = false)
//    @Fetch(FetchMode.JOIN)
//    BoardFileVO thumbFile = null;
//
//
//
//    /**
//     * 쇼핑몰 연계 필드
//     */
//    Long gid = null;
//
//
//
//    @Transient
//    Boolean isSendMail = false;
//
//    @Transient
//    String writerKeyDec;  //id Decrypt
//
//    @Transient
//    String writerDec;  //이름 Decrypt
//
//    @Transient
//    List<BoardFileVO> attachList;
//
//    @Transient
//    long commentCount = 0;
//
//    @Transient
//    List<CommentVO> commentList;
//
//    @Transient
//    BoardVO reply;
//
//    @Transient
//    CommentVO answer;
//
//    @Transient
//    boolean isNew = false;
//
//    @Transient
//    long replyCnt = 0;
//
//    @Transient
//    long likeCount = 0;
//
//    @Transient
//    long cautionCount = 0;
//
//
//
//
//    public void Decrypt ( boolean IS_CRYPT ){
//
//        try {
//            if ( this.writerKey != null ) {
//                if ( IS_CRYPT ){
//                    this.writerKeyDec = CryptUtils.decrypt(this.writerKey);
//                } else {
//                    this.writerKeyDec = this.writerKey;
//                }
//            }
//
//            if ( this.writer != null ) {
//                if ( IS_CRYPT ){
//                    this.writerDec = CryptUtils.decrypt(this.writer);
//                } else {
//                    this.writerDec = this.writer;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            this.writerKeyDec = this.writerKey;
//            this.writerDec = this.writer;
//        }
//    }
//
//
//
//
//}