import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

public class SendSMS {
    public static void main(String[] args) {
        String host = "https://intlsms.market.alicloudapi.com";
        String path = "/comms/sms/sendmsgall";
        String method = "POST";
        String appcode = "XXXXXXXXX";  //去云市场里面复制
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("callbackUrl", "http://test.dev.esandcloud.com");  //短信下发状态回调通知地址(主动回调)
        bodys.put("channel", "0");   //0: 默认通道（默认值） 1: 高质量通道
        bodys.put("mobile", "+86XXXXXXXXXXXXX");  //要发送的手机号
        bodys.put("templateID", "XXXXXXXXXXX"); //模板id （去模板列表里面复制）
        bodys.put("templateParamSet", "XXXX, X");  //模板参数 (多个参数用逗号分隔)。
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
