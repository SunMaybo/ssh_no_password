package com.ansible.cfg;

/**
 * Created by maybo on 2016/11/23.
 */
public class SSHAuthInfo {
    private String host;//宿主机
    private String userName;//用户身份
    private int port;//ssh协议的端口号
    private String password;//连接密码

    public void setHost(String host) {
        this.host = host;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
