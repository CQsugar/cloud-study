package xyz.cchili.springcloud.account.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "t_account")
public class TAccount implements Serializable {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 总额度
     */
    @Column(name = "total")
    private Long total;

    /**
     * 已用余额
     */
    @Column(name = "used")
    private Long used;

    /**
     * 剩余可用额度
     */
    @Column(name = "residue")
    private Long residue;

    private static final long serialVersionUID = 1L;
}
