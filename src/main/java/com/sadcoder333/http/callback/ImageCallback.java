package com.sadcoder333.http.callback;

import com.sadcoder333.util.ImageUtil;
import com.sadcoder333.util.Log;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;

/**
 * desc: 自定义的下载图片的回调
 * author: sadcoder333
 * date: 2020/1/8
 **/
public class ImageCallback implements Callback {

    private String url;

    public ImageCallback(String url) {
        this.url = url;
    }

    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        throw new RuntimeException(e);
    }

    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        ResponseBody body = response.body();
        if (body != null) {
            byte[] bytes = body.bytes();
            if (bytes.length == 0) {
                Log.d("failed to downloadImagesByUrl image for " + url);
                return;
            }
            File image = ImageUtil.getImageFile(url);
            if (!image.exists()) {
                FileUtils.writeByteArrayToFile(image, bytes);
            }
        }
    }
}
