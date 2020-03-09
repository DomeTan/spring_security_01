package cn.gotham.spring_security_01.user.model;

import cn.gotham.spring_security_01.user.enumeration.Authority;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @author tanchong
 * Create Date: 2020/3/8
 */
@ApiModel("角色实体")
@Document("role")
public class Role {

    @Id
    @ApiModelProperty(value = "ObjectId",required = true)
    private ObjectId id;

    @ApiModelProperty(value = "角色名称",required = true)
    @Field("role_name")
    private String roleName;

    @ApiModelProperty(value = "角色所拥有的权限",required = true)
    private List<Authority> authorityList;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {
        this.authorityList = authorityList;
    }
}
