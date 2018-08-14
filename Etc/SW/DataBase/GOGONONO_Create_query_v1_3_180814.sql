create database gogonono default character set utf8mb4;

use gogonono;
-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- Users Table Create SQL
CREATE TABLE Users
(
    `RawID`          INT             NOT NULL    AUTO_INCREMENT COMMENT 'PK', 
    `UserName`       VARCHAR(45)     NOT NULL    COMMENT '이름', 
    `EMail`          VARCHAR(45)     NOT NULL    COMMENT 'Email', 
    `NickName`       VARCHAR(45)     NOT NULL    COMMENT '닉네임', 
    `ClubName`       VARCHAR(45)     NOT NULL    COMMENT '소모임명', 
    `RankName`       VARCHAR(45)     NOT NULL    COMMENT '등급명', 
    `ETC`            VARCHAR(45)     NULL        COMMENT 'ETC', 
    `Image`          VARCHAR(200)    NULL        COMMENT '이미지', 
    `RegDate`        DATETIME        NOT NULL    COMMENT '등록일자', 
    `UpdateDate`     DATETIME        NOT NULL    COMMENT '업데이트일자', 
    `LastLoginDate`  DATETIME        NOT NULL    COMMENT '마지막접속시간', 
    PRIMARY KEY (RawID)
);

ALTER TABLE Users COMMENT '유저 테이블';


-- KP_Groups Table Create SQL
CREATE TABLE KP_Groups
(
    `RawID`       INT            NOT NULL    AUTO_INCREMENT COMMENT 'PK', 
    `GroupName`   VARCHAR(10)    NOT NULL    COMMENT '모임명', 
    `GroupCode`   VARCHAR(6)     NOT NULL    COMMENT '모임코드', 
    `UserID`      INT            NOT NULL    COMMENT '생성자ID', 
    `RegDate`     DATETIME       NOT NULL    COMMENT '등록일자', 
    `UpdateDate`  DATETIME       NOT NULL    COMMENT '업데이트일자', 
    PRIMARY KEY (RawID)
);

ALTER TABLE KP_Groups COMMENT '모임 테이블';

ALTER TABLE KP_Groups ADD CONSTRAINT FK_KP_Groups_UserID_Users_RawID FOREIGN KEY (UserID)
 REFERENCES Users (RawID)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- Votes Table Create SQL
CREATE TABLE Votes
(
    `RawID`       INT             NOT NULL    AUTO_INCREMENT COMMENT 'PK', 
    `VoteName`    VARCHAR(45)     NOT NULL    COMMENT '투표명', 
    `UserID`      INT             NOT NULL    COMMENT '생성자ID', 
    `GroupID`     INT             NOT NULL    COMMENT '모임ID', 
    `IsComplete`  BIT             NOT NULL    COMMENT '완료여부', 
    `ETC`         VARCHAR(200)    NULL        COMMENT '비고', 
    `EndDate`     DATETIME        NOT NULL    COMMENT '종료일자', 
    `RegDate`     DATETIME        NOT NULL    COMMENT '등록일자', 
    `UpdateDate`  DATETIME        NOT NULL    COMMENT '업데이트일자', 
    PRIMARY KEY (RawID)
);

ALTER TABLE Votes COMMENT '투표 테이블';

ALTER TABLE Votes ADD CONSTRAINT FK_Votes_GroupID_KP_Groups_RawID FOREIGN KEY (GroupID)
 REFERENCES KP_Groups (RawID)  ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE Votes ADD CONSTRAINT FK_Votes_UserID_Users_RawID FOREIGN KEY (UserID)
 REFERENCES Users (RawID)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- VoteJoin Table Create SQL
CREATE TABLE VoteJoin
(
    `RawID`       INT         NOT NULL    AUTO_INCREMENT COMMENT 'PK', 
    `VoteID`      INT         NOT NULL    COMMENT '투표ID', 
    `IsVoting`    INT         NOT NULL    COMMENT '투표여부', 
    `UserID`      INT         NOT NULL    COMMENT '참가자ID', 
    `RegDate`     DATETIME    NOT NULL    COMMENT '등록일자', 
    `UpdateDate`  DATETIME    NOT NULL    COMMENT '업데이트일자', 
    PRIMARY KEY (RawID)
);

ALTER TABLE VoteJoin COMMENT '투표 참가 리스트 테이블';

ALTER TABLE VoteJoin ADD CONSTRAINT FK_VoteJoin_VoteID_Votes_RawID FOREIGN KEY (VoteID)
 REFERENCES Votes (RawID)  ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE VoteJoin ADD CONSTRAINT FK_VoteJoin_UserID_Users_RawID FOREIGN KEY (UserID)
 REFERENCES Users (RawID)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- PushLogs Table Create SQL
CREATE TABLE PushLogs
(
    `RawID`       INT         NOT NULL    AUTO_INCREMENT COMMENT 'PK', 
    `UserID`      INT         NOT NULL    COMMENT '유저ID', 
    `VoteID`      INT         NOT NULL    COMMENT '투표ID', 
    `RegDate`     DATETIME    NOT NULL    COMMENT '등록일자(푸쉬시간)', 
    `UpdateDate`  DATETIME    NOT NULL    COMMENT '업데이트일자', 
    PRIMARY KEY (RawID)
);

ALTER TABLE PushLogs COMMENT '푸쉬 로그 테이블';

ALTER TABLE PushLogs ADD CONSTRAINT FK_PushLogs_VoteID_Votes_RawID FOREIGN KEY (VoteID)
 REFERENCES Votes (RawID)  ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE PushLogs ADD CONSTRAINT FK_PushLogs_UserID_Users_RawID FOREIGN KEY (UserID)
 REFERENCES Users (RawID)  ON DELETE RESTRICT ON UPDATE RESTRICT;


-- GroupJoin Table Create SQL
CREATE TABLE GroupJoin
(
    `RawID`       INT         NOT NULL    AUTO_INCREMENT COMMENT 'PK', 
    `GroupID`     INT         NOT NULL    COMMENT '모임 ID', 
    `UserID`      INT         NOT NULL    COMMENT '참가자ID', 
    `RegDate`     DATETIME    NOT NULL    COMMENT '등록일자', 
    `UpdateDate`  DATETIME    NOT NULL    COMMENT '업데이트일자', 
    PRIMARY KEY (RawID)
);

ALTER TABLE GroupJoin COMMENT '모임 참가 테이블';

ALTER TABLE GroupJoin ADD CONSTRAINT FK_GroupJoin_GroupID_KP_Groups_RawID FOREIGN KEY (GroupID)
 REFERENCES KP_Groups (RawID)  ON DELETE RESTRICT ON UPDATE RESTRICT;
ALTER TABLE GroupJoin ADD CONSTRAINT FK_GroupJoin_UserID_Users_RawID FOREIGN KEY (UserID)
 REFERENCES Users (RawID)  ON DELETE RESTRICT ON UPDATE RESTRICT;