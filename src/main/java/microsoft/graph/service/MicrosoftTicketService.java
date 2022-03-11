package microsoft.graph.service;


import com.microsoft.graph.models.User;
import com.microsoft.graph.requests.GraphServiceClient;
import microsoft.graph.producer.qualifiers.Ticket;
import okhttp3.Request;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class MicrosoftTicketService {

    @Inject @Ticket
    GraphServiceClient<Request> graphClientTicket;


    public User userInfo() {
        return graphClientTicket.
                me().
                buildRequest()
                //.select("displayName")
                .get();
    }


}
