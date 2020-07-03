package xyz.cchili.springcloud.storage.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "t_storage")
public class TStorage implements Serializable {

    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 总库存
     */
    @Column(name = "total")
    private Integer total;

    /**
     * 已用库存
     */
    @Column(name = "used")
    private Integer used;

    /**
     * 剩余库存
     */
    @Column(name = "residue")
    private Integer residue;

    private static final long serialVersionUID = 1L;
}
