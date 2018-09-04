package com.example.shseo.listviewexample;

public class EpgItem {
    private String id;
    private String channelName;
    private String channelNumber;
    private String iconURL;
    private String source;
    private String serviceID;

    public EpgItem() {}
    public EpgItem (String id, String channelName, String channelNumber, String iconURL, String source, String serviceID){
        this.id = id;
        this.channelName = channelName;
        this.channelNumber = channelNumber;
        this.iconURL = iconURL;
        this.source = source;
        this.serviceID = serviceID;
    }

    public String getId(){
        return id;
    }
    public String getChannelName(){
        return channelName;
    }
    public String getChannelNumber(){
        return channelNumber;
    }
    public String getIconURL(){
        return iconURL;
    }
    public String getSource(){
        return source;
    }
    public String getServiceID(){
        return serviceID;
    }

}

