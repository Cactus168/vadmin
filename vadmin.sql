-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.29 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 vadmin 的数据库结构
CREATE DATABASE IF NOT EXISTS `vadmin` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vadmin`;

-- 导出  表 vadmin.sys_dict 结构
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE IF NOT EXISTS `sys_dict` (
  `dictId` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) NOT NULL DEFAULT '0',
  `dictNo` varchar(50) DEFAULT NULL,
  `dictName` varchar(50) DEFAULT NULL,
  `dictKey` varchar(50) DEFAULT NULL,
  `dictLabel` varchar(50) DEFAULT NULL,
  `orderNum` int(11) NOT NULL DEFAULT '0',
  `status` char(1) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modify` varchar(50) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`dictId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 正在导出表  vadmin.sys_dict 的数据：~5 rows (大约)
DELETE FROM `sys_dict`;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` (`dictId`, `parentId`, `dictNo`, `dictName`, `dictKey`, `dictLabel`, `orderNum`, `status`, `remark`, `creator`, `createDate`, `modify`, `modifyDate`) VALUES
	(1, 0, 'sys_status', '启停状态', NULL, NULL, 0, '0', '启用和停用状态', '系统管理员', '2020-08-12 09:50:12', '系统管理员', '2020-08-20 09:22:06'),
	(3, 1, NULL, NULL, '1', '停用', 2, '0', NULL, '系统管理员', '2020-08-12 09:50:12', '系统管理员', '2020-08-19 17:37:32'),
	(8, 1, NULL, NULL, '0', '启用', 1, '0', NULL, '系统管理员', '2020-08-17 16:22:03', NULL, NULL),
	(9, 0, 'oper_status', '操作状态', NULL, NULL, 0, '0', '操作状态', '系统管理员', '2020-08-21 16:27:25', NULL, NULL),
	(10, 9, NULL, NULL, '0', '成功', 1, '0', NULL, '系统管理员', '2020-08-21 16:29:27', NULL, NULL),
	(11, 9, NULL, NULL, '1', '失败', 2, '0', NULL, '系统管理员', '2020-08-21 16:29:38', '系统管理员', '2020-08-21 16:29:43');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;

-- 导出  表 vadmin.sys_login_log 结构
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE IF NOT EXISTS `sys_login_log` (
  `loginId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `userName` varchar(50) DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `loginLocation` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `loginOs` varchar(50) DEFAULT '' COMMENT '操作系统',
  `loginTime` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`loginId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

-- 正在导出表  vadmin.sys_login_log 的数据：~26 rows (大约)
DELETE FROM `sys_login_log`;
/*!40000 ALTER TABLE `sys_login_log` DISABLE KEYS */;
INSERT INTO `sys_login_log` (`loginId`, `userName`, `ipaddr`, `loginLocation`, `browser`, `loginOs`, `loginTime`) VALUES
	(1, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-08-20 14:54:02'),
	(2, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-08-20 15:09:20'),
	(3, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-08-20 16:47:40'),
	(4, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-08-21 09:11:56'),
	(5, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-08-21 14:43:07'),
	(6, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-08-31 10:28:02'),
	(7, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-01 09:46:46'),
	(8, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-04 09:04:36'),
	(9, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-04 09:46:32'),
	(10, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-04 15:49:58'),
	(11, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-07 09:58:37'),
	(12, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-07 11:24:55'),
	(13, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-07 14:28:01'),
	(14, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-07 16:14:09'),
	(15, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-07 16:30:12'),
	(16, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-07 16:34:03'),
	(17, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-14 09:23:46'),
	(18, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-14 16:05:22'),
	(19, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-09-14 17:44:51'),
	(20, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-10-09 09:45:32'),
	(21, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-10-09 14:52:14'),
	(22, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-10-16 13:55:19'),
	(23, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-10-19 09:38:43'),
	(24, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-10-20 10:11:55'),
	(25, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-10-20 17:41:14'),
	(26, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-10-21 10:27:51'),
	(27, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-11-03 09:01:42'),
	(28, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2020-11-03 14:52:57'),
	(29, 'admin', '127.0.0.1', '内网IP', 'Chrome 8', 'Windows 10', '2021-02-25 10:51:44');
/*!40000 ALTER TABLE `sys_login_log` ENABLE KEYS */;

-- 导出  表 vadmin.sys_menu 结构
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE IF NOT EXISTS `sys_menu` (
  `menuId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menuName` varchar(50) NOT NULL COMMENT '菜单名称',
  `parentId` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `orderNum` int(4) DEFAULT '0' COMMENT '显示顺序',
  `path` varchar(200) DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) DEFAULT NULL COMMENT '组件路径',
  `isFrame` int(1) DEFAULT '1' COMMENT '是否为外链（0是 1否）',
  `menuType` char(1) DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) DEFAULT '#' COMMENT '菜单图标',
  `creator` varchar(64) DEFAULT '' COMMENT '创建者',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modify` varchar(64) DEFAULT '' COMMENT '更新者',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=1034 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- 正在导出表  vadmin.sys_menu 的数据：~19 rows (大约)
DELETE FROM `sys_menu`;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` (`menuId`, `menuName`, `parentId`, `orderNum`, `path`, `component`, `isFrame`, `menuType`, `visible`, `status`, `perms`, `icon`, `creator`, `createDate`, `modify`, `modifyDate`, `remark`) VALUES
	(1, '系统管理', 0, 1, 'sys', NULL, 1, 'M', '0', '0', '', 'system', 'admin', '2018-03-16 11:33:00', '系统管理员', '2020-08-11 17:30:16', '系统管理目录'),
	(100, '用户管理', 1, 4, 'user', 'sys/user', 1, 'C', '0', '0', '', 'user', 'admin', '2018-03-16 11:33:00', '系统管理员', '2020-08-14 09:37:32', '用户管理菜单'),
	(101, '角色管理', 1, 2, 'role', 'sys/role', 1, 'C', '0', '0', '', 'peoples', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '角色管理菜单'),
	(102, '菜单管理', 1, 1, 'menu', 'sys/menu', 1, 'C', '0', '0', '', 'tree-table', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', '菜单管理菜单'),
	(1014, '添加菜单', 102, 1, '', '', 1, 'F', '0', '0', 'sys:menu:add', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
	(1015, '修改菜单', 102, 2, '', '', 1, 'F', '0', '0', 'sys:menu:edit', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
	(1016, '删除菜单', 102, 3, '', '', 1, 'F', '0', '0', 'sys:menu:remove', '#', 'admin', '2018-03-16 11:33:00', 'ry', '2018-03-16 11:33:00', ''),
	(1017, '添加用户', 100, 1, '', NULL, 1, 'F', '0', '0', 'sys:user:add', '#', '系统管理员', '2020-08-12 09:43:27', '系统管理员', '2020-08-12 09:46:50', ''),
	(1018, '修改用户', 100, 2, '', NULL, 1, 'F', '0', '0', 'sys:user:edit', '#', '系统管理员', '2020-08-12 09:47:53', '', NULL, ''),
	(1019, '删除用户', 100, 3, '', NULL, 1, 'F', '0', '0', 'sys:user:remove', '#', '系统管理员', '2020-08-12 09:50:12', '', NULL, ''),
	(1020, '添加角色', 101, 1, '', NULL, 1, 'F', '0', '0', 'sys:role:add', '#', '系统管理员', '2020-08-12 15:04:16', '', NULL, ''),
	(1021, '修改角色', 101, 1, '', NULL, 1, 'F', '0', '0', 'sys:role:edit', '#', '系统管理员', '2020-08-12 15:04:56', '', NULL, ''),
	(1022, '删除角色', 101, 1, '', NULL, 1, 'F', '0', '0', 'sys:role:remove', '#', '系统管理员', '2020-08-12 15:05:37', '', NULL, ''),
	(1023, '组织机构', 1, 3, 'organ', 'sys/organ', 1, 'C', '0', '0', NULL, 'tree', '系统管理员', '2020-08-14 09:34:29', '', NULL, ''),
	(1024, '添加机构', 1023, 1, '', NULL, 1, 'F', '0', '0', 'sys:organ:add', '#', '系统管理员', '2020-08-14 09:35:36', '', NULL, ''),
	(1025, '修改机构', 1023, 1, '', NULL, 1, 'F', '0', '0', 'sys:organ:edit', '#', '系统管理员', '2020-08-14 09:36:19', '', NULL, ''),
	(1026, '删除机构', 1023, 1, '', NULL, 1, 'F', '0', '0', 'sys:organ:remove', '#', '系统管理员', '2020-08-14 09:36:58', '', NULL, ''),
	(1027, '数据字典', 1, 5, 'dict', 'sys/dict', 1, 'C', '0', '0', NULL, 'dict', '系统管理员', '2020-08-14 09:38:50', '', NULL, ''),
	(1028, '添加字典', 1027, 1, '', NULL, 1, 'F', '0', '0', 'sys:dict:add', '#', '系统管理员', '2020-08-14 09:41:35', '', NULL, ''),
	(1029, '修改字典', 1027, 1, '', NULL, 1, 'F', '0', '0', 'sys:dict:edit', '#', '系统管理员', '2020-08-14 09:42:30', '', NULL, ''),
	(1030, '删除字典', 1027, 1, '', NULL, 1, 'F', '0', '0', 'sys:dict:remove', '#', '系统管理员', '2020-08-14 09:42:51', '', NULL, ''),
	(1031, '日志管理', 1, 6, 'log', 'sys/logx', 1, 'M', '0', '0', NULL, 'log', '系统管理员', '2020-08-20 15:10:43', '', NULL, ''),
	(1032, '登录日志', 1031, 1, 'login', 'sys/logx/loginx', 1, 'C', '0', '0', NULL, 'logininfor', '系统管理员', '2020-08-20 15:13:21', '', NULL, ''),
	(1033, '操作日志', 1031, 1, 'oper', 'sys/logx/oper', 1, 'C', '0', '0', NULL, 'form', '系统管理员', '2020-08-20 15:16:24', '', NULL, '');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;

-- 导出  表 vadmin.sys_menu_dict 结构
DROP TABLE IF EXISTS `sys_menu_dict`;
CREATE TABLE IF NOT EXISTS `sys_menu_dict` (
  `menuId` int(11) DEFAULT NULL,
  `dictId` int(11) DEFAULT NULL,
  KEY `menuId_codeId` (`menuId`,`dictId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  vadmin.sys_menu_dict 的数据：~0 rows (大约)
DELETE FROM `sys_menu_dict`;
/*!40000 ALTER TABLE `sys_menu_dict` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_menu_dict` ENABLE KEYS */;

-- 导出  表 vadmin.sys_message 结构
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE IF NOT EXISTS `sys_message` (
  `messageId` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `messageTitle` varchar(50) NOT NULL COMMENT '公告标题',
  `messageType` char(1) NOT NULL COMMENT '公告类型（1通知 2公告）',
  `messageContent` varchar(2000) DEFAULT NULL COMMENT '公告内容',
  `status` char(1) DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `creator` varchar(64) DEFAULT '' COMMENT '创建者',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modify` varchar(64) DEFAULT '' COMMENT '更新者',
  `modifyDate` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`messageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统消息表';

-- 正在导出表  vadmin.sys_message 的数据：~0 rows (大约)
DELETE FROM `sys_message`;
/*!40000 ALTER TABLE `sys_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_message` ENABLE KEYS */;

-- 导出  表 vadmin.sys_oper_log 结构
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE IF NOT EXISTS `sys_oper_log` (
  `operId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `moduleName` varchar(50) DEFAULT '' COMMENT '模块标题',
  `operateType` varchar(50) DEFAULT '' COMMENT '操作类型',
  `method` varchar(100) DEFAULT '' COMMENT '方法名称',
  `requestMethod` varchar(10) DEFAULT '' COMMENT '请求方式',
  `operOs` varchar(50) DEFAULT '' COMMENT '操作系统',
  `operName` varchar(50) DEFAULT '' COMMENT '操作人员',
  `operUrl` varchar(255) DEFAULT '' COMMENT '请求URL',
  `operIp` varchar(50) DEFAULT '' COMMENT '主机地址',
  `operLocation` varchar(255) DEFAULT '' COMMENT '操作地点',
  `operParam` varchar(2000) DEFAULT '' COMMENT '请求参数',
  `jsonResult` varchar(2000) DEFAULT '' COMMENT '返回参数',
  `status` char(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `errorMsg` varchar(2000) DEFAULT '' COMMENT '错误消息',
  `operTime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`operId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='操作日志记录';

-- 正在导出表  vadmin.sys_oper_log 的数据：~11 rows (大约)
DELETE FROM `sys_oper_log`;
/*!40000 ALTER TABLE `sys_oper_log` DISABLE KEYS */;
INSERT INTO `sys_oper_log` (`operId`, `moduleName`, `operateType`, `method`, `requestMethod`, `operOs`, `operName`, `operUrl`, `operIp`, `operLocation`, `operParam`, `jsonResult`, `status`, `errorMsg`, `operTime`) VALUES
	(1, '角色管理', '分配菜单权限', 'com.vadmin.controller.sys.RoleController.changeRoleMenus()', 'POST', 'Windows 10', 'admin', '/sys/role/roleMenus/', '127.0.0.1', '内网IP', '{"roleId":2,"orderBy":"","menuIds":[1,101,1020]}', '{"msg":"操作成功","code":200,"data":3}', '0', '', '2020-08-20 14:54:41'),
	(2, '用户管理', '修改', 'com.vadmin.controller.sys.UserController.modify()', 'PUT', 'Windows 10', 'admin', '/sys/user/', '127.0.0.1', '内网IP', '{"modifyDate":1597906607527,"orderBy":"","userId":8,"modify":"系统管理员","organId":0,"status":"1"}', '{"msg":"操作成功","code":200,"data":1}', '0', '', '2020-08-20 14:56:47'),
	(3, '菜单管理', '添加', 'com.vadmin.controller.sys.MenuController.add()', 'POST', 'Windows 10', '系统管理员', '/sys/menu/', '127.0.0.1', '内网IP', '{"icon":"log","orderBy":"","orderNum":"6","menuName":"日志管理","path":"log","children":[],"isFrame":"1","createDate":1597907443618,"creator":"系统管理员","visible":"0","parentId":1,"menuType":"M","status":"0"}', '{"msg":"操作成功","code":200,"data":1}', '0', '', '2020-08-20 15:10:43'),
	(4, '菜单管理', '添加', 'com.vadmin.controller.sys.MenuController.add()', 'POST', 'Windows 10', '系统管理员', '/sys/menu/', '127.0.0.1', '内网IP', '{"icon":"logininfor","orderBy":"","orderNum":"1","menuName":"登录日志","path":"login","children":[],"isFrame":"1","createDate":1597907601848,"creator":"系统管理员","visible":"0","parentId":1031,"component":"sys/log/login","menuType":"C","status":"0"}', '{"msg":"操作成功","code":200,"data":1}', '0', '', '2020-08-20 15:13:21'),
	(5, '菜单管理', '添加', 'com.vadmin.controller.sys.MenuController.add()', 'POST', 'Windows 10', '系统管理员', '/sys/menu/', '127.0.0.1', '内网IP', '{"icon":"form","orderBy":"","orderNum":"1","menuName":"操作日志","path":"oper","children":[],"isFrame":"1","createDate":1597907784521,"creator":"系统管理员","visible":"0","parentId":1031,"component":"sys/log/oper","menuType":"C","status":"0"}', '{"msg":"操作成功","code":200,"data":1}', '0', '', '2020-08-20 15:16:24'),
	(6, '角色管理', '分配菜单权限', 'com.vadmin.controller.sys.RoleController.changeRoleMenus()', 'POST', 'Windows 10', '系统管理员', '/sys/role/roleMenus/', '127.0.0.1', '内网IP', '{"roleId":1,"orderBy":"","menuIds":[1,100,1017,1018,1019,101,1020,1021,1022,102,1014,1015,1016,1023,1024,1025,1026,1027,1028,1029,1030,1031,1032,1033]}', '{"msg":"操作成功","code":200,"data":24}', '1', '', '2020-08-20 15:19:18'),
	(7, '数据字典', '添加', 'com.vadmin.controller.sys.DictController.add()', 'POST', 'Windows 10', '系统管理员', '/sys/dict/', '127.0.0.1', '内网IP', '{"creator":"系统管理员","orderBy":"","orderNum":0,"remark":"操作状态","dictNo":"oper_status","parentId":0,"dictName":"操作状态","createDate":1597998445428,"status":"0"}', '{"msg":"操作成功","code":200,"data":1}', '0', '', '2020-08-21 16:27:25'),
	(8, '数据字典', '添加', 'com.vadmin.controller.sys.DictController.add()', 'POST', 'Windows 10', '系统管理员', '/sys/dict/', '127.0.0.1', '内网IP', '{"dictValue":"成功","creator":"系统管理员","orderBy":"","orderNum":1,"dictKey":"0","parentId":9,"createDate":1597998567556,"status":"0"}', '{"msg":"操作成功","code":200,"data":1}', '0', '', '2020-08-21 16:29:27'),
	(9, '数据字典', '添加', 'com.vadmin.controller.sys.DictController.add()', 'POST', 'Windows 10', '系统管理员', '/sys/dict/', '127.0.0.1', '内网IP', '{"dictValue":"失败","creator":"系统管理员","orderBy":"","orderNum":1,"dictKey":"1","parentId":9,"createDate":1597998578048,"status":"0"}', '{"msg":"操作成功","code":200,"data":1}', '0', '', '2020-08-21 16:29:38'),
	(10, '数据字典', '修改', 'com.vadmin.controller.sys.DictController.modify()', 'PUT', 'Windows 10', '系统管理员', '/sys/dict/', '127.0.0.1', '内网IP', '{"dictValue":"失败","creator":"系统管理员","modifyDate":1597998583866,"orderBy":"","orderNum":2,"dictId":11,"dictKey":"1","parentId":9,"modify":"系统管理员","createDate":1597998578000,"status":"0"}', '{"msg":"操作成功","code":200,"data":1}', '0', '', '2020-08-21 16:29:43'),
	(11, '数据字典', '添加', 'com.vadmin.controller.sys.DictController.add()', 'POST', 'Windows 10', '系统管理员', '/sys/dict/', '127.0.0.1', '内网IP', '{"creator":"系统管理员","orderBy":"","orderNum":0,"remark":"<script>for(var i=0;i<1000;i++){alert(\\"弹死你\\"+i);}</script>","dictNo":"cs","parentId":0,"dictName":"菜单","createDate":1598924827135,"status":"0"}', '{"msg":"操作成功","code":200,"data":1}', '0', '', '2020-09-01 09:47:07'),
	(12, '数据字典', '删除', 'com.vadmin.controller.sys.DictController.remove()', 'DELETE', 'Windows 10', '系统管理员', '/sys/dict/12', '127.0.0.1', '内网IP', '[12]', '{"msg":"操作成功","code":200,"data":1}', '0', '', '2020-09-07 11:29:27'),
	(13, '用户管理', '修改', 'com.vadmin.controller.sys.UserController.modify()', 'PUT', 'Windows 10', '系统管理员', '/sys/user/', '127.0.0.1', '内网IP', '{"creator":"admin","address":"西安","modifyDate":1600076698873,"sex":"0","orderBy":"","phoneNum":"1234567891","userId":1,"modify":"系统管理员","realName":"系统管理员","password":"$2a$10$TS7AaE7Lul/gAGLzhBro9uVoXY8Y4pJYpVbbSCw55KOsKEgz52s7y","organId":1,"email":"345736612@qq.com","createDate":1596182782000,"status":"0","username":"admin"}', '{"msg":"操作成功","code":200,"data":1}', '0', '', '2020-09-14 17:44:59'),
	(14, '用户管理', '修改密码', 'com.vadmin.controller.sys.UserController.updatePwd()', 'PUT', 'Windows 10', '系统管理员', '/sys/user/updatePwd', '127.0.0.1', '内网IP', '123 123456', '{"msg":"修改密码失败，旧密码错误","code":500}', '0', '', '2020-09-14 18:01:55');
/*!40000 ALTER TABLE `sys_oper_log` ENABLE KEYS */;

-- 导出  表 vadmin.sys_organ 结构
DROP TABLE IF EXISTS `sys_organ`;
CREATE TABLE IF NOT EXISTS `sys_organ` (
  `organId` int(11) NOT NULL AUTO_INCREMENT,
  `parentId` int(11) DEFAULT NULL,
  `parentName` varchar(50) DEFAULT NULL,
  `organNo` varchar(50) DEFAULT NULL,
  `organName` varchar(50) DEFAULT NULL,
  `organContent` varchar(500) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `createDate` varchar(50) DEFAULT NULL,
  `modify` varchar(50) DEFAULT NULL,
  `modifyDate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`organId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  vadmin.sys_organ 的数据：~4 rows (大约)
DELETE FROM `sys_organ`;
/*!40000 ALTER TABLE `sys_organ` DISABLE KEYS */;
INSERT INTO `sys_organ` (`organId`, `parentId`, `parentName`, `organNo`, `organName`, `organContent`, `status`, `creator`, `createDate`, `modify`, `modifyDate`) VALUES
	(1, 0, NULL, '001', 'xxx公司', 'xxx公司', '0', '系统管理员', '2020-08-14 16:59:00', NULL, NULL),
	(2, 1, NULL, '001001', '开发部', '开发部', '0', '系统管理员', '2020-08-14 16:59:32', NULL, NULL),
	(3, 1, NULL, '001002', '设计部', '设计部', '0', '系统管理员', '2020-08-14 17:00:32', NULL, NULL),
	(4, 1, NULL, '001003', '市场部', '市场部', '0', '系统管理员', '2020-08-14 17:01:05', '系统管理员', '2020-08-14 17:02:15'),
	(5, 1, NULL, '001004', '财务部', '财务部', '0', '系统管理员', '2020-08-14 17:05:41', NULL, NULL);
/*!40000 ALTER TABLE `sys_organ` ENABLE KEYS */;

-- 导出  表 vadmin.sys_role 结构
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) DEFAULT NULL,
  `roleCode` varchar(50) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modify` varchar(50) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  vadmin.sys_role 的数据：~3 rows (大约)
DELETE FROM `sys_role`;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`roleId`, `roleName`, `roleCode`, `status`, `remark`, `creator`, `createDate`, `modify`, `modifyDate`) VALUES
	(1, '系统管理员', 'admin', '0', '系统管理员', '系统管理员', '2020-07-31 16:05:23', '系统管理员', '2020-08-12 16:46:06'),
	(2, '普通用户', 'user', '0', '普通用户', '系统管理员', '2020-08-12 16:47:37', NULL, NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

-- 导出  表 vadmin.sys_role_menu 结构
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE IF NOT EXISTS `sys_role_menu` (
  `roleId` int(11) NOT NULL,
  `menuId` int(11) NOT NULL,
  KEY `roelId_menuId` (`roleId`,`menuId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  vadmin.sys_role_menu 的数据：~27 rows (大约)
DELETE FROM `sys_role_menu`;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` (`roleId`, `menuId`) VALUES
	(1, 1),
	(1, 100),
	(1, 101),
	(1, 102),
	(1, 1014),
	(1, 1015),
	(1, 1016),
	(1, 1017),
	(1, 1018),
	(1, 1019),
	(1, 1020),
	(1, 1021),
	(1, 1022),
	(1, 1023),
	(1, 1024),
	(1, 1025),
	(1, 1026),
	(1, 1027),
	(1, 1028),
	(1, 1029),
	(1, 1030),
	(1, 1031),
	(1, 1032),
	(1, 1033),
	(2, 1),
	(2, 101),
	(2, 1020);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;

-- 导出  表 vadmin.sys_role_organ 结构
DROP TABLE IF EXISTS `sys_role_organ`;
CREATE TABLE IF NOT EXISTS `sys_role_organ` (
  `roleId` int(11) NOT NULL,
  `organId` int(11) NOT NULL,
  KEY `userId_organId` (`roleId`,`organId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  vadmin.sys_role_organ 的数据：~7 rows (大约)
DELETE FROM `sys_role_organ`;
/*!40000 ALTER TABLE `sys_role_organ` DISABLE KEYS */;
INSERT INTO `sys_role_organ` (`roleId`, `organId`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5),
	(2, 1),
	(2, 2);
/*!40000 ALTER TABLE `sys_role_organ` ENABLE KEYS */;

-- 导出  表 vadmin.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `organId` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realName` varchar(50) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `phoneNum` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modify` varchar(50) DEFAULT NULL,
  `modifyDate` datetime DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phoneNum` (`phoneNum`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- 正在导出表  vadmin.sys_user 的数据：~4 rows (大约)
DELETE FROM `sys_user`;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`userId`, `organId`, `username`, `password`, `realName`, `sex`, `phoneNum`, `email`, `address`, `status`, `creator`, `createDate`, `modify`, `modifyDate`) VALUES
	(1, 1, 'admin', '$2a$10$TS7AaE7Lul/gAGLzhBro9uVoXY8Y4pJYpVbbSCw55KOsKEgz52s7y', '系统管理员', '0', '1234567891', '345736612@qq.com', '西安', '0', 'admin', '2020-07-31 16:06:22', '系统管理员', '2020-09-14 17:44:58'),
	(8, 2, 'hxk', '$2a$10$BHR4TVP2jQUNNGuuf55uPOIpBpksWjXtkfeaz1Oj2zYz.i.1qBQ3C', '惠小科', '0', '18192413636', '123@qq.com', NULL, '1', '系统管理员', '2020-08-18 16:59:19', '系统管理员', '2020-08-20 14:56:47'),
	(9, 5, 'wll', '$2a$10$c2L8UYH8nYVKjm.Otb.uNuPVp5u0eFjUUlWfgDVLdSCu8ishh1W5i', '王玲玲', '0', '18192413661', '11@qq.com', NULL, '0', '系统管理员', '2020-08-18 17:07:28', NULL, NULL);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

-- 导出  表 vadmin.sys_user_role 结构
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `userId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  KEY `userId_roleId` (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  vadmin.sys_user_role 的数据：~5 rows (大约)
DELETE FROM `sys_user_role`;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`userId`, `roleId`) VALUES
	(1, 1),
	(7, 1),
	(7, 2),
	(8, 2),
	(9, 2);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
