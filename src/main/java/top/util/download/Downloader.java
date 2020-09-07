package top.util.download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 网页下载器
 *
 * @Author gaoyx1469
 * @Date 2020/9/7
 * @Version 1.0
 */
public class Downloader {

    /**
     * 传入网址，下载内容
     *
     * @param url String
     * @return List<String>
     * @throws IOException IOException
     */
    public static List<String> download(String url) throws IOException {
        List<String> lines = new ArrayList<>();
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null)
                lines.add(line);
        }
        return lines;
    }
}
