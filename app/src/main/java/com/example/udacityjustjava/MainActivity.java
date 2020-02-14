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
        displayPrice(createOrderSummary(calculatePrice())+ "Thank you!"); //adding Thank you here, so it isn't displayed while "Browsing"
    }

    public void increment(View view) { // have added the creatOrderSummary here so it is updated for every click

        if (numberOfCoffees<24) {System.out.println("Error - to much Coffee!!"); }
        else { setNumberOfCoffees(getNumberOfCoffees()+1);}
    display(numberOfCoffees);
    displayPrice(createOrderSummary(calculatePrice()));
    }
    public void decrement(View view) {
        if (getNumberOfCoffees()==0) {System.out.println("Error, at 0 coffees");
        } else { setNumberOfCoffees(getNumberOfCoffees()-1);
            display(numberOfCoffees);
            displayPrice(createOrderSummary(calculatePrice()));
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
             checkBox+="Add whipped cream\n";// adding the corresponding String message to be input below
            price+=(8*numberOfCoffees);
        }
        //the same process happens below, note the "\n" as it changes to the next line
        CheckBox chocolateCheckBox = findViewById(R.id.checkBox_chocolate);
        if (chocolateCheckBox.isChecked()) {
            checkBox +="Add chocolate\n";
            price+=(5*numberOfCoffees);
        }
        //connecting the input for
        EditText nameEditText = findViewById(R.id.editText_name);
        //i am using the .getText() to get the input from the EditText into the String that is displayed. calling it in the String instead of casting it into a
        //String and then using the String in the message below
        String priceMessage = "Name: " + nameEditText.getText() + "\n" +
                checkBox + // since i am using += above, and \n the different toppings is added in here and are going to the next line and their value is displayed
                "Quantity: " + numberOfCoffees +
                "\nTotal: " + price + " kr.\n";

        return priceMessage; } //could delete this and move the return up before the "String priceMessage, but this is more clean in a way




}
