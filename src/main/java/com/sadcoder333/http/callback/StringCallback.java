package com.sadcoder333.http.callback;

import com.sadcoder333.util.Log;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

/**
 * desc: 类功能描述
 * author: sadcoder333
 * date: 2020/1/10
 **/
public abstract class StringCallback implements Callback {

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        Log.d(e.getLocalizedMessage());
    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        String htmlString = Objects.requireNonNull(response.body()).string();
        onResult(htmlString);
    }


    protected abstract void onResult(String result);
}
