package utils;

import ws.wamp.jawampa.*;
import ws.wamp.jawampa.connection.IWampConnectorProvider;
import ws.wamp.jawampa.transport.netty.*;
import rx.functions.Action1;
import java.util.concurrent.TimeUnit;

/**
 * Created by Abraham on 6/27/17.
 */

public class PoloniexUtils implements WAMPClientGeneric{
    public PoloniexUtils(){

    }

    public void getWAMPClient(String URI, String Realm, String feed){
        WampClient client;
        try{
            WampClientBuilder builder = new WampClientBuilder();
            IWampConnectorProvider connectorProvider = new NettyWampClientConnectorProvider();
            builder.withConnectorProvider(connectorProvider)
                    .withUri(URI)
                    .withRealm(Realm)
                    .withInfiniteReconnects()
                    .withReconnectInterval(5, TimeUnit.SECONDS);
            client = builder.build();

        }catch (Exception e){
            return;
        }
        client.statusChanged().subscribe(new Action1<WampClient.State>() {
            @Override
            public void call(WampClient.State t1) {
                System.out.println("Session status changed to " + t1);
            }
        });

        client.statusChanged().subscribe(new Action1<WampClient.State>() {
            @Override
            public void call(WampClient.State t1) {
                if (t1 instanceof WampClient.ConnectedState) {
                    client.makeSubscription(feed)
                            .subscribe((s) -> {
                                System.out.println(s.arguments()); });
                } System.out.println(t1);
            }
        });

        client.open();

    }

}
