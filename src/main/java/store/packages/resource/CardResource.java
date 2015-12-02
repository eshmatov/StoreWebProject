package store.packages.resource;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import store.packages.model.CardItem;
import store.packages.service.CardService;

@Path("card")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CardResource {

    CardService cardService;

    public CardResource(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("cardService") == null) {
            cardService = new CardService();
            session.setAttribute("cardService", cardService);
        } else {
            cardService = (CardService) session.getAttribute("cardService");
        }
    }

    @GET
    public List<CardItem> getCardItems() {
        return cardService.getCardItems();
    }

    @PUT
    public void updateCardItems(List<CardItem> cardItems) {
        cardService.updateCard(cardItems);
    }

    @POST
    public void addCardItem(CardItem cardItem) {
        cardService.addCardItem(cardItem);
    }

    @GET
    @Path("/buy")
    public String buy() {
        cardService.clear();
        return "{\"confirmationNo\":" + (10000000 + (int) (Math.random() * 90000000)) + "}";
    }

}
