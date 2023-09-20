# 我的谷粒学院

## 项目介绍





## 使用技术

#### 后端技术栈

| 技术               | 描述                   | 版本           |
| ------------------ | ---------------------- | -------------- |
| SpringBoot         | SpringBoot框架         | 2.2.1.RELEASE  |
| SpringCloud        | SpringCloud框架        | Hoxton.RELEASE |
| SpringCloudAlibaba | SpringCloudAlibaba框架 | 0.2.2.RELEASE  |
| SpringSecurity     | SpringSecurity框架     | 2.2.1.RELEASE  |
| Redis              | 数据缓存框架           | 6.2.0          |
| JWT                | Web令牌                | 0.7.0          |
| easyexcel          | excel处理工具          | 2.1.1          |
| fastjson           | json解析包             | 1.2.28         |
| swagger-ui         | 接口测试工具           | 2.7.0          |
| hutool             | Java工具类库           | 5.7.13         |

#### 前端技术栈

| 技术       | 描述                 | 版本   |
| ---------- | -------------------- | ------ |
| Vue        | 前端开发框架         |        |
| element-ui | 桌面端组件库         | 2.15.6 |
| Jquery     | 快速的JavaScript框架 | 1.11.3 |
| axios      | 网络请求库           | 0.21.4 |
| EChars     | 可视化图表库         | 5.2    |

### 其他技术

| 技术    | 描述                     | 版本   |
| ------- | -------------------| ------ |
| Maven   | Java项目的管理和构建工具 |        |
| MySQL   | 数据库                   | 5.7    |
| Git     | 分布式版本控制系统       | 2.33.0 |
| 阿里云短信服务 | 使用阿里云发送短信 |  |
| 阿里云OSS | 使用阿里云做文件存储 |  |
| 阿里云视频 | 使用阿里云做视频播放 |  |
| 微信登录 | 接入微信登录接口 |  |
| 微信支付 | 接入微信支付接口 |  |

#### 开发工具

| 工具     | 描述                   | 版本    |
| --------| ------------------------| --------|
| IDEA    | 代码编辑器               | 2021.1 |
| VSCode  | 代码编辑器               | 1.60.2 |
| VMware  | 桌面虚拟计算机软件       | 15.0   |
| CentOS  | Linux操作系统          | 7.1    |
| PostMan | 接口测试工具             | 8.8.0  |



## 页面展示








## 部署流程

<font color=DarkMagenta size=4px>**后端部署流程**</font>

1. 下载项目，解压到本地路径，使用IDEA或其他工具打开项目
2. 把项目资料/数据库脚本目录下的数据库文件导入本地数据库
3. 修改所有application.properties文件中的数据源，使用自己本地的库名，用户名和密码
4. 修改相关路径，配置正确的图片路径、文件路径、附件路径、Mapper扫描路径。
5. 修改所有application.properties文件中的Nacos服务，使用自己的Nacos服务地址和端口
6. 修改所有application.properties文件中的Redis服务，使用自己的Redis服务地址和端口
7. 注意pom.xml中的依赖导入，确保所有的依赖在本地正确安装
8. 尤其需要注意阿里云视频上传的相关依赖，由于该依赖没有开源，无法从中央仓库下载，需要自己手动添加到自己的项目中
9. 修改MyGuliClass/service/service-oss模块下application.properties文件中有关阿里云OSS的配置，使用自己的keyid，keysecret，bucketname和endpoint
10. 修改MyGuliClass/service/service-msm模块下application.properties文件中有关阿里云短信的配置，使用自己的accesskeyid，secret，regionid
11. 修改MyGuliClass/service/service-vod模块下application.properties文件中有关视频点播的配置，使用自己的keyId，keysecret
12. 修改MyGuliClass/service/service-ucenter模块下application.properties文件中有关视频点播的配置，使用自己的app_id，app_secret，redirect_url
13. 启动所用的XXXApplication.java中的main方法，控制台没有报错信息，显示服务启动的端口号和启动时间即运行成功

<font color=DarkMagenta size=4px>**前端部署流程：后台管理部分**</font>

1. 下载项目，解压到本地路径，使用VScode或其他工具打开项目
2. 进入到MyGuliClassVue\vue-admin-1010目录下，执行 npm install 命令，安装项目所有需要的依赖
3. 执行 npm run dev 命令，启动后台管理项目
4. 控制台显示 Your application is running here: http://localhost:9528 ，并会自动打开浏览器
5. 控制台没有报错信息，表示项目启动成功
6. 在浏览器中输入正确的用户名和密码即可正常使用

<font color=DarkMagenta size=4px>**前端部署流程：前台展示部分**</font>

1. 下载项目，解压到本地路径，使用VScode或其他工具打开项目
2. 进入到MyGuliClassVue\vue-front-1010目录下，执行 npm install 命令，安装项目所有需要的依赖
3. 执行 npm run dev 命令，启动前端展示项目
4. 控制台显示服务的地址和内存占用情况
5. 控制台没有报错信息，表示项目启动成功
6. 在浏览器中输入 http://localhost:3000/，即可正常访问

