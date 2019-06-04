# **API接口规范**

一、 说明

API统一采用,类似Restful 风格,采用JSON数据传输

 

二、返回结果体

返回结果对象名称为ReponseVo，每个接口不管成功或者失败，都会返回此json结构。

| **字段名** | **类型** | **字段描述**                                                 |
| ---------- | -------- | ------------------------------------------------------------ |
| code       | int      | 结果码 ：0：代表成功；-1：代表服务器内部错误；其他业务码可有各个业务模块划分定义 |
| message    | string   | 客户端提示消息                                               |
| log        | string   | 错误log日志，生产环境需要关闭开关                            |
| data       | object   | 实际数据对象                                                 |

 

三、分页请求参数PageForm

| **字段名** | **类型** | **字段描述** |
| ---------- | -------- | ------------ |
| pageSize   | int      | 显示分页条数 |
| pageNum    | int      | 显示当前页数 |

 

四、分页响应参数 PageResponseVo

PageResponseVo从ReponseVo继承，除了code, message, log等参数以外。

还增加了分页相关参数。

| **字段名** | **类型** | **字段描述** |
| ---------- | -------- | ------------ |
| pageSize   | int      | 显示分页条数 |
| pageNum    | int      | 显示当前页数 |
| totalNum   | int      | 显示总条数   |
| totalPage  | int      | 显示总页数   |
| data       | object   | 显示结果集   |

 

五、API名称定义规范

| **接口名**                |                                                          |
| ------------------------- | -------------------------------------------------------- |
| /user/view                | 查看单个用户                                             |
| /user/list                | 查看用户列表                                             |
| /user/add                 | 添加用户                                                 |
| /user/logicalDelete       | 逻辑删除用户, 放到回收站 （如果字段中有isDelete）        |
| /user/logicalRestore      | 逻辑恢复用户，从回收站中取出用户（如果字段中有isDelete） |
| /user/update              | 根据主键更新用户                                         |
| /user/delete              | 根据主键删除用户                                         |
|                           |                                                          |
| /user/batchLogicalDelete  | 批量逻辑删除用户（如果字段中有isDelete）                 |
| /user/batchLogicalRestore | 批量逻辑恢复用户（如果字段中有isDelete）                 |
| /user/batchDelete         | 根据主键列表批量删除用户                                 |
| /user/batchUpdate         | 根据更新列表中的主键，批量更新用户                       |
| /user/batchExport         | 批量导出用户，导出为xls文件列表                          |
| /user/batchInport         | 批量导入用户，导入为xls文件列表                          |
| /user/batchInsert         | 批量插入用户，从列表中进行插入                           |

  