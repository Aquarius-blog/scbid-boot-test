package com.didispace;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

import com.scbid.common.utils.HttpUtil;

public class HttpClientTest {
	@Test
	public void testPost() throws UnsupportedEncodingException {
		String url = "http://127.0.0.1:7001/pay-admin/alipay/pcPay";
		Map<String, String> map = new HashMap<String, String>();
		map.put("outTradeNo", "7652714");
		map.put("subject", "哈哈");
		map.put("totalFee", "0.01");
		map.put("body", "哈哈");
		String result;
		try {
			result = HttpUtil.sendPost(url, map);
			System.out.println(result);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Test
	public void checkPassword() {
		String password = new Md5Hash("11111111").toHex();
		System.err.println(password);
	}
	
}
