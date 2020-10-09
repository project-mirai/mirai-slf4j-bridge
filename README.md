<div align="center">
   <img width="160" src="http://img.mamoe.net/2020/02/16/a759783b42f72.png" alt="logo"></br>


   <img width="95" src="http://img.mamoe.net/2020/02/16/c4aece361224d.png" alt="title">

----
Mirai 是一个在全平台下运行，提供 QQ 协议支持的高效率机器人库

这个项目的名字来源于
     <p><a href = "http://www.kyotoanimation.co.jp/">京都动画</a>作品<a href = "https://zh.moegirl.org/zh-hans/%E5%A2%83%E7%95%8C%E7%9A%84%E5%BD%BC%E6%96%B9">《境界的彼方》</a>的<a href = "https://zh.moegirl.org/zh-hans/%E6%A0%97%E5%B1%B1%E6%9C%AA%E6%9D%A5">栗山未来(Kuriyama <b>Mirai</b>)</a></p>
     <p><a href = "https://www.crypton.co.jp/">CRYPTON</a>以<a href = "https://www.crypton.co.jp/miku_eng">初音未来</a>为代表的创作与活动<a href = "https://magicalmirai.com/2019/index_en.html">(Magical <b>Mirai</b>)</a></p>
图标以及形象由画师<a href = "">DazeCake</a>绘制
</div>

# mirai-slf4j-bridge

SLF4J with [mirai] 的连接桥实现,
主要桥接 SLF4J 日志系统到 [mirai] 日志系统

## Download
[ ![Download](https://api.bintray.com/packages/karlatemp/mirai/mirai-slf4j-bridge/images/download.svg?) ](https://bintray.com/karlatemp/mirai/mirai-slf4j-bridge/)

## Use

### Mirai Console

#### 命令行启动
将下载的 `mirai-slf4j-bridge.jar` 放入 `libs` 即可 (最佳做法)

#### 其他模式
将下载的 `mirai-slf4j-bridge` 放入 `plugins` 即可

### 基于 core 的应用
打包应用时携带 `mirai-slf4j-bridge` 即可

[mirai]: https://github.com/mamoe/mirai
