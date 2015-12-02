/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.packages.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import store.packages.model.CardItem;

/**
 *
 * @author Rustam
 */
public class CardService {

    private Map<Integer, CardItem> itemsMap;

    public CardService() {
        itemsMap = new HashMap<>();
    }

    public List<CardItem> getCardItems() {
        return new LinkedList<>(itemsMap.values());
    }

    public void updateCard(List<CardItem> cardItems) {
        clear();
        for (CardItem item : cardItems) {
            addCardItem(item);
        }
    }

    public void addCardItem(CardItem cardItem) {
        Integer id = cardItem.getProduct().getId();

        CardItem oldItem = itemsMap.get(id);
        if (oldItem != null) {
            cardItem.setQuantity(cardItem.getQuantity() + oldItem.getQuantity());

        }
        if (cardItem.getQuantity() <= 0) {
            itemsMap.remove(id);
        } else {
            itemsMap.put(id, cardItem);
        }
    }

    public void clear() {
        itemsMap.clear();
    }

}
