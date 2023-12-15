class CartItem {

    private Dish dish;
    protected int quantity;
    private final int CUSTOMIZATION_PRICE = 5;
    private boolean[] customizations;  // New: Array of booleans to represent customizations

    public CartItem(Dish dish, int quantity) {
        this.dish = dish;
        this.quantity = quantity;
        this.customizations = new boolean[3];
    }
    public Dish getDish() {
        return this.dish;
    }

   /* public void setDish(Dish dish) {
        this.dish = dish;
    }*/

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public boolean[] getCustomizations() {
        return customizations;
    }
    public void customize(int customizationIndex) {
        // Set the selected customization to true
        if (customizationIndex >= 0 && customizationIndex < customizations.length) {
            for (int i = 0; i < quantity; i++) {
                customizations[customizationIndex] = true;
            }
        }
    }
    /* public int getCustomizationPrice() {
         int numberOfCustomizations = 0;
         for (boolean customization : customizations) {
             if (customization) {
                 numberOfCustomizations++;
             }
         }
         return numberOfCustomizations * CUSTOMIZATION_PRICE;
     }


 }*/
    public double getTotalPriceWithCustomizations() {
        double itemTotalPrice = this.getDish().getPrice() * this.quantity;

        // Add customization prices if any
        boolean[] customizations = this.getCustomizations();
        for (boolean customization : customizations) {
            if (customization) {
                itemTotalPrice += CUSTOMIZATION_PRICE;
            }
        }

        return itemTotalPrice;
    }
}