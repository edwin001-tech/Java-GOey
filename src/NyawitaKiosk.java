
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;

	public class NyawitaKiosk extends JFrame{
		private JLabel Greetings;
		private final double WHITE_TEA=2.25;
		private final double BLACK_TEA=1.50;
		public final double CHAPO_BEANS = 0.50;
		public final double CHAPO_DENGU= 0.25;
		public final double UGALI_OMENA= 0.75;
		public final double RICE_BEANS = 0.75;
		public final double KREST = 0.0;
		public final double SPRITE = 1.25;
		public final double COKE = 1.25;
		public final double FANTA = 2.00;
		private JRadioButton WhiteTea;
		private JRadioButton BlackTea;
		private JCheckBox ChapoBeans;
		private JCheckBox ChapoDengu;
		private JCheckBox Ugaliomena;
		private JCheckBox RiceBeans;
		private ButtonGroup bg;
		private JRadioButton Coke;
		private JRadioButton Sprite;
		private JRadioButton Fanta;
		private JRadioButton Krest;
		private JPanel greetingspanel;
		private JPanel Teapanel;
		private JPanel Foodpanel;
		private JPanel Drinkspanel;
		private JPanel buttonpanel;
		private JButton calcbutton;
		private JButton exitbutton;
		private final double TAX_RATE = 0.06;
		
		
		//constructor//
		public NyawitaKiosk()
		{
			
		setTitle("NYAWITA ORDER CALCULATOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		buildgreetingspanel();
		add(greetingspanel);
		buildTeapanel();
		add(Teapanel);
		buildFoodpanel();
		add(Foodpanel);
		buildDrinkspanel();
		add(Drinkspanel);
		buildbuttonpanel();
		add(buttonpanel);
		add(greetingspanel, BorderLayout.NORTH);
		add(Teapanel, BorderLayout.WEST);
		add(Foodpanel, BorderLayout.CENTER);
		add(Drinkspanel, BorderLayout.EAST);
		add(buttonpanel, BorderLayout.SOUTH);
		pack();
		setVisible(true);
		setSize(350,200);
		}
		
		
			//create the custom panels//
			//greetings panel//
		public void buildgreetingspanel() {
			
			Greetings=new JLabel("WELCOME TO NYAWITA FOOD KIOSK");
			Greetings.setForeground(Color.RED);
			greetingspanel=new JPanel();
			greetingspanel.add(Greetings);
		}
		public void buildTeapanel() {
			Teapanel=new JPanel();
			Teapanel.setLayout(new GridLayout (2,1));
			WhiteTea=new JRadioButton("White Tea",true);
			BlackTea=new JRadioButton("Black Tea");
			//group the radio buttons//
			bg=new ButtonGroup();
			bg.add(WhiteTea);
			bg.add(BlackTea);
			Teapanel.setBorder(BorderFactory.createTitledBorder("Tea"));
			Teapanel.setBackground(new java.awt.Color(51,153,255));
			Teapanel.add(WhiteTea);
			Teapanel.add(BlackTea);
			
		}
		public void buildFoodpanel() {
			Foodpanel=new JPanel();
			Foodpanel.setLayout(new GridLayout(4,1));
			ChapoBeans=new JCheckBox("Chapo Beans",true);
			ChapoDengu=new JCheckBox("Chapo Dengu");
			Ugaliomena=new JCheckBox("Ugali Omena");
			RiceBeans=new JCheckBox("Rice Beans");
			Foodpanel.setBackground(new java.awt.Color(51,153,255));
			Foodpanel.setBorder(BorderFactory.createTitledBorder("Food"));
			Foodpanel.add(ChapoBeans);
			Foodpanel.add(ChapoDengu);
			Foodpanel.add(Ugaliomena);
			Foodpanel.add(RiceBeans);
		}
		public void buildDrinkspanel() {
			
			Drinkspanel=new JPanel();
			Drinkspanel.setLayout(new GridLayout (4,1));
			Krest=new JRadioButton("Krest",true);
			Sprite=new JRadioButton("Sprite");
			Coke=new JRadioButton("Coke");
			Fanta=new JRadioButton("Fanta");
			//group the radio buttons//
			bg=new ButtonGroup();
			bg.add(Krest);
			bg.add(Sprite);
			bg.add(Coke);
			bg.add(Fanta);
			Drinkspanel.setBackground(new java.awt.Color(51,153,255));
			Drinkspanel.setBorder(BorderFactory.createTitledBorder("Drinks"));
			Drinkspanel.add(Krest);
			Drinkspanel.add(Sprite);
			Drinkspanel.add(Fanta);
			Drinkspanel.add(Coke);
		}
		public void buildbuttonpanel() {
			buttonpanel=new JPanel();
			calcbutton=new JButton("CALCULATE");
			calcbutton.setSize(50,20);
			exitbutton=new JButton("EXIT");
			buttonpanel.add(calcbutton);
			buttonpanel.add(exitbutton);
			calcbutton.addActionListener(new calcbuttonListener());
			exitbutton.addActionListener(new exitbuttonListener());
			buttonpanel.add(calcbutton);
			buttonpanel.add(exitbutton);
		}
			

			
			
			
			//get tea cost method//
			public double getTeaCost() {
				double TeaCost=0.0;
				if(WhiteTea.isSelected())
				TeaCost=WHITE_TEA;
				else 
				TeaCost=BLACK_TEA;
				return TeaCost;
			
		}
			public double getFoodCost() {
				double FoodCost=0.0;
				if (ChapoBeans.isSelected())
					FoodCost += CHAPO_BEANS;
					if (ChapoDengu.isSelected())
					FoodCost += CHAPO_DENGU;
					if (Ugaliomena.isSelected())
					FoodCost += UGALI_OMENA;
					if (RiceBeans.isSelected()) {
						FoodCost += RICE_BEANS;
					}
					return FoodCost;
					}
			public double getDrinksCost() {
				double DrinksCost=0.0;
				if (Krest.isSelected())
					DrinksCost+= KREST;
				if (Sprite.isSelected())
					DrinksCost+=SPRITE;
				if (Coke.isSelected())
					DrinksCost=+COKE;
				if (Fanta.isSelected())
					DrinksCost+=FANTA;
				return DrinksCost;
				
			
			
			
		}
			
			private class calcbuttonListener implements ActionListener
			{
			public void actionPerformed(ActionEvent e)
			{
			// Variables to hold the subtotal, tax, and total
			double subtotal, tax, total;
			// Calculate the subtotal.
			subtotal =getTeaCost() +
			getFoodCost() +
			getDrinksCost();
			// Calculate the sales tax.
			tax = subtotal * TAX_RATE;
			// Calculate the total.
			total = subtotal + tax;
			// Display the charges.
			JOptionPane.showMessageDialog(null,
			String.format("Subtotal: $%,.2f\n" +
			"Tax: $%,.2f\n" +
			"Total: $%,.2f",
			subtotal, tax, total));
			}
			}
			private class exitbuttonListener implements ActionListener
			{
			public void actionPerformed(ActionEvent e)
			{
			System.exit(0);
			}
			}
			
			public static void main(String[] args)
			{
			new NyawitaKiosk();
			}
		
		
	}




