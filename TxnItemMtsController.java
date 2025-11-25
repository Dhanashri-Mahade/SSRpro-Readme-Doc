package com.siliconmount.ssrpro.controller;

import com.siliconmount.ssrpro.dto.TxnItemMtsDTO;
import com.siliconmount.ssrpro.dto.TxnSubworkDTO;
import com.siliconmount.ssrpro.service.TxnItemMtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/txn-items-mts")
public class TxnItemMtsController {

    @Autowired
    private TxnItemMtsService service;

    // 🔹 Get All Items
    @GetMapping
    public List<TxnItemMtsDTO> getAllTxnItems() {
        return service.getAllTxnItems();
    }

    // 🔹 Get Item by ID
    @GetMapping("/{id}")
    public ResponseEntity<TxnItemMtsDTO> getTxnItemById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getTxnItemById(id));
    }

    // 🔹 Create New Item
    @PostMapping
    public ResponseEntity<TxnItemMtsDTO> createTxnItem(@RequestBody TxnItemMtsDTO txnItemDTO) {
        return ResponseEntity.ok(service.createTxnItem(txnItemDTO));
    }

    // 🔹 Update Item
    @PutMapping("/{id}")
    public ResponseEntity<TxnItemMtsDTO> updateTxnItem(
            @PathVariable Integer id, @RequestBody TxnItemMtsDTO txnItemDTO) {
        return ResponseEntity.ok(service.updateTxnItem(id, txnItemDTO));
    }

    // 🔹 Delete Item
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTxnItem(@PathVariable Integer id) {
        return ResponseEntity.ok(service.deleteTxnItem(id));
    }

    @GetMapping("/ByItemId/{itemId}")
    public ResponseEntity<List<TxnItemMtsDTO>> getTxnItemByItemId(@PathVariable Integer itemId) {
        return ResponseEntity.ok(service.getTxnItemByItemId(itemId));
    }
}

