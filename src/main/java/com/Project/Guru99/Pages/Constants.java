package com.Project.Guru99.Pages;

public class Constants extends BasePage{
	
	//Customer Name Field
	public static final  String customer_name_blank_message = "Customer name must not be blank";
	public static final  String customer_name_alphanumeric_message = "Numbers are not allowed";
	public static final  String customer_name_special_character_message = "Special characters are not allowed";
	public static final  String customer_name_firstChar_blank_space_message = "Numbers are not allowed";
	
	public static final  String address_blank_message = "";//label id message3
	public static final  String address_firstChar_blank_space_message = "";
	
	public static final  String city_blank_message = "City Field must be not blank";//label id message4
	public static final  String city_alphanumeric_message = "Numbers are not allowed";
	public static final  String city_special_character_message = "Special characters are not allowed";
	public static final  String city_firstChar_blank_space_message = "Numbers are not allowed";
	
	
	//Verify Delete_Account(DA1-DA5)
	public static final  String delete_account_blank_message = "Account Number must not be blank";//""//label id message4
	public static final  String delete_account_alphanumeric_message = "Characters are not allowed";//"Acc123"
	public static final  String delete_account_special_character_message = "Special characters are not allowed";//"1235@#$"
	public static final  String delete_account_blank_inbetween_space_message = "";//"12 312"	
	public static final  String delete_account_firstChar_blank_space_message = "";//" 25662"
	
    //Verify Delete Customer(DC1-DC5)
	public static final  String delete_customer_blank_message = "Customer ID is required";// "" //label id message4
	public static final  String delete_customer_alphanumeric_message = " ";//Acc123
	public static final  String delete_customer_special_character_message = "Special characters are not allowed";//"1235@#$"
	public static final  String delete_customer_blank_inbetween_space_message = "";//"12 312"	
	public static final  String delete_customer_firstChar_blank_space_message = ""; //" 25662"
	
	//Verify Mini Statement(MS1-MS5)
	public static final  String mini_statement_blank_message = "Account Number must not be blank";//label id message4
	public static final  String mini_statement_alphanumeric_message = "Characters are not allowed";//Acc123
	public static final  String mini_statement_special_character_message = "Special characters are not allowed";
	public static final  String mini_statement_blank_inbetween_space_message = "Characters are not allowed";//12 312	
	public static final  String mini_statement_firstChar_blank_space_message = "Characters are not allowed";
	

}