package com.siliconmount.ssrpro.repository;

import com.siliconmount.ssrpro.entity.TxnItemMtsEntity;
import com.siliconmount.ssrpro.entity.TxnSubworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TxnItemMtsRepository extends JpaRepository<TxnItemMtsEntity, Integer> {

    @Query(value = "SELECT * FROM txn_item_mts WHERE fk_item_id = :itemId", nativeQuery = true)
    List<TxnItemMtsEntity> findByItemId(@Param("itemId") Integer itemId);
}

