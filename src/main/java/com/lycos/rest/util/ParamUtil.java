package com.lycos.rest.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ParamUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Lycos
 * @date 2014年9月3日 下午9:38:18
 */
public class ParamUtil {
    public static Map<String, String> parse(String paramString) {
        Map<String, String> params = new HashMap<String, String>();
        String[] paramPairs = paramString.split("&");
        for (String param : paramPairs) {
            String[] key_value = param.split("=");
            params.put(key_value[0], key_value[1]);
        }
        return params;
    }
}
