package com.order_manage;

import com.alibaba.fastjson.JSONObject;
import com.order_manage.entity.BaseOrderForm;
import com.order_manage.entity.OrderForm;
import com.order_manage.entity.OrderFormTemp;
import com.order_manage.myutils.MyMethord;
import com.order_manage.myutils.RestRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class OrderManageApplicationTests {

    @Test
	void contextLoads() {

		/*String test = "LAZ01220208-S";
		System.out.println(test.substring(0,MyMethord.findNotChar(test)));*/

	/*	Set test = new HashSet();
		test.add("1");
		test.add("1");
		test.add("2");
	//	test.containsAll();
		System.out.println(test.toString());*/

	/*	Set<String> res = new HashSet<>();
		Set<String> res1 = new HashSet<>();
		String url = "http://localhost:8090/customers/custCodes";
		String body = RestRequest.restfulGetUtils(url);
		String resultCode = JSONObject.parseObject(body).get("code").toString();
		String data = JSONObject.parseObject(body).get("data").toString();
	//	String te = ["232","333","555","2222","test1","32"]
		res =JSONObject.parseObject(data,Set.class);
		System.out.println(data);
	//	Collections.addAll(res, data);
		System.out.println(res);
		res1.add("test");
		res1.add("test2");
		System.out.println(res1);*/
		OrderFormTemp test = new OrderFormTemp();
		test.setOpIdentifier("111");
		test.setId(12345);
		System.out.println(test);
		 String o = JSONObject.toJSONString(test);
		OrderForm res = JSONObject.parseObject(o,OrderForm.class);
		System.out.println(res);



	}

}
