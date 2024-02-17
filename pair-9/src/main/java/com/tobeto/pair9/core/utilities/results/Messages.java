package com.tobeto.pair9.core.utilities.results;

public class Messages {

    //Brand Messages
    public static final String brandAlreadySaved ="Brand already saved";
    public static final String brandIsNotFound ="Brand already saved";
    public static final String brandAdded ="Brand added successfully";
    public static final String brandUpdated ="Brand updated successfully";
    public static final String brandDeleted ="Brand updated successfully";

    //Car Messages
    public static final String carIsNotFound ="Car is not found";
    public static final String carAdded ="Car added successfully";
    public static final String carUpdated ="Car updated successfully";
    public static final String carDeleted ="Car updated successfully";
    public static final String carAlreadySaved ="There cannot be two vehicles with the same license plate!";

    //Color Messages
    public static final String colorAdded ="Color added successfully";
    public static final String colorUpdated ="Color updated successfully";
    public static final String colorDeleted ="Color updated successfully";
    public static final String colorIsNotFound = "Color is not found";
    public static final String colorIsAlreadySaved = "Color is already saved";

    //Customer Messages
    public static final String customerAdded ="Customer added successfully";
    public static final String customerUpdated ="Customer updated successfully";
    public static final String customerDeleted ="Customer updated successfully";
    public static final String customerAlreadySaved = "Customer already saved";
    public static final String customerIsNotFound = "Customer is not found";

    //User Messages
    public static final String userIsNotFound = "User is not found";
    public static final String userAlreadySaved = "User already saved";
    public static final String userAdded ="User added successfully";
    public static final String userUpdated ="User updated successfully";
    public static final String userDeleted ="User updated successfully";
    public static final String tokenIsNotFound = "The token is not found";
    public static final String tokenIsNotValid = "The token is not valid";

    //Invoice Messages
    public static final String invoiceAdded ="Invoice added successfully";
    public static final String invoiceUpdated ="Invoice updated successfully";
    public static final String invoiceDeleted ="Invoice updated successfully";
    public static final String invoiceAlreadySaved = "Invoice already saved";
    public static final String invoiceIsNotFound = "Invoice is not found";
    public static final String invoiceCardNumber = "Invalid card information";

    //Rental Messages
    public static final String rentalIsNotFound = "Rental is not found";
    public static final String rentalAdded ="Rental added successfully";
    public static final String rentalUpdated ="Rental updated successfully";
    public static final String rentalDeleted ="Rental updated successfully";
    public static final String dateIsNotCorrect = "The end date cannot be earlier than the start date.";
    public static final String countRentDay = "The vehicle cannot be rented for more than 25 days";

    //Model Messages
    public static final String modelAlreadySaved = "Model already saved";
    public static final String modelIsNotFound = "Model is not found";
    public static final String modelAdded ="Model added successfully";
    public static final String modelUpdated ="Model updated successfully";
    public static final String modelDeleted ="Model updated successfully";

    //ForgotPassword Messages
    public static final String forgotPasswordMailContent1 = "Hello,<br/><br/>" +
            "We're sending you this email because you requested a password reset.<br/>" +
            "Click on this link to create a new password:<br/><br/>";

    public static final String forgotPasswordMailContent2 = "<br/><br/>If you didn't request a password reset, " +
            "you can ignore this email.<br/>" +
            "Your password will not be changed.<br/><br/>" +
            "Thank You,<br/>" +
            "The Pair-9 Team :)";

    public static final String emailLink = "http://localhost:3000/reset-password/";
    public static final String email = "rentacarpair9@gmail.com";
    public static final String emailSubject = "Password Reset Link";
    public static final String errorSendingEmail = "Error While Sending Email";
    public static final String successSendingEmail = "Email sent successfully";
    public static final String tokenIsAlreadyUsed = "The token is already used";
    public static final String tokenIsExpired = "The token is expired";
    public static final String passwordChanged = "Password changed successfully";




}
