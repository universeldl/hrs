- # 医院挂号系统 - Hospital Registration System

  ### 项目描述

  > 设计来源是医院的预约挂号系统，从原始的仅有预约功能扩展至预约后的就诊、开药、查看就诊记录、排班、数据统计以及对医生的管理等新功能。

  ### 系统功能

  - 管理员

      - [x] 内置并提供一个管理员账号。
      - 管理员登陆后，可以进行以下操作：
         - 科室
            - [x] 添加科室
            - [x] 删除科室，如科室下仍有医生则不允许删除
            - [x] 根据科室名查找科室
            - [x] 修改科室
         - 医生
         	- [x] 医生入职录入 
            - [x] 医生离职删除，如医生仍有未就诊挂号则不允许离职  -------- 待测试  离职按钮ok
            - [x] 根据医生相关信息查找医生 
            - [x] 修改医生相关信息
         - [ ] 同意病人的注销申请
         - [x] 查看所有挂号预约列表
            - [ ] 已取消或者过时未就诊的挂号置灰、后置
         - [x] 药品的增删改查
         - [x] 查看病人列表
         - [x] 排班功能

  - 医生

      - [ ] 医生登陆后，可以进行以下操作：
      	 - [x] 查看挂号列表
         - [x] 确认就诊 --可进入后台
         - [ ] 看病
            - [ ] 基本信息
            - [ ] 既往病例
         - [ ] 诊断当前日期有预约的病人
            - [ ] 写诊断描述
            - [x] 开药  -------- 待测试
         - [x] 修改密码 

  - 病人

      - [x] 病人需要注册
      - [ ] 病人登陆后，可以进行以下行为：
         - [x] 修改自己的信息
            - [x] 不允许修改性别
            - [x] 不允许修改出生年月
            - [x] 修改密码
            - [x] 修改手机号
         - [x] 进行预约挂号
            - [x] 选择科室
            - [x] 选择预约时间
            - [x] 选择当天值班的医生
            - [ ] 付费
         - [x] 取消已预约的挂号
         - [x] 查看预约的挂号列表
         - [x] 查看自己的既往病例
         - [ ] 申请注销账号

  - 其他

      - [x] 三种用户使用同一个登陆页面
      - [x] 登陆需要验证码
      - [x] 登录时可选保留登陆状态一周
      - [x] 退出登陆
      - [x] 用定时任务更新以下信息：
         - [x] 过期未就诊的预约挂号从预约状态置为未就诊状态
         - [x] 每天将值班表中前一天有值班的医生的剩余挂号数更新为最大可预约挂号数

  ### 使用框架

  - 前端框架：bootstrap、Echarts
  - 后端框架：maven、springMVC、mybatis
  - 数 据 库：MySQL
  - 开发工具：eclipse、git
  - 测试工具：postman
  - 其他：shiro、quartz、pageHelper