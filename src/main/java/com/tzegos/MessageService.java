package com.tzegos;


public class MessageService {
    Network network = null;
    
    public MessageService(Network network) {
        this.network = network;
    }
    
    
    // Sends message to remote host. If message delivery fails it retries. 
    // If again it fails it returns false.
    // @param ip, the remote ip
    // @param message, the message
    // @returns true if message was sent, false otherwise
    
    boolean sendMessage(String ip, String message){
        boolean ret = false;
        
        if(checkConnectivity()) {
            ret = network.sendMessage(ip, message);
        }
        return ret;
    }
    
    boolean checkConnectivity() {
        boolean ret = network.isAvailable();

        if(!ret){
            ret = network.isAvailable();
        }
        
        return network.isAvailable();
    }
    
}
