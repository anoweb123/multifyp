package com.ali.anoweb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.print.PrinterId;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class dbhandler extends SQLiteOpenHelper {

    SQLiteDatabase db;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Ecommerce";

    //table for product
    public static final String CARTTABLE_NAME = "cart_table";
    public static final String ID_COLUMN = "ID";
    public static final String Title_COLUMN = "TITLE";
    public static final String COLOR_COLUMN = "COLOR";
    public static final String SIZE_COLUMN = "SIZE";
    public static final String Price_COLUMN = "PRICE";
    public static final String DISCOUNTED_COLUMN = "DISCOUNT";
    public static final String Desc_COLUMN = "DESCC";
    public static final String Quantity_COLUMN = "quan";
    public static final String Details_COLUMN = "DETAIL";
    public static final String Leftitems_COLUMN= "LEFTS";
    public static final String Image_COLUMN = "IMAGE";


    public static final String WISHLISTTABLE_NAME = "WISHLIST_table";
    public static final String WID_COLUMN = "ID";
    public static final String WTitle_COLUMN = "TITLE";
    public static final String WCOLOR_COLUMN = "COLOR";
    public static final String WSIZE_COLUMN = "SIZE";
    public static final String WPrice_COLUMN = "PRICE";
    public static final String WDISCOUNTED_COLUMN = "DISCOUNT";
    public static final String WDesc_COLUMN = "DESCC";
    public static final String WImage_COLUMN = "IMAGE";

    public dbhandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db=this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String tableCART = "CREATE TABLE " + CARTTABLE_NAME + " (" +
                ID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                Title_COLUMN + " TEXT, " +
                Leftitems_COLUMN + " INTEGER, " +
                COLOR_COLUMN + " TEXT, " +
                Desc_COLUMN + " TEXT, " +
                DISCOUNTED_COLUMN + " TEXT, " +
                SIZE_COLUMN + " TEXT, " +
                Price_COLUMN + " TEXT, " +
                Image_COLUMN + " INTEGER, " +
                Quantity_COLUMN + " TEXT)";
        db.execSQL(tableCART);

        String wishlistCART = "CREATE TABLE " + WISHLISTTABLE_NAME + " (" +
                WID_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                WTitle_COLUMN + " TEXT, " +
                WCOLOR_COLUMN + " TEXT, " +
                WDesc_COLUMN + " TEXT, " +
                WDISCOUNTED_COLUMN + " TEXT, " +
                WSIZE_COLUMN + " TEXT, " +
                WPrice_COLUMN + " TEXT, " +
                WImage_COLUMN + " INTEGER)";
        db.execSQL(wishlistCART);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public long addtocart(String title,int image,String desc,String price,String discounted,String color,String size,String qty,int left){
        ContentValues contentValues=new ContentValues();
        contentValues.put(Title_COLUMN,title);
        contentValues.put(Image_COLUMN,image);
        contentValues.put(Desc_COLUMN,desc);
        contentValues.put(Price_COLUMN,price);
        contentValues.put(DISCOUNTED_COLUMN,discounted);
        contentValues.put(COLOR_COLUMN,color);
        contentValues.put(SIZE_COLUMN,size);
        contentValues.put(Quantity_COLUMN,qty);
        contentValues.put(Leftitems_COLUMN,left);
        return db.insert(CARTTABLE_NAME,null,contentValues);
    }

    public List<modelcart> retrievecart(){
        List<modelcart> s=new ArrayList<>();
        String colomn[]=new String[]{ID_COLUMN,Title_COLUMN,Price_COLUMN,Desc_COLUMN,DISCOUNTED_COLUMN,COLOR_COLUMN,SIZE_COLUMN,Image_COLUMN,Quantity_COLUMN,Leftitems_COLUMN};
        Cursor query= db.query(CARTTABLE_NAME,colomn,null,null,null,null,null,null);
        while (query.moveToNext()){
            String a,b,c,d,e,f,g;
            int i,h,j;
            a=query.getString(query.getColumnIndex(Title_COLUMN));
            b=query.getString(query.getColumnIndex(Desc_COLUMN));
            c=query.getString(query.getColumnIndex(Price_COLUMN));
            d=query.getString(query.getColumnIndex(DISCOUNTED_COLUMN));
            e=query.getString(query.getColumnIndex(Quantity_COLUMN));
            f=query.getString(query.getColumnIndex(COLOR_COLUMN));
            g=query.getString(query.getColumnIndex(SIZE_COLUMN));
            h=query.getInt(query.getColumnIndex(ID_COLUMN));
            i=query.getInt(query.getColumnIndex(Image_COLUMN));
            j=query.getInt(query.getColumnIndex(Leftitems_COLUMN));

            s.add(new modelcart(a,c,e,d,g,f,b,i,h,j));
        }
        return s;
    }

    public long deleteincart(int id){
        return db.delete(CARTTABLE_NAME,ID_COLUMN+ "=?",new String[]{String.valueOf(id)});
    }

    public int updateqty(String id, String qty){
        ContentValues cv=new ContentValues();
        cv.put(Quantity_COLUMN,qty);
        return db.update(CARTTABLE_NAME,cv,ID_COLUMN+ "=?",new String[]{id});
    }
    public int getqty(String id){
        int a=0;
        String colomn[]=new String[]{ID_COLUMN,Title_COLUMN,Price_COLUMN,Desc_COLUMN,DISCOUNTED_COLUMN,COLOR_COLUMN,SIZE_COLUMN,Image_COLUMN,Quantity_COLUMN};
        Cursor query= db.query(CARTTABLE_NAME,colomn,ID_COLUMN+ "=?",new String[]{id},null,null,null,null);
        while (query.moveToNext()){
            a=Integer.parseInt(query.getString(query.getColumnIndex(Quantity_COLUMN)));
        }
        return a;
    }

    public int totalprice(){
        int total=0;
        String colomn[]=new String[]{ID_COLUMN,Title_COLUMN,Price_COLUMN,Desc_COLUMN,DISCOUNTED_COLUMN,COLOR_COLUMN,SIZE_COLUMN,Image_COLUMN,Quantity_COLUMN};
        Cursor query= db.query(CARTTABLE_NAME,colomn,null,null,null,null,null,null);
        while (query.moveToNext()){
            total=Integer.parseInt(query.getString(query.getColumnIndex(Quantity_COLUMN)))*Integer.parseInt(query.getString(query.getColumnIndex(Price_COLUMN)))+total;
        }
        return total;
    }

    public long addtowishlist(String title,int image,String desc,String price,String discounted,String color,String size){
        ContentValues contentValues=new ContentValues();
        contentValues.put(WTitle_COLUMN,title);
        contentValues.put(WImage_COLUMN,image);
        contentValues.put(WDesc_COLUMN,desc);
        contentValues.put(WPrice_COLUMN,price);
        contentValues.put(WDISCOUNTED_COLUMN,discounted);
        contentValues.put(WCOLOR_COLUMN,color);
        contentValues.put(WSIZE_COLUMN,size);
        return db.insert(WISHLISTTABLE_NAME,null,contentValues);
    }

    public List<modelwishlist> retrievewishlist(){
        List<modelwishlist> s=new ArrayList<>();
        String colomn[]=new String[]{WID_COLUMN,WTitle_COLUMN,WPrice_COLUMN,WDesc_COLUMN,WDISCOUNTED_COLUMN,WCOLOR_COLUMN,WSIZE_COLUMN,WImage_COLUMN};
        Cursor query= db.query(WISHLISTTABLE_NAME,colomn,null,null,null,null,null,null);
        while (query.moveToNext()){
            String a,b,c,d,f,g;
            int i,h;
            a=query.getString(query.getColumnIndex(WTitle_COLUMN));
            b=query.getString(query.getColumnIndex(WDesc_COLUMN));
            c=query.getString(query.getColumnIndex(WPrice_COLUMN));
            d=query.getString(query.getColumnIndex(WDISCOUNTED_COLUMN));
            f=query.getString(query.getColumnIndex(WCOLOR_COLUMN));
            g=query.getString(query.getColumnIndex(WSIZE_COLUMN));
            h=query.getInt(query.getColumnIndex(WID_COLUMN));
            i=query.getInt(query.getColumnIndex(WImage_COLUMN));
            s.add(new modelwishlist(a,b,c,d,f,g,i,h));
        }
        return s;
    }


}
