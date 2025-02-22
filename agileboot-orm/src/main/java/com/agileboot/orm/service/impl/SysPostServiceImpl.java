package com.agileboot.orm.service.impl;

import com.agileboot.orm.entity.SysPostEntity;
import com.agileboot.orm.entity.SysUserEntity;
import com.agileboot.orm.mapper.SysPostMapper;
import com.agileboot.orm.mapper.SysUserMapper;
import com.agileboot.orm.service.ISysPostService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author valarchie
 * @since 2022-06-16
 */
@Service
@RequiredArgsConstructor
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPostEntity> implements ISysPostService {

    @NonNull
    private SysUserMapper userMapper;

    /**
     * 校验岗位名称是否唯一
     *
     * @param postName 岗位名称
     * @return 结果
     */
    @Override
    public boolean isPostNameDuplicated(Long postId, String postName) {
        QueryWrapper<SysPostEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne(postId != null, "post_id", postId)
            .eq("post_name", postName);
        return baseMapper.exists(queryWrapper);
    }

    @Override
    public boolean isPostCodeDuplicated(Long postId, String postCode) {
        QueryWrapper<SysPostEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.ne(postId != null, "post_id", postId)
            .eq("post_code", postCode);
        return baseMapper.exists(queryWrapper);
    }


    @Override
    public boolean isAssignedToUsers(Long postId) {
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("post_id", postId);
        return userMapper.exists(queryWrapper);
    }


}
