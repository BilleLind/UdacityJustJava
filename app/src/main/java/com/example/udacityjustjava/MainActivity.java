package com.example.udacityjustjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
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


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only mail apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses); should be the one if there
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order for " +name());

        if (intent.resolveActivity(getPackageManager())!=null) {
            startActivity(intent);
        } else{ Log.i("Internet", "Internet - intent was null");}
    }

    public void increment(View view) { // have added the creatOrderSummary here so it is updated for every click

        if (numberOfCoffees==24) {System.out.println("Error - to much Coffee!!"); }
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
            price+=(8*numberOfCoffees); }
        //the same process happens below, note the "\n" as it changes to the next line
        CheckBox chocolateCheckBox = findViewById(R.id.checkBox_chocolate);
        if (chocolateCheckBox.isChecked()) {
            checkBox +="Add chocolate\n";
            price+=(5*numberOfCoffees); }
        //connecting the input for


        String priceMessage = "Name: " + name() + "\n" +
                checkBox + // since i am using += above, and \n the different toppings is added in here and are going to the next line and their value is displayed
                "Quantity: " + numberOfCoffees +
                "\nTotal: " + price + " kr.\n";

        return priceMessage; } //could delete this and move the return up before the "String priceMessage, but this is more clean in a way

        private String name() { // since i needed the name else where (in the email subject) i made it like this, more of a niche thing
            EditText nameEditText = findViewById(R.id.editText_name);
            String name = nameEditText.getText().toString();
            return name;
        }


}
