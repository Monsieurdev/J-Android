/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import java.text.NumberFormat;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        boolean haschocolate = chocolateCheckBox.isChecked();
        int price = calculatePrice();
        String priceMessage = createOderSummary(price, hasWhippedCream, haschocolate);
        displayMessage(priceMessage);
    }

    private String createOderSummary(int price, boolean addwhippedCream, boolean addchocolate){
        String priceMessage = "Name: Mohamed";
        priceMessage += "\nAdd whipped cream?" + addwhippedCream;
        priceMessage += "\nAdd Chocolate?" + addchocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);

    }



    public void decrement(View view) {
        if(quantity < 1) {
            quantity = 1;
        }
        quantity = quantity -1;
        displayQuantity(quantity);

    }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}