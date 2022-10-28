package com.gaurang.test.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

@Entity
@Table(name = "ORD_META" ,schema="ORDERS", uniqueConstraints = { @UniqueConstraint(name = "ORD_META_UK1", columnNames = { "ORD_ID" })})
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class OrderMeta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ORD_META_ID", nullable = false, updatable = false)
    @SequenceGenerator( name = "ORD_META_ID_SEQ", sequenceName = "ORDERS.ORD_META_ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ORD_META_ID_SEQ" )
    private int orderMetaId;

    @Column(name = "ORD_ID", nullable = false, updatable = false, length = 10)
    private String orderId;

    @Column(name = "ORD_STAT_CD", nullable = false)
    private char orderStatusCode;

    @Column(name="INVC_TYPE_CD", nullable = false)
    private char invoiceTypeCode;

    @Column(name="PRNT_CD", nullable = false)
    private char printCode;

    @Column(name="UPLD_TO_WMS_CD", nullable = false)
    private char uploadToWmsCode = 'N';

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = false)
    @JoinColumn(name="ORD_ID", referencedColumnName = "ORD_ID", nullable = false, insertable = false, updatable = false)
    private OrderHeader orderHeader;
}
