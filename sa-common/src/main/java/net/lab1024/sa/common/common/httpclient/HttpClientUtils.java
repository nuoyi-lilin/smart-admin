package net.lab1024.sa.common.common.httpclient;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;

/**
 * 功能描述: httpclient 工具类Client
 */
@Slf4j
@Component
public class HttpClientUtils {

    private final static int CONNECT_TIMEOUT = 15000;//与远程服务器连接超时时间

    private final static int CONNECTION_REQUEST_TIMEOUT = 5*1000;//从连接池中获取连接的超时时间

    private final static int SOCKET_TIMEOUT = 15000; //socket读数据超时时间：从服务器获取响应数据的超时时间

    public static final String UTF_8 = "UTF-8";

    public static final String KEY_CODE = "code";

    public static final String KEY_ENTITY = "entity";

    public static CloseableHttpClient getCloseableHttpClient(Integer timeout) throws Exception {
        return HttpClients.custom()
                .setConnectionManager(createConnectionManager())
                .setDefaultRequestConfig(getRequestConfig(timeout))
                .build();
    }
    private static RequestConfig getRequestConfig(Integer timeout) {
        return RequestConfig.custom()
                .setConnectTimeout(CONNECT_TIMEOUT)
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                .setSocketTimeout(timeout)
                .build();
    }
    public static PoolingHttpClientConnectionManager createConnectionManager() throws Exception {
        SSLContext context = SSLContext.getInstance("TLS");
        TrustManager tm = new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
            @Override
            public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}
            @Override
            public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}
        };
        context.init(null, new TrustManager[] { tm }, null);

        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(context, NoopHostnameVerifier.INSTANCE);

        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("http", PlainConnectionSocketFactory.INSTANCE).register("https", socketFactory).build();

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
                socketFactoryRegistry);
        // 设置连接池大小
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultMaxPerRoute(connectionManager.getMaxTotal());
        // Validate connections after 1 sec of inactivity
        connectionManager.setValidateAfterInactivity(2000);
        return connectionManager;
    }


    public static void main(String[] args) throws Exception {
//        String urls = "http://www.66ip.cn/nmtq.php?getnum=1&isp=0&anonymoustype=0&start=&ports=&export=&ipaddress=&area=1&proxytype=2&api=66ip";
        String urls = "http://api1.ydaili.cn/tools/BMeasureApi.ashx?action=BEAPI&secret=C34FC9CB982240F85FD3DD179B4AC402CE4E932A911A6EBC4B368F7B945A7ACB782476CC562FD394&number=1&orderId=SH20230603170718148&format=txt";
//        Map<String, String> params1 = new HashMap<>();
//        params1.put("start","2023-06-0511:46:00");
//        params1.put("init","1");
//        params1.put("platform","www");
        String url = "https://www.dongqiudi.com/api/data/tab/league/new/index?start=2023-06-0615:15:25&init=1&platform=www";
        Map<String, String> params = new HashMap<>();
        params.put("start","2023-06-0511:46:00");
        params.put("init","1");
        params.put("platform","www");
        String replace = doGetOfReturnJson(urls).trim();
        System.out.println(replace);
        Map<String, Object> stringObjectMap = doGet(url, null, null, "113.236.119.118:40047");
        System.out.println(stringObjectMap);
    }

    /**
     * Get方式请求
     * @param pageUrl 请求地址
     * @param charset 编码方式
     * @param params  参数
     * @param proxyIp 代理IP
     * @return
     */
    public static Map<String, Object> doGet(String pageUrl, String charset, Map<String, String> params, String proxyIp) {
        Map<String, Object> map = new HashMap<String, Object>();
        String result = null;
        if (null == charset) {
            charset = "utf-8";
        }
        //设置绕过SSL请求验证
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(SSLConnection.createSSLConnSocketFactory()).build();
        try {
            URL url = new URL(pageUrl);
            //设置代理协议
            HttpHost target = new HttpHost(url.getHost(), url.getDefaultPort(), url.getProtocol());
            HttpHost proxy = new HttpHost(proxyIp.split(":")[0], Integer.parseInt(proxyIp.split(":")[1]));
            RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(CONNECT_TIMEOUT)
                    .setConnectionRequestTimeout(CONNECT_TIMEOUT).setSocketTimeout(CONNECT_TIMEOUT).build();
            HttpGet httpget = new HttpGet(url.toString());
            httpget.setConfig(config);
            try {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    httpget.addHeader(entry.getKey(), entry.getValue());
                }
            } catch (Exception e) {
            }
            CloseableHttpResponse response = null;
            try {
                response = httpclient.execute(target, httpget);
                if (response != null) {
                    HttpEntity resEntity = response.getEntity();
                    if (resEntity != null) {
                        result = EntityUtils.toString(resEntity, charset);
                        map.put("res", result);
                    }
                    Header[] headerinfo = response.getAllHeaders();
                    map.put("headerinfo", headerinfo);
                }
            } catch (Exception e) {
                map.put("res", "error");
                System.out.println(e.getMessage());
                log.info("Connection refused: connect:{}", e.getMessage());
            } finally {
                try {
                    response.close();
                } catch (NullPointerException e) {
                    map.put("res", "error");
                    log.info("无响应结果");
                }
            }
        }catch (ConnectTimeoutException | SocketTimeoutException e) {
            log.info("请求超时");
            map.put("res", "error");
            return map;
        }catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }




    /**
     * Post方式请求
     * @param pageUrl 请求地址
     * @param params 请求参数
     * @param charset 编码方式
     * @param header 请求头
     * @param proxyIp 代理IP
     * @return
     */
    public static Map<String, Object> doPost(String pageUrl, String params, String charset, Map<String, String> header, String proxyIp) {
//        log.info("===========================================【POST请求信息】==================================================");
//        log.info("||  【POST地址】-{}",pageUrl);
//        log.info("||  【请求参数】{}",params);
//        log.info("===========================================================================================================");
        Map<String, Object> resMap = new HashMap<String, Object>();
        String result = null;
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(SSLConnection.createSSLConnSocketFactory()).build();
        try {
            URL url = new URL(pageUrl);
            HttpHost target = new HttpHost(url.getHost(), url.getDefaultPort(), url.getProtocol());
            HttpHost proxy = new HttpHost(proxyIp.split(":")[0], Integer.parseInt(proxyIp.split(":")[1]));
            RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(CONNECT_TIMEOUT)
                    .setConnectionRequestTimeout(CONNECT_TIMEOUT).setSocketTimeout(CONNECT_TIMEOUT).build();
            HttpPost httpPost = new HttpPost(url.toString());
            httpPost.setConfig(config);
            try {
                if (null != header) {
                    Set<Map.Entry<String, String>> entries = header.entrySet();
                    for (Map.Entry<String, String> entry : entries) {
                        httpPost.addHeader(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception e) {
            }
//            httpPost.setEntity(new StringEntity(params));
//            httpPost.setEntity(new StringEntity(params, ContentType.APPLICATION_FORM_URLENCODED));
            StringEntity stringEntity = new StringEntity(params);
            stringEntity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse response = null;
            try {
                response = httpclient.execute(target, httpPost);
                if (response != null) {
                    HttpEntity resEntity = response.getEntity();
                    if (resEntity != null) {
                        result = EntityUtils.toString(resEntity, "UTF-8");
//                        log.info("===============================================【返回结果】==================================================");
//                        log.info("||  {}",result);
//                        log.info("===========================================================================================================");
                        resMap.put("res", result);
                    }
                    Header[] headerinfo = response.getAllHeaders();
                    resMap.put("headerinfo", headerinfo);
//                    log.info("===============================================【返回头部】==================================================");
//                    log.info("===========================================================================================================");
                }
            } catch (Exception e) {
                resMap.put("res", "error");
                log.info("Connection refused: connect:{}", e.getMessage());
            } finally {
                try {
                    response.close();
                } catch (NullPointerException e) {
                    resMap.put("res", "error");
                    log.info("无响应结果");
                }
            }
        }catch (ConnectTimeoutException | SocketTimeoutException e) {
//            log.info("====请求超时=====");
            log.info("【POST请求异常1】---->",e.getMessage());
            resMap.put("res", "error");
            return resMap;
        }catch (ClientProtocolException e) {
//            e.printStackTrace();
            log.info("【POST请求异常2】---->",e.getMessage());
            resMap.put("res", "error");
            return resMap;
        } catch (IOException e) {
            log.info("【POST请求异常3】---->",e.getMessage());
//            e.printStackTrace();
            resMap.put("res", "error");
            return resMap;
        }finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resMap;
    }



    /**
     * 只针对提交JSON字符串方式
     * @param pageUrl
     * @param params
     * @param charset
     * @param header
     * @param proxyIp
     * @return
     */
    public static Map<String, Object> doPostByJson(String pageUrl, String params, String charset, Map<String, String> header, String proxyIp) {
        log.info("===========================================【doPostByJson-POST请求信息】==================================================");
        log.info("||  【POST地址】-{}",pageUrl);
        log.info("||  【请求参数】{}",params);
        log.info("===========================================================================================================");
        Map<String, Object> resMap = new HashMap<String, Object>();
        String result = null;
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(SSLConnection.createSSLConnSocketFactory()).build();
        try {
            URL url = new URL(pageUrl);
            HttpHost target = new HttpHost(url.getHost(), url.getDefaultPort(), url.getProtocol());
            HttpHost proxy = new HttpHost(proxyIp.split(":")[0], Integer.parseInt(proxyIp.split(":")[1]));
            RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(CONNECT_TIMEOUT)
                    .setConnectionRequestTimeout(CONNECT_TIMEOUT).setSocketTimeout(CONNECT_TIMEOUT).build();
            HttpPost httpPost = new HttpPost(url.toString());
            httpPost.setConfig(config);
            try {
                if (null != header) {
                    Set<Map.Entry<String, String>> entries = header.entrySet();
                    for (Map.Entry<String, String> entry : entries) {
                        httpPost.addHeader(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //参数
            List<BasicNameValuePair> pair =new ArrayList<BasicNameValuePair>();
            pair.add(new BasicNameValuePair("data", params));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pair,"UTF-8");
            httpPost.setEntity(entity);

            Header[] allheader = httpPost.getAllHeaders();
            for (int i = 0; i < allheader.length; i++) {
                log.info("||--请求头信息-->{}",allheader[i]);
            }

            CloseableHttpResponse response = httpclient.execute(target, httpPost);
            log.info("||--请求参数-->{}",EntityUtils.toString(httpPost.getEntity(),"UTF-8"));
            try {
                if (response != null) {
                    HttpEntity resEntity = response.getEntity();
                    if (resEntity != null) {
                        result = EntityUtils.toString(resEntity, "UTF-8");
                        log.info("===============================================【返回结果】==================================================");
                        log.info("||  {}",result);
                        log.info("===========================================================================================================");
                        resMap.put("res", result);
                    }
                    Header[] headerinfo = response.getAllHeaders();
                    resMap.put("headerinfo", headerinfo);
                    log.info("===============================================【返回头部】==================================================");
                    log.info("===========================================================================================================");
                }
            } finally {
                response.close();
            }
        }catch (ConnectTimeoutException | SocketTimeoutException e) {
//            log.info("====请求超时=====");
            log.info("【POST请求异常1】---->",e.getMessage());
            resMap.put("res", "error");
            return resMap;
        }catch (ClientProtocolException e) {
//            e.printStackTrace();
            log.info("【POST请求异常2】---->",e.getMessage());
            resMap.put("res", "error");
            return resMap;
        } catch (IOException e) {
            log.info("【POST请求异常3】---->",e.getMessage());
//            e.printStackTrace();
            resMap.put("res", "error");
            return resMap;
        }finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resMap;
    }

    /**
     * 获得响应HTTP实体内容
     *
     * @param response
     * @return
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    private static String getHttpEntityContent(HttpResponse response) throws IOException, UnsupportedEncodingException {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream is = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                sb.append(line + "\n");
                line = br.readLine();
            }
            return sb.toString();
        }
        return "";
    }

    /******************  GET  *******************/

    public static String doGetOfReturnJson(String url) throws Exception {
        return doGetOfReturnJson(url,null);
    }

    public static String doGetOfReturnJson(String url, Map<String,Object> headerMap) throws Exception {
        CloseableHttpResponse response = null;
        String result = null;
        Integer code = null;//http_status
        JSONObject jsonObject = new JSONObject();
        log.info("HttpClientUtils-doGetOfReturnJson请求url={} -->headerMap={}",url,headerMap);
        try {
            response = doGetBaseInit(url,CONNECT_TIMEOUT,headerMap);
            if(response != null){
                code = response.getStatusLine().getStatusCode();
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, UTF_8);
                }
            }
            log.info("HttpClientUtils-doGetOfReturnJson返回数据："+result);
            return result;
        }finally {
            if(response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static CloseableHttpResponse doGetBaseInit(String url, Integer timeout, Map<String,Object> headerMap) throws Exception {
        if(timeout == null){
            timeout = SOCKET_TIMEOUT;
        }
        //创建HTTPCLIENT链接对象
        CloseableHttpClient httpclient = getCloseableHttpClient(timeout);

        HttpGet httpGet = new HttpGet(url);
        // 设置头部参数。
        if (headerMap != null) {
            Iterator iterator = headerMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry entry = (Entry) iterator.next();
                httpGet.setHeader(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
        } catch (SocketTimeoutException e) {//只处理响应超时，需要订单轮询
            e.printStackTrace();
            log.info("发起HTTP-GET请求SocketTimeout!{}",e.getMessage());
        } catch (ConnectTimeoutException e){
            e.printStackTrace();
            log.info("发起HTTP-GET ConnectTimeout!{}",e.getMessage());
            throw new ConnectTimeoutException();
        }
        return response;
    }

    /******************  POST  *******************/
    public static String doPostBase(String url, Map<String, Object> paramsMap,String paramsStr, Integer timeout,String paramsStrContentType,Map<String, Object> headerMap) throws Exception {
        CloseableHttpResponse response = null;
        log.info("HttpClientUtils-doPostBase请求url={},参数Map={},参数str={}",url,paramsMap,paramsStr);
        try {
            response = doPostBaseInit(url,paramsMap,headerMap,paramsStr,paramsStrContentType,timeout);
            String result = null;
            log.info("HttpClientUtils-HTTP响应消息<========" + response);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, UTF_8);
                }
            }else {
                log.info("HttpClientUtils-getResponseResult未成功的响应的消息体entity=" + response.getEntity()
                        + ",statusCode=" + response.getStatusLine().getStatusCode());
            }
            return result;
        } finally {
            if(response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static JSONObject doPostXmlOfReturnJson(String url, String paramsStr, Map<String, Object> headerMap, Integer timeout) throws Exception {
        return doPostBaseOfReturnJson(url,null,headerMap,paramsStr,"application/xml",null);
    }

    public static JSONObject doPostOfReturnJson(String url, String paramsStr, Integer timeout) throws Exception {
        return doPostOfReturnJson(url,paramsStr,"application/json",timeout);
    }

    public static JSONObject doPostOfReturnJson(String url, String paramsStr, String paramsStrContentType, Integer timeout) throws Exception {
        return doPostBaseOfReturnJson(url,null,null,paramsStr,paramsStrContentType,timeout);
    }

    public static JSONObject doPostOfReturnJson(String url, Map<String, Object> paramsMap, Integer timeout) throws Exception {
        return doPostOfReturnJson(url,paramsMap,null,timeout);
    }

    public static JSONObject doPostOfReturnJson(String url, String paramsStr, Map<String, Object> headerMap, Integer timeout) throws Exception {
        return doPostBaseOfReturnJson(url,null,headerMap,paramsStr,null,timeout);
    }

    public static JSONObject doPostOfReturnJson(String url, Map<String, Object> paramsMap, Map<String, Object> headerMap, Integer timeout) throws Exception {
        return doPostBaseOfReturnJson(url,paramsMap,headerMap,null,null,timeout);
    }

    public static JSONObject doPostBaseOfReturnJson(String url, Map<String, Object> paramsMap, Map<String, Object> headerMap, String paramsStr, String paramsStrContentType, Integer timeout) throws Exception{
        CloseableHttpResponse response = null;
        String result = null;
        Integer code = null;//http_status
        JSONObject jsonObject = new JSONObject();

        log.info("HttpClientUtils-doPostBaseOfReturnJson请求url={},参数Map={},参数str={}",url,paramsMap,paramsStr);
        try {
            response = doPostBaseInit(url,paramsMap,headerMap,paramsStr,paramsStrContentType,timeout);
            if(response != null){
                code = response.getStatusLine().getStatusCode();
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, UTF_8);
                }
            }
            jsonObject.put(KEY_CODE,code);
            jsonObject.put(KEY_ENTITY,result);
            log.info("HttpClientUtils-doPostBaseOfReturnJson返回数据："+jsonObject);
            return jsonObject;
        }catch(ConnectTimeoutException e){
            // 捕获超时异常 并反馈给调用者
            e.printStackTrace();
            log.info("HttpClientUtils-doPostBaseOfReturnJson请求超时,参数e={}",e);
            return null;

        } finally {
            if(response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static CloseableHttpResponse doPostBaseInit(String url, Map<String, Object> paramsMap, Map<String, Object> headerMap, String paramsStr, String paramsStrContentType, Integer timeout) throws Exception {
        if(timeout == null){
            timeout = SOCKET_TIMEOUT;
        }
        RequestConfig config = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).setConnectionRequestTimeout(20000).setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();

        //创建HTTPCLIENT链接对象
        CloseableHttpClient httpclient = getCloseableHttpClient(timeout);

        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<>();
        if(paramsMap != null && !paramsMap.isEmpty()){//设置参数
            Iterator iterator = paramsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry entry = (Entry) iterator.next();
                nvps.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, UTF_8));
        }
        // 设置头部参数。
        if (headerMap != null && !headerMap.isEmpty()) {
            Iterator iterator = headerMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry entry = (Entry) iterator.next();
                httpPost.setHeader(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        if(paramsStr != null){
            StringEntity se = new StringEntity(paramsStr,UTF_8);
            se.setContentEncoding(UTF_8);
            if(paramsStrContentType != null){
                se.setContentType(paramsStrContentType);
            }
            httpPost.setEntity(se);
        }
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpPost);
        } catch (SocketTimeoutException e) {//只处理响应超时，需要订单轮询
            e.printStackTrace();
            log.info("发起HTTP-POST请求异常!{}",e.getMessage());
        } catch (ConnectTimeoutException e){
            e.printStackTrace();
            log.info("发起HTTP-POST ConnectTimeout!{}",e.getMessage());
            throw new ConnectTimeoutException();
        }
        return response;
    }

    /******************  PUT  *******************/
    public static JSONObject doPutBase(String url, Map<String, Object> headerMap, String paramsStr, Integer timeout) throws Exception {
        if(timeout == null){
            timeout = SOCKET_TIMEOUT;
        }
        //创建HTTPCLIENT链接对象
        CloseableHttpClient httpClient = getCloseableHttpClient(timeout);
        HttpPut httpPut = new HttpPut(url);
        // 设置头部参数。
        if (headerMap != null) {
            Iterator iterator = headerMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry entry = (Entry) iterator.next();
                httpPut.setHeader(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        if(paramsStr != null){
            StringEntity se = new StringEntity(paramsStr);
            se.setContentEncoding(UTF_8);
            se.setContentType("application/json");
            httpPut.setEntity(se);
        }
        CloseableHttpResponse response = null;
        String result = null;
        Integer code = null;//http_status
        try {
            response = httpClient.execute(httpPut);
            if(response != null){
                code = response.getStatusLine().getStatusCode();
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, UTF_8);
                }
            }
        } catch (SocketTimeoutException e) {
        }  finally {
            if(response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(KEY_CODE,code);
        jsonObject.put(KEY_ENTITY,result);
        log.info("HttpClientUtils-doPutBase返回数据："+jsonObject);
        return jsonObject;
    }

}
