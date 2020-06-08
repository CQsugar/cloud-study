package xyz.cchili.springcloud.cloudconsumerorder.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Payment implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 支付流水号
     */
    private String serial;

    private static final long serialVersionUID = 1L;
}
