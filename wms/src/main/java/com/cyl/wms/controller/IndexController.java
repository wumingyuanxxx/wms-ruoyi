package com.cyl.wms.controller;


import com.cyl.wms.domain.vo.StockVo;
import com.github.pagehelper.PageHelper;
import com.ruoyi.system.domain.StockMainEntity;
import com.ruoyi.system.service.StockMainRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.util.List;


@Api(description = "库存管理")
@RestController
@RequestMapping("/stock")
public class IndexController {

    @Autowired
    private StockMainRepository stockMainRepository;


    @ApiOperation("create")
    @PostMapping("/create")
    public ResponseEntity<Integer> createStockInfo(@RequestBody StockVo stock) {
        StockMainEntity main = new StockMainEntity();
        main.setId(stock.getId());
        main.setSkuId(stock.getSkuId());
        main.setPicData(stock.getPicData());
        main.setStock(stock.getStock()).init();
        stockMainRepository.saveOrUpdate(main);
        return ResponseEntity.ok(main.getId());
    }

    @ApiOperation("listStock")
    @GetMapping("/listStock")
    public ResponseEntity<Page<StockMainEntity>> listStock(Pageable page) {
        if (page != null) {
            PageHelper.startPage(page.getPageNumber() + 1, page.getPageSize());
        }
        List<StockMainEntity> list = stockMainRepository.list();
        PageImpl result = new PageImpl(list, page, ((com.github.pagehelper.Page) list).getTotal());
        return ResponseEntity.ok(result);
    }

    @ApiOperation("getStockById")
    @GetMapping("/getStockById/{id}")
    public ResponseEntity<StockMainEntity> getStockById(@PathVariable("id") Integer id) {
        StockMainEntity entity = stockMainRepository.getById(id);
        return ResponseEntity.ok(entity);
    }

    @ApiOperation("deleteById")
    @GetMapping("/deleteById/{id}")
    public ResponseEntity<Integer> deleteById(@PathVariable("id") Integer id) {
        stockMainRepository.removeById(id);
        return ResponseEntity.ok(id);
    }


    @SneakyThrows
    private Blob convertMultipartFileToBlob(MultipartFile multipartFile) {
        return new SerialBlob(multipartFile.getBytes());
    }
}
