package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import database.TextWriter;
import system.Hospital_Management_System;
import system.ValidateInput;
import user.Employee;

/*
 * This class displays the add staff panel.
 */
public class AddStaffPanel 
{
	private JComboBox<String> jcDepartment;
	private Font bArial = new Font("Arial", Font.BOLD, 30);
	private Color bgColor = new Color(215,215,215);
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfDay;
	private JTextField tfMonth;
	private JTextField tfYear;
	private JTextField tfPhoneNum;
	private JTextField tfEmail;
	private JRadioButton rdbtnClear;
	private Color Red = new Color(255, 150, 135);
	private Color Default = new Color(255,255,255);
	private ValidateInput val = new ValidateInput();
	private Hospital_Management_System hms;
	/**
	 * This method creates and returns a JPanel
	 * @param hms
	 * @return this panel
	 */
	public JPanel createPanel(Hospital_Management_System hms)
	{
		this.hms = hms;
		//initialize the panel layout and size
		JPanel addStaff = new JPanel();
		addStaff.setLayout(null);
		addStaff.setBounds(0, 0, 1920, 1080);
		//set background
		JLabel lblBackground = new JLabel();
		lblBackground.setIcon(new ImageIcon(AddPatientPanel.class.getResource("/graphics/AddStaffbackground.png")));
		lblBackground.setBounds(0, 0, 1920, 1080);
		/*
		 * HEADER MESSAGE
		 */
		JLabel lblWelcomeBackAdministrator = new JLabel("Welcome Back Administrator!");
		lblWelcomeBackAdministrator.setFont(bArial);
		lblWelcomeBackAdministrator.setBounds(166, 29, 510, 26);
		/*
		 * DATE DISPLAYED BELOW HEADER
		 */
		DateFormat df = new SimpleDateFormat("EEE MMM dd, yyyy");
		Date today = new Date();
		JLabel date = new JLabel("Today is: "+ df.format(today));
		date.setFont(new Font("Calibri Light", Font.PLAIN, 26));
		date.setBounds(166, 87, 560, 26);
		/*
		 * FIRST NAME
		 */
		JLabel lbFirstName = new JLabel("First Name: ");
		lbFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbFirstName.setBounds(660, 388, 100, 50);
		tfFirstName = new JTextField();
		tfFirstName.setBounds(1066, 405, 300, 20);
		tfFirstName.setColumns(10);
		/*
		 * LAST NAME
		 */
		JLabel lbLastName = new JLabel("Last Name: ");
		lbLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbLastName.setBounds(660, 440, 100, 50);
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(1066, 457, 300, 20);
		/*
		 * SEX
		 */
		JLabel lbSex = new JLabel("Sex: ");
		lbSex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbSex.setBounds(660, 501, 100, 42);
		//male button
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(bgColor);
		rdbtnMale.setBounds(1104, 507, 100, 23);
		rdbtnMale.setOpaque(false);
		//female button
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(bgColor);
		rdbtnFemale.setBounds(1230, 507, 100, 23);
		rdbtnFemale.setOpaque(false);
		//"clear radio button"
		rdbtnClear = new JRadioButton("");
		//ensures at most one button can be selected
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		group.add(rdbtnClear);
		/*
		 * DOB
		 */
		JLabel slash = new JLabel("/");
		slash.setBounds(1146, 572, 24, 14);
		JLabel label = new JLabel("/");
		label.setBounds(1266, 572, 24, 14);
		JLabel lbDOB = new JLabel("Date of birth (dd/mm/yyyy): ");
		lbDOB.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbDOB.setBounds(660, 552, 300, 50);
		//day
		tfDay = new JTextField();
		tfDay.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusGained(FocusEvent e) 
			{
				tfDay.setText("");
			}
		});
		tfDay.setText("Day");
		tfDay.setBounds(1066, 569, 70, 20);
		tfDay.setColumns(10);
		//month
		tfMonth = new JTextField();
		tfMonth.setText("Month");
		tfMonth.setColumns(10);
		tfMonth.setBounds(1186, 569, 70, 20);
		// FocusListner that clears the text in the text field.
		tfMonth.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusGained(FocusEvent e) 
			{
				tfMonth.setText("");
			}
		});
		//year
		tfYear = new JTextField();
		tfYear.setText("Year");
		tfYear.setColumns(10);
		tfYear.setBounds(1296, 569, 70, 20);
		// FocusListner that clears the text in the text field.
		tfYear.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusGained(FocusEvent e) 
			{
				tfYear.setText("");
			}
		});
		/*
		 * PHONE NUMBER
		 */
		JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhoneNumber.setBounds(660, 609, 250, 50);
		tfPhoneNum = new JTextField();
		tfPhoneNum.setColumns(10);
		tfPhoneNum.setBounds(1066, 626, 300, 20);
		/*
		 * EMAIL
		 */
		JLabel lbEmail = new JLabel("E-mail: ");
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbEmail.setBounds(660, 668, 250, 50);
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(1066, 685, 300, 20);
		/*
		 * DEPARTMENT
		 */
		JLabel lbDepartment = new JLabel("Department: ");
		lbDepartment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbDepartment.setBounds(660, 735, 250, 50);
		/*
		 * DEPARMENT LIST DROP-DOWN MENU
		 */
		String[] deptList = hms.getStringArray(hms.getDepartmentRecord());
		jcDepartment = new JComboBox<String>(deptList);
		jcDepartment.setSelectedIndex(0);
		jcDepartment.setBounds(1066, 752, 200, 20);
		/*
		 * CANCEL BUTTON
		 */
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				clearTextField();
				clearRedField();
				hms.displayStaffManagementPage();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.BOLD, 16));
		btnCancel.setBounds(1172, 876, 169, 59);
		/*
		 * SUBMIT BUTTON
		 */
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 16));
		btnSubmit.setBounds(636, 876, 169, 59);
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ensure all fields are filled out
				if(formComplete() && (rdbtnMale.isSelected() || rdbtnFemale.isSelected()))
				{
					//Initially clearing all field colors
					clearRedField();
					//Initializing the error message string (Additional explanation is added for the entries that fail validation)
					String errorMessage = "";
					
					//If all input is correct, add this patient
					if(val.validatePatient(tfFirstName.getText(), tfLastName.getText(), tfDay.getText(),
							tfMonth.getText(), tfYear.getText(), tfPhoneNum.getText(), tfEmail.getText()))
					{
						hms.addEmployee(new Employee(tfFirstName.getText(), tfLastName.getText(), 
						(rdbtnMale.isSelected() ? "Male" : "Female"), 
						tfDay.getText()+ "/" + tfMonth.getText() + "/" + tfYear.getText(),
						tfPhoneNum.getText(), tfEmail.getText(), (String) jcDepartment.getSelectedItem()));
						//display confirmation message
						Object[] options = {"Ok"};
						JOptionPane.showOptionDialog(null, "Employee has been added.", "Success",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
						null, options, options[0]);
						//go back to previous menu
						clearTextField();
						clearRedField();
						hms.displayStaffManagementPage();
						new TextWriter().saveLoginInfo(hms.getEmployeeRecord());
					}
					
					//Otherwise, find out which field(s) are incorrect and highlight them 
					else
					{
						//Checking if first name isn't valid
						if(!val.validateName(tfFirstName.getText()))
						{
							tfFirstName.setBackground(Red);
							errorMessage += "Please ensure the first name consists of only letters; no illegal character e.g: *!@#$/.\n";
						}
						
						//Checking if last name isn't valid
						if(!val.validateName(tfLastName.getText()))
						{
							tfLastName.setBackground(Red);
							errorMessage += "Please ensure the last name consists of only letters; no illegal characters e.g: *!@#$/.\n";
						}
						
						//Checking if the day the appointment shall be set isn't valid
						if(!val.validateDay(tfDay.getText(), tfMonth.getText(), tfYear.getText()))
						{
							tfDay.setBackground(Red);
							errorMessage += "Please ensure the day entry contains no more than 2 digits, and exists in the entered month.\n";
						}
						
						//Checking if the month of the appointment isn't valid
						if(!val.validateMonth(tfMonth.getText()))
						{
							tfMonth.setBackground(Red);
							errorMessage += "Please ensure the month entry consists of no more than 2 digits and is between 1 and 12.\n";
						}
						
						//Checking if the birth year entered isn't valid
						if(!val.isPastYear(tfYear.getText()))
						{
							tfYear.setBackground(Red);
							errorMessage += "Please ensure the year entry combined with day and month; forms a valid date in the past.\n";
						}
						
						//Checking if the phone number entered isn't valid
						if(!val.validatePhone(tfPhoneNum.getText()))
						{
							tfPhoneNum.setBackground(Red);
							errorMessage += "Please ensure the phone number entry consists of exactly 10 numbers; no illegal characters e.g: *!@#$/. \n";
						}
						
						//Checking if the email entered isn't valid
						if(!val.validateEmail(tfEmail.getText()))
						{
							tfEmail.setBackground(Red);
							errorMessage += "Please ensure the email entry contains exactly one @ symbol as well as a . (period). \n";
						}

						Object[] options = {"Close"};
						JOptionPane.showOptionDialog(null, errorMessage, "Error",
						JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE,
						null, options, options[0]);
					}
				}
				//display warning message if any fields are empty 
				else
				{
					Object[] options = {"Close"};
					JOptionPane.showOptionDialog(null, "Please fill in all information.", "Warning",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
				}
			}
		});
		//add all the components to panel
		addStaff.add(lbDepartment);
		addStaff.add(jcDepartment);
		addStaff.add(lblPhoneNumber);
		addStaff.add(tfPhoneNum);
		addStaff.add(lbEmail);
		addStaff.add(tfEmail);
		addStaff.add(slash);
		addStaff.add(label);
		addStaff.add(lbDOB);
		addStaff.add(tfDay);
		addStaff.add(tfMonth);
		addStaff.add(tfYear);
		addStaff.add(lbSex);
		addStaff.add(rdbtnMale);
		addStaff.add(rdbtnFemale);
		addStaff.add(lbFirstName);
		addStaff.add(tfFirstName);
		addStaff.add(tfLastName);
		addStaff.add(lbLastName);
		addStaff.add(btnSubmit);
		addStaff.add(btnCancel);
		addStaff.add(lblWelcomeBackAdministrator);
		addStaff.add(date);
		addStaff.add(lblBackground);
		
		return addStaff;
	}
	/**
	 * This method returns true if form is completely filled out 
	 * @return 	true if form completed, false other wise
	 */
	private boolean formComplete() 
	{
		//add all the text fields to an array
		ArrayList<JTextField> allTextFields = new ArrayList<JTextField>();
		allTextFields.add(tfFirstName);
		allTextFields.add(tfLastName);
		allTextFields.add(tfDay);
		allTextFields.add(tfMonth);
		allTextFields.add(tfYear);
		allTextFields.add(tfPhoneNum);
		allTextFields.add(tfEmail);
		//loop through array checking if they are not empty
		for(JTextField t : allTextFields)
		{
			if(!(t.getText().length() > 0))
			{
				return false;
			}
		}
		return true;
	}
	/*
	 * This method updates the jcombobox for the department
	 */
	public void setDeptList() {
		jcDepartment.removeAllItems();
		String[] deptList = hms.getStringArray(hms.getDepartmentRecord());
		for (int i=0; i< deptList.length; i++) 
		{
			//Add the list of department into the combo box
			jcDepartment.addItem(deptList[i]);
		}
	}
	/**
	 * This method resets all the text fields
	 */
	private void clearTextField() 
	{
		rdbtnClear.setSelected(true);
		tfFirstName.setText("");
		tfLastName.setText("");
		tfDay.setText("");
		tfMonth.setText("");
		tfYear.setText("");
		tfPhoneNum.setText("");
		tfEmail.setText("");
	}
	
	/**
	 * This method resets all the text fields color
	 */
	private void clearRedField()
	{
		tfFirstName.setBackground(Default);
		tfLastName.setBackground(Default);
		tfDay.setBackground(Default);
		tfMonth.setBackground(Default);
		tfYear.setBackground(Default);
		tfPhoneNum.setBackground(Default);
		tfEmail.setBackground(Default);	
	}
}
