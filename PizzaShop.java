import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class PizzaShop implements ActionListener {
    JFrame frame;
    JLabel lbl_Qty,lbl_UnitPrice,lbl_SubTotal,lbl_Pepsi,lbl_Sprite,lbl_Topping
    ,lbl_TotalAmount,lbl_SalesTax,lbl_GradTotal;
    JRadioButton r_BtnSmallPizza,r_BtnMediumPizza,r_BtnLargePizza;
    JCheckBox ch_BoxPepperoni,ch_BoxSausage,ch_BoxCheese;
    JTextField txt_SmallPizza,txt_MediumPizza,txt_LargePizza,txt_PQty,txt_SQty,
    txt_PUnitPrice,txt_SUnitPrice,txt_PSubTotal,txt_topping,txt_SSubTotal,txt_TotalAmount,
    txt_SalesTax,txt_GrandTotal;
    JButton btn_Calculate;
    JPanel pizza_Panel,drinks_Panel,topping_Panel,bill_Panel,btn_Panel;

    PizzaShop(){
        frame=new JFrame("Pizza Shop");
        //Pizza size
        r_BtnSmallPizza=new JRadioButton("Small  ");
        r_BtnMediumPizza=new JRadioButton("Medium  ");
        r_BtnLargePizza=new JRadioButton("Large  ",true);
        ButtonGroup btn_Group=new ButtonGroup();
        btn_Group.add(r_BtnSmallPizza);
        btn_Group.add(r_BtnMediumPizza);
        btn_Group.add(r_BtnLargePizza);
        txt_SmallPizza=new JTextField("650",5);
        txt_SmallPizza.setHorizontalAlignment(txt_SmallPizza.RIGHT);
        txt_MediumPizza=new JTextField("950",5);
        txt_MediumPizza.setHorizontalAlignment(txt_MediumPizza.RIGHT);
        txt_LargePizza=new JTextField("1250",5);
        txt_LargePizza.setHorizontalAlignment(txt_LargePizza.RIGHT);
        //Drinks
        lbl_Qty=new JLabel("Qty");
        lbl_Qty.setHorizontalAlignment(lbl_Qty.CENTER);
        lbl_UnitPrice=new JLabel("Unit Price");
        lbl_UnitPrice.setHorizontalAlignment(lbl_UnitPrice.CENTER);
        lbl_SubTotal=new JLabel("Sub Total");
        lbl_SubTotal.setHorizontalAlignment(lbl_SubTotal.CENTER);
        lbl_Pepsi=new JLabel("Pepsi");
        txt_PQty=new JTextField(5);
        txt_PQty.setHorizontalAlignment(txt_PQty.RIGHT);
        txt_PUnitPrice=new JTextField("50");
        txt_PUnitPrice.setHorizontalAlignment(txt_PUnitPrice.RIGHT);
        txt_PSubTotal=new JTextField(5);
        txt_PSubTotal.setHorizontalAlignment(txt_PSubTotal.RIGHT);
        lbl_Sprite=new JLabel("Sprite");
        txt_SQty=new JTextField(5);
        txt_SQty.setHorizontalAlignment(txt_SQty.RIGHT);
        txt_SUnitPrice=new JTextField("60");
        txt_SUnitPrice.setHorizontalAlignment(txt_SUnitPrice.RIGHT);
        txt_SSubTotal=new JTextField(5);
        txt_SSubTotal.setHorizontalAlignment(txt_SSubTotal.RIGHT);
        //Toppings
        ch_BoxPepperoni=new JCheckBox("Pepperoni");
        ch_BoxSausage=new JCheckBox("Sausage");
        ch_BoxCheese=new JCheckBox("Extra Cheese");
        lbl_Topping=new JLabel("Each topping");
        txt_topping=new JTextField("15",5);
        txt_topping.setHorizontalAlignment(txt_topping.RIGHT);
        //Bill Details
        lbl_TotalAmount=new JLabel("Total Amount");
        lbl_SalesTax=new JLabel("Sales Tax@17.5%");
        lbl_GradTotal=new JLabel("Grand Total");
        txt_TotalAmount=new JTextField(10);
        txt_TotalAmount.setHorizontalAlignment(txt_TotalAmount.RIGHT);
        txt_SalesTax=new JTextField(10);
        txt_SalesTax.setHorizontalAlignment(txt_SalesTax.RIGHT);
        txt_GrandTotal=new JTextField(10);
        txt_GrandTotal.setHorizontalAlignment(txt_GrandTotal.RIGHT);
        btn_Calculate=new JButton("Calculate");

        // Panel (one) Pizza Size
        pizza_Panel=new JPanel();
        pizza_Panel.setBorder((BorderFactory.createTitledBorder("Pizza Size")));
        GridBagLayout lay_OutPizza=new GridBagLayout();
        pizza_Panel.setLayout(lay_OutPizza);
        GridBagConstraints gbc_Pizza=new GridBagConstraints();
        gbc_Pizza.fill=GridBagConstraints.BOTH;
        gbc_Pizza.insets=new Insets(5,15,5,15);
        // 1st Row
        gbc_Pizza.gridx=0;
        gbc_Pizza.gridy=0;
        pizza_Panel.add(r_BtnSmallPizza,gbc_Pizza);
        gbc_Pizza.gridx=1;
        gbc_Pizza.gridy=0;
        pizza_Panel.add(txt_SmallPizza,gbc_Pizza);
        // 2nd Row
        gbc_Pizza.gridx=0;
        gbc_Pizza.gridy=1;
        pizza_Panel.add(r_BtnMediumPizza,gbc_Pizza);
        gbc_Pizza.gridx=1;
        gbc_Pizza.gridy=1;
        pizza_Panel.add(txt_MediumPizza,gbc_Pizza);
        // 3rd Row
        gbc_Pizza.gridx=0;
        gbc_Pizza.gridy=2;
        pizza_Panel.add(r_BtnLargePizza,gbc_Pizza);
        gbc_Pizza.gridx=1;
        gbc_Pizza.gridy=2;
        pizza_Panel.add(txt_LargePizza,gbc_Pizza);

        //panel (two) Drink
        drinks_Panel=new JPanel();
        drinks_Panel.setBorder((BorderFactory.createTitledBorder("Drinks")));
        GridBagLayout lay_OutDrink=new GridBagLayout();
        drinks_Panel.setLayout(lay_OutDrink);
        GridBagConstraints gbc_Drink=new GridBagConstraints();
        gbc_Drink.fill=GridBagConstraints.BOTH;
        gbc_Drink.insets=new Insets(5,5,5,5);
        // First Row
        gbc_Drink.gridx=1;
        gbc_Drink.gridy=0;
        gbc_Drink.weightx=1;
        drinks_Panel.add(lbl_Qty,gbc_Drink);
        gbc_Drink.gridx=2;
        gbc_Drink.gridy=0;
        gbc_Drink.weightx=1;
        drinks_Panel.add(lbl_UnitPrice,gbc_Drink);
        gbc_Drink.gridx=3;
        gbc_Drink.gridy=0;
        gbc_Drink.weightx=1;
        drinks_Panel.add(lbl_SubTotal,gbc_Drink);
        //Second Row
        gbc_Drink.gridx=0;
        gbc_Drink.gridy=1;
        gbc_Drink.weightx=1;
        drinks_Panel.add(lbl_Pepsi,gbc_Drink);
        gbc_Drink.gridx=1;
        gbc_Drink.gridy=1;
        gbc_Drink.weightx=1;
        drinks_Panel.add(txt_PQty,gbc_Drink);
        gbc_Drink.gridx=2;
        gbc_Drink.gridy=1;
        gbc_Drink.weightx=1;
        drinks_Panel.add(txt_PUnitPrice,gbc_Drink);
        gbc_Drink.gridx=3;
        gbc_Drink.gridy=1;
        gbc_Drink.weightx=1;
        drinks_Panel.add(txt_PSubTotal,gbc_Drink);
        //Third Row
        gbc_Drink.gridx=0;
        gbc_Drink.gridy=2;
        gbc_Drink.weightx=1;
        drinks_Panel.add(lbl_Sprite,gbc_Drink);
        gbc_Drink.gridx=1;
        gbc_Drink.gridy=2;
        gbc_Drink.weightx=1;
        drinks_Panel.add(txt_SQty,gbc_Drink);
        gbc_Drink.gridx=2;
        gbc_Drink.gridy=2;
        gbc_Drink.weightx=1;
        drinks_Panel.add(txt_SUnitPrice,gbc_Drink);
        gbc_Drink.gridx=3;
        gbc_Drink.gridy=2;
        gbc_Drink.weightx=1;
        drinks_Panel.add(txt_SSubTotal,gbc_Drink);

        //Toppings
        topping_Panel=new JPanel();
        topping_Panel.setBorder((BorderFactory.createTitledBorder("Toppings")));
        GridBagLayout lay_OutTopping=new GridBagLayout();
        topping_Panel.setLayout(lay_OutTopping);
        GridBagConstraints gbc_Topping=new GridBagConstraints();
        gbc_Topping.fill=GridBagConstraints.BOTH;
        gbc_Topping.insets=new Insets(2,5,2,15);
        // 1st Row
        gbc_Topping.gridx=0;
        gbc_Topping.gridy=0;
        gbc_Topping.weightx=2;
        topping_Panel.add(ch_BoxPepperoni,gbc_Topping);
        // 2nd Row
        gbc_Topping.gridx=0;
        gbc_Topping.gridy=1;
        gbc_Topping.weightx=2;
        topping_Panel.add(ch_BoxSausage,gbc_Topping);
        // 3rd Row
        gbc_Topping.gridx=0;
        gbc_Topping.gridy=2;
        gbc_Topping.weightx=2;
        topping_Panel.add(ch_BoxCheese,gbc_Topping);
        // 4th Row
        gbc_Topping.gridx=0;
        gbc_Topping.gridy=3;
        gbc_Topping.weightx=1;
        topping_Panel.add(lbl_Topping,gbc_Topping);
        gbc_Topping.gridx=1;
        gbc_Topping.gridy=3;
        gbc_Topping.weightx=1;
        topping_Panel.add(txt_topping,gbc_Topping);

        //Bill Details
        bill_Panel=new JPanel();
        bill_Panel.setBorder((BorderFactory.createTitledBorder("Bill Detail")));
        GridBagLayout lay_OutBill=new GridBagLayout();
        bill_Panel.setLayout(lay_OutBill);
        GridBagConstraints gbc_Bill=new GridBagConstraints();
        gbc_Bill.fill=GridBagConstraints.BOTH;
        gbc_Bill.insets=new Insets(5,5,5,5);
        // 1st Row
        gbc_Bill.gridx=0;
        gbc_Bill.gridy=0;
        bill_Panel.add(lbl_TotalAmount,gbc_Bill);
        gbc_Bill.gridx=1;
        gbc_Bill.gridy=0;
        bill_Panel.add(txt_TotalAmount,gbc_Bill);
        // 2nd Row
        gbc_Bill.gridx=0;
        gbc_Bill.gridy=1;
        bill_Panel.add(lbl_SalesTax,gbc_Bill);
        gbc_Bill.gridx=1;
        gbc_Bill.gridy=1;
        bill_Panel.add(txt_SalesTax,gbc_Bill);
        // 3rd Row
        gbc_Bill.gridx=0;
        gbc_Bill.gridy=2;
        bill_Panel.add(lbl_GradTotal,gbc_Bill);
        gbc_Bill.gridx=1;
        gbc_Bill.gridy=2;
        bill_Panel.add(txt_GrandTotal,gbc_Bill);

        // Main Frame Layout and Addition of Component
        GridBagLayout lay_out=new GridBagLayout();
        Container container= frame.getContentPane();
        container.setLayout(lay_out);
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets=new Insets(5,5,5,5);
        gbc.gridx=0;
        gbc.gridy=0;
        container.add(pizza_Panel,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        container.add(drinks_Panel,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        container.add(topping_Panel,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        container.add(bill_Panel,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=2;
        gbc.insets=new Insets(-20,250,10,140);
        container.add(btn_Calculate,gbc);
        frame.pack();
        frame.setVisible(true);
        btn_Calculate.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        float bill=0.0f;
        float pSubTotal, sSubTotal,salesTax,grandTotal,pQty,sQty,topping=0.0f ;
        // For exception handling in case of empty textField
        if(!txt_PQty.getText().equals("")) {
            pQty = Float.parseFloat(txt_PQty.getText());
        }
        else
            pQty=0.0f;
        if(!txt_SQty.getText().equals("")) {
            sQty = Float.parseFloat(txt_SQty.getText());
        }
        else
            sQty=0.0f;
        // For selection of Pizza
        if(r_BtnSmallPizza.isSelected()){
            bill+=650.0f;
        }

        else if(r_BtnMediumPizza.isSelected()){
            bill+=950.0f;
        }

        else{
            bill+=1250.0f;
        }
        //Topping
        for (JCheckBox jCheckBox : Arrays.asList(ch_BoxPepperoni, ch_BoxSausage, ch_BoxCheese)) {
            if (jCheckBox.isSelected())
                topping+=15;
        }
        bill+=topping;
        // Pepsi
        pSubTotal=pQty*50.0f;
        bill+=pSubTotal;
        txt_PSubTotal.setText(""+pSubTotal);
        // Sprite
        sSubTotal=sQty*60.0f;
        bill+=sSubTotal;
        txt_SSubTotal.setText(""+sSubTotal);
        // total Amount
        txt_TotalAmount.setText(""+bill);
        // Sales Tax@ 17.5%
        salesTax=bill*17.5f/100.0f;
        txt_SalesTax.setText(""+salesTax);
        // Grand Total
        grandTotal=bill+salesTax;
        txt_GrandTotal.setText(""+grandTotal);

    }

    public static void main(String[] args) {
        new PizzaShop();
    }
}
