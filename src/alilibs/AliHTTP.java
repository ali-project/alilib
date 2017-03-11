package alilibs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

public class AliHTTP {

    private static HttpClient httpClient;

    public static void main(String[] args) throws Exception {
        AliLog.println(AliHTTP.getString("http://www.baidu.com"));

    }

    /**
     * 上传文件
     *
     * @param url 文件路径
     * @param args URL
     * @return 成功 true 失败 false
     * @throws Exception
     */
    public static String postString(String url,String [] args) {
        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
      
        PostMethod valuePost = new PostMethod(url);
        if (httpClient == null) {
            httpClient = new HttpClient(connectionManager);
        }
        for(int i=0;i<args.length;i++)
        {

            String argsString[] = args[i].split("=");
            valuePost.addParameter(argsString[0],argsString[1]);

        }

        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
        try {
            int status = httpClient.executeMethod(valuePost);
            
            //valuePost.releaseConnection();
            InputStream inputStream = valuePost.getResponseBodyAsStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while ((str = br.readLine()) != null) {
                stringBuffer.append(str);
            }
            valuePost.releaseConnection();
            return stringBuffer.toString();
            
        } catch (Exception ex) {
            Logger.getLogger(AliHTTP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public static boolean uploadFile(String filename, String action) throws Exception {

        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        File f = new File(filename);
        PostMethod filePost = new PostMethod(action);
        if (httpClient == null) {
            httpClient = new HttpClient(connectionManager);
        }
        Part[] parts = {new FilePart("file", f)};
        filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
        int status = httpClient.executeMethod(filePost);
        filePost.releaseConnection();
        if (status == HttpStatus.SC_OK) {
            return true;
        };
        return false;

    }

    public static String getString(String url) {
        try {
        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        if (httpClient == null) {
            httpClient = new HttpClient(connectionManager);
        }
        // if(httpClient==null) httpClient =new DefaultHttpClient();
        HttpMethod getMethod = new GetMethod(url);

        //发发 
        
            int response = httpClient.executeMethod(getMethod); // ����GET����

            //byte[] responseBody = getMethod.getResponseBodyAsStream();
            InputStream inputStream = getMethod.getResponseBodyAsStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while ((str = br.readLine()) != null) {
                stringBuffer.append(str);
            }

            return stringBuffer.toString();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "errorerror_unknowcode";

    }
    public static String getStringb(String url) throws Exception {

        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        if (httpClient == null) {
            httpClient = new HttpClient(connectionManager);
        }
        // if(httpClient==null) httpClient =new DefaultHttpClient();
        HttpMethod getMethod = new GetMethod(url);
            getMethod.addRequestHeader(new Header("User-Agent","Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/21.0.1180.89 Safari/537.1"));

        //发发

            int response = httpClient.executeMethod(getMethod); // ����GET����

            //byte[] responseBody = getMethod.getResponseBodyAsStream();
            InputStream inputStream = getMethod.getResponseBodyAsStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();
            String str = "";
            while ((str = br.readLine()) != null) {
                stringBuffer.append(str);
            }

            return stringBuffer.toString();



    }

    public static byte[] getBin(String url) {
        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        if (httpClient == null) {
            httpClient = new HttpClient(connectionManager);
        }
        // if(httpClient==null) httpClient =new DefaultHttpClient();
        HttpMethod getMethod = new GetMethod(url);

        try {
            int response = httpClient.executeMethod(getMethod);
            byte[] responseBody = getMethod.getResponseBody();
            return responseBody;
        } catch (HttpException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;

    }






}
