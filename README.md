This sample shows the issue when one combines `LoadingCache` with Spring Data `Repository`.

This code doesn't work with Spring Boot `2.0.5.RELEASE` and fails to bootstrap the application and is reported as cycle:

```
***************************
APPLICATION FAILED TO START
***************************

Description:

The dependencies of some of the beans in the application context form a cycle:

┌─────┐
|  cacheManager defined in class path resource [org/springframework/boot/autoconfigure/cache/GenericCacheConfiguration.class]
↑     ↓
|  cacheConfig defined in file [C:\dev\sandbox\spring-data-repository-cache\target\classes\mihalcin\CacheConfig.class]
↑     ↓
|  specificationRepository
↑     ↓
|  (inner bean)#4e6d7365
└─────┘
```

When you change `parent.version` in pom file to `1.5.10.RELEASE` and change

```
    private Specification loader(Long specificationId) {
        return specificationRepository.findById(specificationId).get();
    }
```

to

```
    private Specification loader(Long specificationId) {
        return specificationRepository.findOne(specificationId);
    }

```
the the application boots without any issue.

Why is that?
