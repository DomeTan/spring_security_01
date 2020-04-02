package cn.gotham.spring_security_01.asset.controller;

import cn.gotham.spring_security_01.asset.bean.ParamFlag;
import cn.gotham.spring_security_01.asset.model.Asset;
import cn.gotham.spring_security_01.asset.service.AssetService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanchong
 * Create Date: 2020/3/23
 */
@RestController
@RequestMapping("/api/v1/asset")
public class AssetController {

    private AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

//    @PostMapping
//    public Asset insert(Asset asset) throws Exception {
//        return assetService.insert(asset);
//    }

    @PostMapping
    public Asset insert(@RequestParam("name") String name,
                        @RequestParam("ip") String ip,
                        @RequestParam("param") String param) throws Exception {
        return assetService.insert(new Asset(name, ip),param);
    }
}
