package cn.gotham.spring_security_01.asset.service;

import cn.gotham.spring_security_01.asset.bean.ParamFlag;
import cn.gotham.spring_security_01.asset.model.Asset;
import cn.gotham.spring_security_01.asset.repository.AssetRepository;
import cn.gotham.spring_security_01.common.annotation.ArchivesMonitor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

/**
 * @author tanchong
 * Create Date: 2020/3/22
 */
@Service
public class AssetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssetService.class);

    private AssetRepository assetRepository;
    private ObjectMapper objectMapper;

    public AssetService(AssetRepository assetRepository, ObjectMapper objectMapper) {
        this.assetRepository = assetRepository;
        this.objectMapper = objectMapper;
    }

    @ArchivesMonitor("create")
    public Asset insert(Asset asset) throws Exception {
//    public Asset insert(Asset asset, ParamFlag paramFlag) throws Exception {
        if (StringUtils.isBlank(asset.getName()) || StringUtils.isBlank(asset.getIp())) {
            throw new Exception("不能为空");
        }
        return assetRepository.insert(asset);
    }

    @ArchivesMonitor("create1111")
    public Asset insert(Asset asset,String param) throws Exception {
        LOGGER.info("insert {}",param);

        if (StringUtils.isBlank(asset.getName()) || StringUtils.isBlank(asset.getIp())) {
            throw new Exception("不能为空");
        }

        return assetRepository.insert(asset);
    }

    @ArchivesMonitor("update")
    public Asset update(String id,String name,String ip, ParamFlag paramFlag) throws Exception {
        var asset = assetRepository.findById(new ObjectId(id)).orElseThrow(() -> new Exception("数据未找到"));
        asset.setName(name);
        asset.setIp(ip);
        return assetRepository.save(asset);
    }

    @ArchivesMonitor("delete")
    public void delete(String id, ParamFlag paramFlag) throws Exception {
        var asset = assetRepository.findById(new ObjectId(id)).orElseThrow(() -> new Exception("数据未找到"));
        assetRepository.delete(asset);
    }

    public List<Map<String,Object>> getAll() {
        var assetList = assetRepository.findAll();
        ArrayList<Map<String, Object>> maps = new ArrayList<>();
        assetList.forEach(asset -> {
            try {
                maps.add(beanToMap(asset));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return maps;
    }

    private Map<String,Object> beanToMap(Object object) throws IllegalAccessException {
        var hashMap = new HashMap<String,Object>();

        if( object == null){
            return hashMap;
        }
        var objectClass = object.getClass();
        var fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            hashMap.put(field.getName(),field.get(object));
        }
        return hashMap;
    }
}
