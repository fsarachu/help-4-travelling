package uy.edu.cure.servidor.central.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Log {
    private Integer id;
    private String usr;
    private String ip;
    private String url;
    private String so;

    @JsonCreator
    public Log() { }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsr() {return usr; }

    public void setUsr(String usr) { this.usr = usr; }

    public String getIp() { return ip; }

    public void setIp(String ip) { this.ip = ip; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public String getSo() { return so; }

    public void setSo(String so) { this.so = so; }

}


