# ImageDownloader
通过三方库jsoup来自动抓取网页中图片链接的工具



## 使用方法

### 方法一：导入jar包添加依赖

- 抓取HTML网页上的图片
```java

//配置参数
ImageConfig imageConfig = new DefaultImageConfig.Builder()
                .downloadDir("D:/download_images")   //配置图片下载目录
                .timeout(60)                         //下载超时时间
                .create();

//以上配置参数表示图片下载到 D:/download_images文件夹下
ImageDownloadManager.getInstance(imageConfig).downloadImages("http://xxxx.html");
```
- 根据图片链接地址批量下载
```java

//配置参数
ImageConfig imageConfig = new DefaultImageConfig.Builder()
                .downloadDir("D:/download_images")   //配置图片下载目录
                .timeout(60)                         //下载超时时间
                .create();

List<String> imageUrls = Arrays.asList(
                "http://domain/abc/123456.jpg",
                "http://domain/abc/678910.jpg"
                );
//以上配置参数表示图片下载到 D:/download_images文件夹下
ImageDownloadManager.getInstance(imageConfig).downloadImagesByUrl(imageUrls);
```

### 方法二：java命令行执行

在java命令行执行jar包需要两个参数：
- 第一个参数为图片保存路径，文件路径请自己设置
- 第二个参数为txt文件名称

> **txt文件名只能是`htmls.txt`或者`images.txt`**

#### 下载html网页上的图片

在ImageDownloader-1.0.jar的所在目录下新建`htmls.txt`，文件内容每行记录一个html网页地址。

然后执行以下命令:
```
java -jar ImageDownloader-1.0.jar D:/download_images htmls.txt
```

#### 根据图片链接地址批量下载

在ImageDownloader-1.0.jar的所在目录下新建`images.txt`，文件内容每行记录一个图片链接地址。

然后执行以下命令:
```
java -jar ImageDownloader-1.0.jar D:/download_images images.txt
```


