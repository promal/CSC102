import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class SodaMachineFrame extends JFrame {
	private static Integer NICKEL = 5;
	private static Integer DIME = 10;
	private static Integer QUARTER = 25;
	private static Integer HALF_DOLLAR = 50;
	private static Integer DOLLAR = 100;

	public enum CoinButton {
		NICKEL("Nickel"),
		DIME("Dime"),
		QUARTER("Quarter"),
		HALF_DOLLAR("Half Dollar"),
		DOLLAR("Dollar");
		
		private String coin;
		
		private CoinButton(String coin) {
			this.coin = coin;
		}
		
		public String getCoinName() {
			return this.coin;
		}
		
		public static List<CoinButton> listCoinName() {
			return Arrays.asList(CoinButton.values());
		}
	}
	
	private static HashMap<String, Integer> mapping = 
			new HashMap<String, Integer>();
	
	static {
		mapping.put("Nickel", SodaMachineFrame.NICKEL);
		mapping.put("Dime", SodaMachineFrame.DIME);
		mapping.put("Quarter", SodaMachineFrame.QUARTER);
		mapping.put("Half Dollar", SodaMachineFrame.HALF_DOLLAR);
		mapping.put("Dollar", SodaMachineFrame.DOLLAR);
	}
	
	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 300;
	
	private final String coinReturnMessage = new String("Coin Return");
	
	private final JLabel amountDepositMessage = 
			new JLabel("Amount Deposited");
	private final JLabel changeReturnMessage =
			new JLabel("Change Returned");
	private final JLabel totalSalesMessage =
			new JLabel("Total Sales");
	
	private JTextField amountDepositedTextField =
			new JTextField(6);
	private JTextField changeReturnTextField =
			new JTextField(6);
	private JTextField totalSalesTextField =
			new JTextField(6);
	/**
	 * Buttons placed on the EAST of the boarder layout. These buttons
	 * will be placed in their own panel called moneyPanel.
	 */
	private Button nickel;
	private Button dime;
	private Button quarter;
	private Button halfDollar;
	private Button dollar;
	private JPanel moneyPanel;
	
	/**
	 * Keeps track of all the sodas to create buttons.
	 */
	private ArrayList<Button> listOfSoda = new ArrayList<Button>();
	private JPanel sodaPanel;
	
	/**
	 * Amount deposited JPanel that will have a JTextField, JLabel , JButton
	 * that will use a grid layout 3x1
	 */
	private JPanel amountDeposited;
	
	/**
	 * Change return JPanel that will have a JTextField and JLabel that will 
	 * display amount returned.
	 */
	private JPanel changeReturn;
	
	/**
	 * Total Sales JPanel that will have JTextField and JLabel wit
	 * that will display total sales.
	 */
	private JPanel totalSales;
	
	/**
	 * A JPanel that will organize JPanels amountDeposited, changeReturn, and totalSales.
	 */
	private JPanel calcMoney;
	
	/**
	 * Coin return button
	 */
	private Button coinReturn;
	
	private SodaMachine machine;
	
	private ActionListener coinListener = new ActionCoinButtonListener();
	private ActionListener sodaListener = new ActionSodaButtonListener();
	
	public SodaMachineFrame(SodaMachine machine) {
		this.machine = machine;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		
		// initialize soda components
		this.setComponentsForSodayType();
		
		this.setCalculationPanel();
		this.setMoneyPanelComponents();
	}
	
	/**
	 * Initializes the list of button components to a specific soda type.
	 * Right Panel.
	 */
	private void setComponentsForSodayType() {
		// Creates panel of soda
		this.sodaPanel = new JPanel();
		this.sodaPanel.setBorder(new EtchedBorder())
		;
		// Change the panel to a grid layout of Nx1
		this.sodaPanel.setLayout(new GridLayout(this.machine.getCount(), 1));
		
		// Creates components for buttons and adds them to the panel
		for (int index = 0; index < this.machine.getCount(); index++) {
			this.listOfSoda.add(new Button(this.machine.getSodaName(index)));
			this.listOfSoda.get(index).setEnabled(false);
			this.listOfSoda.get(index).addActionListener(this.sodaListener);
			this.sodaPanel.add(this.listOfSoda.get(index));
		}
		
		add(this.sodaPanel, BorderLayout.WEST);
		
	}
	
	/**
	 * Right Panel
	 */
	private void setMoneyPanelComponents() {
		// Create components JPanel and Buttons
		this.moneyPanel = new JPanel();
		this.moneyPanel.setBorder(new EtchedBorder());
		this.nickel = new Button("Nickel");
		this.dime = new Button("Dime");
		this.quarter = new Button("Quarter");
		this.halfDollar = new Button("Half Dollar");
		this.dollar = new Button("Dollar");
		
		// Add to listener
		this.nickel.addActionListener(coinListener);
		this.dime.addActionListener(coinListener);
		this.quarter.addActionListener(coinListener);
		this.halfDollar.addActionListener(coinListener);
		this.dollar.addActionListener(coinListener);

		// Change the panel to a grid layout of 5 rows 1 column
		this.moneyPanel.setLayout(new GridLayout(5, 1));
		
		// Add to panel
		moneyPanel.add(this.nickel);
		moneyPanel.add(this.dime);
		moneyPanel.add(this.quarter);
		moneyPanel.add(this.halfDollar);
		moneyPanel.add(this.dollar);
		
		// Add to main panel
		add(moneyPanel, BorderLayout.EAST);		
	}
	
	/**
	 * Middle Panel
	 */
	private void setCalculationPanel() {
		// Create the main panel for amount deposited, change return and total sales.
		this.calcMoney = new JPanel();
		this.calcMoney.setBorder(new EtchedBorder());
		this.calcMoney.setLayout(new GridLayout(3, 1));
		
		initAmountDepositedPanel();
		initChangeReturnPanel();
		initTotalSalesPanel();
		
		// Add panels amountDeposited, changeReturn, totalSales.
		this.calcMoney.add(this.amountDeposited, BorderLayout.NORTH);
		this.calcMoney.add(this.changeReturn, BorderLayout.CENTER);
		this.calcMoney.add(this.totalSales, BorderLayout.SOUTH);
		
		// Add to main panel and center it.
		add(this.calcMoney, BorderLayout.CENTER);
	}
	
	private void initAmountDepositedPanel() {
		this.amountDeposited = new JPanel();
		this.amountDeposited.setBorder(new EtchedBorder());
		
		this.coinReturn = new Button(this.coinReturnMessage);
		this.coinReturn.setEnabled(false);
		
		this.coinReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Disable soda buttons when coinReturn is pressed
				for (int index = 0; index < listOfSoda.size(); index++) {
					listOfSoda.get(index).setEnabled(false);
				}
				// Change return button is disabled
				coinReturn.setEnabled(false);
				
				
				// Change the state of the machine to represent the amount return
				int cents = machine.returnDeposits();
				double cash = convertFromCentsToCash(cents);
				
				// The change returned text field is set to the amount deposited
				changeReturnTextField.setText(NumberFormat.getCurrencyInstance().format(cash));
				
				// The amount deposited text field is set to $0.00
				amountDepositedTextField.setText(NumberFormat.getCurrencyInstance().format(0.00));
			}
		});
		
		// Position center
		this.amountDepositMessage.setHorizontalAlignment(SwingConstants.CENTER);
		this.amountDepositedTextField.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Show proper format $0.00
		this.amountDepositedTextField.setText(NumberFormat.getCurrencyInstance().format(0.00));
		
		// Text fields not editable
		this.amountDepositedTextField.setEditable(false);
		
		this.amountDeposited.add(this.amountDepositMessage);
		this.amountDeposited.add(this.amountDepositedTextField);
		this.amountDeposited.add(this.coinReturn);
	}
	
	private void initChangeReturnPanel() {
		this.changeReturn = new JPanel();
		this.changeReturn.setBorder(new EtchedBorder());
		
		// Position center
		this.changeReturnMessage.setHorizontalAlignment(SwingConstants.CENTER);
		this.changeReturnTextField.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Show proper format $0.00
		this.changeReturnTextField.setText(NumberFormat.getCurrencyInstance().format(0.00));
		
		// Text fields not editable
		this.changeReturnTextField.setEditable(false);
		
		this.changeReturn.add(this.changeReturnMessage);
		this.changeReturn.add(this.changeReturnTextField);
	}
	
	private void initTotalSalesPanel() {
		this.totalSales = new JPanel();
		this.totalSales.setBorder(new EtchedBorder());
		
		// Position center
		this.totalSalesMessage.setHorizontalAlignment(SwingConstants.CENTER);
		this.totalSalesTextField.setHorizontalAlignment(SwingConstants.CENTER);
		
		// Text fields not editable
		this.totalSalesTextField.setEditable(false);
		
		// Show proper format $0.00
		this.totalSalesTextField.setText(NumberFormat.getCurrencyInstance().format(0.00));
		this.totalSales.add(this.totalSalesMessage);
		this.totalSales.add(this.totalSalesTextField);
	}
	
	public class ActionCoinButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Button buttonPress = (Button) e.getSource();
			changeReturnTextField.setText(NumberFormat.getCurrencyInstance().format(0.00));
			Integer val = mapping.get(buttonPress.getLabel());
			String currentValue = amountDepositedTextField.getText().substring(1);
			Double newVal = Double.parseDouble(currentValue);
			int centsInAmountDeposited = convertFromCashToCents(newVal);
			machine.deposit(val);
			String formatValue = 
					NumberFormat.getCurrencyInstance().format(
							convertFromCentsToCash(val+centsInAmountDeposited));
			amountDepositedTextField.setText(formatValue);
			coinReturn.setEnabled(true);	
			if (machine.sufficientFunds()) { enableRemainingSodas(); }
		}
	}
	
	public class ActionSodaButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Button soda = (Button) e.getSource();
			int loc = -1;
			
			// Disable soda buttons when coinReturn is pressed
			for (int index = 0; index < listOfSoda.size(); index++) {
				listOfSoda.get(index).setEnabled(false);
				if (soda.getLabel().equals(machine.getSodaName(index))) {
					loc = index;
				}
			}
			
			coinReturn.setEnabled(false);
						
			int change = machine.dispenseSoda(loc);

			changeReturnTextField.setText(NumberFormat.getCurrencyInstance().format(convertFromCentsToCash(change)));
			amountDepositedTextField.setText(NumberFormat.getCurrencyInstance().format(0.00));
			
			double sales = convertFromCentsToCash(machine.getSales());
			totalSalesTextField.setText(NumberFormat.getCurrencyInstance().format(sales));

		}
	}
	
	private void enableRemainingSodas() {
		for (int index = 0; index < this.listOfSoda.size(); index++) {
			int count = machine.getSodaCount(index);
			if (count > 0) {
				this.listOfSoda.get(index).setEnabled(true);
			}
		}
	}
	
	/**
	 * Changes 125 to 1.25 to represent money.
	 * @param cents the amount to change to cash.
	 * @return the representation in money.
	 */
	private double convertFromCentsToCash(int cents) {
		return ((double) (cents)) / SodaMachineFrame.DOLLAR;
	}
	
	/**
	 * Change from 1.25 to 125 cents
	 * @param cash the amount to change to cents.
	 * @return the represention in cents.
	 */
	private int convertFromCashToCents(double cash) {
		return (int) Math.round((cash * SodaMachineFrame.DOLLAR));
	}
}