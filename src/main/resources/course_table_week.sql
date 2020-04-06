create table week
(
    id          bigint unsigned auto_increment comment 'ID'
        primary key,
    cweek       bigint                               null comment '教学周',
    is_deleted  tinyint(1) default 0                 not null comment '删除标记',
    create_time timestamp  default CURRENT_TIMESTAMP not null comment '创建时间'
)
    comment '教学周' charset = utf8mb4;

INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (1, 1, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (2, 2, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (3, 3, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (4, 4, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (5, 5, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (6, 6, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (7, 7, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (8, 8, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (9, 9, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (10, 10, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (11, 11, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (12, 12, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (13, 13, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (14, 14, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (15, 15, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (16, 16, 0, '2020-03-25 01:41:29');
INSERT INTO course_table.week (id, cweek, is_deleted, create_time) VALUES (17, 17, 0, '2020-03-25 01:41:29');