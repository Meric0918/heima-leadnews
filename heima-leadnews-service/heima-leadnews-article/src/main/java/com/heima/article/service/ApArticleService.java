package com.heima.article.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * @Author: Meric
 * @CreateTime: 2025-09-21
 * @Description:
 * @Version: 1.0
 */

@Service
public interface ApArticleService extends IService<ApArticle> {
    ResponseResult load(ArticleHomeDto dto, Short type);
}
