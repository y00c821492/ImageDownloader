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

- 下载html网页上的图片
```
java -jar ImageDownloader-1.0.jar 0 D:/download_images http://xxxx.html
```

- 根据图片链接地址批量下载
```
java -jar ImageDownloader-1.0.jar 1 D:/download_images http://domain/abc/123456.jpg,http://domain/abc/678910.jpg
```


