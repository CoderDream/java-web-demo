SELECT um.id,
       u.workId,
       mi.name,
       um.UserId,
       um.MenuId,
       um.Mark
FROM T_UserMenu um,
     T_Users u,
     t_menuInfo mi
WHERE u.ID = um.userId
      AND mi.id = um.MenuId
--ORDER BY um.userid;