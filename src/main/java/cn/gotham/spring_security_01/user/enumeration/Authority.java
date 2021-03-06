package cn.gotham.spring_security_01.user.enumeration;

/**
 *
 * 权限列表
 * @author tanchong
 * Create Date: 2020/3/8
 */
public enum Authority {

    WAM_USER("资产管理-用户");

    private String description;

    Authority(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
