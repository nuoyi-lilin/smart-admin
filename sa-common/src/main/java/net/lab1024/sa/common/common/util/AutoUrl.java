package net.lab1024.sa.common.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class AutoUrl {

    public static String getNewsUrl(String ...proxyIp) {
        String realProxyIp="";
        if(proxyIp.length>0){
            realProxyIp=proxyIp[0];
        }
        String url="";
        try {
            //URL resourceUrl = AutoUrl.class.getResource("autoNowsUrl-linux");
//            URL resourceUrl = AutoUrl.class.getResource("autoNowsUrl-win.exe");
//            String path = resourceUrl.getPath();
            ProcessBuilder pb = new ProcessBuilder("D:\\aliqiu\\smart-admin\\sa-common\\src\\main\\java\\net\\lab1024\\sa\\common\\common\\util\\autoNowsUrl-win.exe",realProxyIp);
            pb.redirectErrorStream(true);
            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                url= line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static void main(String[] args) {
//        URL resource = AutoUrl.class.getResource("autoNowsUrl-win.exe");
//        System.out.println(resource);
        String url1=getNewsUrl();
        System.out.println("url: "+url1);
        //ip生效  返回error
        String url2=getNewsUrl("116.31.55.210:40040");
        System.out.println("url: "+url2);
    }
}
