package com.jason.basis.shiro.chapter2;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class MyRealm2 implements Realm {
    @Override
    public String getName() {
        return "myRealm2";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        if (null == username) {
            throw new UnknownAccountException();
        }
        if ("123".equals(password)) {
            System.out.println("Correct password");
        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
