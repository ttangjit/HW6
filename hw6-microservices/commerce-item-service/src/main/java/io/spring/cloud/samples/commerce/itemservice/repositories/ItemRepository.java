package io.spring.cloud.samples.commerce.itemservice.repositories;

import io.spring.cloud.samples.commerce.itemservice.domain.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends PagingAndSortingRepository<Item, String> {

	@Query("select i from Item i where i.category = :category")	
    public Iterable<Item> findByCategory(@Param("category") String category);
	@Query("select i from Item i where i.id = :Id")
    public Iterable<Item> findById(@Param("Id") Long Id);
}
