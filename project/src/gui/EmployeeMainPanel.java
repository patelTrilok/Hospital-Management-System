package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import system.Hospital_Management_System;

/*
 * This class is a panel which allows administrator to select how to interact with patient/
 * employee records.
 */
public class EmployeeMainPanel
{
	
	private Font bArial = new Font("Arial", Font.BOLD, 30);
	/**
	 * This method creates and returns a JPanel
	 * @param hms
	 * @return this panel
	 */
	public JPanel createPanel(Hospital_Management_System hms)
	{
		//initialize the panel layout and size
		JPanel adminMain = new JPanel();
		adminMain.setLayout(null);
		adminMain.setBounds(0, 0, 1920, 1080);
		//set background
		JLabel lblBackground = new JLabel();
		lblBackground.setIcon(new ImageIcon(EmployeeMainPanel.class.getResource("/graphics/staffMain_background.png")));
		lblBackground.setBounds(0, 0, 1920, 1080);
		/*
		 * HEADER MESSAGE
		 */
		JLabel lblWelcomeBackAdministrator = new JLabel("Welcome Back Doc!");
		lblWelcomeBackAdministrator.setFont(bArial);
		lblWelcomeBackAdministrator.setBounds(166, 29, 510, 26);
		/*
		 * DATE DISPLAYED BELOW HEADER
		 */
		DateFormat df = new SimpleDateFormat("EEE MMM dd, yyyy");
		Date today = new Date();
		JLabel date = new JLabel("Today is: "+df.format(today));
		date.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		date.setBounds(166, 87, 560, 26);
		/*
		 * VIEW PATIENT BUTTON
		 */
		JButton btnView = new JButton("View Patient List");
		btnView.setFont(new Font("Arial", Font.BOLD, 16));
		btnView.setBounds(725, 650, 500, 59);
		btnView.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				hms.setAccessFrom("Employee");
				hms.displayPatientListPage();
			}
		});
		btnView.setFont(new Font("Arial", Font.BOLD, 16));
		btnView.setBounds(725, 450, 500, 59);
		/*
		 * VIEW CALENDAR BUTTON
		 */
		JButton btnViewCalendar = new JButton("View Calendar");
		btnViewCalendar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				hms.displayAprilCalendarPage();
			}
		});
		btnViewCalendar.setFont(new Font("Arial", Font.BOLD, 16));
		btnViewCalendar.setBounds(725, 650, 500, 59);
		/*
		 * RETURN BUTTON
		 */
		JButton btnReturn = new JButton("Logout");
		btnReturn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				hms.displayHomePage();
			}
		});
		btnReturn.setFont(new Font("Arial", Font.BOLD, 16));
		btnReturn.setBounds(725, 850, 500, 59);
		//add all the components to panel
		adminMain.add(btnView);
		adminMain.add(btnViewCalendar);
		adminMain.add(btnReturn);
		adminMain.add(lblWelcomeBackAdministrator);
		adminMain.add(date);
		adminMain.add(lblBackground);
		
		return adminMain;
	}
}

