package com.shijianwei.main.learn.function;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author SHI
 * @date 2022/6/16 15:11
 */
public class CreateTempFileOnWeb {
    public static void main(String[] args) throws Exception {
        File file = File.createTempFile(String.valueOf(System.currentTimeMillis()), '.' + "mp3");
        String mp3Url = "https://hardware-yd.nosdn.127.net/55dcb0f2ce578b0430244dce3290dbae.wav";
        httpGetAudio(file, mp3Url);
        if (file.exists()) {
            System.out.println("文件存在");
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getName());
        }else {
            System.out.println("wenjian bucunzai ");
        }

        System.out.println(file.delete());
    }

    public static void httpGetAudio(File file, String url) throws  Exception {
        URLConnection conn = new URL(url).openConnection();
        InputStream is = conn.getInputStream();

        OutputStream outstream = new FileOutputStream(file);
        byte[] buffer = new byte[4096];
        int len;
        while ((len = is.read(buffer)) > 0) {
            outstream.write(buffer, 0, len);
        }
        is.close();
        outstream.close();
    }
}
