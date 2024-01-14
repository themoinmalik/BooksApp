package com.demo.security.book;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookESRepository extends ElasticsearchRepository<Book, Integer> {
}
