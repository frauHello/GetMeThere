package com.example.user.getmethere;

/**
 * Created by user on 5/31/2017.
 */

public class Plan_bus {
   private int id_account;
  private   int _id;
  private   int id_trip;
   private int disabled_book;
  private   int children_book;
 private    String payement ;
    public Plan_bus(int _id,int id_account,int id_trip,int children_book,String payement,int disabled_book){
        this._id=_id;
        this.id_account=id_account;
        this.id_trip=id_trip;
        this.disabled_book=disabled_book;
        this.children_book=children_book;
        this.payement=payement;
    }
}
