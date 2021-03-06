/*
 * This file is generated by jOOQ.
*/
package com.dsd.db.tables.records;


import com.dsd.db.tables.Deviceevents;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class DeviceeventsRecord extends TableRecordImpl<DeviceeventsRecord> implements Record4<String, String, Timestamp, String> {

    private static final long serialVersionUID = 1361494595;

    /**
     * Setter for <code>MeterDataStore.deviceEvents.deviceID</code>.
     */
    public void setDeviceid(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>MeterDataStore.deviceEvents.deviceID</code>.
     */
    public String getDeviceid() {
        return (String) get(0);
    }

    /**
     * Setter for <code>MeterDataStore.deviceEvents.eventName</code>.
     */
    public void setEventname(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>MeterDataStore.deviceEvents.eventName</code>.
     */
    public String getEventname() {
        return (String) get(1);
    }

    /**
     * Setter for <code>MeterDataStore.deviceEvents.eventTime</code>.
     */
    public void setEventtime(Timestamp value) {
        set(2, value);
    }

    /**
     * Getter for <code>MeterDataStore.deviceEvents.eventTime</code>.
     */
    public Timestamp getEventtime() {
        return (Timestamp) get(2);
    }

    /**
     * Setter for <code>MeterDataStore.deviceEvents.eventText</code>.
     */
    public void setEventtext(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>MeterDataStore.deviceEvents.eventText</code>.
     */
    public String getEventtext() {
        return (String) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, Timestamp, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<String, String, Timestamp, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Deviceevents.DEVICEEVENTS.DEVICEID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Deviceevents.DEVICEEVENTS.EVENTNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field3() {
        return Deviceevents.DEVICEEVENTS.EVENTTIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Deviceevents.DEVICEEVENTS.EVENTTEXT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getDeviceid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getEventname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component3() {
        return getEventtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getEventtext();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getDeviceid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getEventname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value3() {
        return getEventtime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getEventtext();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeviceeventsRecord value1(String value) {
        setDeviceid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeviceeventsRecord value2(String value) {
        setEventname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeviceeventsRecord value3(Timestamp value) {
        setEventtime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeviceeventsRecord value4(String value) {
        setEventtext(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeviceeventsRecord values(String value1, String value2, Timestamp value3, String value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DeviceeventsRecord
     */
    public DeviceeventsRecord() {
        super(Deviceevents.DEVICEEVENTS);
    }

    /**
     * Create a detached, initialised DeviceeventsRecord
     */
    public DeviceeventsRecord(String deviceid, String eventname, Timestamp eventtime, String eventtext) {
        super(Deviceevents.DEVICEEVENTS);

        set(0, deviceid);
        set(1, eventname);
        set(2, eventtime);
        set(3, eventtext);
    }
}
