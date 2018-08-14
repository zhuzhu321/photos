package com.liyujian.utils;

import java.util.UUID;

public class UUIDUtils {
	//生成UUID
	public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
   }
}
