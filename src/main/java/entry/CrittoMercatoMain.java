package entry;

import utils.BitstampUtils;
import java.util.Scanner;

/**
 * Created by Abraham on 6/10/17.
 */
public class CrittoMercatoMain {
    public static void main(String[] args) throws Exception {
        String apiKey, channelName, eventName;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Bitstamp apiKey ");
        apiKey = in.next();
        System.out.println("Enter Bitstamp channelName ");
        channelName = in.next();
        System.out.println("Enter Bitstamp eventName");
        eventName = in.next();

       new BitstampUtils().getPusherClient(apiKey, channelName, eventName);

        //while (true) {
            //int i = 1;
        //}

        //Thread.sleep(100000);
        /*WampClient client;
        try{
            WampClientBuilder builder = new WampClientBuilder();
            IWampConnectorProvider connectorProvider = new NettyWampClientConnectorProvider();
            builder.withConnectorProvider(connectorProvider)
                    .withUri("wss://api.poloniex.com")
                    .withRealm("realm1")
                    .withInfiniteReconnects()
                    .withReconnectInterval(5, TimeUnit.SECONDS);
            client = builder.build();
        } catch (Exception e){
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
                    client.makeSubscription("ticker")
                            .subscribe((s) -> {
                                System.out.println(s.arguments()); });
                } System.out.println(t1);
            }
        });
        client.open();
*/

    }
}
