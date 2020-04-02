package cn.gotham.spring_security_01.asset.repository;

import cn.gotham.spring_security_01.asset.model.Asset;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author tanchong
 * Create Date: 2020/3/22
 */
public interface AssetRepository extends MongoRepository<Asset, ObjectId> {
}
