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
-- 2020-03-25 01:39:30 by Lemonfish
CREATE TABLE `week`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT '教学周';
-- 2020-03-25 01:40:34 by Lemonfish
ALTER TABLE `week` ADD COLUMN `cweek` bigint COMMENT '教学周' AFTER `id`;
-- 2020-03-25 01:40:35 by Lemonfish
ALTER TABLE `week` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `cweek`;
-- 2020-04-01 21:52:29 by Lemonfish
CREATE TABLE `stars`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT '星星';
-- 2020-04-01 21:52:55 by Lemonfish
ALTER TABLE `stars` ADD COLUMN `counts` bigint COMMENT '星星数量' AFTER `id`;
-- 2020-04-01 21:52:55 by Lemonfish
ALTER TABLE `stars` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `counts`;
-- 2020-04-01 22:08:24 by Lemonfish
CREATE TABLE `stars`( `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',`is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记',`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',PRIMARY KEY (`id`))AUTO_INCREMENT=10000002 DEFAULT CHARSET=utf8mb4 COMMENT '星星';
-- 2020-04-01 22:08:42 by Lemonfish
ALTER TABLE `stars` ADD COLUMN `counts` bigint COMMENT '星星数量' AFTER `id`;
-- 2020-04-01 22:08:42 by Lemonfish
ALTER TABLE `stars` MODIFY COLUMN `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '删除标记' AFTER `counts`;
