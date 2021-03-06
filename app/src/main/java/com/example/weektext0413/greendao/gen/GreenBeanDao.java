package com.example.weektext0413.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.weektext0413.model.GreenBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "GREEN_BEAN".
*/
public class GreenBeanDao extends AbstractDao<GreenBean, Long> {

    public static final String TABLENAME = "GREEN_BEAN";

    /**
     * Properties of entity GreenBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property FollowMovie = new Property(0, int.class, "followMovie", false, "FOLLOW_MOVIE");
        public final static Property Id = new Property(1, Long.class, "id", true, "_id");
        public final static Property ImageUrl = new Property(2, String.class, "imageUrl", false, "IMAGE_URL");
        public final static Property Name = new Property(3, String.class, "name", false, "NAME");
        public final static Property Rank = new Property(4, int.class, "rank", false, "RANK");
        public final static Property ReleaseTime = new Property(5, long.class, "releaseTime", false, "RELEASE_TIME");
        public final static Property ReleaseTimeShow = new Property(6, String.class, "releaseTimeShow", false, "RELEASE_TIME_SHOW");
        public final static Property Summary = new Property(7, String.class, "summary", false, "SUMMARY");
    }


    public GreenBeanDao(DaoConfig config) {
        super(config);
    }
    
    public GreenBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"GREEN_BEAN\" (" + //
                "\"FOLLOW_MOVIE\" INTEGER NOT NULL ," + // 0: followMovie
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 1: id
                "\"IMAGE_URL\" TEXT," + // 2: imageUrl
                "\"NAME\" TEXT," + // 3: name
                "\"RANK\" INTEGER NOT NULL ," + // 4: rank
                "\"RELEASE_TIME\" INTEGER NOT NULL ," + // 5: releaseTime
                "\"RELEASE_TIME_SHOW\" TEXT," + // 6: releaseTimeShow
                "\"SUMMARY\" TEXT);"); // 7: summary
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"GREEN_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, GreenBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getFollowMovie());
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(2, id);
        }
 
        String imageUrl = entity.getImageUrl();
        if (imageUrl != null) {
            stmt.bindString(3, imageUrl);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
        stmt.bindLong(5, entity.getRank());
        stmt.bindLong(6, entity.getReleaseTime());
 
        String releaseTimeShow = entity.getReleaseTimeShow();
        if (releaseTimeShow != null) {
            stmt.bindString(7, releaseTimeShow);
        }
 
        String summary = entity.getSummary();
        if (summary != null) {
            stmt.bindString(8, summary);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, GreenBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getFollowMovie());
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(2, id);
        }
 
        String imageUrl = entity.getImageUrl();
        if (imageUrl != null) {
            stmt.bindString(3, imageUrl);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(4, name);
        }
        stmt.bindLong(5, entity.getRank());
        stmt.bindLong(6, entity.getReleaseTime());
 
        String releaseTimeShow = entity.getReleaseTimeShow();
        if (releaseTimeShow != null) {
            stmt.bindString(7, releaseTimeShow);
        }
 
        String summary = entity.getSummary();
        if (summary != null) {
            stmt.bindString(8, summary);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1);
    }    

    @Override
    public GreenBean readEntity(Cursor cursor, int offset) {
        GreenBean entity = new GreenBean( //
            cursor.getInt(offset + 0), // followMovie
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // imageUrl
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // name
            cursor.getInt(offset + 4), // rank
            cursor.getLong(offset + 5), // releaseTime
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // releaseTimeShow
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // summary
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, GreenBean entity, int offset) {
        entity.setFollowMovie(cursor.getInt(offset + 0));
        entity.setId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setImageUrl(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setName(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setRank(cursor.getInt(offset + 4));
        entity.setReleaseTime(cursor.getLong(offset + 5));
        entity.setReleaseTimeShow(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setSummary(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(GreenBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(GreenBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(GreenBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
