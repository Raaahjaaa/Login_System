package com.calculator;

import java.util.HashMap;

public class IDandPasswords {
    HashMap<String, String> LoginInfo= new HashMap<String, String>();
    
    IDandPasswords(){
         LoginInfo.put("rajasoni","rajasoni");
         LoginInfo.put("ShivaSoni", "Shiva10soni");
    }

    protected HashMap getLoginInfo(){
        return LoginInfo;
    }
}
