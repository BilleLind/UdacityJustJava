package com.example.udacityjustjava;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

import java.text.NumberFormat;




public class MainActivity extends AppCompatActivity {
   static int numberOfCoffees;
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
        displayPrice(numberOfCoffees);
    }

    public void increment(View view) {
    setNumberOfCoffees(getNumberOfCoffees()+1);
    display(numberOfCoffees);
    displayPrice(numberOfCoffees);
    }
    public void decrement(View view) {
        if (getNumberOfCoffees()==0) {System.out.println("Error, at 0 coffees");
        } else { setNumberOfCoffees(getNumberOfCoffees()-1);
            display(numberOfCoffees);
        displayPrice(numberOfCoffees);}
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
    private void displayPrice(int numberOfCoffees) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("Total: " +NumberFormat.getCurrencyInstance().format(numberOfCoffees*20)+ "\n" +
                "Thank You!");
    }




}
