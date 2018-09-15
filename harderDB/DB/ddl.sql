DROP TABLE IF EXISTS p1_memb RESTRICT;
DROP TABLE IF EXISTS p1_board RESTRICT;
DROP TABLE IF EXISTS p1_att_file RESTRICT;
DROP TABLE IF EXISTS p1_stud RESTRICT;
DROP TABLE IF EXISTS p1_mgr RESTRICT;
DROP TABLE IF EXISTS p1_tchr RESTRICT;
DROP TABLE IF EXISTS p1_lect RESTRICT;
DROP TABLE IF EXISTS p1_lect_tcher RESTRICT;
DROP TABLE IF EXISTS p1_lect_stud RESTRICT;


CREATE TABLE p1_memb (
    mno   INTEGER      NOT NULL COMMENT '회원 번호',
    name  VARCHAR(50)  NOT NULL COMMENT '이름',
    email VARCHAR(40)  NOT NULL COMMENT '이메일',
    pwd   VARCHAR(100) NOT NULL COMMENT '암호',
    tel   VARCHAR(30)  NULL     COMMENT '전화',
    cdt   DATETIME     NOT NULL COMMENT '등록일'
    )
COMMENT 'Member';
ALTER TABLE p1_memb
    ADD CONSTRAINT PK_p1_memb
        PRIMARY KEY (
            mno 
        );
CREATE UNIQUE INDEX UIX_p1_memb
    ON p1_memb (
        email ASC 
    );
ALTER TABLE p1_memb
    MODIFY COLUMN mno INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원 번호';


CREATE TABLE p1_board (
    bno  INTEGER      NOT NULL COMMENT '게시물번호',
    titl VARCHAR(255) NOT NULL COMMENT '제목',
    cont TEXT         NOT NULL COMMENT '내용',
    cnt  INTEGER      NULL     COMMENT '조회수',
    cdt  DATETIME     NOT NULL COMMENT '등록일',
    mno  INTEGER      NOT NULL COMMENT '회원 번호'
    )
COMMENT '게시판';
ALTER TABLE p1_board
    ADD CONSTRAINT PK_p1_board
        PRIMARY KEY (
            bno
        );
ALTER TABLE p1_board
    MODIFY COLUMN bno INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시물번호';


CREATE TABLE p1_att_file (
    afno  INTEGER      NOT NULL COMMENT '파일번호',
     bno   INTEGER      NOT NULL COMMENT '게시물번호',
fi_nm VARCHAR(255) NOT NULL COMMENT '파일명' 
)
COMMENT '첨부파일';
ALTER TABLE p1_att_file
    ADD CONSTRAINT PK_p1_att_file 
        PRIMARY KEY (
            afno
        );
ALTER TABLE p1_att_file
    MODIFY COLUMN afno INTEGER NOT NULL AUTO_INCREMENT COMMENT '파일번호';


CREATE TABLE p1_stud (
    sno  INTEGER     NOT NULL COMMENT '학생 번호',
     schl VARCHAR(50) NOT NULL COMMENT '최종학력', 
   work CHAR(1)     NOT NULL COMMENT '재직여부' 
)
COMMENT '학생';
ALTER TABLE p1_stud
    ADD CONSTRAINT PK_p1_stud
        PRIMARY KEY (
            sno
        );


CREATE TABLE p1_mgr (
    mrno INTEGER     NOT NULL COMMENT '매니저 번호',
    posi VARCHAR(50) NOT NULL COMMENT '직위'
)
COMMENT '매니저';
ALTER TABLE p1_mgr
    ADD CONSTRAINT PK_p1_mgr
        PRIMARY KEY (
            mrno 
        );


CREATE TABLE p1_tchr (
    tno   INTEGER      NOT NULL COMMENT '강사 번호',
    hrpay INTEGER      NOT NULL COMMENT '시급',
    subj  VARCHAR(255) NOT NULL COMMENT '과목'
)
COMMENT '강사';
ALTER TABLE p1_tchr
    ADD CONSTRAINT PK_p1_tchr
        PRIMARY KEY (
            tno
        );


CREATE TABLE p1_lect (
    lno    INTEGER      NOT NULL COMMENT '강의 번호',
    titl   VARCHAR(255) NOT NULL COMMENT '강의명',
    dist   TEXT         NOT NULL COMMENT '설명',
    sdt    DATETIME     NOT NULL COMMENT '시작일',
    edt    DATETIME     NOT NULL COMMENT '종료일',
    tot_hr INTEGER      NOT NULL COMMENT '총 강의 시간',
    day_hr INTEGER      NOT NULL COMMENT '일 강의 시간',
    capa   INTEGER      NOT NULL COMMENT '모집 인원',
    mrno   INTEGER      NULL     COMMENT '매니저 번호'
    )
COMMENT '강의';
ALTER TABLE p1_lect
    ADD CONSTRAINT PK_p1_lect
        PRIMARY KEY (
            lno
        );
ALTER TABLE p1_lect
    MODIFY COLUMN lno INTEGER NOT NULL AUTO_INCREMENT COMMENT '강의 번호';


CREATE TABLE p1_lect_tcher (
    tno INTEGER NOT NULL COMMENT '강사 번호',
    lno INTEGER NOT NULL COMMENT '강의 번호'
)
COMMENT '강의 배졍';
ALTER TABLE p1_lect_tcher
    ADD CONSTRAINT PK_p1_lect_tcher
        PRIMARY KEY (
            tno, 
            lno 
        );



CREATE TABLE p1_lect_stud (
    sno INTEGER NOT NULL COMMENT '학생 번호', 
    lno INTEGER NOT NULL COMMENT '강의 번호' 
)
COMMENT '수강생';
ALTER TABLE p1_lect_stud
    ADD CONSTRAINT PK_p1_lect_stud 
        PRIMARY KEY (
            sno, 
            lno
        );


ALTER TABLE p1_board
    ADD CONSTRAINT FK_p1_memb_TO_p1_board
        FOREIGN KEY (
            mno 
        )
        REFERENCES p1_memb (
            mno 
        );


ALTER TABLE p1_att_file
    ADD CONSTRAINT FK_p1_board_TO_p1_att_file
    FOREIGN KEY (
            bno 
        )
        REFERENCES p1_board ( 
            bno 
        );


ALTER TABLE p1_stud
    ADD CONSTRAINT FK_p1_memb_TO_p1_stud
    FOREIGN KEY (
            sno 
        )
        REFERENCES p1_memb (
            mno 
        );


ALTER TABLE p1_mgr
    ADD CONSTRAINT FK_p1_memb_TO_p1_mgr
    FOREIGN KEY (
            mrno 
        )
        REFERENCES p1_memb ( 
            mno
    );


ALTER TABLE p1_tchr
    ADD CONSTRAINT FK_p1_memb_TO_p1_tchr
        FOREIGN KEY (tno)
        REFERENCES p1_memb ( 
            mno 
        );

ALTER TABLE p1_lect
    ADD CONSTRAINT FK_p1_mgr_TO_p1_lect
        FOREIGN KEY (
            mrno 
        )
        REFERENCES p1_mgr ( 
            mrno 
        );


ALTER TABLE p1_lect_tcher
    ADD CONSTRAINT FK_p1_tchr_TO_p1_lect_tcher 
        FOREIGN KEY (
            tno
        )
        REFERENCES p1_tchr ( 
            tno 
        );

ALTER TABLE p1_lect_tcher
    ADD CONSTRAINT FK_p1_lect_TO_p1_lect_tcher 
        FOREIGN KEY (
            lno
        )
        REFERENCES p1_lect (
            lno
        );

ALTER TABLE p1_lect_stud
    ADD CONSTRAINT FK_p1_stud_TO_p1_lect_stud
        FOREIGN KEY (
            sno
        )
        REFERENCES p1_stud (
            sno
        );


ALTER TABLE p1_lect_stud
    ADD CONSTRAINT FK_p1_lect_TO_p1_lect_stud
        FOREIGN KEY (
            lno
        )
        REFERENCES p1_lect (
            lno
        );