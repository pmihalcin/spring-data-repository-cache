package mihalcin;


import static com.github.benmanes.caffeine.cache.Caffeine.newBuilder;

import com.github.benmanes.caffeine.cache.LoadingCache;
import mihalcin.specification.Specification;
import mihalcin.specification.SpecificationRepository;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    private final SpecificationRepository specificationRepository;

    public CacheConfig(SpecificationRepository specificationRepository) {
        this.specificationRepository = specificationRepository;
    }

    @SuppressWarnings("unchecked")
    @Bean
    public Cache activeSpecificationsCache() {
        LoadingCache<Long, Specification> loadingCache = newBuilder()
                .recordStats()
                .build(this::loader);

        return new CaffeineCache("cache", (com.github.benmanes.caffeine.cache.Cache) loadingCache);
    }

    private Specification loader(Long specificationId) {
        return specificationRepository.findById(specificationId).get();
//        return specificationRepository.findOne(specificationId);
    }
}
