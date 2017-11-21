/*
 * This file is generated by jOOQ.
*/
package com.dsd.db.tables.records;


import com.dsd.db.tables.Registerreads;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RegisterreadsRecord extends TableRecordImpl<RegisterreadsRecord> implements Record8<Integer, Integer, Double, String, Timestamp, Timestamp, Integer, String> {

    private static final long serialVersionUID = -427788585;

    /**
     * Setter for <code>MeterDataStore.RegisterReads.registerNum</code>.
     */
    public void setRegisternum(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>MeterDataStore.RegisterReads.registerNum</code>.
     */
    public Integer getRegisternum() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>MeterDataStore.RegisterReads.readType</code>.
     */
    public void setReadtype(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>MeterDataStore.RegisterReads.readType</code>.
     */
    public Integer getReadtype() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>MeterDataStore.RegisterReads.readValue</code>.
     */
    public void setReadvalue(Double value) {
        set(2, value);
    }

    /**
     * Getter for <code>MeterDataStore.RegisterReads.readValue</code>.
     */
    public Double getReadvalue() {
        return (Double) get(2);
    }

    /**
     * Setter for <code>MeterDataStore.RegisterReads.UOM</code>.
     */
    public void setUom(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>MeterDataStore.RegisterReads.UOM</code>.
     */
    public String getUom() {
        return (String) get(3);
    }

    /**
     * Setter for <code>MeterDataStore.RegisterReads.readTime</code>.
     */
    public void setReadtime(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>MeterDataStore.RegisterReads.readTime</code>.
     */
    public Timestamp getReadtime() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>MeterDataStore.RegisterReads.maxDemandTime</code>.
     */
    public void setMaxdemandtime(Timestamp value) {
        set(5, value);
    }

    /**
     * Getter for <code>MeterDataStore.RegisterReads.maxDemandTime</code>.
     */
    public Timestamp getMaxdemandtime() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>MeterDataStore.RegisterReads.touTier</code>.
     */
    public void setToutier(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>MeterDataStore.RegisterReads.touTier</code>.
     */
    public Integer getToutier() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>MeterDataStore.RegisterReads.serialNumber</code>.
     */
    public void setSerialnumber(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>MeterDataStore.RegisterReads.serialNumber</code>.
     */
    public String getSerialnumber() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, Integer, Double, String, Timestamp, Timestamp, Integer, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row8<Integer, Integer, Double, String, Timestamp, Timestamp, Integer, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Registerreads.REGISTERREADS.REGISTERNUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Registerreads.REGISTERREADS.READTYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Double> field3() {
        return Registerreads.REGISTERREADS.READVALUE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Registerreads.REGISTERREADS.UOM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Registerreads.REGISTERREADS.READTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Registerreads.REGISTERREADS.MAXDEMANDTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Registerreads.REGISTERREADS.TOUTIER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return Registerreads.REGISTERREADS.SERIALNUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getRegisternum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getReadtype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double component3() {
        return getReadvalue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getUom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getReadtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getMaxdemandtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getToutier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component8() {
        return getSerialnumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getRegisternum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getReadtype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double value3() {
        return getReadvalue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getUom();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getReadtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getMaxdemandtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getToutier();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getSerialnumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RegisterreadsRecord value1(Integer value) {
        setRegisternum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RegisterreadsRecord value2(Integer value) {
        setReadtype(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RegisterreadsRecord value3(Double value) {
        setReadvalue(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RegisterreadsRecord value4(String value) {
        setUom(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RegisterreadsRecord value5(Timestamp value) {
        setReadtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RegisterreadsRecord value6(Timestamp value) {
        setMaxdemandtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RegisterreadsRecord value7(Integer value) {
        setToutier(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RegisterreadsRecord value8(String value) {
        setSerialnumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RegisterreadsRecord values(Integer value1, Integer value2, Double value3, String value4, Timestamp value5, Timestamp value6, Integer value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RegisterreadsRecord
     */
    public RegisterreadsRecord() {
        super(Registerreads.REGISTERREADS);
    }

    /**
     * Create a detached, initialised RegisterreadsRecord
     */
    public RegisterreadsRecord(Integer registernum, Integer readtype, Double readvalue, String uom, Timestamp readtime, Timestamp maxdemandtime, Integer toutier, String serialnumber) {
        super(Registerreads.REGISTERREADS);

        set(0, registernum);
        set(1, readtype);
        set(2, readvalue);
        set(3, uom);
        set(4, readtime);
        set(5, maxdemandtime);
        set(6, toutier);
        set(7, serialnumber);
    }
}