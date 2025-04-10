package com.i2i.service;

import com.i2i.entity.Product;
import com.i2i.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    private final RedisTemplate<String, Object> redisTemplate;

    @Cacheable(key = "#id", value = "products")
    public Product findProductById(long id) {
        log.info("find products for id {}", id);
        return productRepository.findById(id).orElseThrow();
    }

    public Product getProductById(long id) {
        var redisCacheKey = "products:" + id;
        var product = (Product) redisTemplate.opsForValue().get(redisCacheKey);
        if (product == null) {
            log.info("product {} not found in cache", id);
            product = productRepository.findById(id).orElseThrow();
            redisTemplate.opsForValue().set(redisCacheKey, product, Duration.ofMinutes(10));
        }
        return product;
    }

    @CacheEvict(key = "#id", value = "products")
    public void deleteFromCache(long id) {
        log.info("product {} deleted from cache", id);
        //removing all entries
    }
}
