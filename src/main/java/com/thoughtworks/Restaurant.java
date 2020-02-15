package com.thoughtworks;

public class Restaurant {

  public String bestCharge(String selectedItems) {
    RenderReceipt renderReceipt = new RenderReceipt(selectedItems);
    return renderReceipt.getReceipt();
  }
}
