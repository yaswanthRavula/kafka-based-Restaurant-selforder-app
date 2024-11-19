package com.Restaurant.selforder.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Restaurant.selforder.Entity.Order;

import jakarta.transaction.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(nativeQuery = true, value = "select * from orders where table_no =?1")
	public List<Order> fetchAllOrderByTableNo(int tableNo);
	
	
	@Modifying(flushAutomatically = true,clearAutomatically = true)
	@Transactional
	@Query(nativeQuery = true, value="update orders set item_status = ?1 where item_id = ?2")
	public void updateItemStatus(String status, long itemId);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(nativeQuery = true, value="delete from orders where table_no = ?1")
	public void deleteAllItemsOnTable(int tableNo);
}
