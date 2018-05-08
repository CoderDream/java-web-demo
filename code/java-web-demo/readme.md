


## 2018/5/8需求 ##

T_StaffManage数据中BSM分布：

BSM区间为0.5~2.5
0.5~1.0	25%
1.0~1.4	60%
1.4~2.0	10%
2.0~2.5	5%

PDRC组织关系
表：PDRC_Organization
视图：PDRC_V_OrganizationMap
PDM-》PGM-》PM
RCH-》RCM-》TM
数据：
1-》5》34

项目分布：
主项目24个：
已开始-已结束：13
已开始-未结束：9
未开始-未结束：2
子项目：60个
已开始-已结束：37
已开始-未结束：18
未开始-未结束：5

项目时间区间：
2017-12-01~2019-01-31

测试文件入口：GenSqlService20180508Test.java
由JUnit改造成TestNG