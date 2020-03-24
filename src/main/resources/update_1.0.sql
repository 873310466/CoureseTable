-- 2020-03-24 19:29:44 by Lemonfish
ALTER TABLE `course` MODIFY COLUMN `name` varchar(100) NOT NULL COMMENT '1' AFTER `id`;
-- 2020-03-24 19:29:44 by Lemonfish
ALTER TABLE `course` MODIFY COLUMN `teacher` varchar(20) NOT NULL COMMENT '2' AFTER `name`;
-- 2020-03-24 19:29:44 by Lemonfish
ALTER TABLE `course` MODIFY COLUMN `location` varchar(100) NOT NULL COMMENT '3' AFTER `teacher`;
-- 2020-03-24 19:29:44 by Lemonfish
ALTER TABLE `course` MODIFY COLUMN `week` bigint NOT NULL COMMENT '4' AFTER `location`;
-- 2020-03-24 19:29:44 by Lemonfish
ALTER TABLE `course` MODIFY COLUMN `day` bigint NOT NULL COMMENT '5' AFTER `week`;
-- 2020-03-24 19:29:45 by Lemonfish
ALTER TABLE `course` MODIFY COLUMN `row_span` bigint NOT NULL COMMENT '6' AFTER `day`;
-- 2020-03-24 19:31:37 by Lemonfish
ALTER TABLE `course` MODIFY COLUMN `name` varchar(100) NOT NULL COMMENT '课程名称' AFTER `id`;
-- 2020-03-24 19:31:37 by Lemonfish
ALTER TABLE `course` MODIFY COLUMN `teacher` varchar(20) NOT NULL COMMENT '课程老师' AFTER `name`;
-- 2020-03-24 19:31:37 by Lemonfish
ALTER TABLE `course` MODIFY COLUMN `location` varchar(100) NOT NULL COMMENT '课程教室' AFTER `teacher`;
-- 2020-03-24 19:31:37 by Lemonfish
ALTER TABLE `course` MODIFY COLUMN `week` bigint NOT NULL COMMENT '课程周数' AFTER `location`;
-- 2020-03-24 19:31:37 by Lemonfish
ALTER TABLE `course` MODIFY COLUMN `day` bigint NOT NULL COMMENT '课程星期数' AFTER `week`;
-- 2020-03-24 19:31:38 by Lemonfish
ALTER TABLE `course` ADD COLUMN `begin` bigint NOT NULL COMMENT '课程开始节数' AFTER `day`;
-- 2020-03-24 19:31:38 by Lemonfish
ALTER TABLE `course` MODIFY COLUMN `row_span` bigint NOT NULL COMMENT '课程共几节' AFTER `begin`;
