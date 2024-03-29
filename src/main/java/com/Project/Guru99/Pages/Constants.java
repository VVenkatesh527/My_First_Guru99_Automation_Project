package com.Project.Guru99.Pages;

public class Constants extends BasePage{
	
	/**
	 * If the message is same for below variables, then you can use Map and store the key and values.
	 * Eg : Map<String,String> data = new HashMap<String,String>();
	 *    data.put("name_blank_message","Customer name must not be blank");
	 */
	
	//New Customer Field(Customer Name)
	public static final  String customer_name_blank_message = "Customer name must not be blank";
	public static final  String customer_name_alphanumeric_message = "Numbers are not allowed";
	public static final  String customer_name_special_character_message = "Special characters are not allowed";
	public static final  String customer_name_firstchar_blank_space_message = "Numbers are not allowed";
	
	//New Customer Field(Address)
	public static final  String address_blank_message = "";//label id message3
	public static final  String address_firstchar_blank_space_message = "";
	
	//New Customer Field(City)
	public static final  String city_blank_message = "City Field must be not blank";//label id message4
	public static final  String city_alphanumeric_message = "Numbers are not allowed";
	public static final  String city_special_character_message = "Special characters are not allowed";
	public static final  String city_firstchar_blank_space_message = "Numbers are not allowed";
	
	//New Customer Field(State)
	public static final  String state_blank_message = "State must not be blank";//label id message4
	public static final  String state_alphanumeric_message = "Numbers are not allowed";
	public static final  String state_special_character_message = "Special characters are not allowed";
	public static final  String state_firstchar_blank_space_message = "Numbers are not allowed";
		
	//New Customer Field(PIN)
	public static final String pincode_character_message = "Characters are not allowed";
	public static final String pincode_blank_message = "PIN code must not be blank";
	public static final String pincode_mustbe_6Digits_message = "PIN Code must have 6 Digits";
	public static final String pincode_special_character_message = "Special characters are not allowed";
	public static final String pincode_firstchar_blank_space_message = "Characters are not allowed";
	 
	//New Customer Field(Telephone)
	public static final String telephone_blank_message = "Telephone no must not be blank";
	public static final String telephone_special_character_message = "Characters are not allowed";
	public static final String telephone_firstchar_blank_space_message = "Characters are not allowed";
	public static final String telephone_blank_space_message = "Special characters are not allowed";
	
	//New Customer Field(EMail)
	public static final  String email_blank_message = "Email ID must not be blank";
	public static final  String email_Invalid_message = "Email- ID is not valid";
	public static final  String email_blank_space_inbetween_message = "";
	
	//Add New Customer Form
	
	public static final String all_fields_submit_pop_message = "Your User id is wrong please provide correct userid" ;
	
	//Edit Customer Field
	public static final  String edit_customer_blank_message = "Customer ID is required";
	public static final  String edit_customer_alphanumeric_message = "Characters are not allowed";
	public static final  String edit_customer_special_character_message = "Special characters are not allowed";
	public static final  String edit_customer_firstchar_blank_space_message = "First character can not have space";
	public static final  String edit_customer_blank_space_inbetween_message = "Characters are not allowed";
	
	//Verify Delete_Account(DA1-DA5)
	public static final  String delete_account_blank_message = "Account Number must not be blank";//""//label id message4
	public static final  String delete_account_alphanumeric_message = "Characters are not allowed";//"Acc123"
	public static final  String delete_account_special_character_message = "Special characters are not allowed";//"1235@#$"
	public static final  String delete_account_blank_space_inbetween_message = "";//"12 312"	
	public static final  String delete_account_firstchar_blank_space_message = "Characters are not allowed";//" 25662"
	
    //Verify Delete Customer(DC1-DC5)
	public static final  String delete_customer_blank_message = "Customer ID is required";// "" //label id message4
	public static final  String delete_customer_alphanumeric_message = " ";//Acc123
	public static final  String delete_customer_special_character_message = "Special characters are not allowed";//"1235@#$"
	public static final  String delete_customer_blank_space_inbetween_message = "";//"12 312"	
	public static final  String delete_customer_firstchar_blank_space_message = ""; //" 25662"
	
	//Verify Mini Statement(MS1-MS5)
	public static final  String mini_statement_blank_message = "Account Number must not be blank";//label id message4
	public static final  String mini_statement_alphanumeric_message = "Characters are not allowed";//Acc123
	public static final  String mini_statement_special_character_message = "Special characters are not allowed";
	public static final  String mini_statement_blank_space_inbetween_message = "Characters are not allowed";//12 312	
	public static final  String mini_statement_firstchar_blank_space_message = "Characters are not allowed";
	
	//Edit Account Field
		public static final  String edit_account_blank_message = "Account Number must not be blank";
		public static final  String edit_account_alphanumeric_message = "Characters are not allowed";
		public static final  String edit_account_special_character_message = "Special characters are not allowed";
		public static final  String edit_account_firstchar_blank_space_message = "Characters are not allowed";
		public static final  String edit_account_blank_space_inbetween_message = "Characters are not allowed";
		
		//Balance Enquiry
		public static final  String balance_enquiry_blank_message = "Account Number must not be blank";
		public static final  String balance_enquiry_alphanumeric_message = "Characters are not allowed";
		public static final  String balance_enquiry_special_character_message = "Special characters are not allowed";
		public static final  String balance_enquiry_firstchar_blank_space_message = "Characters are not allowed";
		public static final  String balance_enquiry_blank_space_inbetween_message = "Characters are not allowed";
		


}