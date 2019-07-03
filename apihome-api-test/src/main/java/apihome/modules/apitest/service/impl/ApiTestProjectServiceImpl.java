package apihome.modules.apitest.service.impl;

import apihome.modules.apitest.dao.ApiTestProjectDao;
import apihome.modules.apitest.entity.ApiTestProjectEntity;
import apihome.modules.apitest.service.ApiTestProjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by zyanycall@gmail.com on 2019-07-02 16:45.
 */
@Service("ApiTestProjectService")
public class ApiTestProjectServiceImpl extends ServiceImpl<ApiTestProjectDao, ApiTestProjectEntity> implements ApiTestProjectService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String paramKey = (String) params.get("projectName");

        IPage<ApiTestProjectEntity> page = this.page(
                new Query<ApiTestProjectEntity>().getPage(params),
                new QueryWrapper<ApiTestProjectEntity>()
                        .like(StringUtils.isNotBlank(paramKey), "project_name", paramKey)
//                        .eq("status", 1)
        );

        return new PageUtils(page);
    }

    @Override
    public void saveProject(ApiTestProjectEntity apiTestProject) {
        this.save(apiTestProject);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(ApiTestProjectEntity apiTestProject) {
        this.updateById(apiTestProject);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[] ids) {
//        for(Long id : ids){
//            SysConfigEntity config = this.getById(id);
//            sysConfigRedis.delete(config.getParamKey());
//        }
        this.removeByIds(Arrays.asList(ids));
    }
}
