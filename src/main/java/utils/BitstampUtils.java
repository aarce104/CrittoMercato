package utils;

import com.pusher.client.Pusher;
import com.pusher.client.channel.Channel;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionStateChange;
/**
 * Created by Abraham on 6/27/17.
 */

public class BitstampUtils implements PusherClientGeneric{

    public BitstampUtils() {

    }

    public void getPusherClient(String apiKey, String channelName, String eventName) {
        Pusher pusher = new Pusher(apiKey);
        pusher.connect(new ConnectionEventListener() {
            @Override
            public void onConnectionStateChange(ConnectionStateChange connectionStateChange) {

            }

            @Override
            public void onError(String message, String code, Exception e) {
                System.out.println("There was a problem connecting!");
            }
        });
        Channel channel = pusher.subscribe(channelName);
        channel.bind(eventName, (channel1, event, data) -> {
            System.out.println("Received event with data: " + data);
        });


    }
}
