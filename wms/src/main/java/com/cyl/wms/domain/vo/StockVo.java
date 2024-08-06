package com.cyl.wms.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StockVo {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "商品id")
    private String skuId;

    @ApiModelProperty(value = "库存数")
    private Integer stock;

    @ApiModelProperty(value = "待入库")
    private Integer preStock;

    @ApiModelProperty(value = "图片")
    private String picData;
}
