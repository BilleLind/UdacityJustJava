package com.example.udacityjustjava;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;






public class MainActivity extends AppCompatActivity {
   private int numberOfCoffees;
    public int getNumberOfCoffees() {
        return numberOfCoffees;
    }
    public void setNumberOfCoffees(int numberOfCoffees) {
        this.numberOfCoffees = numberOfCoffees;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(numberOfCoffees);
        int price = calculatePrice();
        displayPrice(createOrderSummary(price));
    }

    private String priceMessageMethod() {
        int price = calculatePrice();
        return "Total: " + price + " kr.";
    }
    public void increment(View view) {
    setNumberOfCoffees(getNumberOfCoffees()+1);
    display(numberOfCoffees);
displayPrice(priceMessageMethod());
    }
    public void decrement(View view) {
        if (getNumberOfCoffees()==0) {System.out.println("Error, at 0 coffees");
        } else { setNumberOfCoffees(getNumberOfCoffees()-1);
            display(numberOfCoffees);
            displayPrice(priceMessageMethod());
        }
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display( int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_number);
        quantityTextView.setText("" + numberOfCoffees);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    private int calculatePrice() {
        return (numberOfCoffees * 20); }


    private String createCustomerGreeting(String firstName, String lastName) {
        return "Welcome, " + firstName +" " + lastName + "!";
    } // don't know if i needed this for this tutorial or just some practice :/

    private String createOrderSummary(int price) {
        String checkBox=""; // initializes the checkbox so there aren't errors
        CheckBox whippedCreamCheckBox =  findViewById(R.id.checkBox_whipped_cream); //connects the checkbox to whippedCreamCheckBox
        if (whippedCreamCheckBox.isChecked()) { //using the built in methods to check if it is check or not
             checkBox+="Add whipped cream\n"; // adding the corresponding String message to be input below
        }
        //the same process happens below, note the "\n" as it changes to the next line
        CheckBox chocolateCheckBox = findViewById(R.id.checkBox_chocolate);
        if (chocolateCheckBox.isChecked()) {
            checkBox +="Add chocolate\n";
        }
        //connecting the input for
        EditText nameEditText = findViewById(R.id.editText_name);
        //i am using the .getText() to get the input from the EditText into the String that is displayed
        String priceMessage = "Name: " + nameEditText.getText() + "\n" +
                checkBox +
                "Quantity: " + numberOfCoffees +
                "\nTotal: " + price + " kr.\n" +
                "Thank you!";

        return priceMessage; }




}
