CREATE database physical_exam CHARACTER SET utf8;

use physical_exam;

-- 总成绩等级在各院系的分布情况 (优秀A/良好B/及格C/不及格D)--
CREATE TABLE `score_A` (
`major` varchar(255) DEFAULT NULL,
`count` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 身高体重等级在各院系的分布情况 (肥胖A/超重B/正常C/低体重D)--
CREATE TABLE `body_A` (
`major` varchar(255) DEFAULT NULL,
`count` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 平均身高 2013级 2016_to_2017--
CREATE TABLE `avg_height_grade13_2016_to_2017` (
`major` varchar(255) DEFAULT NULL,
`weight` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 平均体重 2013级 2016_to_2017--
CREATE TABLE `avg_weight_grade13_2016_to_2017` (
`major` varchar(255) DEFAULT NULL,
`weight` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 身高体重等级_平均肺活量 2013级 2016_to_2017--
CREATE TABLE `avg_body_lang_grade13_2016_to_2017` (
`body_level` varchar(255) DEFAULT NULL,
`lang` decimal(6,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 体能_平均肺活量 2013级 2016_to_2017--
CREATE TABLE `avg_sport_lang_grade13_2016_to_2017` (
`sport_level` varchar(255) DEFAULT NULL,
`lang` decimal(6,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 以2013级为例，三年来他们身高、体重、体能的变化 --
CREATE TABLE `grade13_2014_to_2015_change` (
`stu_num` int DEFAULT NULL,
`weight` double DEFAULT NULL,
`weight` double DEFAULT NULL,
`sport_score` decimal(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `grade13_2015_to_2016_change` (
`stu_num` int DEFAULT NULL,
`weight` double DEFAULT NULL,
`weight` double DEFAULT NULL,
`sport_score` decimal(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `grade13_2016_to_2017_change` (
`stu_num` int DEFAULT NULL,
`weight` double DEFAULT NULL,
`weight` double DEFAULT NULL,
`sport_score` decimal(4,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;