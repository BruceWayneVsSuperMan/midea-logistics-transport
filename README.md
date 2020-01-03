# DOP 开发运维平台 
*Dev Ops Platform*

## 文档
[物流云脚手架](http://lsit.midea.com:7080/#/framework/logistics)

## 项目生成器
   本项目已经接入[项目生成器](http://lsit.midea.com:7080/#/framework/gen), 可以进行部分通用代码的自动生成.

   业务迭代中，当数据库结构发生调整后(注意：是物理数据库真的完成结构调整后)，开发人员需要手工运行项目中的gen.java代码。项目会请求代码生成器服务端，生成器会根据规则，把数据库变动的entity，mapper，service，rest等代码覆盖到本地项目中，最终完成项目的通用代码维护。

## 目录结构注意事项
   本项目中有很多_READ.md, _WARN.md文件. 开发人员应该去阅读和遵守里面的说明.
    
   其中
   _READ.md表示代码生成器不会干预该目录,
   _WARN.md表示代码生成器可能会覆盖里面的文件, 开发人员应该阅读里面的说明去进行开发

