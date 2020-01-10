# ImageDownloader
通过三方库jsoup来自动抓取网页中图片链接的工具



## 使用方法

```java

//配置参数
ImageConfig imageConfig = new DefaultImageConfig.Builder()
                .baseDir("D:/test")     //文件基本目录
                .folder("20200110")     //子目录
                .timeout(60)           //http超时时间
                .create();

//以上配置参数表示图片下载到 D:/test/20200110文件夹下
ImageDownloadManager.getInstance(imageConfig).download("http://xxxx.html");
```