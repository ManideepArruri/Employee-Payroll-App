package com.seveneleven.employeepayroll.session;

public class Session {
	private String username;
    private long loginTime;
    private long timeout = 5*60*1000;

    public Session(String username){

        this.username = username;
        this.loginTime = System.currentTimeMillis();

    }

    public boolean isExpired(){

        return System.currentTimeMillis()-loginTime > timeout;

    }
}
