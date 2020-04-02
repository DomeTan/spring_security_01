package cn.gotham.spring_security_01.asset.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author tanchong
 * Create Date: 2020/3/22
 */
@Document("asset")
public class Asset {


    private ObjectId id;

    private String name;

    private String ip;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Asset(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
