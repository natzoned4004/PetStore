/*
 * Noah Alonso-Torres
 * PetStore Sort
 * SortTest Class
 */



// Tester for the Pet and PetStore classes
// Lowrie/Ames Fall 2010

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SortTest implements ActionListener{ 
	private JButton sortByNameAscendingButton = new JButton("Sort by Name Ascending");
	private JButton sortByNameDescendingButton = new JButton("Sort by Name Descending");
	private JButton sortByCountAscendingButton = new JButton("Sort by Count Ascending");
	private JButton sortByCountDescendingButton = new JButton("Sort by Count Descending");
    private JButton writeOutputButton = new JButton("Write Output");
    // Wanted more room
	private JTextArea reportArea = new JTextArea(30,25);
	
	private PetStore myStore = null;
	
	public SortTest(){
		
	    myStore = new PetStore();
		
		JFrame frame = new JFrame("My Pet Store");
		frame.getContentPane().setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,2));
		buttonPanel.add(sortByNameAscendingButton);
		buttonPanel.add(sortByNameDescendingButton);
		buttonPanel.add(sortByCountAscendingButton);
		buttonPanel.add(sortByCountDescendingButton);
		frame.add(writeOutputButton, BorderLayout.NORTH);
		frame.add(buttonPanel,       BorderLayout.SOUTH);
		frame.add(reportArea,        BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		sortByNameAscendingButton  .addActionListener(this);
		sortByNameDescendingButton .addActionListener(this);
		sortByCountAscendingButton .addActionListener(this);
        sortByCountDescendingButton.addActionListener(this);
        writeOutputButton          .addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == sortByNameAscendingButton){ 
			myStore.sortAscendingByName();
			
		} else if(event.getSource() == sortByNameDescendingButton){
			myStore.sortDescendingByName();
			
		} else if(event.getSource() == sortByCountAscendingButton){
			myStore.sortAscendingByCount();

		} else if(event.getSource() == sortByCountDescendingButton){
			myStore.sortDescendingByCount();
			
		} else if(event.getSource() == writeOutputButton){
			myStore.writeData("petInventorySorted.txt");
		} else {
			reportArea.setText("Bad Button");
		}
		reportArea.setText(myStore.toString());
	}
	
	
	public static void main(String[] args) {
		SortTest tester = new SortTest();	
		tester.myStore.readData("petInventory.txt"); // File to be sorted goes here
		tester.reportArea.setText(tester.myStore.toString());
	}
}