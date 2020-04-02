package cn.gotham.spring_security_01.asset.bean;

/**
 * @author tanchong
 * Create Date: 2020/3/23
 */
public class ParamFlag {
    public ParamFlag(String paramFlag) {
        this.paramFlag = paramFlag;
    }

    private String paramFlag;

    public String getParamFlag() {
        return paramFlag;
    }

    public void setParamFlag(String paramFlag) {
        this.paramFlag = paramFlag;
    }

    @Override
    public String toString() {
        return "ParamFlag{" +
                "paramFlag='" + paramFlag + '\'' +
                '}';
    }
}
