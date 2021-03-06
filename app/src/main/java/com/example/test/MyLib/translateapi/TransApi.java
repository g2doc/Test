package com.example.test.MyLib.translateapi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/*
    翻译 API 工具类
 */

public class TransApi {
    private static final String TRANS_API_HOST = "http://fanyi-api.baidu.com/api/trans/vip/translate";
    private String appid  = "20210424000799461";
    private String securityKey = "Edy88vtKdpsyPwa4VQxM";

    public TransApi(String appid, String securityKey) {
        this.appid = appid;
        this.securityKey = securityKey;
    }

    public Map<String, String> getTransResult(String query, String from, String to){
        Map<String, String> params = buildParams(query,from,to);
        String result = HttpGet.get(TRANS_API_HOST,params);
        return jsonToMap(result);
    }

    private Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = new HashMap<>();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        params.put("appid",appid);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);

        // 签名
        String src = appid + query + salt + securityKey; // 加密前的原文
        params.put("sign", MD5.md5(src));

        return params;
    }

    //json字符串转Map集合
    public static Map<String, String> jsonToMap(String str) {
        Map<String, String> map = new HashMap<>();
        JSONObject jsonObject = JSON.parseObject(str);
        JSONArray trans_result = jsonObject.getJSONArray("trans_result");


        JSONObject results = JSON.parseObject(trans_result.get(0).toString());
        map.put("from",jsonObject.getString("from"));
        map.put("to",jsonObject.getString("to"));
        map.put("src",results.getString("src"));
        map.put("dst",results.getString("dst"));
        return map;
    }

}
