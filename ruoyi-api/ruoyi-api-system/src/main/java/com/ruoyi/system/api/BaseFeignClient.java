package com.ruoyi.system.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Carl
 * @since 6.1.0
 */
public interface BaseFeignClient<T> {

    /**
     * 根据ID获取
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    T getById(@PathVariable("id") Long id);

    /**
     * 获取所有
     * @param entity
     * @return
     */
    @PostMapping("/")
    T create(@RequestBody T entity);

    /**
     * 根据ID删除
     * @param id
     */
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);
}
