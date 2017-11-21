/*
 * This file is generated by jOOQ.
*/
package com.dsd.db;


import com.dsd.db.tables.Device;
import com.dsd.db.tables.Deviceevents;
import com.dsd.db.tables.Intervalreads;
import com.dsd.db.tables.Registerreads;
import com.dsd.db.tables.records.DeviceRecord;
import com.dsd.db.tables.records.DeviceeventsRecord;
import com.dsd.db.tables.records.IntervalreadsRecord;
import com.dsd.db.tables.records.RegisterreadsRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>MeterDataStore</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<DeviceRecord> KEY_DEVICE_PRIMARY = UniqueKeys0.KEY_DEVICE_PRIMARY;
    public static final UniqueKey<DeviceeventsRecord> KEY_DEVICEEVENTS_UK_DEVICEEVENTS = UniqueKeys0.KEY_DEVICEEVENTS_UK_DEVICEEVENTS;
    public static final UniqueKey<IntervalreadsRecord> KEY_INTERVALREADS_UK_INTERVAL_READ = UniqueKeys0.KEY_INTERVALREADS_UK_INTERVAL_READ;
    public static final UniqueKey<RegisterreadsRecord> KEY_REGISTERREADS_UK_REGISTER_KEY = UniqueKeys0.KEY_REGISTERREADS_UK_REGISTER_KEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<DeviceeventsRecord, DeviceRecord> FK_DEVICEEVENTS_1 = ForeignKeys0.FK_DEVICEEVENTS_1;
    public static final ForeignKey<IntervalreadsRecord, DeviceRecord> FK_INTERVALREADS_1 = ForeignKeys0.FK_INTERVALREADS_1;
    public static final ForeignKey<RegisterreadsRecord, DeviceRecord> FK_REGISTERREADS_1 = ForeignKeys0.FK_REGISTERREADS_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<DeviceRecord> KEY_DEVICE_PRIMARY = createUniqueKey(Device.DEVICE, "KEY_device_PRIMARY", Device.DEVICE.SERIALNUMBER);
        public static final UniqueKey<DeviceeventsRecord> KEY_DEVICEEVENTS_UK_DEVICEEVENTS = createUniqueKey(Deviceevents.DEVICEEVENTS, "KEY_deviceEvents_uk_deviceevents", Deviceevents.DEVICEEVENTS.DEVICEID, Deviceevents.DEVICEEVENTS.EVENTNAME, Deviceevents.DEVICEEVENTS.EVENTTIME);
        public static final UniqueKey<IntervalreadsRecord> KEY_INTERVALREADS_UK_INTERVAL_READ = createUniqueKey(Intervalreads.INTERVALREADS, "KEY_IntervalReads_uk_interval_read", Intervalreads.INTERVALREADS.CHANNELNUMBER, Intervalreads.INTERVALREADS.UOM, Intervalreads.INTERVALREADS.READTIME, Intervalreads.INTERVALREADS.SERIALNUMBER);
        public static final UniqueKey<RegisterreadsRecord> KEY_REGISTERREADS_UK_REGISTER_KEY = createUniqueKey(Registerreads.REGISTERREADS, "KEY_RegisterReads_uk_register_key", Registerreads.REGISTERREADS.REGISTERNUM, Registerreads.REGISTERREADS.READTIME, Registerreads.REGISTERREADS.SERIALNUMBER, Registerreads.REGISTERREADS.TOUTIER);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<DeviceeventsRecord, DeviceRecord> FK_DEVICEEVENTS_1 = createForeignKey(com.dsd.db.Keys.KEY_DEVICE_PRIMARY, Deviceevents.DEVICEEVENTS, "fk_deviceEvents_1", Deviceevents.DEVICEEVENTS.DEVICEID);
        public static final ForeignKey<IntervalreadsRecord, DeviceRecord> FK_INTERVALREADS_1 = createForeignKey(com.dsd.db.Keys.KEY_DEVICE_PRIMARY, Intervalreads.INTERVALREADS, "fk_IntervalReads_1", Intervalreads.INTERVALREADS.SERIALNUMBER);
        public static final ForeignKey<RegisterreadsRecord, DeviceRecord> FK_REGISTERREADS_1 = createForeignKey(com.dsd.db.Keys.KEY_DEVICE_PRIMARY, Registerreads.REGISTERREADS, "fk_RegisterReads_1", Registerreads.REGISTERREADS.SERIALNUMBER);
    }
}
