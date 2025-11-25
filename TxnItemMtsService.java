package com.siliconmount.ssrpro.service;

import com.siliconmount.ssrpro.dto.TxnItemMtsDTO;
import com.siliconmount.ssrpro.dto.TxnSubworkDTO;
import com.siliconmount.ssrpro.entity.TxnItemMtsEntity;
import com.siliconmount.ssrpro.entity.TxnSubworkEntity;
import com.siliconmount.ssrpro.mapper.TxnItemMtsMapper;
import com.siliconmount.ssrpro.mapper.TxnSubworkMapper;
import com.siliconmount.ssrpro.repository.TxnItemMtsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TxnItemMtsService {

    @Autowired
    private TxnItemMtsRepository repository;

    @Autowired
    TxnItemMtsMapper mapper;

    public List<TxnItemMtsDTO> getAllTxnItems() {


        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public TxnItemMtsDTO getTxnItemById(Integer id) {
        TxnItemMtsEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));
        return mapper.toDTO(entity);
    }

    public TxnItemMtsDTO createTxnItem(TxnItemMtsDTO txnItemDTO) {
        TxnItemMtsEntity entity = mapper.toEntity(txnItemDTO);
        return mapper.toDTO(repository.save(entity));
    }

    public TxnItemMtsDTO updateTxnItem(Integer id, TxnItemMtsDTO txnItemDTO) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Item not found with ID: " + id);
        }
        txnItemDTO.setId(id); // Ensure the entity has the correct ID
        TxnItemMtsEntity txnItemMtsEntity = repository.getById(id);
        mapper.toEntity(txnItemDTO, txnItemMtsEntity);
        TxnItemMtsEntity updatedEntity = repository.save(txnItemMtsEntity);
        return mapper.toDTO(updatedEntity);
    }

    public String deleteTxnItem(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Item not found with ID: " + id);
        }
        repository.deleteById(id);
        return "successfully deleted";
    }

    public List<TxnItemMtsDTO> getTxnItemByItemId(Integer itemId) {
        List<TxnItemMtsEntity>  entity = repository.findByItemId(itemId);
        return entity.stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}

