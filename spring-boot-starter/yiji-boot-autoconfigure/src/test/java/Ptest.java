/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * muyu@yiji.com 2016-08-01 15:13 创建
 *
 */

import org.junit.Test;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/08/01
 */
public class Ptest {
    static{
        System.setProperty("spring.profiles.active", "local");
    }

    @Test
    public void litigationRisk() throws Exception {
        String url="https://test.suanhua.org/cpcs/api/v2/channel/6001";
        Map<String, String> param = new TreeMap<String, String>();
        param.put("name","茹张顺");
        param.put("sorgcode","20500105201607001");
        param.put("idCard","330621195903076211");
        param.put("sorgseq","swerthjhgfreghjk");
        hash(param);
        System.out.println(param);
        String result = sendPost(url, param, "UTF-8");
        System.out.println(result);
    }
    static private void hash(Map<String, String> param) {
        //param.put("sorgseq", getSeq());
        StringBuilder sb = new StringBuilder();
        Iterator iterator = param.keySet().iterator();
        while (iterator.hasNext()) {
            sb.append(param.get(iterator.next()));
        }
        param.put("hash", md5(sb.toString() + "cM2zn3rGDZTM524", "UTF-8").toUpperCase());
    }

    static private String md5(String msg, String charset) {
        try {
            System.out.println("md5Src:" + msg);
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] hashedBytes = digest.digest(msg.getBytes(charset));
            String rst = byts2hexstr(hashedBytes);
            System.out.println("md5:" + rst.toUpperCase());
            return rst;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
        }
        return "";
    }
    private static String byts2hexstr(byte[] arrayBytes) {
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        for (int i = 0; i < arrayBytes.length; i++) {
            tmp = Integer.toHexString(arrayBytes[i] & 0xff);
            sb.append(tmp.length() == 1 ? "0" + tmp : tmp);
        }
        return sb.toString();
    }

    public static String sendPost(String url, Map<String, String> param, String charset) {
        OutputStream out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = getConnection(realUrl);
//
//            Map<String, String> defaultHeaders = new LinkedHashMap<>();
//            defaultHeaders.put("accept", "*/*");
//            defaultHeaders.put("connection", "Keep-Alive");
//            defaultHeaders.put("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = conn.getOutputStream();
            String p = buildParams(param, charset);
            if(p != null) {
                // 发送请求参数
                out.write(p.getBytes());
                // flush输出流的缓冲
                out.flush();
            }
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), charset));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
    static public HttpURLConnection getConnection(URL url) {
        HttpURLConnection connection = null;
        try{
            if(url.getProtocol().toUpperCase().startsWith("HTTPS")) {
                SSLContext ctx = SSLContext.getInstance("SSL");
                ctx.init(new KeyManager[0], new TrustManager[] {new X509TrustManager() {

                    @Override
                    public void checkClientTrusted(X509Certificate[] arg0,
                                                   String arg1) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] arg0,
                                                   String arg1) throws CertificateException {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                }}, new SecureRandom());


                HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
                conn.setSSLSocketFactory(ctx.getSocketFactory());
                conn.setConnectTimeout(10000);
                conn.setReadTimeout(40000);

                conn.setHostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });

                connection = conn;
            } else {
                connection = (HttpURLConnection) url.openConnection();
            }


        } catch(Exception e){
            e.printStackTrace();
        }

        return connection;
    }
    public static String buildParams(Map<String, String> param, String charset) {
        if (param != null && !param.isEmpty()) {
            StringBuffer buffer = new StringBuffer();
            for (Map.Entry<String, String> entry : param.entrySet()) {
                try {
                    buffer.append(entry.getKey()).append("=")
                            .append(URLEncoder.encode(entry.getValue(), charset))
                            .append("&");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return buffer.deleteCharAt(buffer.length() - 1).toString();
        } else {
            return null;
        }
    }
}
