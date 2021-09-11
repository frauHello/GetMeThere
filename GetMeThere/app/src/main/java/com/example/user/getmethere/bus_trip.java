package com.example.user.getmethere;

/**
 * Created by user on 5/31/2017.
 */

public class bus_trip {
    private int _id;
    private int id_bus;
    private String depart_stat;
    private String arrival_stat;
    private String depart_time ;
    private String arrival_time ;
    private int children_Services ;
    private int disabled_Services ;
    private String service_name ;
    private int nb_stat_btw;
    private int spaces;
    private String ticket ;

public bus_trip(int _id,int id_bus,String depart_stat,String depart_time,String arrival_stat,String arrival_time,int children_Services,int disabled_Services,String service_name,int nb_stat_btw,int spaces,String ticket){
    this._id=_id;
    this.id_bus=id_bus;
    this.depart_stat=depart_stat;
    this.depart_time=depart_time;
    this.arrival_time=arrival_time;
    this.arrival_stat=arrival_stat ;
    this.children_Services=children_Services;
    this.disabled_Services=disabled_Services;
    this.spaces=spaces;
    this.nb_stat_btw=nb_stat_btw;
    this.ticket=ticket;
    this.service_name=service_name;


}
}
