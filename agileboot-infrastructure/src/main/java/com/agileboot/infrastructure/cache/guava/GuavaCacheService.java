package com.agileboot.infrastructure.cache.guava;


import com.agileboot.orm.entity.SysDeptEntity;
import com.agileboot.orm.service.ISysConfigService;
import com.agileboot.orm.service.ISysDeptService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author valarchie
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class GuavaCacheService {

    @NonNull
    private ISysConfigService configService;

    @NonNull
    private ISysDeptService deptService;

    public AbstractGuavaCacheTemplate<String> configCache = new AbstractGuavaCacheTemplate<String>() {
        @Override
        public String getObjectFromDb(Object id) {
            return configService.getConfigValueByKey(id.toString());
        }
    };

    public AbstractGuavaCacheTemplate<SysDeptEntity> deptCache = new AbstractGuavaCacheTemplate<SysDeptEntity>() {
        @Override
        public SysDeptEntity getObjectFromDb(Object id) {
            return deptService.getById(id.toString());
        }
    };


}
