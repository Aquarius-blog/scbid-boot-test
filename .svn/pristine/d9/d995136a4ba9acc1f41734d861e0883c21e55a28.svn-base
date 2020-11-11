package com.scbid.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @Title: HttpUtil.java 
 * @Description: TODO
 * @Package com.bloom.credit.common
 * @Author: wangyun   
 * @Date: 2018年4月10日 上午10:06:44
 * @Copyright: 四川国际招标有限责任公司
 * 注意：本内容仅限于必朗科技内部传阅，禁止外泄以及用于其他的商业目的
 */
public class HttpUtil {
    static Logger logger = LoggerFactory.getLogger(HttpUtil.class);
    
    private static final CloseableHttpClient httpclient = HttpClients.createDefault();
    
	/**
	 * @Title: getHtml 
	 * @Description: TODO
	 * @author: wangyun   
	 * @date: 2018年4月10日 上午10:06:35 
	 * @param htmlUrl
	 * @return
	 */
    
    
	public synchronized static String getHtml(String htmlUrl) {
		HttpClient httpClient = new HttpClient();
		//GetMethod getMethod = new GetMethod("http://www.ccgp.gov.cn/cr/list");
		GetMethod getMethod = new GetMethod(htmlUrl);
		logger.info("请求地址："+htmlUrl);
		//getMethod.getParams().setContentCharset("UTF-8"); 
		String htmlRet=""; 
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode != HttpStatus.SC_OK) {
			    logger.info("Method failed: "+ getMethod.getStatusLine());
			}
			// 读取内容
			InputStream in = getMethod.getResponseBodyAsStream();
			BufferedReader reader=new BufferedReader(new InputStreamReader(in,"ISO-8859-1"));
			String tmp=null;
			while((tmp=reader.readLine())!=null){
			htmlRet+=tmp;
			}
			htmlRet = new String(htmlRet.getBytes("ISO-8859-1"),"UTF-8");
		} catch (Exception e) {
		    logger.info("页面无法访问");
		}
		getMethod.releaseConnection();
		return htmlRet;
	}
	/**
	 * @Title: postHtml 
	 * @Description: TODO
	 * @author: wangyun   
	 * @date: 2018年4月10日 上午10:06:26 
	 * @param htmlUrl
	 * @return
	 */
	public static String postHtml(String htmlUrl,HttpMethodParams params) {
		HttpClient httpClient =new HttpClient();
        PostMethod postMethod =new PostMethod(htmlUrl);
        postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
        postMethod.setParams(params);
        postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
           try {
            int statusCode = httpClient.executeMethod(postMethod);
               if (statusCode != HttpStatus.SC_OK) {
                   logger.info("Method failed: "+ postMethod.getStatusLine());
               }
               //读取内容 
               byte[] responseBody = postMethod.getResponseBody();
               //处理内容
               String html = new String(responseBody);
               return html;
        } catch (Exception e) {
            logger.info("页面无法访问");
        }
           postMethod.releaseConnection();
           return htmlUrl;
	}
	/**
	 * @Title: gzipHtml 
	 * @Description: TODO
	 * @author: wangyun   
	 * @date: 2018年4月10日 上午10:06:08 
	 * @param ip
	 * @param port
	 * @param url
	 * @return
	 */
	public static String gzipHtml(String ip,int port,String url) {
		HttpClient httpClient =new HttpClient();
        httpClient.getHostConfiguration().setHost(ip, port);
        GetMethod getMethod =new GetMethod(url);
        String acceptEncoding ="";
        if (getMethod.getResponseHeader("Content-Encoding") !=null)
            acceptEncoding = getMethod.getResponseHeader("Content-Encoding").getValue();
        if (acceptEncoding.toLowerCase().indexOf("gzip") >-1) {
            getMethod.setRequestHeader("Accept-Encoding", "gzip, deflate");
            try {
                int statusCode = httpClient.executeMethod(getMethod);
                if (statusCode != HttpStatus.SC_OK) {
                    logger.info("Method failed: "+ getMethod.getStatusLine());
                }

                InputStream is = getMethod.getResponseBodyAsStream();
                GZIPInputStream gzin =new GZIPInputStream(is);
                InputStreamReader isr =new InputStreamReader(gzin, "utf-8"); // 设置读取流的编码格式，自定义编码
                java.io.BufferedReader br =new java.io.BufferedReader(isr);
                StringBuffer sb =new StringBuffer();
                String tempbf;
                while ((tempbf = br.readLine()) !=null) {
                    sb.append(tempbf);
                }
                isr.close();
                gzin.close();
                String html = sb.toString();
                return html;
            } catch (Exception e) {
                logger.info("页面无法访问");
            }
            getMethod.releaseConnection();
        }
        return url;
	}
	
    /**
     * @Title: sendGet 
     * @Description: TODO
     * @author: wangyun   
     * @date: 2018年4月10日 上午8:31:46 
     * @param url
     * @return
     */
    public static String sendGet(String url) {
        // 获取当前客户端对象
        HttpClient httpClient = new HttpClient();
        // 根据地址获取请求
        GetMethod getMethos = new GetMethod(url);// 这里发送get请求
        getMethos.setRequestHeader("Content-type", "application/x-www-form-urlencoded " + "; charset=UTF-8");
        // 通过请求对象获取响应对象
        String responseString = null;
        try {
            int statusCode = httpClient.executeMethod(getMethos);
            // LOGGER.debug("返回码： " + statusCode);
            logger.info("返回码： " + statusCode);
            // http响应失败，则返回空
            if (statusCode != HttpStatus.SC_OK) {
                // LOGGER.error("响应失败，返回码：" + statusCode);
                logger.info("响应失败，返回码：" + statusCode);
                return responseString;
            }
            // 流式读取响应体
            BufferedInputStream bis = new BufferedInputStream(getMethos.getResponseBodyAsStream());
            byte[] bytes = new byte[1024];
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int count = 0;
            while ((count = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, count);
            }
            byte[] strByte = bos.toByteArray();
            responseString = new String(strByte, 0, strByte.length, "utf-8");
            logger.info("返回内容： " + responseString);
            bos.close();
            bis.close();
        } catch (IOException e) {
            logger.error("文件系统IO异常", e);
            e.printStackTrace();
        } finally {
            getMethos.releaseConnection();
        }
        return responseString;
    }

    /**
     * 绕过https验证
     * @Title: createIgnoreVerifySSL 
     * @Description: TODO
     * @author: wangyun
     * @date: 2018年4月10日 上午10:04:22 
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[] { trustManager }, null);
        return sc;
    }
    
    /**
     * @Title: httpsGet 
     * @Description: TODO
     * @author: wangyun
     * @date: 2018年4月10日 上午10:05:01 
     * @param url
     * @param encoding
     * @return
     */
    public synchronized static String httpsGet(String url){
        String body = "";
        //采用绕过验证的方式处理https请求
        SSLContext sslcontext;
        try
        {
            sslcontext = createIgnoreVerifySSL();
         // 设置协议http和https对应的处理socket链接工厂的对象
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslcontext))
                .build();
            PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            HttpClients.custom().setConnectionManager(connManager);

            //创建自定义的httpclient对象
            CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build();
            
            //创建post方式请求对象
            HttpGet httpGet = new HttpGet(url);
            
            logger.info("请求地址："+url);
            
            //设置header信息
            //指定报文头【Content-type】、【User-Agent】
            httpGet.setHeader("Content-type", "application/x-www-form-urlencoded");
            httpGet.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            
            //执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpResponse response = client.execute(httpGet);
            //获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //按指定编码转换结果实体为String类型
                body = EntityUtils.toString(entity, "utf-8");
            }
            EntityUtils.consume(entity);
            //释放链接
            response.close();
           
        }
        catch (KeyManagementException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (NoSuchAlgorithmException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ClientProtocolException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  
        logger.info("请求结果："+body);
        return body;
        
    }
    
    /**
     * 发送HttpGet请求
     * @param url
     * @return
     */
    public static String sendGet2(String url) {

        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    /**
     * 发送HttpPost请求，参数为map
     * @param url
     * @param map
     * @return
     * @throws IOException 
     * @throws ClientProtocolException 
     */
    public static String sendPost(String url, Map<String, String> map) throws ClientProtocolException, IOException {
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            formparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(entity);
        CloseableHttpResponse response = httpclient.execute(httppost);
       
        HttpEntity entity1 = response.getEntity();
        String result = EntityUtils.toString(entity1);
        return result;
    }
    /**
     * 发送不带参数的HttpPost请求
     * @param url
     * @return
     * @throws IOException 
     * @throws ClientProtocolException 
     */
    public static String sendPost(String url) throws ClientProtocolException, IOException {
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        return result;
    }
}

