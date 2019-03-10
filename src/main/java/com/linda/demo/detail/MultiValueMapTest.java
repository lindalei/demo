package com.linda.demo.detail;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

public class MultiValueMapTest {
    private static MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();

    public static void main(String[] args) {
        multiValueMap.add("key1", "Monday");
        multiValueMap.add("key1", "Tuesday");
        for (String key : multiValueMap.keySet()) {
            List<String> values = multiValueMap.get(key);
            System.out.println(values);
            System.out.println(StringUtils.join(values,' ')+" :"+key);
        }
    }

}
