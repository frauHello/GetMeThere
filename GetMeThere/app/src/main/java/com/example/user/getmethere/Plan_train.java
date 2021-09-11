package com.example.user.getmethere;

/**
 * Created by user on 5/31/2017.
 */

public class Plan_train {
    private int _id ;
    private int id_account ;
    private int id_trip ;
    private int group_save ;
    private String payement ;

    public Plan_train(int _id,int id_account,int id_trip,int group_save,String payement){
        this._id=_id;
        this.id_account=id_account;
        this.id_trip=id_trip;
        this.group_save=group_save;
        this.payement=payement;
    }
}
