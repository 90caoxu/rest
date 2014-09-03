package com.lycos.rest.storage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.lycos.rest.bean.Address;
import com.lycos.rest.bean.Contact;

/**
 * @ClassName: ContactStore
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Lycos
 * @date 2014年9月3日 下午9:37:51
 */
public class ContactStore {
    private static Map<String, Contact> store;
    private static ContactStore instance = null;

    private ContactStore() {
        store = new HashMap<String, Contact>();
        initOneContact();
    }

    public static Map<String, Contact> getStore() {
        if (instance == null) {
            instance = new ContactStore();
        }
        return store;
    }

    private static void initOneContact() {
        Address[] addrs = { new Address("Shanghai", "Long Hua Street"), new Address("Shanghai", "Dong Quan Street") };
        Contact cHuang = new Contact("huangyim", "Huang Yi Ming", Arrays.asList(addrs));
        store.put(cHuang.getId(), cHuang);
    }
}
