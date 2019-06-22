package com.example.microservice_architecture_integration.util;

import java.util.UUID;

/**
 * 生产UUID32工具
 */
public class UuidUtil {

    /**
     * 获取UUID32
     * @return
     */
    public static String getId() {
       String uuid = UUID.randomUUID().toString();//转化为String对象
       uuid = uuid.replace("-", "");//因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可
       return uuid;
    }
}
