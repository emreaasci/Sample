package org.csystem.app.samples.device;

public class Device {
    private String m_name;
    private String m_host;
    private int m_port;

    public Device(String name, String host, int port) {
        m_name = name;
        m_host = host;
        m_port = port;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        m_name = name;
    }

    public String getHost() {
        return m_host;
    }

    public void setHost(String host) {
        m_host = host;
    }

    public int getPort() {
        return m_port;
    }

    public void setPort(int port) {
        m_port = port;
    }

    public String toString(){
        return String.format("[%s]%s:%d",this.m_name,this.m_host,this.m_port);

    }
}
