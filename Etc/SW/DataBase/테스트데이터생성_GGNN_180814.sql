-- 테스트 데이터 생성
-- user 정보
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('박세웅', 'sw@kp.com', '세웅', '사통백이', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('권태형', 'th@kp.com', '태형', '사통백이', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('조태준', 'tj@kp.com', '태준', '사통백이', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('김지성', 'js@kp.com', '지성', '사통백이', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('오승택', 'st@kp.com', '승택', '산소래', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('김욱진', 'oj@kp.com', '욱진', '자올소리', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('김준명', 'jm@kp.com', '준명', '산지니', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('김다훈', 'dh@kp.com', '다훈', '굴렁쇠', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('박시은', 'se@kp.com', '시은', '산지니', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('이소현', 'sh@kp.com', '소현', '자올소리', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('윤영훈', 'yh@kp.com', '영훈', '산소래', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('장문원', 'mw@kp.com', '문원', '자올소리', '졸선07', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('최권석', 'ks@kp.com', '권석', '난장', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('최진규', 'jk@kp.com', '진규', '어진바람', '졸선11', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('정진교', 'jjk@kp.com', '진교', '난장', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('박완배', 'wb@kp.com', '완배', '산소래', '졸선10', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('이호수', 'hs@kp.com', '호수', '어진바람', '졸선12', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('이수한', 'hs@kp.com', '호수', '굴렁쇠', '졸선11', NOW(), NOW(), '', '', NOW());
INSERT INTO Users (UserName, EMail, NickName, ClubName, RankName, RegDate, UpdateDate, ETC, Image, LastLoginDate) VALUES ('이성기', 'sk@kp.com', '성기', '굴렁쇠', '졸선11', NOW(), NOW(), '', '', NOW());

-- 소모임 정보 생성 및 그룹 참가 리스트 생성자 추가
INSERT INTO KP_Groups (GroupName, GroupCode, UserID, RegDate, UpdateDate) VALUES ('사통백이', 'st1022', 1, NOW(), NOW());
INSERT INTO GroupJoin (GroupID, UserID, RegDate, UpdateDate) VALUES (1, 1, NOW(), NOW());
INSERT INTO KP_Groups (GroupName, GroupCode, UserID, RegDate, UpdateDate) VALUES ('산소래', 'soerae', 5, NOW(), NOW());
INSERT INTO GroupJoin (GroupID, UserID, RegDate, UpdateDate) VALUES (2, 5, NOW(), NOW());
INSERT INTO KP_Groups (GroupName, GroupCode, UserID, RegDate, UpdateDate) VALUES ('자올소리', 'josori', 6, NOW(), NOW());
INSERT INTO GroupJoin (GroupID, UserID, RegDate, UpdateDate) VALUES (3, 6, NOW(), NOW());
INSERT INTO KP_Groups (GroupName, GroupCode, UserID, RegDate, UpdateDate) VALUES ('산지니', 'jiniji', 7, NOW(), NOW());
INSERT INTO GroupJoin (GroupID, UserID, RegDate, UpdateDate) VALUES (4, 7, NOW(), NOW());
INSERT INTO KP_Groups (GroupName, GroupCode, UserID, RegDate, UpdateDate) VALUES ('어진바람', 'ojwind', 12, NOW(), NOW());
INSERT INTO GroupJoin (GroupID, UserID, RegDate, UpdateDate) VALUES (5, 12, NOW(), NOW());
INSERT INTO KP_Groups (GroupName, GroupCode,UserID, RegDate, UpdateDate) VALUES ('굴렁쇠', 'circle', 8, NOW(), NOW());
INSERT INTO GroupJoin (GroupID, UserID, RegDate, UpdateDate) VALUES (6, 8, NOW(), NOW());
INSERT INTO KP_Groups (GroupName, GroupCode, UserID, RegDate, UpdateDate) VALUES ('난장', 'nanjan', 15, NOW(), NOW());
INSERT INTO GroupJoin (GroupID, UserID, RegDate, UpdateDate) VALUES (7, 15, NOW(), NOW());


-- 투표 정보 생성 및 투표 참가자 추가
INSERT INTO Votes (VoteName, UserID, GroupID, IsComplete, ETC, EndDate, RegDate, UpdateDate) VALUES ('테스트 투표', 1, 1, 0, '투표 테스트 중', NOW(), NOW(), NOW());
INSERT INTO VoteJoin (VoteID, IsVoting, UserID, RegDate, UpdateDate) VALUES (1, 0, 1, NOW(), NOW());
INSERT INTO Votes (VoteName, UserID, GroupID, IsComplete, ETC, EndDate, RegDate, UpdateDate) VALUES ('신년회 참가 투표', 1, 1, 1, '신년회 참가 하실 수 있으신가요?', NOW(), NOW(), NOW());
INSERT INTO VoteJoin (VoteID, IsVoting, UserID, RegDate, UpdateDate) VALUES (2, 1, 1, NOW(), NOW());
INSERT INTO Votes (VoteName, UserID, GroupID, IsComplete, ETC, EndDate, RegDate, UpdateDate) VALUES ('창립제 참가 투표', 1, 1, 0, '창립제 가능?', NOW(), NOW(), NOW());
INSERT INTO VoteJoin (VoteID, IsVoting, UserID, RegDate, UpdateDate) VALUES (3, 0, 1, NOW(), NOW());
INSERT INTO Votes (VoteName, UserID, GroupID, IsComplete, ETC, EndDate, RegDate, UpdateDate) VALUES ('8월 2주 패별 연습 투표', 1, 1, 1, '패별 연습', NOW(), NOW(), NOW());
INSERT INTO VoteJoin (VoteID, IsVoting, UserID, RegDate, UpdateDate) VALUES (4, 1, 1, NOW(), NOW());
INSERT INTO Votes (VoteName, UserID, GroupID, IsComplete, ETC, EndDate, RegDate, UpdateDate) VALUES ('8월 3주 패별 연습 투표', 1, 1, 1, '패별 연습', NOW(), NOW(), NOW());
INSERT INTO VoteJoin (VoteID, IsVoting, UserID, RegDate, UpdateDate) VALUES (5, 1, 1, NOW(), NOW());
INSERT INTO Votes (VoteName, UserID, GroupID, IsComplete, ETC, EndDate, RegDate, UpdateDate) VALUES ('8월 4주 패별 연습 투표', 1, 1, 0, '패별 연습', NOW(), NOW(), NOW());
INSERT INTO VoteJoin (VoteID, IsVoting, UserID, RegDate, UpdateDate) VALUES (6, 0, 1, NOW(), NOW());