package com.example.user.getmethere;

public class train_trip {
    private int _id;
    private int id_train;
    private String depart_stat;
    private String arrival_stat;
    private String depart_time ;
    private String arrival_time ;
    private int group_save ;


    private int nb_stat_btw;
    private int spaces;
    private String ticket ;

    public train_trip(int _id,int id_train,String depart_stat,int group_save,String depart_time,String arrival_stat,String arrival_time,int nb_stat_btw,int spaces,String ticket){
        this._id=_id;
        this.id_train=id_train;
        this.depart_stat=depart_stat;
        this.depart_time=depart_time;
        this.arrival_time=arrival_time;
        this.arrival_stat=arrival_stat ;
        this.group_save=group_save;

        this.spaces=spaces;
        this.nb_stat_btw=nb_stat_btw;
        this.ticket=ticket;



    }
}