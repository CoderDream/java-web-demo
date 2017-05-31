# java-web-demo



----------






----------





----------
不排序的Map，按插入顺序输出：

LinkedHashMap



----------

插入数据，数据来源于其他表的字段，通过条件查询获得：

    INSERT INTO T_UserMenu (UserId, MenuId) VALUES((SELECT ID FROM T_Users WHERE WorkId = 'B-29685'),(SELECT ID FROM T_MenuInfo WHERE Name = 'BSM明细查询'));

INSERT INTO T_UserMenu (UserId, MenuId) VALUES((SELECT ID FROM T_Users WHERE WorkId = 'B-29685'),(SELECT ID FROM T_MenuInfo WHERE Name = 'BSM明细查询'));

----------
