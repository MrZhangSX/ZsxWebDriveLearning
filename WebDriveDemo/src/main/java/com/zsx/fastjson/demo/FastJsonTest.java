package com.zsx.fastjson.demo;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import org.openqa.selenium.json.Json;

public class FastJsonTest {
    public static void main(String[] args) {
        TestJsonObject();
        javaToJson();
        jsonToJava();
    }

    //读取JSON对象
    public static void TestJsonObject(){
        String string = "{\"id\":123}";
        JSONObject jsonObject = JSON.parseObject(string);
        System.out.println(jsonObject.getIntValue("id"));
        String stringList = "[\"id\", 123]";
        JSONArray jsonArray = JSON.parseArray(stringList);
        System.out.println(jsonArray.get(0));
        System.out.println(jsonArray.get(1));
    }

    //JavaBean对象生成JSON格式
    public static void javaToJson(){
        Product product = new Product(123,"zsx");
        System.out.println(JSON.toJSONString(product));
        System.out.println(JSON.toJSONString(product, JSONWriter.Feature.BeanToArray));
    }

    //Json转换成JavaBean
    public static void jsonToJava(){
        String string = "{\"id\":123,\"name\":\"zsx\"}";
        Product product = JSON.parseObject(string, Product.class);
        System.out.println(product.getId() + "  " + product.getName());
    }
}
