package apihome.modules.apitest.service;

import apihome.modules.apitest.entity.ApiTestProjectEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;

import java.util.Map;

/**
 * 接口项目service
 *
 * Created by zyanycall@gmail.com on 2019-07-02 15:05.
 */
public interface ApiTestProjectService extends IService<ApiTestProjectEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 保存配置信息
     */
    void saveProject(ApiTestProjectEntity apiTestProject);

    /**
     * 更新配置信息
     */
    void update(ApiTestProjectEntity apiTestProject);

//    /**
//     * 根据key，更新value
//     */
//    void updateValueByKey(String key, String value);

    /**
     * 删除配置信息
     */
    void deleteBatch(Long[] ids);

//    /**
//     * 根据key，获取配置的value值
//     *
//     * @param key           key
//     */
//    String getValue(String key);

//    /**
//     * 根据key，获取value的Object对象
//     * @param key    key
//     * @param clazz  Object对象
//     */
//    <T> T getConfigObject(String key, Class<T> clazz);


}
