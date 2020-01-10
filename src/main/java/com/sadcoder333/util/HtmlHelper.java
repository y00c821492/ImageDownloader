package com.sadcoder333.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * desc: HTML文本内容解析img标签内容的工具类
 * author: sadcoder333
 * date: 2020/1/9
 **/
public class HtmlHelper {

    public static List<String> readHtmlImages(String htmlContent) {
        List<String> srcList = new ArrayList<>(16);
        Pattern p = Pattern.compile("<(img|IMG)(.*?)(>|></img>|/>)");
        Matcher matcher = p.matcher(htmlContent);
        boolean hasPic = matcher.find();
        if (hasPic) {
            while (hasPic) {
                String group = matcher.group(2);
                Pattern srcText = Pattern.compile("(src|SRC)=(\"|\')(.*?)(\"|\')");
                Matcher matcher2 = srcText.matcher(group);
                if (matcher2.find()) {
                    srcList.add(matcher2.group(3));
                }
                hasPic = matcher.find();
            }
        }
        return srcList
                .stream()
                .filter(str -> str.toLowerCase().startsWith("http"))
                .collect(Collectors.toList());
    }


}
