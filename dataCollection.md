## 项目简述



<br><br>
## 开源技术栈
- Java EE
- SpringBoot
- HttpClient
- webMagic
- Spider-flow
- Redis
- MySQL
- VUE
- Tomcat
- Nginx
- Zookeeper
- Kafka
- RabbitMQ
- Bootstrap


## 总体架构
![输入图片说明](ProIMG/Qon4S9stvKHpWoe8RSYMLw.png)
  （这是最早期系统架构图）  

## 数据处理流程
![输入图片说明](ProIMG/-SaHmZ-9GeADfc121RJbqw.png)
（这是最早期系统设计图）

## 信源管理
信源，信息来源的简称。
<br><br>
我们需要对采集 类型，内容，平台，地区 等多种属性进行管理。我们对此开发了三代信源管理平台。
##### 一代产品形态
![输入图片说明](ProIMG/spider-factory-1.png)

##### 二代产品形态
![输入图片说明](ProIMG/spider-factory-2.png)

##### 三代产品形态
 ![输入图片说明](ProIMG/spider-factory-3.png)

## 站点画像  

采用模拟浏览器请求技术实现深度和广度抓取算法，总体分3个环节,对整个站点进行 1)全站扫描、2)数据储存、3)特性分析。 <br>
- siteMeta <br>
识别整个网站的结构，并且解析存储，给每一个抓取的网站都建立一个“小档案”库。 <br><br> 
- siteIndex <br>
在识别基础上把所有网页都预存储下来，并且提取各种特征值进行分析计算，从站点目录，到站点栏目，以及每个抓取目标页面都会标记不同的特性参数。 <br><br>
- siteFeatures<br>
最后将整体分析演算的结果，还原成这个网站的抓取画像和特性，以便于机器将会知道采用哪种抓取策略自动去匹配这个网站的特性抓取，基于这样的设计可以实现大规模数据采集无人值守的效果，也就是百度、谷歌 这些大型搜索引擎实现的数据效果。<br>

用“探头机器人”对整个网站预抓取一遍，相当于一个先头部队，把抓取网站的情况搞清楚以后，很快机器就知道采取哪种采集策略，大量需要采集的网站，只有极小的部分需要人工干预采集，而且更不需要编写一行爬虫采集代码，完全是自动化及低代码化大规模数据采集。


## 数据抓取
- 自动抓取 <br>
有了网站的画像属性，就知道匹配那种采集抓取策略了，大部分网站就能自动抓取就自动识别抓取数据，无需人工干预。<br>

- 人工配置 <br>
有的网站抓取难度大，采用可视化技术将整个站点的标签提取出来给开发工程师，他们将可以快速的对网站的抓取进行配置。
我们在采集任何一个网站的时候将会有各种“探头”对网站的结构，广告位，关键性内容，导航栏，分页，列表，站点特性，站点数据量，抓取难易度，站点更新频率，等等。
<br>

- 采集模板 <br>
为了简化人工操作，提高工作效率，我们还提供了爬虫模板。爬虫模板的意义在于，用户遇到一个配置繁琐的站点，不用从头开始，只需要到爬虫模板库里面找类似的模板即可，如图所示：
![输入图片说明](ProIMG/spider-factory-templeta.png)
<br> 

## 数据暂存
- 暂存  <br>
如果把数据直接储存到系统大数据库里，一旦有大量采集的脏数据下来就是浪费时间和精力，所有数据都会预演储存一遍，储存完成后会有程序对此核对监测，以免数据字段漏存，错存。
- 预警  <br>
如果在暂存环节发现储存错误，将会及时通过邮件发送对研发工程师提醒，告知错误内容，让其对此修正。
<br>


## 低代码开发

- 配置<br>
目前的爬虫工厂已经一个低代码化开发的平台了，更准确的说，我们不是在上面开发，而且在上面进行爬虫配置对数据采集抓取。如图所示：
![输入图片说明](ProIMG/spider-factory-4.png)


- 维护 <br>
通过低代码的方式的开发，我们对爬虫的维护更加方便，只需要在web管理界面中，修改爬虫抓取配置即可，同时还可以在线调试，查看具体的抓取错误日志。否则某一个站点抓取出现问题，都不知道是哪台服务器上的哪个爬虫抓取错误。各种站点爬虫的量一旦大起来，维护成本极高。
![输入图片说明](ProIMG/spider-work-err.png)

<br>

## 分布式采集
- 控制器(master)

- 分发器(dispatch)

- 执行器 (downloader)
  
<br>

## 爬虫管理
- 爬虫状态

- 采集状态


<br> 

## 反爬策略

- 模拟请求头

- 代理IP池

<br> 


## 采集分类

##### 网站采集
x

##### app 采集
x

##### 公众号采集
x

##### 小程序采集
x

##### (短)视频采集
x
<br>

## 采集日志
- 日志跟踪ID
 

- 数据生命周期
<br><br>


## 数据解析
- 自动解析

- 手动解析

<br> 


## 数据储存
##### 异步调用

通过kafka中间件将数据通过消息的形式发送给储存端子系统。
<br><br>
##### 更多内容
[【数据处理】技术架构说明文档](https://gitee.com/stonedtx/yuqing/blob/master/dataProcessing.md) 

<br><br><br><br>